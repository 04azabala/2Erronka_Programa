package erronka2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class interfazeLogin extends JFrame {
	
	private static String rol;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JTextField textField;
	static JTextField textField_1;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public interfazeLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Erabiltzailea:");
		lblNewLabel.setBounds(95, 126, 78, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblPasahitza = new JLabel("Pasahitza:");
		lblPasahitza.setBounds(95, 156, 78, 20);
		contentPane.add(lblPasahitza);
		
		textField = new JTextField();
		textField.setBounds(183, 129, 96, 18);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(183, 157, 96, 18);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1 = new JLabel("LOGIN");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(131, 50, 164, 41);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Logeatu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				rol = login.logina();
				
				
				if(rol.equals("admin")) {
					 JOptionPane.showMessageDialog(null, "Ongi etorri, rola:  "+rol);
					 new AdminMenu().setVisible(true);
				     dispose();
				}else if(rol.equals("teknikaria")) {
					JOptionPane.showMessageDialog(null, "Ongi etorri, rola:  "+rol);
					new LangileMenu().setVisible(true);
					dispose();
				}
				
				}	
			
			
		});
		btnNewButton.setBounds(183, 184, 96, 20);
		contentPane.add(btnNewButton);
		
		
		
	
}
	public static String getRola() {
		return rol;
	}
	
}
