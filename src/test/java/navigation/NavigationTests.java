package navigation;
// CON ESTE TEST SE NAVEGARÁ ENTRE PAGINAS
import base.BaseTests;
import org.testng.annotations.Test;

public class NavigationTests extends BaseTests {
  // We can do homePage.clickDynamicLoading, which will give us Dynamic Loading page. And then
  // we could say clickExample1, which gives us the DynamicLoadingExample1Page.
    @Test
    public void testNavigator(){
        homePage.clickDynamicLoading().clickExample1();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://google.com");
    }

    @Test
    public void testSwitchTab(){
        homePage.clickMultipleWindows().clickHere();
        getWindowManager().switchToTab("New Window");
    }
}
