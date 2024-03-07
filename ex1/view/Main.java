package view;

import javax.swing.JOptionPane;
import controller.RedesController;

public class Main 
{
	public static void main(String arg[])
	{
		int opc = 0;
		RedesController metodos = new RedesController();

		
		while(opc != 9)
		{
			opc = Integer.parseInt(JOptionPane.showInputDialog("INFORMACOES IP/PING \n1 - Ler IPv4s \n2 - Ler PING do dominio Google \n9 - Finalizar programa"));
			switch(opc)
			{
			case 1:
				metodos.ip();
			break;
			
			case 2:
				metodos.ping();
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
