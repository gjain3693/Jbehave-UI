package ui;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.Screenshot;

/**
 * This class will execute scenarios as mentioned in story file. This is step defination class.
 * @author gauravp.jain
 *
 */

public class LoginPageSteps extends Steps {
	
	/**
	 * This method will navigate user to website.
	 * @param url will contain web url of website.
	 */
	@Given("we have valid ebay url as \"$url\"")
	public void setUrl(String url) {
	
		TestSequence.webDriver.get(url);
				
	}
	
	/**
	 * This method will perform click operation to navigate sign in page.
	 */
	
	@When("we click on sign in button")
	public void navigateToSignIn() {
		WebElement sign = TestSequence.webDriver.findElement(
				By.xpath("//*[@id='gh-ug']/a"));
		sign.click();
	}
	
	/**
	 * This method will verify user is at sign in page.
	 * @param expectedPage will contain name of page as mentioned in story file.
	 */
	
	@Then("we will redirect to $expectedPage page")
	public void verifySignInPage(String expectedPage) {
		
		WebElement signInOption = TestSequence.webDriver.findElement(
				By.xpath("//*[@id='sgnTab']/span[2]"));
		String actualTag = signInOption.getText();
		
		org.junit.Assert.assertEquals(actualTag, expectedPage);
		Screenshot screenShot = new Screenshot();
		screenShot.takeScreenShot("loginPage");
		
	}
	

}
