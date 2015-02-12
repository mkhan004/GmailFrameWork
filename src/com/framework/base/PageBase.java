package com.framework.base;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageBase {
	public WebDriver driver;

	public String getFolderByName(WebDriver driver, String folderName){
		String elementName = null;
		List <WebElement> allFolders = driver.findElements(By.className("aKz"));
		for(int i=0; i<allFolders.size(); i++){
			if(allFolders.get(i).getText().equalsIgnoreCase(folderName)){
				elementName = allFolders.get(i).getText();
			}
		}
		return elementName;
	}

	public Integer convertStringToInteger(String stringData){
		int integerValue = Integer.parseInt(stringData);
		return integerValue;
	}

	public String convertIntegerToString(Integer integerValue){
		String newString = String.valueOf(integerValue);
		return newString;
	}

	//cssSelectorName = "tr[class='zA zE'],tr[class='zA yO']"
	//cssSelectorName = "tr[class='zA zE']"
	public List<WebElement> getListOfWebElements(WebDriver driver, String cssSelectorName){
		List <WebElement> allElements = driver.findElements(By.cssSelector(cssSelectorName));		
		return allElements;
	}

	public Iterator<String> getWindow(){
		Iterator<String> window = null;
		if(driver.getWindowHandles().size()>1){
			Set<String> windID = driver.getWindowHandles();
			window = windID.iterator();
		}
		return window;
	}
}
