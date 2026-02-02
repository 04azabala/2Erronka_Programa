package erronka2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class interfazeBerriak extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	public interfazeBerriak() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Irten");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (interfazeLogin.getRola().equals("admin")) {
					AdminMenu am = new AdminMenu();
					am.setVisible(true);
					dispose();
				} else if (interfazeLogin.getRola().equals("teknikaria")) {
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
