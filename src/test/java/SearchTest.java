import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page.HomePage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by wwl on 2019/2/19.
 */
public class SearchTest {
    private static HomePage homePage;

    private

    @BeforeAll
    static void setup() {
        homePage = HomePage.start();
    }

    @ParameterizedTest
    @CsvSource({
            "Selenium",
            "python"
    })
    void 搜索测试(String keyword) {
        String result = homePage.sendKeysToSearchInput(keyword).actionSendEnter().getResultText();
        String[] buff = result.split(" “|” ");
        //result = 关于 “Selenium” 的搜索结果, 共 1301 条
        // 截取查询关键字对比是否一致
        assertThat(keyword, equalTo(buff[1]));
    }

    @AfterAll
    static void teardown() {
        HomePage.qiut();
    }
}
