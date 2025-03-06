package View;

import controller.KillController;
import java.util.Scanner;
public class Main {

	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		KillController killController = new KillController();
		
		int opc;
		String pid, nome;
		
		do {
			System.out.println("Escolha a opção desejada: \n  1-listagem da tabela de processos  \n  2-Matar processo pelo PID  \n  3-matar processo pelo nome  \n  9-encerrar");
			opc = in.nextInt();
			switch (opc) {
			case 1:
				killController.listaProcessos();
				break;
			case 2:
				System.out.println("Digite o PID do processo que deseja matar:");
				pid = in.next();
				killController.mataPid(pid);
				break;
			case 3:
				System.out.println("Digite o nome do processo que deseja matar:");
				nome = in.next();
				killController.mataNome(nome);
				break;
			case 9:
				System.exit(0);
			}
		}while(opc != 9);
		
		//killController.listaProcessos();

	}

}
