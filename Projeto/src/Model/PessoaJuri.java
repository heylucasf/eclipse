package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pessoa_juridica")
public class PessoaJuri {
	
	@Id
	@Column(name="cnpj_pessoa")
	private int cnpj_pessoa;
	
	@OneToOne
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;

	public int getCnpj_pessoa() {
		return cnpj_pessoa;
	}

	public void setCnpj_pessoa(int cnpj_pessoa) {
		this.cnpj_pessoa = cnpj_pessoa;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
