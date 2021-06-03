package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static setup.DriverSetup.getDriver;

public class ImageBrowserPage extends BasePage {

    @FindBy(css = "[href='/hashtag/hashtag_changed']")
    private WebElement hashtag;


    public void open() {
        open(getUrl());
    }

    public ImageBrowserPage(String imageId) {
        open(BasePage.BASE_URL + "/i/" + imageId);
        PageFactory.initElements(getDriver(), this);
    }

    @Override
    public String getUrl() {
        return null;
    }

    public boolean isHashtagChanged() {
        return isDisplayed(hashtag);
    }

}