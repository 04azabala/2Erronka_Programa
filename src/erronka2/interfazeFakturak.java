package erronka2;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class interfazeFakturak extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public interfazeFakturak() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Irten");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				langileak l = login.logina();
				
				if(l.getRola().equals("admin")) {
					AdminMenu am = new AdminMenu();
					am.setVisible(true);
					dispose();
				}else if(l.getRola().equals("teknikaria")) {
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
		
		JButton btnNewButton_1 = new JButton("Faktura pdf-ra");
		btnNewButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String idText = textField.getText();
		        if (idText.isEmpty()) {
		            javax.swing.JOptionPane.showMessageDialog(null, "Sartu id bat");
		            return;
		        }

		        int idFaktura = Integer.parseInt(textField.getText());

		        
		        DAO dao = new DAO();
		        fakturak f = dao.getFacturaPorId(idFaktura); 

		        if (f != null) {
		           
		            fakturaPDF.generarFactura(
		                f.getId(),
		                f.getBezeroa(),
		                f.getHornitzailea(),
		                f.getProduktu(),
		                f.getSaskia(),
		                f.getData(),
		                f.getTotala(),
		                f.getZenbatekoa()
		                
		            );

		            javax.swing.JOptionPane.showMessageDialog(null, "PDF generado correctamente.");
		        } else {
		            javax.swing.JOptionPane.showMessageDialog(null, "No existe la factura con ese ID.");
		        }
		        
		    }
		});

		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_1.setBounds(10, 12, 120, 20);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(208, 13, 96, 18);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Sartu id-a:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel.setBounds(162, 16, 90, 12);
		contentPane.add(lblNewLabel);
		kargatuTaula();
		
		


	}
	
	private void kargatuTaula() {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "ID", "id_bezeroa", "id_hornitzailea", "id_produktua", "id_saskia" , "data" , "totala", "zenbatekoa","faktura_ruta"});
		table.setModel(modelo);
		


		DAO dao = new DAO();
		ArrayList<fakturak> lista = dao.getFakturak();

		

		for (fakturak f : lista) {
			modelo.addRow(new Object[] {
				f.getId(),
				f.getBezeroa(),
				f.getHornitzailea(),
				f.getProduktu(),
				f.getSaskia(),
				f.getData(),
				f.getTotala(),
				f.getZenbatekoa(),
				f.getFakturaRuta()
			});
		}
	}
}
