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

public class insertLangileak extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textFieldData;
	private JTextField txtSartuHemenBerria;
	private JTextField txtIrudia;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public insertLangileak() {
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
		
		JLabel lblBerriarenData = new JLabel("Abizena:");
		lblBerriarenData.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblBerriarenData.setBounds(10, 32, 85, 12);
		contentPane.add(lblBerriarenData);
		
		JLabel lblBerria = new JLabel("Erabiltzailea:");
		lblBerria.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblBerria.setBounds(10, 54, 85, 12);
		contentPane.add(lblBerria);
		
		JLabel lblBerriarenIrudia = new JLabel("Pasahitza:");
		lblBerriarenIrudia.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblBerriarenIrudia.setBounds(10, 76, 85, 12);
		contentPane.add(lblBerriarenIrudia);
		
		JLabel lblGarrantziMaila = new JLabel("Rola:");
		lblGarrantziMaila.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblGarrantziMaila.setBounds(10, 98, 85, 12);
		contentPane.add(lblGarrantziMaila);
		
		textFieldData = new JTextField();
		textFieldData.setForeground(new Color(128, 128, 128));
		textFieldData.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textFieldData.setColumns(10);
		textFieldData.setBounds(83, 29, 96, 18);
		contentPane.add(textFieldData);
		
		txtSartuHemenBerria = new JTextField();
		txtSartuHemenBerria.setHorizontalAlignment(SwingConstants.LEFT);
		txtSartuHemenBerria.setForeground(new Color(128, 128, 128));
		txtSartuHemenBerria.setColumns(10);
		txtSartuHemenBerria.setBounds(83, 51, 96, 18);
		contentPane.add(txtSartuHemenBerria);
		
		txtIrudia = new JTextField();
		txtIrudia.setForeground(new Color(128, 128, 128));
		txtIrudia.setColumns(10);
		txtIrudia.setBounds(83, 73, 96, 18);
		contentPane.add(txtIrudia);
		
		JButton btnNewButton = new JButton("Gehitu");
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String izena = textField.getText();
		        String abizena = textFieldData.getText();
		        String erabiltzailea = txtSartuHemenBerria.getText();
		        String pasahitza = txtIrudia.getText();
		        String rola = textField_1.getText();
		        
		        
		        
		        

		        try {
		            Connection cn = konexioa.konektatu();
		            if (cn != null) {
		                String sql = "INSERT INTO langileak (izena, abizena, erabiltzailea, pasahitza, rola) "
		                           + "VALUES (?, ?, ?, ?, ?)";
		                PreparedStatement pst = cn.prepareStatement(sql);

		                
		                pst.setString(1, izena);
		                pst.setString(2, abizena);
		                pst.setString(3, erabiltzailea);
		                pst.setString(4, pasahitza);
		                pst.setString(5, rola);
		                

		                pst.executeUpdate();

		                pst.close();
		                cn.close();

		                JOptionPane.showMessageDialog(null, "Langilea gehitu da.");
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Langilea gehitzerakoan arazoak egon dira.");
		        }
		    }
		});

		btnNewButton.setBounds(10, 120, 169, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Itzuli");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfazeLangileak il = new interfazeLangileak();
				il.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(342, 6, 84, 20);
		contentPane.add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.GRAY);
		textField_1.setColumns(10);
		textField_1.setBounds(83, 95, 96, 18);
		contentPane.add(textField_1);

	}
}
