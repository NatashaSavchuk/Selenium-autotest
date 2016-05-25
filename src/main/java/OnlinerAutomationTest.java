
import steps.Steps;



public class OnlinerAutomationTest {
    private Steps steps;
    private final String USERNAME = "testsel2015@yandex.ru";
    private final String PASSWORD = "test123";
    private final String USERID = "1942578";

    private final String TITLE = "Buy refrigerator";
    private final String TEXTAD = "Buy refrigerator. Inexpensively";
    private final String SHORTTEXT = "refrigerator";
    private final String PRICE = "2000000";

    private final String SEARCHTEXT = "iPhone";

    private final Integer VALUECOUNTMANY = 56;

    private final String NAME = "Natalia32";
    private final String TITLE2 = "The event will take place";
    private final String TEXT = "The event will take place on Wednesday evening.";

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