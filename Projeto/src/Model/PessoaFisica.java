package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pessoa_fisica")
public class PessoaFisica {
	
	@Id
	@Column(name="cpf_pessoa")
	private int cpf_pessoa;
	
	@Column(name="rg_pessoa")
	private int rg_pessoa;
	
	@OneToOne
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;

	public int getCpf_pessoa() {
		return cpf_pessoa;
	}

	public void setCpf_pessoa(int cpf_pessoa) {
		this.cpf_pessoa = cpf_pessoa;
	}

	public int getRg_pessoa() {
		return rg_pessoa;
	}

	public void setRg_pessoa(int rg_pessoa) {
		this.rg_pessoa = rg_pessoa;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
