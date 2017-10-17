package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import ui.TestSequence;


/**
 * This class will take screenshots
 * @author gauravp.jain
 *
 */

public class Screenshot {
	
	/**
	 * This method will take screenshot of screen and save to target folder
	 * @param fileName will contain name of screenshot file.
	 */
	public void takeScreenShot(String fileName) {
		
		File scrFile = ((TakesScreenshot)TestSequence.webDriver)
				.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("F:\\PetProjects\\web"
					+ "\\target\\Screenshots\\" + fileName + ".png"));
		} catch (IOException ex) {
			
			ex.printStackTrace();
		}
		  
	}

}
