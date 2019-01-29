package br.ce.mhtarif.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.mhtarif.core.BaseTest;
import br.ce.mhtarif.pages.ContasPage;
import br.ce.mhtarif.pages.MenuPage;

public class RemoverMovimentacaoContaTest extends BaseTest{
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	
	@Test 
	public void testExcluirContaComMovimentacao() {
		menuPage.acessarTelaListarConta();
		
		contasPage.clicarExcluirConta("Conta com movimentacao");
		
		Assert.assertEquals("Conta em uso na movimentações",contasPage.obterMensagemErro());

	}

}
