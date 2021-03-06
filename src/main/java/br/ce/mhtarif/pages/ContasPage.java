package br.ce.mhtarif.pages;

import org.openqa.selenium.By;

import br.ce.mhtarif.core.BasePage;

public class ContasPage extends BasePage {

	public void setNome(String nome) {
		escreve("nome", nome);
	}
	
	public void salvar() {
		clicarBotaoPorTexto("Salvar");
	}
	
	public String obterMensagemSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public String obterMensagemErro() {
		return obterTexto(By.xpath("//div[@class='alert alert-danger']"));
	}

	public void clicarAlterarConta(String conta) {
		obterCelula("Conta", conta, "Ações", "tabelaContas")
			.findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
	}
	public void clicarExcluirConta(String conta) {
		obterCelula("Conta", conta, "Ações", "tabelaContas")
		.findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
	}

}
