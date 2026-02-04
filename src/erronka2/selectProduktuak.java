package erronka2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.time.LocalDate;

public class selectProduktuak extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textFieldData;
	private JTextField txtAbizena;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public selectProduktuak() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Izena:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel.setBounds(10, 10, 85, 12);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(83, 7, 96, 18);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblBerriarenData = new JLabel("Prezioa:");
		lblBerriarenData.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblBerriarenData.setBounds(10, 32, 85, 12);
		contentPane.add(lblBerriarenData);
		
		JLabel lblBerria = new JLabel("Stock:");
		lblBerria.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblBerria.setBounds(10, 54, 85, 12);
		contentPane.add(lblBerria);
		
		JLabel lblBerriarenIrudia = new JLabel("Egoera:");
		lblBerriarenIrudia.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblBerriarenIrudia.setBounds(10, 76, 85, 12);
		contentPane.add(lblBerriarenIrudia);
		
		JLabel lblGarrantziMaila = new JLabel("Konponketa:");
		lblGarrantziMaila.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblGarrantziMaila.setBounds(10, 98, 85, 12);
		contentPane.add(lblGarrantziMaila);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(83, 72, 96, 20);
		contentPane.add(comboBox);
		comboBox.addItem("berria");
		comboBox.addItem("Konponduta");
		comboBox.addItem("Konpondu gabea");
		
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(83, 94, 96, 20);
		contentPane.add(comboBox_1);
		comboBox_1.addItem("ez");
		comboBox_1.addItem("bai");
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(83, 116, 96, 20);
		contentPane.add(comboBox_2);
		comboBox_2.addItem("mugikorra");
		comboBox_2.addItem("ordenagailu eramangarria");
		comboBox_2.addItem("tableta");
		comboBox_2.addItem("sagua");
		comboBox_2.addItem("teklatua");
		comboBox_2.addItem("monitorea");
		comboBox_2.addItem("inprimagailua");
		comboBox_2.addItem("biltegiratzea");
		comboBox_2.addItem("sarea");
		comboBox_2.addItem("erloju adimenduna");
		comboBox_2.addItem("aurikularrak");
		comboBox_2.addItem("kamera");
		
		

		
		textFieldData = new JTextField();
		textFieldData.setForeground(new Color(128, 128, 128));
		textFieldData.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textFieldData.setColumns(10);
		textFieldData.setBounds(83, 29, 96, 18);
		contentPane.add(textFieldData);
		
		txtAbizena = new JTextField();
		txtAbizena.setHorizontalAlignment(SwingConstants.LEFT);
		txtAbizena.setForeground(new Color(128, 128, 128));
		txtAbizena.setColumns(10);
		txtAbizena.setBounds(83, 51, 96, 18);
		contentPane.add(txtAbizena);
		
		JButton btnNewButton = new JButton("Gehitu");
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String izena = textField.getText();
		        double prezioa = Double.parseDouble(textFieldData.getText());
		        int stock = Integer.parseInt(txtAbizena.getText());
		        String egoera = (String) comboBox.getSelectedItem();
		        String konponketa = (String) comboBox_1.getSelectedItem();
		        String mota = (String) comboBox_2.getSelectedItem();
		        String irudia = textField_2.getText();
		        
		        
		        
		        

		        try {
		            Connection cn = konexioa.konektatu();
		            if (cn != null) {
		                String sql = "INSERT INTO bezeroak (NAN, izena, abizena, email, pasahitza) "
		                           + "VALUES (?, ?, ?, ?, ?)";
		                PreparedStatement pst = cn.prepareStatement(sql);

		                
		                pst.setString(1, izena);
		                pst.setDouble(2, prezioa);
		                pst.setInt(3, stock);
		                pst.setString(4, egoera);
		                pst.setString(5, konponketa);
		                pst.setString(6, mota);
		                pst.setString(7, irudia);
		              
		                

		                pst.executeUpdate();

		                pst.close();
		                cn.close();

		                JOptionPane.showMessageDialog(null, "Produktuak gehitu da.");
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Produktuak gehitzerakoan arazoak egon dira.");
		        }
		    }
		});

		btnNewButton.setBounds(10, 169, 169, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Itzuli");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfazeProduktuak ip = new interfazeProduktuak();
				ip.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(342, 6, 84, 20);
		contentPane.add(btnNewButton_1);
		
		JLabel lblMota = new JLabel("Mota:");
		lblMota.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblMota.setBounds(10, 120, 85, 12);
		contentPane.add(lblMota);
		
		JLabel lblIrudia = new JLabel("Irudia:");
		lblIrudia.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblIrudia.setBounds(10, 142, 85, 12);
		contentPane.add(lblIrudia);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.GRAY);
		textField_2.setColumns(10);
		textField_2.setBounds(83, 141, 96, 18);
		contentPane.add(textField_2);
		
		
	}
}
