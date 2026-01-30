package erronka2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMenu frame = new AdminMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		btnNewButton.setBounds(333, 83, 93, 80);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Bezeroak");
		btnNewButton_1.setBounds(230, 83, 93, 80);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Produktuak");
		btnNewButton_1_1.setBounds(127, 83, 93, 80);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Berriak");
		btnNewButton_1_1_1.setBounds(24, 83, 93, 80);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Fakturak");
		btnNewButton_1_1_1_1.setBounds(10, 173, 93, 80);
		contentPane.add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("Konponketak");
		btnNewButton_1_1_1_1_1.setBounds(115, 173, 93, 80);
		contentPane.add(btnNewButton_1_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1_1 = new JButton("Saskia");
		btnNewButton_1_1_1_1_1_1.setBounds(218, 173, 93, 80);
		contentPane.add(btnNewButton_1_1_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1_1_1 = new JButton("Hornitzaileak");
		btnNewButton_1_1_1_1_1_1_1.setBounds(320, 173, 93, 80);
		contentPane.add(btnNewButton_1_1_1_1_1_1_1);

	}
}
