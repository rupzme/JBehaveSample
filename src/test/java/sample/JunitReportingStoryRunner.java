package sample;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.reporters.StoryReporterBuilder.Format;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.runner.RunWith;

import sample.jbehave.steps.TraderSteps;
import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;

@RunWith(JUnitReportingRunner.class)
public class JunitReportingStoryRunner extends JUnitStories {

	public JunitReportingStoryRunner() {
		super();
	}

	@Override
	public Configuration configuration() {
		return new MostUsefulConfiguration().useStoryLoader(
				new LoadFromClasspath(this.getClass()))
				.useStoryReporterBuilder(
						new StoryReporterBuilder().withCodeLocation(
								codeLocationFromClass(this.getClass()))
								.withFormats(
										Format.HTML, Format.IDE_CONSOLE).withDefaultFormats());
	}

	@Override
	public List<CandidateSteps> candidateSteps() {
		return new InstanceStepsFactory(configuration(), new TraderSteps())
				.createCandidateSteps();
	}


	@Override
	protected List<String> storyPaths() {

		return new StoryFinder().findPaths(
				codeLocationFromClass(this.getClass()).getFile(),
				asList("**/*.story"), null);
	}
}
