package TesteQa;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteCadastro {
	
WebDriver driver; 
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200,765));
		driver.get("https://www2.fiap.com.br/cadastro-qa/");
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test
	public void deveRealizarCadastroComSucesso() throws InterruptedException {
		    		
			TimeUnit.SECONDS.sleep(1);
			driver.findElement(By.id("txtNome")).click();
			
			driver.findElement(By.id("txtNome")).sendKeys("Yamaguche Soares Castro");
			
			driver.findElement(By.id("txtData")).sendKeys("05/08/1989");
			
			driver.findElement(By.id("txtEmail")).click();
			
			driver.findElement(By.id("txtEmail")).sendKeys("yamaguche@hotmail.com");
		
			driver.findElement(By.xpath("//*[@id=\'__next\']/div/form/div[3]/label[1]")).click();
			TimeUnit.SECONDS.sleep(1);
			driver.findElement(By.xpath("//*[@id='__next']/div/form/div[4]/button")).click();
			TimeUnit.SECONDS.sleep(1);
			//driver.findElement(By.xpath("//*[@id=\'__next\']/div/div/h2")).getText();
			//driver.findElement(By.xpath("//*[@id=\'__next\']/div/div/h2")).getText();
			WebElement elemento = driver.findElement(By.xpath("//*[@id=\'__next\']/div/div/h2"));
			System.out.println("" + elemento.getText());
			
			Assert.assertEquals("Yamaguche Soares Castro", driver.findElement(By.id("txtNome")).getText());
			Assert.assertEquals("CADASTRO REALISADO COM SUCESSO.", elemento.getText());
		
	}
}
