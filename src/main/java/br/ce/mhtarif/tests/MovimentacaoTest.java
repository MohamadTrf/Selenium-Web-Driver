package br.ce.mhtarif.tests;

import static br.ce.mhtarif.utills.DataUtils.obterDataFormatada;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.ce.mhtarif.core.BaseTest;
import br.ce.mhtarif.pages.MenuPage;
import br.ce.mhtarif.pages.MovimentacaoPage;
import br.ce.mhtarif.utills.DataUtils;

public class MovimentacaoTest extends  BaseTest{
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();
	
	
	@Test
	public void test1_InserirMovimentacao() {
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.setDataMovimentacao(obterDataFormatada(new Date()));
		movPage.setDataPagamento(obterDataFormatada(new Date()));
		movPage.setDescricao("Movimentação do Teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("510");
		movPage.setConta("Conta para movimentacoes");
		movPage.setStatusPago();
		movPage.salvar();
		
		Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMensagemSucesso());
	}
	
	@Test
	public void test2_CamposObrigatorios() {
		menuPage.acessarTelaInserirMovimentacao();
		
		movPage.salvar();
		List<String> erros =  movPage.obterErros();
		//Assert.assertEquals("Data da movimentação é obrigatorio", erros.get(0));
		//Assert.assertTrue(erros.contains("Data da movimentação é obrigatorio"));
		/*Assert.assertTrue(erros.containsAll(Arrays.asList(
				 "Data da movimentação é obrigatorio", "Data do Pagamento é Obrigatorio",
				  "Descrição é obrigatório", "Interessado é obrigatório", "Valor é obrigatório",
				  "Valor deve ser um número")));*/
		Assert.assertEquals(6, erros.size());
	}
	
	@Test
	public void test3_InserirMovimentacaoFutura() {
		menuPage.acessarTelaInserirMovimentacao();
		
		Date dataFutura = DataUtils.obterDataComDiferencaDias(5); // jogando a data atual para 5 dias a frente
		String dataFormatada = DataUtils.obterDataFormatada(dataFutura);
		
		movPage.setDataMovimentacao(dataFormatada);
		movPage.setDataPagamento(dataFormatada);
		movPage.setDescricao("Movimentação do Teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("510");
		movPage.setConta("Conta para movimentacoes");
		movPage.setStatusPago();
		movPage.salvar();

		List<String> erros =  movPage.obterErros();
		//Assert.assertEquals("Data da movimentação é obrigatorio", erros.get(0));
		//Assert.assertTrue(erros.contains("Data da movimentação é obrigatorio"));
		Assert.assertTrue(erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
		Assert.assertEquals(1, erros.size());
	}
	
}
