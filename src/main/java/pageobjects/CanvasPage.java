package pageobjects;

import helpers.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import setup.DriverHelper;


public class CanvasPage extends BasePage<CanvasPage> {

    @FindBy(css = "[data-test='canvas-container'] .konvajs-content")
    private WebElement canvas;

    @FindBy(id = "context-menu")
    private WebElement contextMenu;


    public CanvasPage open() {
        return openPage();

    }

    public CanvasPage init() {
        return initPage();
    }

    @Override
    public String getUrl() {
        return "/create/editor?templateSize=insta_story";
    }

    public CanvasPage rightClick() {
     //   init();
        Actions action = new Actions(DriverHelper.get().getDriver());
        action.contextClick(canvas).build().perform();
        return this;
    }

    public boolean contextMenuDisplayed() {
        return isDisplayed(contextMenu);
    }

    @Override
    protected void isLoaded() throws Error {
        WaitHelper.getWait().waitForElementDisplayed(canvas);
    }
}

