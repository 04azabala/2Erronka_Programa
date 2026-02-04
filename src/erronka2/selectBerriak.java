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

public class selectBerriak extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textFieldData;
	private JTextField txtSartuHemenBerria;
	private JTextField txtIrudia;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public selectBerriak() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Berriaren tituloa:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel.setBounds(10, 10, 85, 12);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(83, 7, 96, 18);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblBerriarenData = new JLabel("Berriaren data:");
		lblBerriarenData.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblBerriarenData.setBounds(10, 32, 85, 12);
		contentPane.add(lblBerriarenData);
		
		JLabel lblBerria = new JLabel("Berria:");
		lblBerria.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblBerria.setBounds(10, 54, 85, 12);
		contentPane.add(lblBerria);
		
		JLabel lblBerriarenIrudia = new JLabel("Berriaren irudia:");
		lblBerriarenIrudia.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblBerriarenIrudia.setBounds(10, 76, 85, 12);
		contentPane.add(lblBerriarenIrudia);
		
		JLabel lblGarrantziMaila = new JLabel("Garrantzi maila:");
		lblGarrantziMaila.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblGarrantziMaila.setBounds(10, 102, 85, 12);
		contentPane.add(lblGarrantziMaila);
		
		textFieldData = new JTextField();
		textFieldData.setForeground(new Color(128, 128, 128));
		textFieldData.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textFieldData.setText("yyyy-mm-dd");
		textFieldData.setColumns(10);
		textFieldData.setBounds(83, 29, 96, 18);
		contentPane.add(textFieldData);
		
		txtSartuHemenBerria = new JTextField();
		txtSartuHemenBerria.setHorizontalAlignment(SwingConstants.LEFT);
		txtSartuHemenBerria.setForeground(new Color(128, 128, 128));
		txtSartuHemenBerria.setText("Sartu hemen berria izango duen textua");
		txtSartuHemenBerria.setColumns(10);
		txtSartuHemenBerria.setBounds(83, 51, 201, 18);
		contentPane.add(txtSartuHemenBerria);
		
		txtIrudia = new JTextField();
		txtIrudia.setForeground(new Color(128, 128, 128));
		txtIrudia.setText("irudia.png");
		txtIrudia.setColumns(10);
		txtIrudia.setBounds(83, 73, 96, 18);
		contentPane.add(txtIrudia);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("ALTUA");
		comboBox.addItem("ERTAINA");
		comboBox.addItem("BAJUA");
		comboBox.setBounds(83, 98, 96, 20);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Gehitu");
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String tituloa = textField.getText();
		        String berria = txtSartuHemenBerria.getText();
		        String irudia = txtIrudia.getText();
		        String aukera = (String) comboBox.getSelectedItem();
		        
		        java.sql.Date sqlDate = null;
		        try {
		           
		            java.util.Date utilDate = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(textFieldData.getText());
		            sqlDate = new java.sql.Date(utilDate.getTime());
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Data formatua ez da zuzena, erabili formatu hau: yyyy-MM-dd");
		            return; 
		        }

		        try {
		            Connection cn = konexioa.konektatu();
		            if (cn != null) {
		                String sql = "INSERT INTO berriak (berria_izena, berria_data, berria, berria_argazkia, garrantzi_maila) "
		                           + "VALUES (?, ?, ?, ?, ?)";
		                PreparedStatement pst = cn.prepareStatement(sql);

		                
		                pst.setString(1, tituloa);
		                pst.setDate(2, sqlDate);
		                pst.setString(3, berria);
		                pst.setString(4, irudia);
		                pst.setString(5, aukera);

		                pst.executeUpdate();

		                pst.close();
		                cn.close();

		                JOptionPane.showMessageDialog(null, "Berria gehitu da.");
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Berria gehitzerakoan arazoak egon dira.");
		        }
		    }
		});

		btnNewButton.setBounds(10, 124, 169, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Itzuli");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfazeBerriak ib = new interfazeBerriak();
				ib.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(342, 6, 84, 20);
		contentPane.add(btnNewButton_1);

	}
}
