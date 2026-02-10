package erronka2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;

public class interfazeBerriak extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;

	public interfazeBerriak() {
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

				if (l.getRola().equals("admin")) {
					AdminMenu am = new AdminMenu();
					am.setVisible(true);
					dispose();
				} else if (l.getRola().equals("teknikaria")) {
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
				int idBerriak = Integer.parseInt(textField_1.getText());    
		        
		        String sql = "DELETE FROM berriak WHERE id = ?";
		        
		        try (Connection cn = konexioa.konektatu();
		             PreparedStatement pst = cn.prepareStatement(sql)) {

		            if (cn == null) return;

		            pst.setInt(1, idBerriak);
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
		btnNewButton_1.setBounds(192, 50, 84, 20);
		contentPane.add(btnNewButton_1);
		
		if(l.getRola().equals("teknikaria")) {
			btnNewButton_1.setVisible(false);
		}
		
		JLabel lblNewLabel = new JLabel("Berri bat gehitu:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel.setBounds(10, 16, 97, 12);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Berri bat ezabatu:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_1.setBounds(10, 54, 90, 12);
		contentPane.add(lblNewLabel_1);
		if(l.getRola().equals("teknikaria")) {
			lblNewLabel_1.setVisible(false);
		}
		
		textField_1 = new JTextField();
		textField_1.setBounds(86, 51, 96, 18);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		if(l.getRola().equals("teknikaria")) {
			textField_1.setVisible(false);
		}
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("berria_izena");
		comboBox.addItem("berria_data");
		comboBox.addItem("berria");
		comboBox.addItem("berria_argazkia");
		comboBox.addItem("garrantzi_maila");
		comboBox.setBounds(393, 6, 96, 20);
		contentPane.add(comboBox);
		if(l.getRola().equals("teknikaria")) {
			comboBox.setVisible(false);
		}
		
		JButton btnNewButton_2 = new JButton("Gehitu");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertBerriak sb = new insertBerriak();
				sb.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(76, 12, 84, 20);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Datu berria:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_1_1.setBounds(307, 54, 90, 12);
		contentPane.add(lblNewLabel_1_1);
		if(l.getRola().equals("teknikaria")) {
			lblNewLabel_1_1.setVisible(false);
		}
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(393, 51, 96, 18);
		contentPane.add(textField);
		if(l.getRola().equals("teknikaria")) {
			textField.setVisible(false);
		}
		
		JButton btnNewButton_1_1 = new JButton("Editatu");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idKonponketa = Integer.parseInt(textField_2.getText()); 
				String zutabea = (String) comboBox.getSelectedItem();
				String aldaketa = textField.getText();
				
		        
		        String sql = "UPDATE berriak SET "+ zutabea +" = ? WHERE id = ?";
		        
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
		btnNewButton_1_1.setBounds(499, 50, 84, 20);
		contentPane.add(btnNewButton_1_1);
		if(l.getRola().equals("teknikaria")) {
			btnNewButton_1_1.setVisible(false);
		}
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Editatzeko id-a:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_1_1_1.setBounds(307, 32, 90, 12);
		contentPane.add(lblNewLabel_1_1_1);
		if(l.getRola().equals("teknikaria")) {
			lblNewLabel_1_1_1.setVisible(false);
		}
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Zutabea:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_1_1_2.setBounds(307, 10, 90, 12);
		contentPane.add(lblNewLabel_1_1_2);
		if(l.getRola().equals("teknikaria")) {
			lblNewLabel_1_1_2.setVisible(false);
		}
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(393, 29, 96, 18);
		contentPane.add(textField_2);
		if(l.getRola().equals("teknikaria")) {
			textField_2.setVisible(false);
		}

		kargatuTaula();
	}

	
	private void kargatuTaula() {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "ID", "Izena", "Data", "Berria", "Garrantzia" });
		table.setModel(modelo);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);


		DAO dao = new DAO();
		ArrayList<berriak> lista = dao.getBerriak();

		

		for (berriak b : lista) {
			modelo.addRow(new Object[] {
				b.getId(),
				b.getBerriaIzena(),
				b.getData(),
				b.getBerria(),
				b.getGarrantziMaila()
			});
		}
	}
}
