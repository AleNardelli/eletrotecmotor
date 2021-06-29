package br.com.eletrotecmotor.vadidacao;

public class ErroClienteCadastroDto {

	private String cadastro;
	private String erro;
	public ErroClienteCadastroDto(String field, String mensagem) {
		
	}
	public String getMensagem() {
		return cadastro;
		
	}
		
	public String getErro() {
		return erro;
	}
}
