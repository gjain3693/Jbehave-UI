package ui;



import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ContactUsPageStep extends Steps {
	
	/**
	 * This method will navigate user to Help Page.
	 */
	
	@Given("user is at Help Page of Ebay")
	public void userAtHelpPage() {
		
		TestSequence.webDriver.findElement(By.xpath("//*[@id='gh-p-3']/a")).click();
		
	}
	
	/**
	 * This method will navigate user to Contact us page.
	 * @param desiredButton will contain name of Contact us Button
	 * @throws InterruptedException
	 */
	
	@When("user Click on $desiredButton button")
	public void userNavigateToContactUs(@Named("desiredButton")
		String desiredButton) throws InterruptedException {
		Thread.sleep(1000);
	
		TestSequence.webDriver.findElement(By.xpath("//*[@id='w1-36']")).click();
		
	}
	
	/**
	 * This page will verify user navigate to desired Contact us page.
	 * @param desiredPage contains name of desired page as mentioned in story file. 
	 */
	@Then("user navigate to $desiredPage page")
	public void verifyDesiredPage(@Named("desiredPage") String desiredPage) {
		
		WebDriverWait webDriverWait = new WebDriverWait(TestSequence.webDriver, 60);
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//div[@class='pagewidth']/h2")));
		
		String actualPage = TestSequence.webDriver.findElement(
				By.xpath("//div[@class='pagewidth']/h2")).getText();
		System.out.println("actualPage::::::" + actualPage);
		
		Assert.assertEquals(desiredPage, actualPage);
		
	}

}
