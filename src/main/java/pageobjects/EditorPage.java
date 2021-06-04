package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static setup.DriverSetup.getDriver;

public class EditorPage extends BasePage {

    @FindBy(css = "[alt='template-5ebbf1aa1deff9572ef442cc']")
    private WebElement firstSlider;
    @FindBy(css = "stickers-category")
    private WebElement stickerIcon;
    @FindBy(css = "pa-uiLib_sidebar--actions__button")
    private WebElement myStickers;
    @FindBy(css = "[data-test='insta-story'] span")
    private WebElement instaStory;
    @FindBy (css = "[class*='customSizeContainer']")
    private List<WebElement> editorItem;
    @FindBy(css = "#background-category")
    private WebElement fitIcon;


    public EditorPage(){
        open(getUrl());
        PageFactory.initElements(getDriver(), this);
    }

    public EditorPage init() {
        PageFactory.initElements(getDriver(), this);
        return this;
    }

    public void clickInstaStory() {
        init();
        Actions action = new Actions(driver);
        action.moveToElement(instaStory).click().build().perform();
        new WebDriverWait(driver, 10);
        // changeTab(1);
    }

    public int getItemsCount() {
        init();
        //helpers.WaitHelper.getInstance().waitForElementDisplayed(editorItemLocation);
        //new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
        return editorItem.size();
    }

    public void clickFitIcon() {
        init();
        //new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(fitIcon));
        click(fitIcon);
    }

    public void clickFirstSlider() {
        init();
        click(firstSlider);
       // new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(stickerIcon));
    }

    public void clickSticker() {
        init();
        click(stickerIcon);
       // new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(myStickers));
    }

    public void clickMySticker() {
        init();
        click(myStickers);
    }

    public boolean isMyStickersDisplayed() {
        return isDisplayed(myStickers);
    }

    @Override
    public String getUrl() {
        return BasePage.BASE_URL;
    }


}
