package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import lib.Platform;

abstract public class ArticlePageObject extends MainPageObject
{
    protected static String
    TITLE,
    FOOTER_ELEMENT,
    OPTIONS_BUTTON,
    OPTIONS_ADD_TO_MY_LIST_BUTTON,
    ADD_TO_MY_LIST_OVERLAY,
    MY_LIST_NAME_INPUT,
    MY_LIST_OK_BUTTON,
    CLOSE_SYNC_YOUR_SAVED_ARTICLES_BUTTON,
    CLOSE_ARTICLE_BUTTON,
    SUBTITLE;

    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
       return this.waitForElementPresent(TITLE, "Cannot find article title on page!", 15);
    }
    public WebElement waitForSubtitleElement()
    {
        return this.waitForElementPresent(SUBTITLE,"Cannot find article subtitle on page!", 15);
    }

    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        if (Platform.getInstance().isAndroid())
        {
            return title_element.getAttribute("text");
        }
        else
        {
            return title_element.getAttribute("name");
        }
    }

    public String getArticleSubtitle()
    {
        WebElement subtitle_element = waitForSubtitleElement();
        if (Platform.getInstance().isAndroid())
        {
            return subtitle_element.getAttribute("text");
        }
        else
        {
            return subtitle_element.getAttribute("name");
        }
    }

    public void swipeToFooter()
    {
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    60
            );
        }
        else {
            swipeUpTillElementAppear(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    60
            );
        }
    }
    public void addArticleToMyList(String name_of_folder)
    {
         this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option to add first article to reading list",
                5
        );
        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "Cannot find 'Got it' tip overlay",
                15
        );
        this.waitForElementAndClear(
                MY_LIST_NAME_INPUT,
                "Cannot find input to set name of articles folder",
                5
        );

        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "cannot put text into articles folder input",
                5
        );
        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot press 'OK' button",
                5
        );
    }

    public void addNextArticleToMyList(String name_of_folder)
    {
        waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options (second search- Appium article)",
                5
        );

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option to add article to reading list (second search- Appium article)",
                5
        );
        waitForElementAndClick(
                "xpath://*[@text='" + name_of_folder + "']",
                "Сannot add an article to an existing list (second search - Appium article)",
                15
        );
    }

    public void addArticlesToMySaved()
    {
        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option to add article to reading list",
                5
        );
    }

    public void closeSyncWindow()
    {
        this.waitForElementAndClick(
                CLOSE_SYNC_YOUR_SAVED_ARTICLES_BUTTON,
                "Cannot find and tap X link on sync window",
                5
        );
    }

    public void closeArticle()
    {
        this.waitForElementAndClick(
                CLOSE_ARTICLE_BUTTON,
                "Cannot close article, cannot find X link",
                10
        );
    }
    public void assertThereAreTitleElementsInTheArticle()
    {
        this.assertElementPresent(TITLE, "We supposed to find any titles in the article!");
    }
}
