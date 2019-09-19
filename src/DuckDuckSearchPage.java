import org.openqa.selenium.WebElement;

public class DuckDuckSearchPage {
	// строка поиска
	private WebElement search_form_input_homepage;
    // метод поиска информации в поисковой строке
    public void searchFor(String text) {
    	search_form_input_homepage.sendKeys(text);
    	search_form_input_homepage.submit();
    }
}
