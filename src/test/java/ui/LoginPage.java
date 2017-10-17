package ui;

import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;

/**
 * This class will map step class with story file which contains test scenarios.
 * This class name will be same as story file name only difference is java class
 * name will be in camelcase where story file name will be in snake_case.
 */

public class LoginPage extends JUnitStory {
	
	/**
	 * Configuration instances are responsible for the configuration of story
	 * execution.
	 *
	 * @return Returns the configuration
	 */
	
	@Override
	public Configuration configuration() {
		return new MostUsefulConfiguration()
		.useStoryLoader(new LoadFromClasspath(this.getClass()))
		.useStoryReporterBuilder(new StoryReporterBuilder()
		.withDefaultFormats().withFormats(Format.HTML,
				Format.CONSOLE,Format.STATS));
	}
	
	/**
	 * instances are used to find the Java methods that match the textual steps
	 * in the stories.
	 *
	 * @return the list of step candidates, representing methods annotated with
	 * @Given, @When or @Then that can be matched
	 */
	
	@Override
	public List<CandidateSteps> candidateSteps() {
		return new InstanceStepsFactory(configuration(), new LoginPageSteps())
		.createCandidateSteps();

	}
	

}
