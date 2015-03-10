package view;

import javax.swing.JPanel;
import java.awt.Frame;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import java.awt.Dimension;
import javax.swing.JTextArea;
import java.awt.Rectangle;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import model.dao.RegistroDAO;

public class TelaLista extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTextArea taNomes = null;
	private JLabel lbNomes = null;
	private JButton btVoltar = null;

	/**
	 * This method initializes taNomes	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getTaNomes() {
		if (taNomes == null) {
			taNomes = new JTextArea();
			taNomes.setBounds(new Rectangle(16, 34, 405, 156));
			taNomes.setEditable(false);
		}
		return taNomes;
	}

	/**
	 * This method initializes btVoltar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtVoltar() {
		if (btVoltar == null) {
			btVoltar = new JButton();
			btVoltar.setBounds(new Rectangle(16, 203, 68, 26));
			btVoltar.setText("Voltar");
			btVoltar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
				}
			});
		}
		return btVoltar;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TelaLista thisClass = new TelaLista(null,
						"Tela Lista de Nomes", true);
				thisClass.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});

	}

	/**
	 * @param owner
	 */
	public TelaLista(Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		initialize();
		
		listaNomes();
	}

	
	private void listaNomes(){
		RegistroDAO pessoaDao = new RegistroDAO();
		
		try {
			
			taNomes.setText(pessoaDao.pesquisa());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(459, 279);
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lbNomes = new JLabel();
			lbNomes.setBounds(new Rectangle(15, 14, 116, 16));
			lbNomes.setText("Nomes Cadastrados");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getTaNomes(), null);
			jContentPane.add(lbNomes, null);
			jContentPane.add(getBtVoltar(), null);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
