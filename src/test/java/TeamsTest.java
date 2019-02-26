import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.HomePage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by wwl on 2019/2/19.
 */
public class TeamsTest {
    private static HomePage homePage;

    @BeforeAll
    static void setup() {
        homePage = HomePage.start();
    }

//    @BeforeEach
//    void gotoHome(){
//
//    }

    @Test
    void 未登录点击霍格沃兹测试学院测试1() {
        String result = homePage.gotoTeams().gotoHogwarts().clickFirstTopicFail().getAlertText();
        assertThat(result, equalTo("访问被拒绝，你可能没有权限或未登录。"));
    }


    @Test
    void notLoginClickHogwarts() {
        String result =homePage.gotoTeams2().
                gotoTeamPageByName("霍格沃兹测试学院").
                clickFirstTopicFail().getAlertText();

        assertThat(result, equalTo("访问被拒绝，你可能没有权限或未登录。"));
    }

    @Test
    void 未登录点击霍格沃兹测试学院测试3() {
        String result = homePage.gotoTeams().gotoHogwarts().clickFirstTopicFail().getAlertText();
        assertThat(result, equalTo("访问被拒绝，你可能没有权限或未登录。"));
    }

//    @AfterAll
//    static void teardown() {
//        HomePage.quit();
//    }
}
