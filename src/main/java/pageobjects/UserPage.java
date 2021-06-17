package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserPage extends BasePage<UserPage> {

    private String userName;

    public UserPage(String userName) {
        this.userName = userName;
    }

    public UserPage() {
        this.userName = "smart_offer";
    }

    @Override
    public String getUrl() {
        return "/u/" + userName;
    }

    @Override
    public UserPage open() {
        return openPage();
    }

    public UserPage init(){
        return initPage();
    }

    @FindBy (css = "[class*='c-dynamic-tooltip'] [data-photo-id='349802346077201']")
    private WebElement like;

    @FindBy (css = "figure[class*='c-preview']")
    private List<WebElement> image;


    public void moveToImage() {
       // WaitHelper.getInstance().waitForElementDisplayed(image);
        clickByAction(image.get(0));
        //List<WebElement> imagesList = findAll(image);
    }

    public boolean isImageLiked() {
        return like.getAttribute("class").contains("active");
    }

    public void moveToLikeButton() {
        //WaitHelper.getInstance().waitForElementDisplayed(like);
        clickByAction(like);
    }

}