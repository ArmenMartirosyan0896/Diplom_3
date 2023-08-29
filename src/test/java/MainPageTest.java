import base.ExtendsTest;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;


@DisplayName("Тесты главной страницы")
public class MainPageTest extends ExtendsTest {

    @Before
    @DisplayName("Открываю главную страницу без авторизации")
    public void setupMainPage() {
        mainPage.open();
    }

    @Test
    @DisplayName("Раздел Булки")
    @Description("Выбираю раздел Булки и проверяю заголовок")
    public void chooseBunsTabTest() {
        mainPage.chooseFillingsTab();
        String expectedSection = "Булки";
        mainPage.chooseBunsTab();
        String activeSection = mainPage.getActiveSection();
        Assert.assertEquals("Раздел 'Булки' не активен", expectedSection, activeSection);
        assertTrue("Метод chooseBunsTab() вернул некорректное значение", mainPage.checkActiveSectionIs(expectedSection));
    }


    @Test
    @DisplayName("Раздел Начинки")
    @Description("Выбираю раздел Начинки и проверяю заголовок")
    public void chooseFillingsTabTest() {
        String expectedSection = "Начинки";
        mainPage.chooseFillingsTab();
        String activeSection = mainPage.getActiveSection();
        Assert.assertEquals("Раздел 'Начинки' не активен", expectedSection, activeSection);
        assertTrue("Метод chooseFillingsTab() вернул некорректное значение", mainPage.checkActiveSectionIs(expectedSection));
    }

    @Test
    @DisplayName("Проверка активности раздела Соусы")
    @Description("Проверяю, что раздел Соусы активен на главной странице")
    public void checkSaucesTabIsActiveTest() {
        String expectedSection = "Соусы";
        mainPage.chooseSaucesTab();
        String activeSection = mainPage.getActiveSection();
        Assert.assertEquals("Раздел 'Соусы' не активен", expectedSection, activeSection);
        assertTrue("Метод chooseSaucesTab() вернул некорректное значение", mainPage.checkActiveSectionIs(expectedSection));
    }
}
