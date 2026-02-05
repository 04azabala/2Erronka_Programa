package erronka2;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class interfazeKonponketak extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

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
		
		JButton btnNewButton = new JButton("Irten");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(interfazeLogin.getRola().equals("admin")) {
					AdminMenu am = new AdminMenu();
					am.setVisible(true);
					dispose();
				}else if(interfazeLogin.getRola().equals("teknikaria")) {
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
		btnNewButton_1.setBounds(218, 50, 84, 20);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Konponketa bat gehitu:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel.setBounds(10, 16, 97, 12);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Konponketa bat ezabatu:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_1.setBounds(10, 54, 123, 12);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(111, 51, 96, 18);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
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
		
		JLabel lblNewLabel_1_1 = new JLabel("Konponketa bat editatu:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_1_1.setBounds(375, 54, 115, 12);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(486, 52, 96, 18);
		contentPane.add(textField);
		
		JButton btnNewButton_1_1 = new JButton("Editatu");
		btnNewButton_1_1.setBounds(592, 50, 84, 20);
		contentPane.add(btnNewButton_1_1);
		
		
		kargatuTaula();


	}
	
	private void kargatuTaula() {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "ID", "id_langilea", "sarrera_data", "amaiera_data", "hasierako_egoera", "hornitzaile_izena" , "bezero_izena"});
		table.setModel(modelo);
		


		DAO dao = new DAO();
		ArrayList<konponketak> lista = dao.getKonponketak();

		

		for (konponketak k : lista) {
			modelo.addRow(new Object[] {
				k.getId(),
				k.getLangilea(),
				k.getSarreraData(),
				k.getAmaieraData(),
				k.getHasierakoEgoera(),
				k.getHornitzaileIzena(),
				k.getBezeroIzena(),
			
			});
		}
	}

}
