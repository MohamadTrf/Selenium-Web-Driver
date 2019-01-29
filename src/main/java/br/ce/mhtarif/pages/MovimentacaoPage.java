package br.ce.mhtarif.pages;

import java.util.ArrayList;
import java.util.List;

import static br.ce.mhtarif.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.ce.mhtarif.core.BasePage;

public class MovimentacaoPage extends BasePage {
	
	public void setDataMovimentacao(String data) {
		escreve("data_transacao", data);
	}

	public void setDataPagamento(String data) {
		escreve("data_pagamento", data);
	}
	
	public void setDescricao(String descricao) {
		escreve("descricao", descricao);
	}
	
	public void setInteressado(String interessado) {
		escreve("interessado", interessado);
	}
	
	public void setValor(String valor) {
		escreve("valor", valor);
	}
	
	public void setConta(String conta) {
		selecionaCombo("conta", conta);
	}
	
	public void setStatusPago() {
		clicaRadio("status_pago");
	}
	
	public void salvar() {
		clicarBotaoPorTexto("Salvar");
	}
	
	public String obterMensagemSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public List<String> obterErros(){
		List<WebElement> erros = getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
		List<String> retorno = new ArrayList<String>(); 
		
		for(WebElement erro: erros) {
			retorno.add(erro.getText());
		}
		return retorno;
	}

}
