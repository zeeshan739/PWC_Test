package com.automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.base.DemoQaBase;

public class DemoQaAHome extends DemoQaBase {
	
	
	@FindBy(xpath ="//input[@id='firstName']")
	WebElement firstName;
	
	@FindBy(xpath ="//input[@id='lastName']")
	WebElement lastName;
	
	@FindBy(xpath ="//input[@id='userEmail']")
	WebElement userEmail;
	
	
	@FindBy(xpath ="//input[@type='radio' and @value ='Male']")
	WebElement genderMale;
	
	@FindBy(xpath ="//input[@type='radio' and @value ='Female']")
	WebElement genderFemale;
	
	@FindBy(xpath ="//input[@id='userNumber']")
	WebElement userNumber;

	@FindBy(xpath ="//input[@type='checkbox' and @value='1']")
	WebElement sportsCheckbox;

	@FindBy(xpath ="//input[@type='checkbox' and @value='2']")
	WebElement readingCheckbox;
	
	@FindBy(xpath ="//input[@type='checkbox' and @value='3']")
	WebElement musicCheckbox;
	
	@FindBy(xpath ="//input[@id='uploadPicture']")
	WebElement picture;
	
	@FindBy(xpath ="//input[@id='dateOfBirthInput']")
	WebElement dateOfBirthInput;
	
	@FindBy(xpath ="//input[@id='currentAddress']")
	WebElement currentAddress;
	
	@FindBy(xpath ="//div[@id='state']")
	WebElement state;

	@FindBy(xpath ="//div[@id='city']")
	WebElement city;
	
	@FindBy(xpath ="//input[@id='submit']")
	WebElement submit;
	
	@FindBy(xpath ="//div[text()=\"Thanks for submitting the form\"]")
	WebElement SuccessfulPage;
	
	
	
	@FindBy(xpath ="//h5[text()='Student Registration Form']")
	WebElement pageName;
	
	public DemoQaAHome() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPageTitle() {
		return driver.getTitle();
	}
	
	public String provideDetails() throws InterruptedException {
		firstName.sendKeys(prop.getProperty("firstName"));
		lastName.sendKeys(prop.getProperty("lastName"));
		userEmail.sendKeys(prop.getProperty("userEmail"));
		userNumber.sendKeys(prop.getProperty("userNumber"));
		picture.sendKeys(System.getProperty("user.dir")+"\\data\\phonepicutres.jpg");
		currentAddress.sendKeys(prop.getProperty("currentAddress"));
		
		
		state.click();
		Thread.sleep(5000);
		if(prop.getProperty("state").equals("NCR")) {
			driver.findElement(By.xpath(" //div[@class=' css-1uccc91-singleValue' and text()='NCR']")).click();
		}
		
		city.click();
		Thread.sleep(5000);
		if(prop.getProperty("city").equals("Delhi")) {
			driver.findElement(By.xpath(" //div[@class=' css-1uccc91-singleValue' and text()='Delhi']")).click();
		}
		
		if(prop.getProperty("hobbies").equals("Sports")) {
			sportsCheckbox.click();
		}
		if(prop.getProperty("hobbies").equals("Reading")) {
			sportsCheckbox.click();
		}
		if(prop.getProperty("hobbies").equals("Music")) {
			sportsCheckbox.click();
		}
		
		
		if(prop.getProperty("gender").equals("Male")) {
			genderMale.click();
		}
		else {
			genderFemale.click();
		}
		
		submit.click();
		Thread.sleep(5000);
		driver.switchTo().alert();
		return pageName.getText();
		
	}
	
	
	
			

}
