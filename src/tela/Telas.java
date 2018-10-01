package tela;

import java.awt.Component;
import java.awt.EventQueue;
import metodos.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RootPaneContainer;
import javax.xml.bind.ParseConversionEvent;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Telas {
	
	protected static final Component RootPane = null;
	Conjuntos c1 = null;
	Conjuntos c2 = null;
	String conj = "A=";

	private JFrame frame;
	private JTextField textField_TamanhoA;
	private JTextField textField_TamanhoB;
	private JTextField textField_IncluirA;
	private JTextField textField_IncluirB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Telas window = new Telas();
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
	public Telas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 428);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea_Resultado = new JTextArea();
		textArea_Resultado.setBounds(28, 295, 372, 72);
		frame.getContentPane().add(textArea_Resultado);
		
		JButton btn_B_A = new JButton("B - A");
		btn_B_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					String saida = "Diferença entre B e A \n\n";
					
					saida += "B -A = " + c2.diferenca(c1).getConjunto();
					
					textArea_Resultado.setText(saida);
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(RootPane, e.getMessage());
					// TODO: handle exception
				}
			}
		});
		btn_B_A.setEnabled(false);
		btn_B_A.setBounds(371, 142, 117, 25);
		frame.getContentPane().add(btn_B_A);
		
		JButton btn_A_B = new JButton("A - B");
		btn_A_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					String saida = "Calculo da diferença A e B \n\n";
					
					saida += "A - B = " + c1.diferenca(c2).getConjunto();
					
					textArea_Resultado.setText(saida);
					
					btn_B_A.setEnabled(true);
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(RootPane, e.getMessage());
					// TODO: handle exception
				}
			}
		});
		btn_A_B.setEnabled(false);
		btn_A_B.setBounds(242, 144, 117, 25);
		frame.getContentPane().add(btn_A_B);
		
		JButton btn_Interseccao = new JButton("A ∩ B");
		btn_Interseccao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					String saida = "Calculo intersecção A ∩ B \n\n";
					
					saida += "A ∩ B = " + c1.intersecao(c2).getConjunto() + "\n";
					
					textArea_Resultado.setText(saida);
					
					btn_A_B.setEnabled(true);
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(RootPane, e.getMessage());
					// TODO: handle exception
				}
			}
		});
		btn_Interseccao.setEnabled(false);
		btn_Interseccao.setBounds(128, 144, 100, 25);
		frame.getContentPane().add(btn_Interseccao);
		
		JButton btn_Uniao = new JButton("A U B");
		btn_Uniao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					String saida = "União dos conjuntos A U B" + "\n \n";
					
					saida += "A U B = " + c1.uniao(c2).getConjunto();
					
					textArea_Resultado.setText(saida);
					
					btn_Interseccao.setEnabled(true);
					textField_IncluirB.setEnabled(false);
					
					
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(RootPane, e.getMessage());
					// TODO: handle exception
				}
			}
		});
		btn_Uniao.setEnabled(false);
		btn_Uniao.setBounds(12, 142, 100, 25);
		frame.getContentPane().add(btn_Uniao);
		
		JTextArea textArea_ConjuntoB = new JTextArea();
		textArea_ConjuntoB.setEnabled(false);
		textArea_ConjuntoB.setBounds(272, 111, 210, 19);
		frame.getContentPane().add(textArea_ConjuntoB);
		
		JTextArea textArea_ConjuntoA = new JTextArea();
		textArea_ConjuntoA.setEnabled(false);
		textArea_ConjuntoA.setBounds(22, 111, 196, 19);
		frame.getContentPane().add(textArea_ConjuntoA);
		
		JButton btnIncluir_B = new JButton("Incluir");
		btnIncluir_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					c2.setElemento(Integer.parseInt(textField_IncluirB.getText()));
					textField_IncluirB.setText("");
					btn_Uniao.setEnabled(true);
					textField_TamanhoB.setEnabled(false);
					
					String saida = " ";
					saida += "B = " + c2.getConjunto() + "";
					
					textArea_ConjuntoB.setText(saida);
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(RootPane, e.getMessage());
					// TODO: handle exception
				}
			}
		});
		btnIncluir_B.setEnabled(false);
		btnIncluir_B.setBounds(391, 79, 87, 25);
		frame.getContentPane().add(btnIncluir_B);
		
		JButton btnCriar_B = new JButton("Criar");
		btnCriar_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					c2 = new Conjuntos(Integer.parseInt(textField_TamanhoB.getText()));
					btnIncluir_B.setEnabled(true);
					textField_IncluirB.setEnabled(true);
					textField_IncluirA.setEnabled(false);
										
				} catch (Exception e) {
					JOptionPane.showMessageDialog(RootPane, e.getMessage());
					// TODO: handle exception
				}
			}
		});
		btnCriar_B.setEnabled(false);
		btnCriar_B.setBounds(391, 52, 70, 25);
		frame.getContentPane().add(btnCriar_B);
		
		textField_TamanhoB = new JTextField();
		textField_TamanhoB.setEnabled(false);
		textField_TamanhoB.setBounds(318, 57, 59, 19);
		frame.getContentPane().add(textField_TamanhoB);
		textField_TamanhoB.setColumns(10);
		
		JButton btnIncluir_A = new JButton("Incluir");
		btnIncluir_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					c1.setElemento(Integer.parseInt(textField_IncluirA.getText()));
					textField_IncluirA.setText("");
					btnCriar_B.setEnabled(true);
					textField_TamanhoB.setEnabled(true);
					textField_TamanhoA.setEnabled(false);
					
					
					String saida = " ";
					saida += "A = " + c1.getConjunto() + "";
					
					textArea_ConjuntoA.setText(saida);
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(RootPane, e.getMessage());
					// TODO: handle exception
				}
				
			}
		});
		btnIncluir_A.setEnabled(false);
		btnIncluir_A.setBounds(148, 79, 77, 25);
		frame.getContentPane().add(btnIncluir_A);
		
		JLabel lblTamnho = new JLabel("Tamnho:");
		lblTamnho.setBounds(12, 57, 70, 15);
		frame.getContentPane().add(lblTamnho);
		
		textField_TamanhoA = new JTextField();
		textField_TamanhoA.setBounds(77, 55, 59, 19);
		frame.getContentPane().add(textField_TamanhoA);
		textField_TamanhoA.setColumns(10);
		
		JButton btnCriar_A = new JButton("Criar");
		btnCriar_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					c1 = new Conjuntos(Integer.parseInt(textField_TamanhoA.getText()));
					textField_IncluirA.setEnabled(true);
					btnIncluir_A.setEnabled(true);
					textField_TamanhoB.setEditable(true);
					
					btnCriar_A.setEnabled(false);
					
					//textField_TamanhoB.setEnabled(true);
					//btnIncluir_B.setEnabled(true);
										
				} catch (Exception e) {
					JOptionPane.showMessageDialog(RootPane, e.getMessage());
					// TODO: handle exception
				}
			}
		});
		btnCriar_A.setBounds(148, 52, 70, 25);
		frame.getContentPane().add(btnCriar_A);
		
		JLabel lblConjuntoA = new JLabel("Conjunto A");
		lblConjuntoA.setBounds(64, 30, 100, 15);
		frame.getContentPane().add(lblConjuntoA);
		
		JLabel lblConjuntoB = new JLabel("Conjunto B");
		lblConjuntoB.setBounds(262, 30, 100, 15);
		frame.getContentPane().add(lblConjuntoB);
		
		JLabel lblTamanho = new JLabel("Tamanho:");
		lblTamanho.setBounds(247, 57, 70, 15);
		frame.getContentPane().add(lblTamanho);
		
		JLabel lblIncluirA = new JLabel("Incluir:");
		lblIncluirA.setBounds(12, 84, 70, 15);
		frame.getContentPane().add(lblIncluirA);
		
		textField_IncluirA = new JTextField();
		textField_IncluirA.setEnabled(false);
		textField_IncluirA.setBounds(77, 84, 59, 19);
		frame.getContentPane().add(textField_IncluirA);
		textField_IncluirA.setColumns(10);
		
		JLabel lblIncluirB = new JLabel("Incluir:");
		lblIncluirB.setBounds(247, 84, 70, 15);
		frame.getContentPane().add(lblIncluirB);
		
		textField_IncluirB = new JTextField();
		textField_IncluirB.setEnabled(false);
		textField_IncluirB.setBounds(318, 84, 59, 19);
		frame.getContentPane().add(textField_IncluirB);
		textField_IncluirB.setColumns(10);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(28, 268, 90, 15);
		frame.getContentPane().add(lblResultado);
		
		JButton btn_novo = new JButton("Novo");
		btn_novo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				btnCriar_A.setEnabled(true);
				//btnCriar_B.setEnabled(true);
				//btnIncluir_A.setEnabled(true);
				//btnIncluir_B.setEnabled(false);
				//btn_Uniao.setEnabled(false);
				//btn_Interseccao.setEnabled(false);
				//btn_A_B.setEnabled(false);
				//btn_B_A.setEnabled(false);
				textField_TamanhoA.setEnabled(true);
				textField_IncluirA.setText(null);
				textField_IncluirB.setText(null);
				textField_TamanhoA.setText(null);
				textField_TamanhoB.setText(null);
				textArea_ConjuntoA.setText(null);
				textArea_ConjuntoB.setText(null);
				textArea_Resultado.setText(null);
				
			}
		});
		btn_novo.setBounds(418, 290, 70, 25);
		frame.getContentPane().add(btn_novo);
		
		JButton btnSubAB = new JButton("A SUB B");
		btnSubAB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String saida = "Subconjunto\n\n";
					saida +="A é Subconjunto de B = " + c1.eSubConjunto(c2);
					textArea_Resultado.setText(saida);
					
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(RootPane, e.getMessage());
				}
			}
		});
		btnSubAB.setBounds(12, 184, 100, 25);
		frame.getContentPane().add(btnSubAB);
		
		JButton btnBSubA = new JButton("B SUB A");
		btnBSubA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String saida = "SubConjunto\n\n";
					saida += "B é SubConjunto de B = " + c2.eSubConjunto(c1);
					textArea_Resultado.setText(saida);
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(RootPane, e2.getMessage());
				}
			}
		});
		btnBSubA.setBounds(128, 184, 100, 25);
		frame.getContentPane().add(btnBSubA);
		

	}
}
