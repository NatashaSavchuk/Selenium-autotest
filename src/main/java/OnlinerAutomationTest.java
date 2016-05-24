import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.Steps;

public class OnlinerAutomationTest {
    private Steps steps;
    private final String USERNAME = "testselen2015@yandex.ru";
    private final String PASSWORD = "test123";
    private final String USERID = "1942578";

    private final String TITLE = "Куплю холодильник";
    private final String TEXTAD = "Куплю холодильник. Не дорого";
    private final String SHORTTEXT = "Холодильник";
    private final String PRICE = "2000000";

    private final String SEARCHTEXT = "iPhone";

    private final Integer VALUECOUNTMANY = 56;

    private final String NAME = "Natalia32";
    private final String TITLE2 = "Событие стостоится";
    private final String TEXT = "Событие состоится в среду вечером.";

    @BeforeMethod(description = "Init browser")
    public void setUp()
    {
        steps = new Steps();
        steps.initBrowser();
    }


    @Test(description = "Login to Onliner")
    public void oneCanLoginOnliner()
    {
        steps.loginOnliner(USERNAME, PASSWORD);
        Assert.assertTrue(steps.isLoggedIn(USERID));
    }

    @Test(description = "Add new ad")
    public void oneCanAddAd()
    {

        steps.loginOnliner(USERNAME, PASSWORD);
        steps.addAd(TITLE,TEXTAD,SHORTTEXT,PRICE);

        Assert.assertTrue(steps.isAdded(TITLE));
    }

    @Test(description = "Search")
    public void oneCanSearch()
    {
        steps.search(SEARCHTEXT);

        Assert.assertTrue(steps.isSearchPopupDisplayed());
    }

    @Test(description = "Exchange")
    public void oneCanExchangeOperation()
    {
        steps.currency(VALUECOUNTMANY);
        Assert.assertTrue(steps.isTrueCorrency(VALUECOUNTMANY));
    }

    @Test(description = "SendMessage")
    public void oneCanSendMessage()
    {
        steps.loginOnliner(USERNAME,PASSWORD);
        steps.sendMessage(NAME, TITLE2, TEXT);

        Assert.assertTrue(steps.isMessageSent(TITLE));
    }


    @AfterMethod(description = "Stop Browser")
    public void stopBrowser()
    {
        steps.closeDriver();
    }
}
