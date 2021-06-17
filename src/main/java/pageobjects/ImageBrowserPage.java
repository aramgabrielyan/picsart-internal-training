package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ImageBrowserPage extends BasePage<ImageBrowserPage> {

    private String imageId;

    @FindBy(css = "[href='/hashtag/hashtag_changed']")
    private WebElement hashtag;


    public ImageBrowserPage(String imageId) {
        this.imageId = imageId;
    }

    @Override
    public ImageBrowserPage open() {
        return openPage();
    }

    @Override
    public ImageBrowserPage init() {
        return initPage();
    }

    @Override
    public String getUrl() {
        return "/i/" + imageId;
    }

    public boolean isHashtagChanged() {
        return isDisplayed(hashtag);
    }
}