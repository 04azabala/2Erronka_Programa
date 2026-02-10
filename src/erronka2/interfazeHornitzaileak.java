package erronka2;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

public class interfazeHornitzaileak extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public interfazeHornitzaileak() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		langileak l = login.logina();
		
		JButton btnNewButton = new JButton("Irten");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				langileak l = login.logina();
				
				if(l.getRola().equals("admin")) {
					AdminMenu am = new AdminMenu();
					am.setVisible(true);
					dispose();
				}else if(l.getRola().equals("teknikaria")) {
					LangileMenu lm = new LangileMenu();
					lm.setVisible(true);
					dispose();
					}
				}
		});
		btnNewButton.setBounds(530, 10, 90, 25);
		contentPane.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("izena");
		comboBox.addItem("kontaktu_izena");
		comboBox.addItem("email");
		comboBox.addItem("pasahitza");
		comboBox.addItem("helbidea");
		comboBox.addItem("telefonoa");
		if(l.getRola().equals("teknikaria")) {
			comboBox.setVisible(false);
		}
		comboBox.setBounds(415, 6, 96, 20);
		contentPane.add(comboBox);
		
		JButton btnNewButton_1 = new JButton("Ezabatu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idHornitzaileak = Integer.parseInt(textField_1.getText());    
		        
		        String sql = "DELETE FROM hornitzaileak WHERE id = ?";
		        
		        try (Connection cn = konexioa.konektatu();
		             PreparedStatement pst = cn.prepareStatement(sql)) {

		            if (cn == null) return;

		            pst.setInt(1, idHornitzaileak);
		            int filas = pst.executeUpdate();

		            if (filas > 0) {
		                JOptionPane.showMessageDialog(null, "Ezabatuta");
		            } else {
		                JOptionPane.showMessageDialog(null, "Sartutako id-a ez da aurkitu");
		            }

		        } catch (SQLException ex) {
		            ex.printStackTrace();
		           
		        }
		        kargatuTaula();
			}
		});
		btnNewButton_1.setBounds(211, 50, 84, 20);
		contentPane.add(btnNewButton_1);
		if(l.getRola().equals("teknikaria")) {
			btnNewButton_1.setVisible(false);
		}
		
		JButton btnNewButton_1_1 = new JButton("Editatu");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idHornitzailea = Integer.parseInt(textField.getText()); 
				String zutabea = (String) comboBox.getSelectedItem();
				String aldaketa = textField_2.getText();
				
		        
		        String sql = "UPDATE hornitzaileak SET "+ zutabea +" = ? WHERE id = ?";
		        
		        try (Connection cn = konexioa.konektatu();
		             PreparedStatement pst = cn.prepareStatement(sql)) {

		            if (cn == null) return;

		            pst.setString(1, aldaketa);
		            pst.setInt(2, idHornitzailea);
		            int filas = pst.executeUpdate();

		            if (filas > 0) {
		                JOptionPane.showMessageDialog(null, "Editatuta");
		            } else {
		                JOptionPane.showMessageDialog(null, "Sartutako id-a ez da aurkitu");
		            }

		        } catch (SQLException ex) {
		            ex.printStackTrace();
		           
		        }
		        kargatuTaula();
			}
		});
		btnNewButton_1_1.setBounds(536, 50, 84, 20);
		contentPane.add(btnNewButton_1_1);
		if(l.getRola().equals("teknikaria")) {
			btnNewButton_1_1.setVisible(false);
		}
		
		JLabel lblNewLabel_1 = new JLabel("Hornitzaile bat ezabatu:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_1.setBounds(10, 54, 113, 12);
		contentPane.add(lblNewLabel_1);
		if(l.getRola().equals("teknikaria")) {
			lblNewLabel_1.setVisible(false);
		}
		
		JLabel lblNewLabel = new JLabel("Hornitzaile bat gehitu:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel.setBounds(10, 16, 97, 12);
		contentPane.add(lblNewLabel);
		if(l.getRola().equals("teknikaria")) {
			lblNewLabel.setVisible(false);
		}
		
		JButton btnNewButton_2 = new JButton("Gehitu");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertHornitzaileak sb = new insertHornitzaileak();
				sb.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(95, 12, 84, 20);
		contentPane.add(btnNewButton_2);
		if(l.getRola().equals("teknikaria")) {
			btnNewButton_2.setVisible(false);
		}
		
		textField_1 = new JTextField();
		textField_1.setBounds(105, 51, 96, 18);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		if(l.getRola().equals("teknikaria")) {
			textField_1.setVisible(false);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 610, 215);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2 = new JLabel("Zutabea:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_2.setBounds(361, 10, 44, 12);
		contentPane.add(lblNewLabel_2);
		if(l.getRola().equals("teknikaria")) {
			lblNewLabel_2.setVisible(false);
		}
		
		JLabel lblNewLabel_2_1 = new JLabel("Editatzeko id-a:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_2_1.setBounds(334, 32, 71, 12);
		contentPane.add(lblNewLabel_2_1);
		if(l.getRola().equals("teknikaria")) {
			lblNewLabel_2_1.setVisible(false);
		}
		
		JLabel lblNewLabel_2_2 = new JLabel("Datu berria:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_2_2.setBounds(350, 54, 78, 12);
		contentPane.add(lblNewLabel_2_2);
		if(l.getRola().equals("teknikaria")) {
			lblNewLabel_2_2.setVisible(false);
		}
		
		textField = new JTextField();
		textField.setBounds(415, 29, 96, 18);
		contentPane.add(textField);
		textField.setColumns(10);
		if(l.getRola().equals("teknikaria")) {
			textField.setVisible(false);
		}
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(415, 51, 96, 18);
		contentPane.add(textField_2);
		if(l.getRola().equals("teknikaria")) {
			textField_2.setVisible(false);
		}
		
		
		kargatuTaula();


	}
	
	private void kargatuTaula() {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "ID", "izena", "kontaktu_izena", "email", "helbidea", "telefonoa"});
		table.setModel(modelo);
		


		DAO dao = new DAO();
		ArrayList<hornitzaileak> lista = dao.getHornitzaileak();

		

		for (hornitzaileak h : lista) {
			modelo.addRow(new Object[] {
				h.getId(),
				h.getIzena(),
				h.getKontaktuIzena(),
				h.getEmail(),
				h.getHelbidea(),
				h.getTelefonoa()
			});
		}
	}

}


