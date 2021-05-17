import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditorPage extends BasePage{

    private final By firstSliderLocation = By.cssSelector("[alt='template-5ebbf1aa1deff9572ef442cc']");
    private final By stickerIconLocation = By.id("stickers-category");
    private final By myStickersLocation = By.className("pa-uiLib_sidebar--actions__button");
    private final By instaStoryLocation = By.cssSelector("[data-test='insta-story'] p");

    public void clickInstaStory(){
        click(instaStoryLocation);
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(stickerIconLocation));
    }

    public void clickFirstSlider(){
        click(firstSliderLocation);
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(stickerIconLocation));
    }

    public void clickSticker(){
        click(stickerIconLocation);
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(myStickersLocation));
    }

    public void clickMySticker(){
        click(myStickersLocation);
    }

    @Override
    public String getUrl() {
        return BASE_URL;
    }



}
