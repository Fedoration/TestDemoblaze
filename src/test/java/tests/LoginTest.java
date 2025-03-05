package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    /*
    1. Открыть страницу https://www.demoblaze.com/#
    2. Нажать кнопку Login in в верхнем
    3. Ввести поле username
    3. Ввести поле password
    4. Нажать кнопку Login in
    5. Проверить, что если неправильные креды, то всплывает окно
       Wrong password.
     */

    @Test
    public void checkNegativeLoginWithEmptyPassword() {
        loginPage.open()
                .loginForNegativeData("user", "user123456");
        assertEquals(loginPage.getErrorMessage(), "Wrong password.");
    }

    @Test
    public void checkPositiveLogin() {
        String user = "test";
        String password = "test";
        loginPage.open()
                .login(user, password);
        assertTrue(clientPage.isPageOpened());
    }
}
