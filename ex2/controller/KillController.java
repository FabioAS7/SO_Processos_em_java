package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController 
{
	private static String os()
	{
		String so = System.getProperty("os.name") ;
		return so;
	}

	public void listaProcessos()
	{
		String so = os(), linha_lida;
		StringBuffer comando = new StringBuffer ();
		comando=(so.contains("Windows"))?comando.append("TASKLIST /FO TABLE"):comando.append("ps -ef");
		
		try
		{
			Process proc = Runtime.getRuntime().exec(comando.toString());
			InputStream fluxo = proc.getInputStream();
			InputStreamReader leitor_dados = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor_dados);
			linha_lida = buffer.readLine();
			
			while(linha_lida != null)
			{
				System.out.println(linha_lida);
				linha_lida = buffer.readLine();
			}
			
			fluxo.close();
			leitor_dados.close();
			buffer.close();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
	
	public void mataPid(int pid)
	{
		String so = os();
		StringBuffer comando = new StringBuffer ();
		comando=(so.contains("Windows"))?comando.append("TASKKILL /PID " + pid):comando.append("kill -9 " + pid);
		
		try
		{
			Process prc = Runtime.getRuntime().exec(comando.toString());
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		System.out.println("Programa de PID: " + pid + " fechado com sucesso");
	}
	
	public void mataNome(String nome_comando)
	{
		String so = os();
		StringBuffer comando = new StringBuffer ();
		comando=(so.contains("Windows"))?comando.append("TASKKILL /IM " + nome_comando):comando.append("pkill -f " + nome_comando);
		
		try
		{
			Process proc = Runtime.getRuntime().exec(comando.toString());
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		System.out.println("Programa de nome: " + nome_comando + " fechado com sucesso");
	}
}