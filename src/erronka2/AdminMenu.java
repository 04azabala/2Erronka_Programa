package erronka2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class AdminMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public AdminMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Langileak");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfazeLangileak il = new interfazeLangileak();
				il.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(319, 83, 93, 80);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Bezeroak");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfazeBezeroak ib = new interfazeBezeroak();
				ib.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(216, 83, 93, 80);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Produktuak");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfazeProduktuak ip = new interfazeProduktuak();
				ip.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setBounds(113, 83, 93, 80);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Berriak");
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfazeBerriak ib = new interfazeBerriak();
				ib.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1.setBounds(10, 83, 93, 80);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Fakturak");
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfazeFakturak i = new interfazeFakturak();
				i.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1_1.setBounds(10, 173, 93, 80);
		contentPane.add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("Konponketak");
		btnNewButton_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfazeKonponketak ik = new interfazeKonponketak();
				ik.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1_1_1.setBounds(115, 173, 93, 80);
		contentPane.add(btnNewButton_1_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1_1 = new JButton("Saskia");
		btnNewButton_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfazeSaskia is = new interfazeSaskia();
				is.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1_1_1_1.setBounds(218, 173, 93, 80);
		contentPane.add(btnNewButton_1_1_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1_1_1 = new JButton("Hornitzaileak");
		btnNewButton_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_1_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfazeHornitzaileak ih = new interfazeHornitzaileak();
				ih.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1_1_1_1_1.setBounds(320, 173, 93, 80);
		contentPane.add(btnNewButton_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel = new JLabel("Administratzaile menua");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(101, 22, 221, 19);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("saioa itxi");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfazeLogin il = new interfazeLogin();
				il.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(342, 18, 84, 31);
		contentPane.add(btnNewButton_2);

	}
}
