package view;

import javax.swing.JOptionPane;

import controller.DistroController;

public class Main3 
{
	public static void main(String args[])
	{
		int opc = 0;
		DistroController metodos = new DistroController();
		
		while(opc != 9)
		{
			opc = Integer.parseInt(JOptionPane.showInputDialog("INFOMAÇOES DO SO \n1 - Obter informações \n9 - finalizar programa"));
			switch(opc)
			{
			case 1:
				metodos.exibeDistro();
			break;
			
			case 9:
				JOptionPane.showMessageDialog(null, "Programa finalizado com sucesso!");
			break;
			
			default:
				JOptionPane.showMessageDialog(null, "Opção invalida! Tente novamente");
			}
		}
	}
}
