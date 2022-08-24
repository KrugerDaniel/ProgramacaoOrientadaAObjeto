import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Apresntacao {

	private JFrame frame;
	private JTextField tfNome;
	private JTextField tfCPF;
	private JTextField tfUF;
	private JTextField tfImposto;
	private JTextField tfMostrarImposto;
	private Contribuinte[] contribuintes = new Contribuinte[500];
	private int indice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apresntacao window = new Apresntacao();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Apresntacao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 10, 45, 13);
		frame.getContentPane().add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setBounds(94, 7, 199, 19);
		frame.getContentPane().add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setBounds(10, 39, 45, 13);
		frame.getContentPane().add(lblNewLabel);
		
		tfCPF = new JTextField();
		tfCPF.setBounds(94, 36, 147, 19);
		frame.getContentPane().add(tfCPF);
		tfCPF.setColumns(10);
		
		tfUF = new JTextField();
		tfUF.setBounds(94, 65, 96, 19);
		frame.getContentPane().add(tfUF);
		tfUF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Estado (UF):");
		lblNewLabel_1.setBounds(10, 68, 74, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Imposto:");
		lblNewLabel_2.setBounds(10, 96, 74, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		tfImposto = new JTextField();
		tfImposto.setBounds(94, 93, 96, 19);
		frame.getContentPane().add(tfImposto);
		tfImposto.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contribuinte c;
				c = new Contribuinte(tfNome.getText(), tfCPF.getText(), tfUF.getText(), 
									Double.parseDouble(tfImposto.getText()));
				
				String msg = "Contribuinte: " + c.getNome() + " , CPF: " + c.getCpf() + 
							" pagará R$" + c.calcularImposto();
				JOptionPane.showMessageDialog(frame, msg);
				
				contribuintes[indice] = c;
				indice++;
			}
		});
		btnCalcular.setBounds(94, 122, 85, 21);
		frame.getContentPane().add(btnCalcular);
		
		JLabel lblNewLabel_3 = new JLabel("Imposto a mostrar");
		lblNewLabel_3.setBounds(94, 179, 96, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		tfMostrarImposto = new JTextField();
		tfMostrarImposto.setBounds(197, 176, 96, 19);
		frame.getContentPane().add(tfMostrarImposto);
		tfMostrarImposto.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double impostoAConsultar = Double.parseDouble(tfMostrarImposto.getText());
				String exibicao = "Contribuintes com imposto acima de R$" + impostoAConsultar + "\n";
				
				for (int i = 0; i < indice; i++) {
					Contribuinte c = contribuintes[i];
					if (c.calcularImposto() > impostoAConsultar) {
						exibicao += "\n" + c.getNome() + " , CPF:" + c.getCpf() + " Renda " +
									c.getRendaAnual() + " Imposto " + c.calcularImposto();
					}
				}
				
				JOptionPane.showMessageDialog(frame, exibicao);
			}
		});
		btnConsultar.setBounds(197, 205, 85, 21);
		frame.getContentPane().add(btnConsultar);
	}
}
