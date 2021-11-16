import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Text;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class Mytest {

    private WebDriver driver;

    @Before
    public void setup(){
        String pathDriver = "chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathDriver);
        driver = new ChromeDriver();
    }

    //@After
    public void close(){
        driver.close();
    }

    @Test
    public void test1(){
        driver.navigate().to("http://localhost:4200");
        driver.findElement(By.xpath("/html/body/app-root/div/app-winter-fell/div[1]/p/span")).click();
        driver.findElement(By.xpath("/html/body/app-root/div/app-winter-fell/div[1]/p/span")).click();
        driver.findElement(By.xpath("/html/body/app-root/div/app-winter-fell/div[1]/p/span")).click();
        driver.findElement(By.xpath("/html/body/app-root/div/app-winter-fell/div[1]/p/span")).click();
        driver.findElement(By.xpath("/html/body/app-root/div/app-winter-fell/div[1]/p/span")).click();
        String count = driver.findElement(By.cssSelector("body > app-root > div > app-winter-fell > div:nth-child(2) > p")).getText();
        assertThat(count, containsString("5 times"));
    }

    @Test
    public void test2(){
        driver.navigate().to("http://localhost:4200");
        driver.findElement(By.xpath("/html/body/app-root/div/app-winter-fell/div[2]/p/input")).clear();
        driver.findElement(By.xpath("/html/body/app-root/div/app-winter-fell/div[2]/p/input")).sendKeys("SE");
        String count = driver.findElement(By.cssSelector("body > app-root > div > app-winter-fell > div:nth-child(3) > p")).getText();
        assertThat(count, containsString("SE"));
    }

    @Test
    public void test3(){
        driver.navigate().to("https://www.basketball-reference.com/teams/DAL/2022.html");
        WebElement tableElement = driver.findElement(By.id("per_game"));
        List<WebElement> rows = tableElement.findElements(By.tagName("tr"));

        for (int i = 0; i < rows.size(); i++) {
            String row = rows.get(i).getText();
            System.out.println(row);
        }
    }

}
