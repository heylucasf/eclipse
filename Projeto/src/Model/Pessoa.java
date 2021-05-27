package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue
	@Column(name="id_pessoa")
	private int id_pessoa;
	
	@Column(name="nom_pessoa")
	private String nome_pessoa;
	
	@Column(name="end_pessoa")
	private String end_pessoa;
	
	@Column(name="cep_pessoa")
	private int cep_pessoa;
	
	@Column(name="tel_pessoa")
	private int tel_pessoa;
	
	@Column(name="renda_pessoa")
	private double renda_pessoa;
	
	@Column(name="sit_pessoa")
	private int sit_pessoa;
	
	public int getId_pessoa() {
		return id_pessoa;
	}
	public void setId_pessoa(int id_pessoa) {
		this.id_pessoa = id_pessoa;
	}
	public String getNome_pessoa() {
		return nome_pessoa;
	}
	public void setNome_pessoa(String nome_pessoa) {
		this.nome_pessoa = nome_pessoa;
	}
	public String getEnd_pessoa() {
		return end_pessoa;
	}
	public void setEnd_pessoa(String end_pessoa) {
		this.end_pessoa = end_pessoa;
	}
	public int getCep_pessoa() {
		return cep_pessoa;
	}
	public void setCep_pessoa(int cep_pessoa) {
		this.cep_pessoa = cep_pessoa;
	}
	public int getTel_pessoa() {
		return tel_pessoa;
	}
	public void setTel_pessoa(int tel_pessoa) {
		this.tel_pessoa = tel_pessoa;
	}
	public double getRenda_pessoa() {
		return renda_pessoa;
	}
	public void setRenda_pessoa(double renda_pessoa) {
		this.renda_pessoa = renda_pessoa;
	}
	public int getSit_pessoa() {
		return sit_pessoa;
	}
	public void setSit_pessoa(int sit_pessoa) {
		this.sit_pessoa = sit_pessoa;
	}
}
