package br.com.microservice.cliente.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ErroDeClienteDTO {
	
	private String campo;
	private String mensagem;
	
	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
