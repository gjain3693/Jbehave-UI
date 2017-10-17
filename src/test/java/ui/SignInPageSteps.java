package ui;

import junit.framework.Assert;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.Screenshot;

/**
 * This is step defination class which will execute steps as per story file.
 * @author gauravp.jain
 *
 */

public class SignInPageSteps extends Steps {
	
	/**
	 * This method will verify current page name.
	 */
	
	@Given("user is at sign in page") 
	public void signInPage() {
		
		WebElement signInOption = TestSequence.webDriver.findElement(
				By.xpath("//*[@id='sgnTab']/span[2]"));
		String actualTag = signInOption.getText();

		Assert.assertEquals("Sign in", actualTag);
		
	}
	
	/**
	 * This method will enter credentials as mentioned in story file and will perform login. 
	 * @param userName will contain name of user as mentioned in story file.
	 * @param passWord will contain password as mentioned in story file.
	 */
	
	@When("user enter username as $userName and password as $passWord")
	public void enterCredentials(@Named("userName")
	String userName, @Named("passWord") String passWord) {
		
		TestSequence.webDriver.findElement(
				By.xpath("//*[@id='userid']")).sendKeys(userName);
		TestSequence.webDriver.findElement(By.xpath("//*[@id='pass']")).sendKeys(passWord);

		boolean stayedSignIn = TestSequence.webDriver.findElement(
				By.xpath("//*[@id='csi']")).isSelected();

		if (!stayedSignIn) {
			TestSequence.webDriver.findElement(By.xpath("//*[@id='csi']")).click();
		}

		TestSequence.webDriver.findElement(By.xpath("//*[@id='sgnBt']")).click();
		
	}
	
	/**
	 * This method will verify user logged in to successfully. 
	 * @throws InterruptedException will be thrown when a thread 
	 * is waiting or sleeping and another thread interrupts
	 */
	
	@Then("user logged in successfully")
	public void verifyLogIn() throws InterruptedException {
		
		Thread.sleep(3000);
		
		String loginName = TestSequence.webDriver.findElement(
				By.xpath("//*[@id='gh-ug']")).getText();
		
		Assert.assertEquals("Hi Gaurav!", loginName);
		
		Screenshot screenShot = new Screenshot();
		screenShot.takeScreenShot("signInPage");
		
	}

}
