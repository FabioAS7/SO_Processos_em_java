package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController 
{
	private static String os()
	{
		String sistema_operacional = System.getProperty("os.name");;
		return sistema_operacional;
	}

	public void ip()
	{
		String so = os(), linha_lida;
		StringBuffer comando = new StringBuffer ();
		comando=(so.contains("Windows"))?comando.append("IPCONFIG"):comando.append("ip addr");

		try
		{
			Process proc = Runtime.getRuntime().exec(comando.toString());
			InputStream fluxo = proc.getInputStream();
			InputStreamReader leitor_fluxo = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor_fluxo);
			linha_lida = buffer.readLine();
			
			while(linha_lida != null)
			{
				if((so.contains("Windows") && (linha_lida.contains("Adaptador") || linha_lida.contains("IPv4"))))
				{
					System.out.println(linha_lida);	
				}
				else if((so.contains("Linux") && (linha_lida.contains("inet"))))
				{
					System.out.println(linha_lida);
				}
				
				linha_lida = buffer.readLine();
			}
			
			fluxo.close();
			leitor_fluxo.close();
			buffer.close();
		}
		catch(Exception err)
		{
			System.err.println(err.getMessage());
		}
	}
	
	public void ping()
	{
		String so = os(), linha_lida;
		StringBuffer comando = new StringBuffer ();
		comando=(so.contains("Windows"))?comando.append("ping -4 -n 10 www.google.com.br"):comando.append("ping -4 -c 10 www.google.com.br");
		
		try
		{
			Process proc = Runtime.getRuntime().exec(comando.toString());
			InputStream fluxo = proc.getInputStream();
			InputStreamReader leitor_dados = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor_dados);
			linha_lida = buffer.readLine();
			
			while(linha_lida != null)
			{
				if(so.contains("Windows") && linha_lida.contains("M�dia ="))
				{
					System.out.println(linha_lida);
				}
				
				if(so.contains("Linux") && linha_lida.contains("rtt min/avg/max/mdev"))
				{
					System.out.println(linha_lida);
				}
				
				linha_lida = buffer.readLine();
			}
			
			fluxo.close();
			leitor_dados.close();
			buffer.close();
		}
		catch(Exception err)
		{
			System.err.println(err.getMessage());
		}
	}
}