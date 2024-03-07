package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Tela_execultavel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField caixa_de_texto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_execultavel frame = new Tela_execultavel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela_execultavel() 
	{
		setTitle("Executador");
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 241);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 539, 202);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Digite o caminho do executável ou clique em \"Procurar\"");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(120, 35, 377, 42);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		caixa_de_texto = new JTextField();
		caixa_de_texto.setFont(new Font("Arial", Font.PLAIN, 16));
		caixa_de_texto.setBounds(135, 78, 362, 42);
		panel.add(caixa_de_texto);
		caixa_de_texto.setColumns(10);
		
		JButton botao_procurar = new JButton("Procurar");
		botao_procurar.setFont(new Font("Arial", Font.PLAIN, 15));
		botao_procurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				JFileChooser escolher_arq = new JFileChooser();
				escolher_arq.setDialogTitle("Procurar executavel");
				escolher_arq.setFileSelectionMode(0);
				
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("execultavel", "exe");
				escolher_arq.setFileFilter(filtro);
				
				escolher_arq.showOpenDialog(null);
			}
		});
		botao_procurar.setBounds(385, 151, 150, 40);
		panel.add(botao_procurar);
		
		
		JButton botao_cancelar = new JButton("Cancelar");
		botao_cancelar.setFont(new Font("Arial", Font.PLAIN, 15));
		botao_cancelar.setBounds(205, 151, 150, 40);
		panel.add(botao_cancelar);
		
		JButton botao_confimar = new JButton("OK");
		botao_confimar.setFont(new Font("Arial", Font.PLAIN, 15));
		botao_confimar.setBounds(10, 151, 150, 40);
		panel.add(botao_confimar);
		
		JLabel icone_java = new JLabel("");
		icone_java.setIcon(new ImageIcon(Tela_execultavel.class.getResource("/imagens/java_logo.png")));
		icone_java.setBounds(0, 0, 175, 132);
		panel.add(icone_java);
	}
}
