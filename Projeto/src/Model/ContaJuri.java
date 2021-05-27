package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="conta_especial")
public class ContaJuri {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@OneToOne
	@JoinColumn(name="id_conta")
	private ContaComum conta;
	
	@Column(name="limite_conta")
	private double limite_conta;
	
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

	public double getLimite_conta() {
		return limite_conta;
	}

	public void setLimite_conta(double limite_conta) {
		this.limite_conta = limite_conta;
	}
}
