package pageobjects;

import helpers.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.DriverHelper;

import java.util.List;



public class ChallengePage extends BasePage<ChallengePage> {

    WaitHelper waitHelper = new WaitHelper();

    @FindBy(css = "[data-test='subNavigation-groupList'] [href='/challenges']")
    private WebElement challenges;
    @FindBy(css = "[data-test='headerNavigation-navigationListItem-Discover']")
    private List<WebElement> discover;
    @FindBy(css = ".grid-cards .card")
    private List<WebElement> challengeItems;
    @FindBy(css = "[class='c-get-the-app-popup js-prevent-default-event primary-big-btn']")
    private WebElement participate;
    @FindBy(id = "qrcode")
    private WebElement qrCode;

    public ChallengePage init() {
        PageFactory.initElements(DriverHelper.get().getDriver(), this);
        return this;
    }

    public ChallengePage open() {
        open();
        PageFactory.initElements(DriverHelper.get().getDriver(), this);
        return this;
    }

    public void goToDiscoverButton() {
        init();
       // waitHelper.waitForElementDisplayed(discover);
        Actions actions = new Actions(DriverHelper.get().getDriver());
        actions.moveToElement(discover.get(discover.size() - 1)).click().build().perform();
    }

    public void challengesClick() {
        init();
        waitHelper.waitForElementClickable(challenges);
        click(challenges);
    }

    public void selectChallenge() {
        init();
       // WaitHelper.getInstance().waitForElementDisplayed(challengeItems);
       // waitHelper.waitForElementClickable(challengeItems);
        click(challengeItems.get(1));
    }

    public void participateClick() {
        init();
       // WaitHelper.getInstance().waitForElementDisplayed(participate);
        click(participate);
    }

    public boolean qrCodeIsVisible() {
        return isDisplayed(qrCode);
    }

    @Override
    public String getUrl() {
        return BasePage.BASE_URL;
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }
}