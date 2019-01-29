package br.ce.mhtarif.suites;


import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.mhtarif.core.DriverFactory;
import br.ce.mhtarif.pages.LoginPage;
import br.ce.mhtarif.tests.ContaTest;
import br.ce.mhtarif.tests.MovimentacaoTest;
import br.ce.mhtarif.tests.RemoverMovimentacaoContaTest;
import br.ce.mhtarif.tests.ResumoTest;
import br.ce.mhtarif.tests.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoTest.class
})
public class SuiteGeral {	
	private static LoginPage page = new LoginPage();
	
	@BeforeClass
	public static void reset() {
		page.acessarTelaInicial();
		
		page.setEmail("hamude@modal.com");
		page.setSenha("123456789");
		page.entrar();
		
		page.resetar();
		
		DriverFactory.killDriver();
	}

}
