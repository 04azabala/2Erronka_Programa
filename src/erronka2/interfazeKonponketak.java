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

public class interfazeKonponketak extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public interfazeKonponketak() {
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
		modelo.setColumnIdentifiers(new String[] { "ID", "id_langilea", "sarrera_data", "amaiera_data", "hasierako_egoera", "konponenten_beharra", "id_bezeroa", "azken_emaitza", "proba_emaitza","konponenten_xehetasunak","konponenten_egoera"});
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
				k.getKonponentenBeharra(),
				k.getBezeroa(),
				k.getAzkenEmaitza(),
				k.getProbaEmaitza(),
				k.getKonponentenXehetasunak(),
				k.getKonponentenEgoera()
			});
		}
	}

}
