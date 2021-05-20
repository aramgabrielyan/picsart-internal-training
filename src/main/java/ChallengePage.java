import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static setup.DriverSetup.getDriver;

public class ChallengePage extends BasePage {

    WaitHelper waitHelper = new WaitHelper();

    private final By challengesLocation = By.cssSelector("[data-test='subNavigation-groupList'] [href='/challenges']");
    private final By discoveryBttn = By.cssSelector("[data-test='headerNavigation-navigationListItem-Discover']");
    private final By challengeItems = By.cssSelector(".grid-cards .card");
    private final By participate = By.cssSelector("[class='c-get-the-app-popup js-prevent-default-event primary-big-btn']");
    private final By qrCode = By.id("qrcode");

    public void goToDiscoveryBttn() {
        waitHelper.waitForElementDisplayed(discoveryBttn);
        List<WebElement> element = getDriver().findElements(discoveryBttn);

        Actions actions = new Actions(getDriver());
        actions.moveToElement(element.get(element.size() - 1)).click().build().perform();
    }

    public void challengesClick() {
        waitHelper.waitForElementClickable(challengesLocation);
        click(challengesLocation);
    }

    public void selectChallenge() {
        WaitHelper.getInstance().waitForElementDisplayed(challengeItems);
        waitHelper.waitForElementClickable(challengeItems);
        click(findAll(challengeItems).get(1));
    }

    public void participateClick(){
        WaitHelper.getInstance().waitForElementDisplayed(participate);
        click(participate);
    }

    public boolean qrCodeIsVisible() {
        return isDisplayed(qrCode);
    }

    @Override
    public String getUrl() {
        return BASE_URL;
    }

}
