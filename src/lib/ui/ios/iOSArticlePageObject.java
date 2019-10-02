package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class iOSArticlePageObject extends ArticlePageObject {
    static
    {
        TITLE = "id:Java (programming language)";
        FOOTER_ELEMENT = "id:View article in browser";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
        CLOSE_SYNC_YOUR_SAVED_ARTICLES_BUTTON = "id:places auth close";
        CLOSE_ARTICLE_BUTTON = "id:Back";
        SUBTITLE = "id:Object-oriented programming language";
    }
    public iOSArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

}
