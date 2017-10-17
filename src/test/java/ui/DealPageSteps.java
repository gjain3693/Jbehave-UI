package ui;

import junit.framework.Assert;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.By;

/**
 * This is step defination class which will execute steps as per story file.
 * @author gauravp.jain
 *
 */

public class DealPageSteps extends Steps {

	/**
	 * This method will verify user is logged into to Ebay.
	 * @throws InterruptedException will be thrown when a thread 
	 * is waiting or sleeping and another thread interrupts
	 */
	
	@Given("user is logged in at Ebay")
	public void currentStatus() throws InterruptedException {

		Thread.sleep(3000);

		String loginName = TestSequence.webDriver.findElement(
				By.xpath("//*[@id='gh-ug']")).getText();

		Assert.assertEquals("Hi Gaurav!", loginName);

	}
	
	/**
	 *This method will navigate user to Deals page. 
	 * @param desiredPage will contain name of page as mentioned in story file.
	 */
	
	@When("user Click on $desiredPage link")
	public void navigateToDealPage(@Named("desiredPage") String desiredPage) {
		
		String page = TestSequence.webDriver.findElement(
				By.xpath("//*[@id='gh-p-1']/a")).getText();
		TestSequence.webDriver.findElement(By.xpath("//*[@id='gh-p-1']/a")).click();
		Assert.assertEquals(page,desiredPage);
		
	}
	
	/**
	 *This method will verify name of page. 
	 * @param expectedPage will contain name of page as mentioned in story file.
	 */
	
	@Then("user navigate to $expectedPage page")
	public void verifyDealPage(@Named("expectedPage") String expectedPage) {
		
		String actualPage = TestSequence.webDriver.findElement(
				By.xpath("//*[@id='s2']/h1/a")).getText();
	
		Assert.assertEquals(expectedPage, actualPage);
		
	}

}
