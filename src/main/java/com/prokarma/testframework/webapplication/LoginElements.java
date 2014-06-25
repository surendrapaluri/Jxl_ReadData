package com.prokarma.testframework.webapplication;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class LoginElements{
      
    @FindBy(how = How.ID, using = "os_username")
    public WebElement userName;

    public void setUserName(String username){
    	userName.sendKeys(username);
    }
    
    @FindBy(how = How.ID, using = "os_password")
    public WebElement password;

    public void setPassword(String Password){
    	password.sendKeys(Password);
    }
    
    @FindBy(how = How.ID, using = "loginButton")
    public WebElement loginButton;

    public void clickOnLoginButton(){
    	loginButton.click();
    }
    
    @FindBy(how = How.CSS, using = "#user-menu-link > span > span")
    public WebElement navigateToLogoutLink;
    
    public void LogoutLinkNavigator(){
    	navigateToLogoutLink.click();
    }
    
    @FindBy(how = How.CSS, using = "#logout-link > span")
    public WebElement logoutLink;
    
    public void ClickOnLogout(){
    	logoutLink.click();
    }
    
    @FindBy(how = How.ID, using = "quick-search-query")
    public WebElement SearchTextBox;
  
    public void SearchTextBox(String searchText){
    	SearchTextBox.sendKeys(searchText);
    }
}
