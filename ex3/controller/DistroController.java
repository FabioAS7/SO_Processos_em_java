package controller;


public class DistroController 
{
	private String os()
	{
		String sistema_operacional, arquitetura, versao;
		
		sistema_operacional = System.getProperty("os.name");
		arquitetura = System.getProperty("os.arch");
		versao = System.getProperty("os.version");
		
		System.out.println(sistema_operacional + " V." + versao + " arc: " + arquitetura + "\n");
		return sistema_operacional;
	}
	
	public void exibeDistro()
	{
		String so = os();
		
		if (so.contains("Linux"))
		{
			
			try 
			{
				System.out.println(so);
				Process proc = Runtime.getRuntime().exec("cat /etc/os-release");
			} catch (Exception e) 
			{
				System.err.println(e.getMessage());
			}
		}
		else
		{
			System.out.println("O Sistema Operacinal é " + so + "!");
		}
	}
}
