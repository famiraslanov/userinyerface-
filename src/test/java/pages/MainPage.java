package pages;

import org.openqa.selenium.By;
import singletone.Singletone;

public class MainPage extends BasePage
{
    private final By startLink = By.xpath("//a[@class='start__link']");

    public MainPage()
    {
        super("//button[@class='start__button']");
    }

    public void clickStartLink()
    {
        Singletone.getDriver().findElement(startLink).click();
    }
}
