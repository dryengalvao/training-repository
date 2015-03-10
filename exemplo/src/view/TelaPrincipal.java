package view;

import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;

import model.dao.RegistroDAO;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel lbNome = null;
	private JTextField tfNome = null;
	private JButton btSalvar = null;
	private JButton btVisualizar = null;

	/**
	 * This method initializes tfNome	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTfNome() {
		if (tfNome == null) {
			tfNome = new JTextField();
			tfNome.setBounds(new Rectangle(80, 37, 368, 25));
		}
		return tfNome;
	}

	/**
	 * This method initializes btSalvar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtSalvar() {
		if (btSalvar == null) {
			btSalvar = new JButton();
			btSalvar.setBounds(new Rectangle(40, 84, 111, 40));
			btSalvar.setText("SALVAR");
			btSalvar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					RegistroDAO pessoaDao = new RegistroDAO();
					
					try {
						pessoaDao.insert(tfNome.getText());
						JOptionPane.showMessageDialog(null, "Nome salvo com sucesso!");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return btSalvar;
	}

	/**
	 * This method initializes btVisualizar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtVisualizar() {
		if (btVisualizar == null) {
			btVisualizar = new JButton();
			btVisualizar.setBounds(new Rectangle(342, 86, 111, 40));
			btVisualizar.setText("VISUALIZAR");
			btVisualizar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					TelaLista.main(null);
				}
			});
		}
		return btVisualizar;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TelaPrincipal thisClass = new TelaPrincipal();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public TelaPrincipal() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(507, 275);
		this.setContentPane(getJContentPane());
		this.setTitle("Tela Principal da Aplicação");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lbNome = new JLabel();
			lbNome.setBounds(new Rectangle(38, 37, 38, 25));
			lbNome.setText("Nome:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(lbNome, null);
			jContentPane.add(getTfNome(), null);
			jContentPane.add(getBtSalvar(), null);
			jContentPane.add(getBtVisualizar(), null);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
