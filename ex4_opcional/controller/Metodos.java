package controller;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

// QUEM SABE NUM FUTURO PROXIMO

public class Metodos 
{
	public static String SearchController()
	{
		JFileChooser escolher_arq = new JFileChooser();
		escolher_arq.setDialogTitle("Procurar executavel");
		escolher_arq.setFileSelectionMode(0);
		
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("execultavel", "exe");
		escolher_arq.setFileFilter(filtro);
		
		escolher_arq.showOpenDialog(null);

		return null;
	}

	public void RunController()
	{
		
	}
	
	public void CancelController()
	{
		
	}
}
