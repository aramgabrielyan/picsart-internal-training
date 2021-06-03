package pageobjects;

import helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static setup.DriverSetup.getDriver;

public class UserPage extends BasePage {

    @Override
    public String getUrl() {
        return BasePage.BASE_URL + "u/smart_offer";
    }

    public UserPage(){
        open(getUrl());
        PageFactory.initElements(getDriver(), this);
    }

    public UserPage init(){
        PageFactory.initElements(getDriver(), this);
        return this;
    }

    @FindBy (css = "[class*='c-dynamic-tooltip'] [data-photo-id='349802346077201']")
    private By like;
    @FindBy (css = "figure[class*='c-preview']")
    private By image;


    public void moveToImage() {
        WaitHelper.getInstance().waitForElementDisplayed(image);
        Actions actions = new Actions(driver);
        List<WebElement> imagesList = findAll(image);
        actions.moveToElement(imagesList.get(0)).build().perform();
    }

    public boolean isImageLiked() {
        return find(like).getAttribute("class").contains("active");
    }

    public void moveToLikeButton() {
        WaitHelper.getInstance().waitForElementDisplayed(like);
        Actions actions = new Actions(driver);
        actions.moveToElement(find(like)).click().build().perform();
    }

}