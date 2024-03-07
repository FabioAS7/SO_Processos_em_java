package view;

import javax.swing.JOptionPane;
import controller.KillController;

public class Main2 
{
	public static void main (String args[])
	{
		int opc = 0, pid;
		String nome;
		KillController metodos = new KillController();
		
		while(opc!=9)
		{
			opc = Integer.parseInt(JOptionPane.showInputDialog("PROCESSOS/CLOSE \n1 - Listar processos \n2 - Matar processo(NOME) \n3 - Matar processo(PID)\n9 - Finalizar programa"));
			switch(opc)
			{
			case 1:
				metodos.listaProcessos();
			break;
			
			case 2:
				pid = Integer.parseInt(JOptionPane.showInputDialog("Digite o PID do programa para finaliza-lo"));
				metodos.mataPid(pid);
			break;
			
			case 3:
				nome = JOptionPane.showInputDialog("Digte o NOME do programa para finaliza-lo");
				metodos.mataNome(nome);
			break;
			
			case 9:
				JOptionPane.showMessageDialog(null, "Programa finalizado com sucesso!");
			break;
			
			default:
				JOptionPane.showMessageDialog(null, "Opção invalida! Tente novamente");
			}
		}
		System.out.println("programa fechado");
	}
}