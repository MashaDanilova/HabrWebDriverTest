
import org.junit.jupiter.api.Test; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.support.PageFactory;

class SearchTest {

   @Test
   public void find_habr_article() {     

	   WebDriver driver = new ChromeDriver();
       driver.get("https://duckduckgo.com/");
       DuckDuckSearchPage page = PageFactory.initElements(driver, DuckDuckSearchPage.class);
       page.searchFor("habrahabr");
       // ��������� ������ ������
       driver.findElement(By.xpath("//*[@id='r1-0']/div/h2/a[1]")).click();
       // ��������� ���������
       driver.findElement(By.xpath("//*[@id=\"navbar-links\"]/li[6]/a")).click();
       // ��������� �� ������ �������� ���������
       driver.findElement(By.xpath("//*[@id=\"nav-pagess\"]/li[2]/a")).click();
       // ������� �������, "����������" ������ ������ �� ��������
       WebElement titleEl = driver.findElement(By.xpath("//*[@id=\"post_131901\"]/h2/a"));
       // ���������� �������� ������
       String title = titleEl.getText();
       // ���������� url ������
       String titleHabrUrl = titleEl.getAttribute("href");
       
       if (titleHabrUrl.contains("/ru/"))
       {
    	   titleHabrUrl = titleHabrUrl.replace("/ru/", "/");
       }
       
       driver.get("https://duckduckgo.com/");
       DuckDuckSearchPage npage = PageFactory.initElements(driver, DuckDuckSearchPage.class);
       // ���� � ���������� �������� ������
       npage.searchFor(title);
       
       // ���� � ����������� ������ ������ �������� ������ ��� ������
       WebElement duckSearch = driver.findElement(By.partialLinkText(title.substring(0, 15)));
       // ���������� url ��������� ������
       String titleDuckUrl = duckSearch.getAttribute("href");
       duckSearch.click();       
       
       assertTrue(titleHabrUrl.equals(titleDuckUrl));
       
       driver.quit();
	   
   }
}