package pageobjects;

import helpers.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static helpers.WaitHelper.getWait;

public class EditorPage extends BasePage<EditorPage> {

    @FindBy(css = "[alt='template-5ebbf1aa1deff9572ef442cc']")
    private WebElement firstSlider;

    @FindBy(css = "stickers-category")
    private WebElement stickerIcon;

    @FindBy(css = "pa-uiLib_sidebar--actions__button")
    private WebElement myStickers;

    @FindBy(css = "[data-test='insta-story'] span")
    private WebElement instaStory;

    @FindBy(css = "[class*='customSizeContainer']")
    private List<WebElement> editorItem;

    @FindBy(css = "#background-category")
    private WebElement fitIcon;

    @Override
    public EditorPage open() {
        return openPage();
    }

    @Override
    public EditorPage init() {
        return initPage();
    }

    @Override
    public String getUrl() {
        return "/create";
    }

    public void clickInstaStory() {
        clickByAction(instaStory);
        new WaitHelper().waitForPageReady();
        changeTab(1);
        initPage();
    }

    public int getItemsCount() {
        WaitHelper.getWait().waitForElementDisplayed(editorItem.get(0));
        return editorItem.size();
    }

    public void clickFitIcon() {
        //new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(fitIcon));
        click(fitIcon);
        getWait().waitForPageReady();
    }

    public void clickFirstSlider() {
        click(firstSlider);
        // new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(stickerIcon));
    }

    public void clickSticker() {
        click(stickerIcon);
        // new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(myStickers));
    }

    public void clickMySticker() {
        click(myStickers);
    }

    public boolean isMyStickersDisplayed() {
        return isDisplayed(myStickers);
    }

}
