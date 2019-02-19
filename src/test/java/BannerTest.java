import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import page.EventPage;
import page.HomePage;

import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by wwl on 2019/2/19.
 */
public class BannerTest {
    private static HomePage homePage;

    private

    @BeforeAll
    static void setup() {
        homePage = HomePage.start();
    }

    @RepeatedTest(5)
    @DisplayName("重复打开banner链接5次")
    void banner跳转测试() {
        String handle = homePage.getCurrentWindowHandle();
        EventPage eventPage = homePage.clickBanner();
        String eventTitle = eventPage.getPageTitle();
        assertThat(eventTitle, containsStringIgnoringCase("互联网测试开发大会"));
        // 返回主页面
        eventPage.gotoHomePage(handle);
    }

    @AfterAll
    static void teardown() {
        HomePage.qiut();
    }

}
