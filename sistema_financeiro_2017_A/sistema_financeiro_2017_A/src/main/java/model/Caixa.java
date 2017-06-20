package model;



public class Caixa {
	private int id_caixa;
	private String data;
	private String descricao;
	private double valor;
	private boolean status;
	private int formapagamento,id_tipodespesa,id_cliente;
	
	
	public Caixa(){}

	public Caixa(String data, String descricao, double valor, boolean status, int formapagamento, int id_tipodespesa,
			int id_cliente) {
		super();
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
		this.status = status;
		this.formapagamento = formapagamento;
		this.id_tipodespesa = id_tipodespesa;
		this.id_cliente = id_cliente;
	}





	public int getId_caixa() {
		return id_caixa;
	}





	public void setId_caixa(int id_caixa) {
		this.id_caixa = id_caixa;
	}





	public String getData() {
		return data;
	}





	public void setData(String data) {
		this.data = data;
	}





	public String getDescricao() {
		return descricao;
	}





	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}





	public double getValor() {
		return valor;
	}





	public void setValor(double valor) {
		this.valor = valor;
	}





	public boolean isStatus() {
		return status;
	}





	public void setStatus(boolean status) {
		this.status = status;
	}





	public int getFormapagamento() {
		return formapagamento;
	}





	public void setFormapagamento(int formapagamento) {
		this.formapagamento = formapagamento;
	}





	public int getId_tipodespesa() {
		return id_tipodespesa;
	}





	public void setId_tipodespesa(int id_tipodespesa) {
		this.id_tipodespesa = id_tipodespesa;
	}





	public int getId_cliente() {
		return id_cliente;
	}





	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	};

	

}
