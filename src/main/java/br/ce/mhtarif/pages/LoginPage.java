package br.ce.mhtarif.pages;

import br.ce.mhtarif.core.BasePage;
import br.ce.mhtarif.core.DriverFactory;

public class LoginPage extends BasePage {

	public void acessarTelaInicial() {
		DriverFactory.getDriver().get("https://srbarriga.herokuapp.com/logout");
	}
	
	public void setEmail(String email) {
		escreve("email", email);
	}
	
	public void setSenha(String senha) {
		escreve("senha", senha);
	}
	
	public void entrar() {
		clicarBotaoPorTexto("Entrar");
	}
	
	public void logar(String email, String senha) {
		setEmail(email);
		setSenha(senha);
		entrar();
	}
	
	public void resetar() {
		clicarLink("reset");
	}
}
