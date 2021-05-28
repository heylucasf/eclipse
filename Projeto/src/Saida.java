import java.util.ArrayList;
import java.util.Scanner;

import Controller.ControllerConta;
import Controller.ControllerJuri;
import Controller.ControllerMovimentacao;
import Controller.ControllerPessoa;
import Controller.ControllerPessoaF;
import Controller.ControllerPessoaJ;
import Controller.ControllerPoupanca;
import Model.ContaComum;
import Model.ContaJuri;
import Model.ContaPoupanca;
import Model.Pessoa;
import Model.PessoaFisica;
import Model.PessoaJuri;

public class Saida {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		// Instancia a PESSOA e demais
		Pessoa p = new Pessoa();
		ControllerPessoa cp = new ControllerPessoa();

		// Instancia CONTA e demais
		ContaComum cc = new ContaComum();
		ControllerConta ccc = new ControllerConta();

		// Instancia POUPANCA e demais
		ContaPoupanca cpoup = new ContaPoupanca();
		ControllerPoupanca ccpoup = new ControllerPoupanca();

		// Instancia JURI e demais
		ContaJuri cjuri = new ContaJuri();
		ControllerJuri ccjuri = new ControllerJuri();

//		//Inicia o programa
		System.out.print("BEM VINDO!\n");
		System.out.print("Vamos come�ar.\n");
		System.out.print("1 - Registrar conta \n2 - Fazer movimenta��o da conta\n3 - Listar contas\n");
			int opm = s.nextInt();

		// Dicis�o de Registro de conta ou movimenta��o
		switch (opm) {
		case 1:
			Scanner s1 = new Scanner(System.in); // Tem que colocar isso aqui sen�o duplica a linha e sysout
			
			// Ja eu mexo aqui -- Colocar dentro do primeiro IF (opm 1)
			System.out.println("Informe o seu Nome Completo: ");
				p.setNome_pessoa(s1.nextLine());
			System.out.println("Informe o seu endere�o: ");
				p.setEnd_pessoa(s1.nextLine());
			System.out.println("Informe o seu CEP: ");
				p.setCep_pessoa(s1.nextInt());
			System.out.println("Informe o seu telefone: ");
				p.setTel_pessoa(s1.nextInt());
			System.out.println("Informe sua renda: ");
				p.setRenda_pessoa(s1.nextDouble());
			System.out.println("Voc� vai abrir uma conta fisica ou jur�dica? \nPara Fisica - 1\nPara Juridica - 2");
				int o = s.nextInt();

			switch (o) {
			case 1:
				ControllerPessoaF pfc = new ControllerPessoaF();
				PessoaFisica pf = new PessoaFisica();

				System.out.println("Informe o seu CPF: ");
					pf.setCpf_pessoa(s1.nextInt());
				System.out.println("Informe o seu RG: ");
					pf.setRg_pessoa(s1.nextInt());

				System.out.println("Cliente registrado!\n");
				System.out.println("Agora vamos registrar a sua conta\n");
				System.out.println("Informe um numero para sua conta: ");
					cc.setNro_conta(s1.nextInt());
				System.out.println("Informe uma senha para a sua conta: ");
					cc.setSenha(s1.nextInt());

				// Cria a Pessoa
				cp.create(p);

				// Cria Pessoa Fisica
				pf.setPessoa(p);
				pfc.create(pf);

				// Cria Conta da Pessoa Fisica
				cc.setPessoa(p);
				cc.setSituacao(1);
				ccc.create(cc);

				// Cria Conta Poup Pessoa Fisica
				cpoup.setConta(cc);
				ccpoup.create(cpoup);

				System.out.println("Conta poupan�a criada!");
				break;
			case 2:
				PessoaJuri pj = new PessoaJuri();
				ControllerPessoaJ cpj = new ControllerPessoaJ();

				System.out.println("Informe o seu CNPJ: ");
					pj.setCnpj_pessoa(s1.nextInt());

				System.out.println("Cliente registrado!\n");
				System.out.println("Agora vamos registrar a sua conta\n");
				System.out.println("Informe um numero para sua conta: ");
					cc.setNro_conta(s1.nextInt());
				System.out.println("Informe uma senha para a sua conta: ");
					cc.setSenha(s1.nextInt());

				System.out.println(
						"Voc� quer abrir uma conta Poupan�a ou uma conta Especial? \n1 - Conta POUPAN�A \n2 - Conta ESPECIAL");
				int o2 = s1.nextInt();

				switch (o2) {
				case 1:
					// Cria pessoa
					cp.create(p);

					// Cria pessoa Juri
					pj.setPessoa(p);
					cpj.create(pj);

					// Cria Conta da Pessoa Juri
					cc.setPessoa(p);
					cc.setSituacao(1);
					ccc.create(cc);

					// Cria Conta Poup Pessoa Juri
					cpoup.setConta(cc);
					ccpoup.create(cpoup);

					System.out.println("Conta poupan�a criada!");
					break;
				case 2:
					System.out.println("Informe um limite para a conta: ");
					cjuri.setLimite_conta(s1.nextDouble());

					// Cria pessoa
					cp.create(p);

					// Cria pessoa Juri
					pj.setPessoa(p);
					cpj.create(pj);

					// Cria Conta da Pessoa Juri
					cc.setPessoa(p);
					cc.setSituacao(1);
					ccc.create(cc);

					// Cria conta Especial Pessoa Juri
					cjuri.setConta(cc);
					ccjuri.create(cjuri);
					System.out.println("Conta especial criada!");
					break;
				}
				break;
			}

			break;
		case 2:
			System.out.println("1 - Saque \n2 - Dep�sito");
				int opm2 = s.nextInt();

			// Switch para escolher a op��o de saque ou dep�sito
			switch (opm2) {
			case 1:
				ControllerConta crud = new ControllerConta();
				ControllerMovimentacao cm = new ControllerMovimentacao();
				
				System.out.println("Infome o ID da conta: ");
					ContaComum c = crud.find(s.nextInt());
					
				System.out.println("Atualmente voc� tem R$" + c.getSaldo() + " na sua conta.");
				System.out.println("Digite o valor que deseja depositar: ");
					cm.deposito(s.nextDouble());
				break;

			case 2:

				break;
			}
			break;
		case 3:
			ControllerConta crud = new ControllerConta();
			System.out.println("[LISTA DE CONTAS]\n");
			
			ArrayList<ContaComum> lista = crud.list();
			for(ContaComum contacom : lista) {
				System.out.println("ID - NUM - SALDO");
				System.out.println(contacom.getId_conta() + " - " + 
								   contacom.getNro_conta() + " - " + 
								   contacom.getSaldo());
			}
			break;
		}
	}
}
