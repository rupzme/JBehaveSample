JBehaveSample
=============

Basic JBehave Example - 3 Different Runner Styles &amp; Simple Story & Simple RESTFul Web Service Story 

*Prerequisites*

*Features*

1. Junit style story runner - features junit step creation and nicer view in junit panel.
2. An annontated story runner - mainly just to experiment, I prefer the Junit one.
3. Both can be run as a junit test in Eclipse.
4. Sample & Steps story based on the JBehave Trader example on http://jbehave.org/reference/latest/index.html
5. The Trader Stock service is partialy implemented, 1 test passes, 1 fails.
6. Reports for the Junit runner are created in {project root}/jbehave and the other runner creates them in {project root}/target/jbehave/
7. I have added 'style' and 'images' to give nice looking reports.

*UPDATE 1*

* Have created a SpringStoryRunner with application context aware step builder.
* TraderSteps wired using test spring java config.
* Stock now passes story tests. 

*UPDATE 2*

* Have added a story that to test a simple RESTFul web service.

*TIPS*

* If you make new story steps make sure they are on the spring application context when using the SpringStoryRunner e.g. annotate with @Component
