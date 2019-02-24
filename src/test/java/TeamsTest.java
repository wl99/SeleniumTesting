import org.junit.jupiter.api.*;
import page.HomePage;
import page.TeamListPage;
import page.TeamPage;

import static java.time.Duration.ofMinutes;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTimeout;

/**
 * Created by wwl on 2019/2/19.
 */
public class TeamsTest {
    private static HomePage homePage;

    private

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
//        homePage.gotoHomePage();
    }


    @Test
    void 未登录点击霍格沃兹测试学院测试2() {
        TeamListPage actualResult1 = assertTimeout(ofMinutes(2), () -> homePage.gotoTeams2());
        TeamPage actualResult = assertTimeout(ofMinutes(2), () -> actualResult1.gotoTeamPageByName("霍格沃兹测试学院"));
        String result = actualResult.clickFirstTopicFail().getAlertText();
        assertThat(result, equalTo("访问被拒绝，你可能没有权限或未登录。"));
//        homePage.gotoHomePage();
    }

    @AfterAll
    static void teardown() {
        HomePage.quit();
    }
}
