package br.ce.mhtarif.core;

import static br.ce.mhtarif.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.ce.mhtarif.pages.LoginPage;


public class BaseTest {
	
	private static LoginPage page  = new LoginPage();
	
	@Before	
	public  void inicializa() {
		page.acessarTelaInicial();
		
		page.setEmail("hamude@modal.com");
		page.setSenha("123456789");
		page.entrar();
	}
	

	
	@Rule
	public TestName testName = new TestName();
	
	@After
	public void finaliza() throws IOException
	{
		TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver();	
	    File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File("target"+ File.separator +"screenshots" +
			File.separator +	testName.getMethodName()+"screenshot.jpg"));
	    
		if(Propriedades.FECHAR_BROWSER==true) {
			killDriver();
		}
	}

}
