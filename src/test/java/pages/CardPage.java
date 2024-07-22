package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import singletone.Singletone;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.time.Duration;

public class CardPage extends BasePage
{
    WebDriverWait wait = new WebDriverWait(Singletone.getDriver(), Duration.ofSeconds(10));
    private By cardNumberLabel = By.xpath("//div[@class='page-indicator']");
    private By passwordInput = By.xpath("//input[@placeholder='Choose Password']");
    private By emailInput = By.xpath("//input[@placeholder='Your email']");
    private By domainInput = By.xpath("//input[@placeholder='Domain']");
    private By domainDropDown = By.xpath("//div[contains(@class, 'dropdown__list-item')]");
    private By dropDownButtton = By.xpath("//span[@class='icon icon-chevron-down']");
    private By nextButton = By.xpath("//a[@class='button--secondary']");
    private By acceptConditionsButton = By.xpath("//span[@class='icon icon-check checkbox__check']");
    private By checkBoxes = By.xpath("//span[@class='checkbox__box']");
    private By nextButtonSecondCard = By.xpath("//button[contains(text(), 'Next')]");
    private By imageUploadButton = By.xpath("//a[@class='avatar-and-interests__upload-button']");
    private By downloadButtob = By.xpath("//button[contains(text(), 'Download image')]");
        private By denyCookieButton = By.xpath("//button[@class='button button--solid button--transparent']");

    public CardPage()
    {
        super("//div[@class='page-indicator']");
    }

    public String GetCardNumber()
    {
        String[] parts = Singletone.getDriver().findElement(cardNumberLabel).getText().split("/");
        return parts[0];
    }

    public void login()
    {
        Singletone.getDriver().findElement(passwordInput).clear();
        Singletone.getDriver().findElement(passwordInput).sendKeys("asdsa@2aAFFASFF!");
        Singletone.getDriver().findElement(emailInput).clear();
        Singletone.getDriver().findElement(emailInput).sendKeys("asdsa@2aAFFASFF!");
        Singletone.getDriver().findElement(domainInput).clear();
        Singletone.getDriver().findElement(domainInput).sendKeys("asdsa@2aAFFASFF!");
        Singletone.getDriver().findElement(dropDownButtton).click();
        Singletone.getDriver().findElements(domainDropDown).get(2).click();
        Singletone.getDriver().findElement(acceptConditionsButton).click();
        Singletone.getDriver().findElement(nextButton).click();
    }

    public void uploadImageAndSelectCheckboxes(int checkBoxNumber)
    {
        Singletone.getDriver().findElements(checkBoxes).getLast().click();
        for (int i = 1; i <= checkBoxNumber; i++)
        {
            Singletone.getDriver().findElements(checkBoxes).get(i).click();
        }

            Singletone.getDriver().findElement(downloadButtob).click();

            Singletone.getDriver().findElement(imageUploadButton).click();

            try {
                Robot robot = new Robot();
                robot.setAutoDelay(2000);
                StringSelection stringSelection = new StringSelection("\"C:\\Users\\f.amiraslanov\\Downloads\\avatar.png\"");
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

                // Press Ctrl+V to paste the file path
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);

                // Press Enter to close the dialog
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
            }
            catch (AWTException e)
            {e.printStackTrace();}


        Singletone.getDriver().findElement(nextButtonSecondCard).click();
    }

    public void closeCookies()
    {
        wait.until(ExpectedConditions.elementToBeClickable(denyCookieButton));
        Singletone.getDriver().findElement(denyCookieButton).click();
        Assert.assertFalse(Singletone.getDriver().findElement(denyCookieButton).isDisplayed());
    }
}
