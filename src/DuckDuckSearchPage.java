import org.openqa.selenium.WebElement;

public class DuckDuckSearchPage {
	// ������ ������
	private WebElement search_form_input_homepage;
    // ����� ������ ���������� � ��������� ������
    public void searchFor(String text) {
    	search_form_input_homepage.sendKeys(text);
    	search_form_input_homepage.submit();
    }
}
