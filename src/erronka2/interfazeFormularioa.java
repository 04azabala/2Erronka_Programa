package erronka2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;

public class interfazeFormularioa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	public interfazeFormularioa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 610, 215);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("sartu id-a:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setBounds(29, 34, 82, 12);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(84, 31, 96, 18);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Onartu");
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		        langileak l = login.logina();
		        if (l == null) return;

		        int idFormulario;
		        idFormulario = Integer.parseInt(textField.getText());		      
		        int id_langilea = l.getId();
		        LocalDate sarrera_data = LocalDate.now();
		        
		       


		        try {
		            Connection cn = konexioa.konektatu();
		            if (cn == null) return;
		            
		            String sql = "SELECT produktuaren_deskribapena FROM formularioa WHERE id = "+l.getId();
			        PreparedStatement pst = cn.prepareStatement(sql);
			        

			        ResultSet rs = pst.executeQuery();

			        String egoera = null;
			        if (rs.next()) {
			            egoera = rs.getString("produktuaren_deskribapena");
			        }
			        
			        String sql1 = "SELECT izena, abizena FROM formularioa WHERE id = "+l.getId()+" && Bezero_mota = 'hornitzailea'" ;
			        PreparedStatement pst1 = cn.prepareStatement(sql1);
			        

			        ResultSet rs1 = pst1.executeQuery();

			        String hornitzaile_izena = null;
			        if (rs1.next()) {
			        	hornitzaile_izena = rs1.getString("izena") + " " + rs1.getString("abizena");
			        }
			        
			        
			        String sql3 = "SELECT izena, abizena FROM formularioa WHERE id = "+l.getId()+" && Bezero_mota = 'bezeroa'" ;
			        PreparedStatement pst3 = cn.prepareStatement(sql3);
			        

			        ResultSet rs3 = pst3.executeQuery();

			        String bezero_izena = null;
			        if (rs3.next()) {
			            bezero_izena = rs3.getString("izena") + " " + rs3.getString("abizena");
			        }

		            String checkSql = "SELECT * FROM formularioa WHERE id = ?";
		            PreparedStatement checkPst = cn.prepareStatement(checkSql);
		            checkPst.setInt(1, idFormulario);
		            ResultSet rs2 = checkPst.executeQuery();

		            if (!rs2.next()) {
		                JOptionPane.showMessageDialog(null, "ID hori ez da existitzen");
		                rs.close();
		                checkPst.close();
		                cn.close();
		                return;
		            }

		            rs.close();
		            checkPst.close();

		            
		            String sql4 = "INSERT INTO konponketak (id_langilea, sarrera_data, amaiera_data, hasierako_egoera, hornitzaile_izena, bezero_izena) VALUES (?, ?, ?, ?, ?, ?)";
		            PreparedStatement pst2 = cn.prepareStatement(sql4);

		            pst2.setInt(1, id_langilea);
		            pst2.setDate(2, java.sql.Date.valueOf(sarrera_data));
		            pst2.setDate(3, null);
		            pst2.setString(4, egoera);
		            pst2.setString(5, hornitzaile_izena);
		            pst2.setString(6, bezero_izena);

		            pst2.executeUpdate();

		            pst.close();
		            cn.close();

		            JOptionPane.showMessageDialog(null, "Konponketa ondo gehitu da.");

		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Errorea datuak sartzerakoan.");
		        }
		    }
		});

		btnNewButton.setBounds(222, 10, 84, 20);
		contentPane.add(btnNewButton);
		
		JButton btnDeuseztatu = new JButton("Deuseztatu");
		btnDeuseztatu.setBounds(222, 40, 84, 20);
		contentPane.add(btnDeuseztatu);
		
		JButton btnNewButton_1 = new JButton("Atera");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfazeKonponketak ik = new interfazeKonponketak();
				ik.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(536, 10, 84, 20);
		contentPane.add(btnNewButton_1);

		kargatuTaula();
	}

	
	private void kargatuTaula() {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "ID", "bezero_mota", "izena", "abizena", "harremanetako_pertsona", "posta_elektronikoa", "telefonoa", "enpresaren_izena", "produktu_mota", "produktu_marka" , "produktua" , "produktu_kopurua" , "produktuaren_deskribapena" , "oharrak" });
		table.setModel(modelo);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);


		DAO dao = new DAO();
		ArrayList<formularioa> lista = dao.getFormularioa();

		

		for (formularioa b : lista) {
			modelo.addRow(new Object[] {
				b.getId(),
				b.getBezeroMota(),
				b.getIzena(),
				b.getAbizena(),
				b.getHerramanetakoPertsona(),
				b.getPostaElektronikoa(),
				b.getTelefonoa(),
				b.getEnpresarenIzena(),
				b.getProduktuMota(),
				b.getProduktuMarka(),
				b.getProduktua(),
				b.getProduktuKopurua(),
				b.getProduktuarenDeskribapena(),
				b.getOharrak()
			});
		}
	}
}
