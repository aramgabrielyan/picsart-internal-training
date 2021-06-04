package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static setup.DriverSetup.getDriver;

public class CanvasPage extends BasePage {
    @FindBy(css = "[data-test='canvas-container'] .konvajs-content")
    private WebElement canvas;

    @FindBy(id = "context-menu")
    private WebElement contextMenu;


    public CanvasPage open() {
        open(getUrl());
        PageFactory.initElements(getDriver(), this);
        return this;
    }

    public CanvasPage init() {
        PageFactory.initElements(getDriver(), this);
        return this;
    }

    @Override
    public String getUrl() {
        return BASE_URL + "/create/editor?templateSize=insta_story";
    }

    public CanvasPage rightClick() {
        init();
        Actions action = new Actions(getDriver());
        action.contextClick(canvas).build().perform();
        return this;
    }

    public boolean contextMenuDisplayed() {
        return isDisplayed(contextMenu);
    }
}

