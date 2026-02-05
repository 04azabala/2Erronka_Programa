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

public class interfazeProduktuak extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public interfazeProduktuak() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 610, 215);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		JButton btnNewButton_1 = new JButton("Ezabatu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idProduktuak = Integer.parseInt(textField_1.getText());    
		        
		        String sql = "DELETE FROM produktuak WHERE id = ?";
		        
		        try (Connection cn = konexioa.konektatu();
		             PreparedStatement pst = cn.prepareStatement(sql)) {

		            if (cn == null) return;

		            pst.setInt(1, idProduktuak);
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
		btnNewButton_1.setBounds(213, 50, 84, 20);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Produktu bat gehitu:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel.setBounds(10, 16, 97, 12);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Produktu bat ezabatu:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_1.setBounds(10, 54, 90, 12);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("izena");
		comboBox.addItem("prezioa");
		comboBox.addItem("stock");
		comboBox.addItem("egoera");
		comboBox.addItem("konponketa");
		comboBox.addItem("mota");
		comboBox.addItem("irudia");
		comboBox.setBounds(414, 6, 96, 20);
		contentPane.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setBounds(107, 51, 96, 18);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Gehitu");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertProduktuak sp = new insertProduktuak();
				sp.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(98, 12, 84, 20);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Datu berria:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_1_1.setBounds(336, 54, 90, 12);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(414, 52, 96, 18);
		contentPane.add(textField);
		
		JButton btnNewButton_1_1 = new JButton("Editatu");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int idKonponketa = Integer.parseInt(textField_2.getText()); 
				String zutabea = (String) comboBox.getSelectedItem();
				String aldaketa = textField.getText();
				
		        
		        String sql = "UPDATE produktuak SET "+ zutabea +" = ? WHERE id = ?";
		        
		        try (Connection cn = konexioa.konektatu();
		             PreparedStatement pst = cn.prepareStatement(sql)) {

		            if (cn == null) return;

		            pst.setString(1, aldaketa);
		            pst.setInt(2, idKonponketa);
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
		btnNewButton_1_1.setBounds(520, 50, 84, 20);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Editatzeko id-a:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_1_1_1.setBounds(336, 32, 90, 12);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Zutabea:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_1_1_2.setBounds(336, 10, 90, 12);
		contentPane.add(lblNewLabel_1_1_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(414, 29, 96, 18);
		contentPane.add(textField_2);
		
		
		kargatuTaula();


	}
	
	private void kargatuTaula() {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "ID", "izena", "prezioa", "stock", "egoera", "konponketa","mota"});
		table.setModel(modelo);
		


		DAO dao = new DAO();
		ArrayList<produktuak> lista = dao.getProduktuak();

		

		for (produktuak p : lista) {
			modelo.addRow(new Object[] {
				p.getId(),
				p.getIzena(),
				p.getPrezioa(),
				p.getStock(),
				p.getEgoera(),
				p.getKonponketa(),
				p.getMota()
			});
		}

	}

}
