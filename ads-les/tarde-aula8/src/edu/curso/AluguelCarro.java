package edu.curso;
import java.io.Serializable;
import java.util.Date;
public class AluguelCarro implements Serializable {
	private static final long serialVersionUID = 2870265480627915029L;
	private long id;
	private String modeloCarro = "";
	private Date dataInicio = new Date();
	private int dias;
	private float valorDiaria;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getModeloCarro() {
		return modeloCarro;
	}
	public void setModeloCarro(String modeloCarro) {
		this.modeloCarro = modeloCarro;
	}
	
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public int getDias() {
		return dias;
	}
	public void setDias(int dias) {
		this.dias = dias;
	}
	
	public float getValorDiaria() {
		return valorDiaria;
	}
	public void setValorDiaria(float valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
}
