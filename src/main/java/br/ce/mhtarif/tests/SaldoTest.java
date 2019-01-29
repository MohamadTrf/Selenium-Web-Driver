package br.ce.mhtarif.tests;

import org.junit.Assert;
import org.junit.Test;

import br.ce.mhtarif.core.BaseTest;
import br.ce.mhtarif.pages.HomePage;
import br.ce.mhtarif.pages.MenuPage;

public class SaldoTest extends BaseTest {
	HomePage page = new HomePage();
	MenuPage menu = new MenuPage();
	
	@Test
	public void testSaldoConta() {
		menu.acessarTelaPrincipal();
		Assert.assertEquals("534.00", page.obterSaldoConta("Conta para saldo"));
	}
	
}
