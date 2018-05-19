package nz.ac.auckland.se754sem2018.mycash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

public class DollarUIStoryRunner extends JUnitStories{
	 
    public DollarUIStoryRunner() {
        configuredEmbedder()
        .embedderControls()
        .doGenerateViewAfterStories(true)
        .doIgnoreFailureInStories(false)
        .doIgnoreFailureInView(true)
        .doVerboseFailures(true)
        .useThreads(5);
    }
 
    @Override
    public Configuration configuration() {
        Class<? extends Embeddable> embeddableClass = this.getClass();
        return new MostUsefulConfiguration()
            .useStoryLoader(new LoadFromClasspath(embeddableClass))
            .useStoryReporterBuilder(new StoryReporterBuilder()
                .withCodeLocation(CodeLocations.codeLocationFromClass(embeddableClass))
                .withDefaultFormats()
                .withFormats(Format.CONSOLE, Format.TXT, Format.HTML_TEMPLATE, Format.XML_TEMPLATE));                               
    }
 
    @Override
    public InjectableStepsFactory stepsFactory() {
    	return new InstanceStepsFactory(configuration(), new MultiplicationWithUISteps());
    }
     
    @Override
    protected List<String> storyPaths() {
        String codeLocation = CodeLocations.codeLocationFromClass(this.getClass()).getFile();
        return new StoryFinder().findPaths(codeLocation, Collections.singletonList("**/multiplication.story"), new ArrayList<String>());
    }

}
