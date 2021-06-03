import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditorPage extends BasePage {


    private final By firstSliderLocation = By.cssSelector("[alt='template-5ebbf1aa1deff9572ef442cc']");
    private final By stickerIconLocation = By.id("stickers-category");
    private final By myStickersLocation = By.className("pa-uiLib_sidebar--actions__button");
    private final By instaStoryLocation = By.cssSelector("[data-test='insta-story'] span");
    private final By editorItemLocation = By.cssSelector("[class*='customSizeContainer']");
    private final By fitIconLocation = By.cssSelector("#background-category");

    public void clickInstaStory() {
        Actions action = new Actions(driver);
        action.moveToElement(find(instaStoryLocation)).click().build().perform();
        new WebDriverWait(driver, 10);
        // changeTab(1);
    }

    public int getItemsCount() {
        //WaitHelper.getInstance().waitForElementDisplayed(editorItemLocation);
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(editorItemLocation));
        return findAll(editorItemLocation).size();
    }

    public void clickFitIcon() {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(fitIconLocation));
        click(fitIconLocation);
    }

    public void clickFirstSlider() {
        click(firstSliderLocation);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(stickerIconLocation));
    }

    public void clickSticker() {
        click(stickerIconLocation);
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(myStickersLocation));
    }

    public void clickMySticker() {
        click(myStickersLocation);
    }

    public boolean isMyStickersDisplayed() {
        return isDisplayed(myStickersLocation);
    }

    @Override
    public String getUrl() {
        return BASE_URL;
    }


}
