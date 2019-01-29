package br.ce.mhtarif.tests;

import static br.ce.mhtarif.core.DriverFactory.getDriver;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.mhtarif.core.BaseTest;
import br.ce.mhtarif.core.DriverFactory;
import br.ce.mhtarif.pages.MenuPage;
import br.ce.mhtarif.pages.ResumoPage;


public class ResumoTest extends BaseTest {
	private MenuPage menuPage = new MenuPage();
	private ResumoPage resumoPage = new ResumoPage();
	
	@Test
	public void test1ExcluirMovimentacao() {
		menuPage.acessarTelaResumo();
		
		resumoPage.excluirMovimentacao();
		
		Assert.assertEquals("Movimentação removida com sucesso!", 
				resumoPage.obterMensagemSucesso());
	}

	@Test
	public void test2ResumoMensal() {
		menuPage.acessarTelaResumo();
		
		Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
		
		resumoPage.selecionarAno("2017");
		resumoPage.buscar();
		
		List<WebElement> elementosEncontrados  = 
				DriverFactory.getDriver().findElements(By.xpath(".//*[@id='tabelaExtrato']/tbody/tr"));
		

		
		Assert.assertEquals(0, elementosEncontrados.size());
		
	}

}
