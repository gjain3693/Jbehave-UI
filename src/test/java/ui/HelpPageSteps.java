package ui;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import junit.framework.Assert;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.By;

import utility.Screenshot;

/**
 * This is step defination class which will execute steps as per story file.
 * @author gauravp.jain
 *
 */

public class HelpPageSteps extends Steps {
	
	
	/**
	 * This method will verify current page.
	 * @throws InterruptedException will be thrown when a thread 
	 * is waiting or sleeping and another thread interrupts
	 */
	
	@Given("user logged into Ebay")
	public void currentPage() throws InterruptedException {
		
		Thread.sleep(3000);
		String loginName = TestSequence.webDriver.findElement(
				By.xpath("//*[@id='gh-ug']")).getText();
		
		Assert.assertEquals("Hi Gaurav!", loginName);
		
	}
	
	/**
	 * This method will navigate user to Customer service page.
	 */
	
	@When("user click on Help & Contact link")
	public void navigateToHelp() {
		
		TestSequence.webDriver.findElement(By.xpath("//*[@id='gh-p-3']/a")).click();
				
	}
	
	/**
	 * This method will check navigate page is same as mentioned in story file.
	 * @param currentPage will contain current open page name as mentioned in story file.
	 */
	@When("user navigated to $currentPage page")
	public void lookingForSolutions(@Named("currentPage") String currentPage) {
		
		String openPage = TestSequence.webDriver.findElement(
				By.xpath("//*[@id='gh-title']")).getText();
		
		Assert.assertEquals(openPage, currentPage);
		
	}
	
	/**
	 * This method will verify current page is Customer Service or not.
	 * @param help will contain current page name as mentioned in story file.
	 * 
	 */
	
	@Then("user will navigate to $help page")
	public void verifyHelpPage(@Named("help") String help) {
		
		String pageTitle = TestSequence.webDriver.findElement(
				By.xpath("//*[@id='gh-title']")).getText();
		
		Assert.assertEquals(pageTitle, help);
		Screenshot screenShot = new Screenshot();
		screenShot.takeScreenShot("Customer Service");
		
	}
	
	/**
	 *This method will verify Help options present on page as mentioned in story file. 
	 * @param helpOptions will contain name of options as mentioned in story file.
	 */
	
	@Then("user will find below catagory for help $ExamplesTable")
	public void verifyAvailableOptions(ExamplesTable helpOptions) {
		Set<String> helpTopic = new TreeSet<String>();
		
				
		String solution = TestSequence.webDriver.findElement(
				By.xpath("//*[@id='body']/div[2]/div[4]/div[2]/h2")).getText();
		String topic = TestSequence.webDriver.findElement(
				By.xpath(" //*[@id='browseByTopic']")).getText();
				
		
		for (Map<String,String> readRecords:helpOptions.getRows()) {
			String options = readRecords.get("Options");
			helpTopic.add(options);			
			
		}
		
		Iterator it = helpTopic.iterator();
		while (it.hasNext()) {
			it.next();
			helpTopic.contains(solution);
			helpTopic.contains(topic);
		}
		
		
		
	}

}
