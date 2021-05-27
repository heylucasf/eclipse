package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="conta_comum")
public class ContaComum {
	
	@Id
	@GeneratedValue
	@Column(name="id_conta")
	private int id_conta;
	
	@OneToOne
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;
	
	@Column(name="nro_conta")
	private int nro_conta;
	
	@Column(name="dt_encerramento")
	private String dt_encerramento;
	
	@Column(name="situacao")
	private int situacao;
	
	@Column(name="senha")
	private int senha;
	
	@Column(name="saldo")
	private double saldo;

	public int getId_conta() {
		return id_conta;
	}

	public void setId_conta(int id_conta) {
		this.id_conta = id_conta;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public int getNro_conta() {
		return nro_conta;
	}

	public void setNro_conta(int nro_conta) {
		this.nro_conta = nro_conta;
	}

	public String getDt_encerramento() {
		return dt_encerramento;
	}

	public void setDt_encerramento(String dt_encerramento) {
		this.dt_encerramento = dt_encerramento;
	}

	public int getSituacao() {
		return situacao;
	}

	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
