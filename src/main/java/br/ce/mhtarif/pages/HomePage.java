package br.ce.mhtarif.pages;

import br.ce.mhtarif.core.BasePage;

public class HomePage extends BasePage {

	public String obterSaldoConta(String nome) {
	 return obterCelula("Conta", nome, "Saldo", "tabelaSaldo").getText();  
	}
}
