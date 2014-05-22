package sample;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

import java.text.SimpleDateFormat;

import org.jbehave.core.Embeddable;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.UsingSteps;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.AnnotatedEmbedderRunner;
import org.jbehave.core.parsers.RegexPrefixCapturingPatternParser;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.ParameterConverters.DateConverter;
import org.junit.Test;
import org.junit.runner.RunWith;

import sample.AnnotatedEmbedderStoryRunner.MyDateConverter;
import sample.AnnotatedEmbedderStoryRunner.MyReportBuilder;
import sample.AnnotatedEmbedderStoryRunner.MyStoryLoader;
import sample.jbehave.steps.TraderSteps;

@RunWith(AnnotatedEmbedderRunner.class)
@Configure(storyLoader = MyStoryLoader.class, storyReporterBuilder = MyReportBuilder.class, 
        parameterConverters = { MyDateConverter.class })
@UsingEmbedder(embedder = Embedder.class, generateViewAfterStories = true, ignoreFailureInStories = true, ignoreFailureInView = true)
@UsingSteps(instances = { TraderSteps.class})
public class AnnotatedEmbedderStoryRunner implements Embeddable {
 
    private Embedder embedder;
 
    public void useEmbedder(Embedder embedder) {
        this.embedder = embedder;
    }
 
    @Test
    public void run() {
        embedder.runStoriesAsPaths(new StoryFinder().findPaths(codeLocationFromClass(this.getClass()).getFile(),
                asList("**/*.story"), asList("")));
    }
    
    public static class MyStoryControls extends StoryControls {
        public MyStoryControls() {
            doDryRun(false);
            doSkipScenariosAfterFailure(false);
        }
    }
 
    public static class MyStoryLoader extends LoadFromClasspath {
        public MyStoryLoader() {
            super(AnnotatedEmbedderStoryRunner.class.getClassLoader());
        }
    }
 
    public static class MyReportBuilder extends StoryReporterBuilder {
        public MyReportBuilder() {
            this.withFormats(Format.CONSOLE, Format.TXT, Format.HTML, Format.XML).withDefaultFormats();
        }
    }
 
    public static class MyRegexPrefixCapturingPatternParser extends RegexPrefixCapturingPatternParser {
        public MyRegexPrefixCapturingPatternParser() {
            super("%");
        }
    }
 
    public static class MyDateConverter extends DateConverter {
        public MyDateConverter() {
            super(new SimpleDateFormat("yyyy-MM-dd"));
        }
    }
}
