package pages;

import org.openqa.selenium.By;
import singletone.Singletone;

public class BasePage
{
    private By baseElement;

    BasePage(String baseElement){
        this.baseElement = By.xpath(baseElement);
    }

    public boolean isDisplayed()
    {
        return Singletone.getDriver().findElement(this.baseElement).isDisplayed();
    }
}
