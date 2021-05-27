import java.util.Scanner;

import Controller.ControllerConta;
import Controller.ControllerJuri;
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
		
		//Instancia a PESSOA e demais
		Pessoa p = new Pessoa();
		ControllerPessoa cp = new ControllerPessoa();
		
		//Instancia CONTA e demais
		ContaComum cc = new ContaComum();
		ControllerConta ccc = new ControllerConta();
		
		//Instancia POUPANCA e demais
		ContaPoupanca cpoup = new ContaPoupanca();
		ControllerPoupanca ccpoup = new ControllerPoupanca();
		
		//Instancia JURI e demais
		ContaJuri cjuri = new ContaJuri();
		ControllerJuri ccjuri = new ControllerJuri();
		
		System.out.println("Informe o seu Nome Completo: ");
			p.setNome_pessoa(s.nextLine());
		System.out.println("Informe o seu endereço: ");
			p.setEnd_pessoa(s.nextLine());
		System.out.println("Informe o seu CEP: ");
			p.setCep_pessoa(s.nextInt());
		System.out.println("Informe o seu telefone: ");
			p.setTel_pessoa(s.nextInt());
		System.out.println("Informe sua renda: ");
			p.setRenda_pessoa(s.nextDouble());
		System.out.println("Você vai abrir uma conta fisica ou jurídica? \nPara Fisica - 1\nPara Juridica - 2");
			int o = s.nextInt();
			
		switch(o) {
		case 1:
			ControllerPessoaF pfc = new ControllerPessoaF();
			PessoaFisica pf = new PessoaFisica();
			
			System.out.println("Informe o seu CPF: ");
				pf.setCpf_pessoa(s.nextInt());
			System.out.println("Informe o seu RG: ");
				pf.setRg_pessoa(s.nextInt());
				
				
			System.out.println("Cliente registrado!\n");	
			System.out.println("Agora vamos registrar a sua conta\n");
			System.out.println("Informe um numero para sua conta: ");
				cc.setNro_conta(s.nextInt());
			System.out.println("Informe uma senha para a sua conta: ");
				cc.setSenha(s.nextInt());
				
			//Cria a Pessoa
			cp.create(p);
			
			//Cria Pessoa Fisica
			pf.setPessoa(p);
			pfc.create(pf);
			
			//Cria Conta da Pessoa Fisica
			cc.setPessoa(p);
			cc.setSituacao(1);
			ccc.create(cc);
			
			//Cria Conta Poup Pessoa Fisica
			cpoup.setConta(cc);
			ccpoup.create(cpoup);

			System.out.println("Conta poupança criada!");
			break;
		case 2:
			PessoaJuri pj = new PessoaJuri();
			ControllerPessoaJ cpj = new ControllerPessoaJ();
			
			System.out.println("Informe o seu CNPJ: ");
				pj.setCnpj_pessoa(s.nextInt());
				
			System.out.println("Cliente registrado!\n");	
			System.out.println("Agora vamos registrar a sua conta\n");
			System.out.println("Informe um numero para sua conta: ");
				cc.setNro_conta(s.nextInt());
			System.out.println("Informe uma senha para a sua conta: ");
				cc.setSenha(s.nextInt());
				
			System.out.println("Você quer abrir uma conta Poupança ou uma conta Especial? \n1 - Conta POUPANÇA \n2 - Conta ESPECIAL");
				int o2 = s.nextInt();
				
			switch(o2) {
				case 1:
					//Cria pessoa
					cp.create(p);
					
					//Cria pessoa Juri
					pj.setPessoa(p);
					cpj.create(pj);
					
					//Cria Conta da Pessoa Juri
					cc.setPessoa(p);
					cc.setSituacao(1);
					ccc.create(cc);
					
					//Cria Conta Poup Pessoa Juri
					cpoup.setConta(cc);
					ccpoup.create(cpoup);
					
					System.out.println("Conta poupança criada!");
					break;
				case 2:
					System.out.println("Informe um limite para a conta: ");
						cjuri.setLimite_conta(s.nextDouble());
						
					//Cria pessoa
					cp.create(p);
					
					//Cria pessoa Juri
					pj.setPessoa(p);
					cpj.create(pj);
					
					//Cria Conta da Pessoa Juri
					cc.setPessoa(p);
					cc.setSituacao(1);
					ccc.create(cc);
					
					//Cria conta Especial Pessoa Juri
					cjuri.setConta(cc);
					ccjuri.create(cjuri);
					System.out.println("Conta especial criada!");
					break;
			}
			break;
		}
	}
}
