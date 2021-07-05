package br.com.eletrotecmotor.validacao;

public class ErroCadastroDto {
	
	
	private String cadastro;
	private String erro;
	
	public ErroCadastroDto(String field, String mensagem) {
		// TODO Auto-generated constructor stub
	}
	public String getCampo() {
		return cadastro;
	}
	public String getErro() {
		return erro;
	}
	

}
