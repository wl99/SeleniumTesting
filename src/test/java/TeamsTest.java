import listener.TimingExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import page.HomePage;
import page.LoginPage;
import taginterface.FastTest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by wwl on 2019/2/19.
 */
@ExtendWith(TimingExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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

    @Order(2)
    @FastTest
    void 未登录点击霍格沃兹测试学院测试1() {
        LoginPage loginPage = homePage.gotoTeams().gotoHogwarts().clickFirstTopicFail();
        String result = loginPage.getAlertText();
        loginPage.gotoHomePage();

        assertThat(result, equalTo("访问被拒绝，你可能没有权限或未登录。"));
    }


    @Order(3)
    @Test
    void notLoginClickHogwarts() {
        LoginPage loginPage = homePage.gotoTeams2().
                gotoTeamPageByName("霍格沃兹测试学院").
                clickFirstTopicFail();
        String result = loginPage.getAlertText();

        assertThat(result, equalTo("访问被拒绝，你可能没有权限或未登录。"));
        loginPage.gotoHomePage();
    }

    @Order(1)
    @Disabled()
    @Test
    void 未登录点击霍格沃兹测试学院测试3() {
        LoginPage loginPage = homePage.gotoTeams().gotoHogwarts().clickFirstTopicFail();
        String result = loginPage.getAlertText();
        loginPage.gotoHomePage();

        assertThat(result, equalTo("访问被拒绝，你可能没有权限或未登录。"));
    }

//    @AfterAll
//    static void teardown() {
//        HomePage.quit();
//    }
}
