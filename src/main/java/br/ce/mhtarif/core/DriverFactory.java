package br.ce.mhtarif.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import br.ce.mhtarif.core.Propriedades.TipoExecucao;

public class DriverFactory {
	
	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>(){
		@Override
		protected synchronized WebDriver initialValue() {
			return initDriver();
		}
	};
	
	public DriverFactory() {}
	
	public static WebDriver getDriver() {
	  return threadDriver.get();
	}
	
	public static WebDriver initDriver() {
		WebDriver driver = null;	
		
		if(Propriedades.TIPO_EXECUCAO == TipoExecucao.LOCAL) {
			switch (Propriedades.BROWSER) {
			case FIREFOX: 
				System.setProperty("gecko.driver","C:\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				break;
			case CHROME:
				System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");
				driver = new  ChromeDriver();
				break;
		}
	}
		if(Propriedades.TIPO_EXECUCAO == TipoExecucao.GRID) {
			DesiredCapabilities cap = null;
			
			switch (Propriedades.BROWSER) {
			case FIREFOX: 
				cap = DesiredCapabilities.firefox();
				break;
			case CHROME:
				cap = DesiredCapabilities.chrome();
				break;
			default:
				break;
			}
			
			try {
				driver = new RemoteWebDriver(new URL("http://192.168.15.127:4444/wd/hub") , cap);
			} catch (MalformedURLException e) {
				System.out.println("Falha na conexão com o GRID");
				e.printStackTrace();
			}
		}
		
		if(Propriedades.TIPO_EXECUCAO == TipoExecucao.NUVEM) {
			DesiredCapabilities cap = null;
			
			switch (Propriedades.BROWSER) {
			case FIREFOX: 
				cap = DesiredCapabilities.firefox();
				break;
			case CHROME:
				cap = DesiredCapabilities.chrome();
				break;
			default:
				break;
			}
			
			try {
				driver = new RemoteWebDriver(new URL("http://MohamadTrf123::fa237e8d-d73c-4b68-82c2-c5eaeb983f70@ondemand.saucelabs.com:80/wd/hub") , cap);
			} catch (MalformedURLException e) {
				System.out.println("Falha na conexão com o GRID");
				e.printStackTrace();
			}
		}
		
		driver.manage().window().setSize(new Dimension(1200, 765));
		return driver;
	}
	
	public static void killDriver() {
		WebDriver driver = getDriver();
		if(driver!=null) {
			driver.quit();
			driver = null;
		}
		if(threadDriver != null) {
			threadDriver.remove(); 
		}
	}
	
}
