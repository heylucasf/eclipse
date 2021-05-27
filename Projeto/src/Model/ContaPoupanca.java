package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="conta_poupanca")
public class ContaPoupanca {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@OneToOne
	@JoinColumn(name="id_conta")
	private ContaComum conta;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ContaComum getConta() {
		return conta;
	}

	public void setConta(ContaComum conta) {
		this.conta = conta;
	}
}
