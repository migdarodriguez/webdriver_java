package login;

import base.BaseTests;
import Pages.LoginPage;
import Pages.SecureAreaPage;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");      // PROBAR QUé HACE CON CREDENCIALES ERRADAS
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        assertTrue(secureAreaPage.getAlertText()
                        .contains("You logged into a secure area!"),
                "Alert text is incorrect");
        assertFalse(secureAreaPage.getAlertText()
                        .contains("Tus credenciales son erradas"),
                "Usuario o password incorrectos");

        //assertEquals(secureAreaPage.getAlertText(), "You logged into a secure area!", "Alert text is incorrect");
    }
}
