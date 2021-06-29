package br.com.eletrotecmotor.modelo;

public enum Status {
	
	Fechado, //pedido cancelado
	Concluido, // entregue ao cliente
	Em_Andamento, // sendo executado
	Em_Espera, //esperando peças 
	Retirada, // retirado pelo cliente
	Aberto, // abertura do pedido

}
