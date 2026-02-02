package erronka2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class interfazeProduktuak extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

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
		btnNewButton.setBounds(530, 10, 90, 25);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 610, 250);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
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
