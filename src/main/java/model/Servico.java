package model;

public class Servico {
	
	private Integer id_funcionario;
	private String referencia;
	private String descricao;
	private String tipo;
	private Double valorServico;
	private Double valorMax;
	private Double valorMin;
	

	
	
	public Servico(Integer id_funcionario, String referencia, String descricao, String tipo, Double valorServico,
			Double valorMax, Double valorMin) {		
		this.id_funcionario = id_funcionario;
		this.referencia = referencia;
		this.descricao = descricao;
		this.tipo = tipo;
		this.valorServico = valorServico;
		this.valorMax = valorMax;
		this.valorMin = valorMin;
	}
	
	public Integer getId_funcionario() {
		return id_funcionario;
	}
	public void setId_funcionario(Integer id_funcionario) {
		this.id_funcionario = id_funcionario;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Double getValorServico() {
		return valorServico;
	}
	public void setValorServico(Double valorServico) {
		this.valorServico = valorServico;
	}
	public Double getValorMax() {
		return valorMax;
	}
	public void setValorMax(Double valorMax) {
		this.valorMax = valorMax;
	}
	public Double getValorMin() {
		return valorMin;
	}
	public void setValorMin(Double valorMin) {
		this.valorMin = valorMin;
	}
	
	
	
	
}
