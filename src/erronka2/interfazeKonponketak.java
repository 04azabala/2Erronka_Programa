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

public class interfazeKonponketak extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public interfazeKonponketak() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		langileak l = login.logina();
		
		JButton btnNewButton = new JButton("Irten");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
		btnNewButton.setBounds(586, 10, 90, 25);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 666, 215);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Ezabatu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idKonponketa = Integer.parseInt(textField_1.getText());    
		        
		        String sql = "DELETE FROM konponketak WHERE id = ?";
		        
		        try (Connection cn = konexioa.konektatu();
		             PreparedStatement pst = cn.prepareStatement(sql)) {

		            if (cn == null) return;

		            pst.setInt(1, idKonponketa);
		            int filas = pst.executeUpdate();

		            if (filas > 0) {
		                JOptionPane.showMessageDialog(null, "Ezabatuta");
		            }else {
		            	JOptionPane.showMessageDialog(null, "Sartutako id-a ez da aurkitu");
		            }

		        } catch (SQLException ex) {
		            ex.printStackTrace();
		           
		        }
		        kargatuTaula();
			}
		});
		btnNewButton_1.setBounds(218, 50, 84, 20);
		contentPane.add(btnNewButton_1);
		if(l.getRola().equals("teknikaria")) {
			btnNewButton_1.setVisible(false);
		}
		
		JLabel lblNewLabel = new JLabel("Konponketa bat gehitu:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel.setBounds(10, 16, 97, 12);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Konponketa bat ezabatu:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_1.setBounds(10, 54, 123, 12);
		contentPane.add(lblNewLabel_1);
		if(l.getRola().equals("teknikaria")) {
			lblNewLabel_1.setVisible(false);
		}
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(111, 51, 96, 18);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		if(l.getRola().equals("teknikaria")) {
			textField_1.setVisible(false);
		}
		
		
		JComboBox comboBox = new JComboBox();
		if(l.getRola().equals("admin")) {
		comboBox.addItem("amaiera_data");
		comboBox.addItem("hasierako_egoera");
		}else if(l.getRola().equals("teknikaria")) {
		comboBox.addItem("hasierako_egoera");	
		}
		comboBox.setBounds(459, 6, 96, 20);
		contentPane.add(comboBox);
		
		JButton btnNewButton_2 = new JButton("Gehitu");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfazeFormularioa ifo = new interfazeFormularioa();
				ifo.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(111, 12, 84, 20);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("Editatu");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int idKonponketa = Integer.parseInt(textField_3.getText()); 
				String zutabea = (String) comboBox.getSelectedItem();
				String aldaketa = textField_4.getText();
				
		        
		        String sql = "UPDATE konponketak SET "+ zutabea +" = ? WHERE id = ?";
		        
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
		btnNewButton_1_1.setBounds(565, 50, 84, 20);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Zutabea:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_1_1_1.setBounds(387, 10, 115, 12);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Editatzeko id-a:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_1_1_2.setBounds(387, 32, 115, 12);
		contentPane.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Datu berria:");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_1_1_2_1.setBounds(387, 54, 115, 12);
		contentPane.add(lblNewLabel_1_1_2_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(459, 29, 96, 18);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(459, 51, 96, 18);
		contentPane.add(textField_4);
		
		
		
		
		kargatuTaula();


	}
	
	private void kargatuTaula() {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "ID", "id_langilea", "bezero_id" ,"hornitzaile_id" ,"sarrera_data", "amaiera_data", "hasierako_egoera" });
		table.setModel(modelo);
		


		DAO dao = new DAO();
		ArrayList<konponketak> lista = dao.getKonponketak();

		

		for (konponketak k : lista) {
			modelo.addRow(new Object[] {
				k.getId(),
				k.getLangilea(),
				k.getBezero(),
				k.getHornitzaile(),
				k.getSarreraData(),
				k.getAmaieraData(),
				k.getHasierakoEgoera(),
				
				
			
			});
		}
	}
}
