import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.CardPage;
import pages.MainPage;
import singletone.Singletone;

public class UserinyerfaceTests
{
    private String baseUrl = "https://userinyerface.com/";

    @Before
    public void setUp()
    {
        Singletone.getDriver().get(baseUrl);
        Singletone.getDriver().manage().window().maximize();
    }

    @Test
    public void userinyerfaceTests()
    {
        MainPage mainPage = new MainPage();
        Assert.assertTrue( mainPage.isDisplayed());
        mainPage.clickStartLink();
        CardPage cardPage = new CardPage();
        cardPage.closeCookies();
        Assert.assertEquals("1 ", cardPage.GetCardNumber());
        cardPage.login();
        Assert.assertEquals("2 ", cardPage.GetCardNumber());
        cardPage.uploadImageAndSelectCheckboxes(3);
        Assert.assertEquals("3 ", cardPage.GetCardNumber());


    }

    @After
    public void tearDown()
    {
        if (Singletone.getDriver() != null)
        {
            Singletone.getDriver().quit();
        }
    }
}
