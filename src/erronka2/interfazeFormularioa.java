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
		setBounds(100, 100, 786, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 752, 215);
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
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {

		        langileak l = login.logina();
		        if (l == null) return;

		        int idFormulario;
		        try {
		            idFormulario = Integer.parseInt(textField.getText());
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "ID zenbaki bat izan behar da.");
		            return;
		        }

		        int id_langilea = l.getId();
		        LocalDate sarrera_data = LocalDate.now();

		        try (Connection cn = konexioa.konektatu()) {
		            if (cn == null) return;

		            
		            String checkSql = "SELECT * FROM formularioa WHERE id = ?";
		            PreparedStatement checkPst = cn.prepareStatement(checkSql);
		            checkPst.setInt(1, idFormulario);
		            ResultSet rsCheck = checkPst.executeQuery();

		            if (!rsCheck.next()) {
		                JOptionPane.showMessageDialog(null, "ID hori ez da existitzen");
		                return;
		            }

		            String egoera = rsCheck.getString("produktuaren_deskribapena");
		            String bezeroMota = rsCheck.getString("Bezero_mota");

		            Integer hornitzaile_id = null;
		            Integer bezero_id = null;

		            if ("hornitzailea".equalsIgnoreCase(bezeroMota)) {
		                hornitzaile_id = rsCheck.getInt("hornitzaile_id");
		            } else if ("bezeroa".equalsIgnoreCase(bezeroMota)) {
		                bezero_id = rsCheck.getInt("bezero_id");
		            }

		            
		            String sql4 = "INSERT INTO konponketak(id_langilea, bezero_id, hornitzaile_id, sarrera_data, amaiera_data, hasierako_egoera) VALUES (?, ?, ?, ?, ?, ?)";

		            PreparedStatement pst2 = cn.prepareStatement(sql4);

		            pst2.setInt(1, id_langilea);

		            if (bezero_id != null) {
		                pst2.setInt(2, bezero_id);
		            }else {
		                pst2.setNull(2, java.sql.Types.INTEGER);
		            }
		            if (hornitzaile_id != null) {
		                pst2.setInt(3, hornitzaile_id);
		            }else {
		                pst2.setNull(3, java.sql.Types.INTEGER);
		            }

		            pst2.setDate(4, Date.valueOf(sarrera_data));
		            pst2.setNull(5, java.sql.Types.DATE);
		            pst2.setString(6, egoera);

		            pst2.executeUpdate();

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
		btnDeuseztatu.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int idFormulario = Integer.parseInt(textField.getText());    
		        
		        String sql = "DELETE FROM formularioa WHERE id = ?";
		        
		        try (Connection cn = konexioa.konektatu();
		             PreparedStatement pst = cn.prepareStatement(sql)) {

		            if (cn == null) return;

		            pst.setInt(1, idFormulario);
		            int filas = pst.executeUpdate();

		            if (filas > 0) {
		                JOptionPane.showMessageDialog(null, "Duseztatuta");
		            } else {
		                JOptionPane.showMessageDialog(null, "Sartutako id-a ez da aurkitu");
		            }

		        } catch (SQLException ex) {
		            ex.printStackTrace();
		           
		        }
		        kargatuTaula();
		    }
		});

		btnDeuseztatu.setFont(new Font("Tahoma", Font.PLAIN, 9));
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
		btnNewButton_1.setBounds(678, 10, 84, 20);
		contentPane.add(btnNewButton_1);

		kargatuTaula();
	}

	
	private void kargatuTaula() {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] { "ID", "bezero_id","hornitzaile_id", "bezero_mota", "izena", "abizena", "harremanetako_pertsona", "posta_elektronikoa", "telefonoa", "enpresaren_izena", "produktu_mota", "produktu_marka" , "produktua" , "produktu_kopurua" , "produktuaren_deskribapena" , "oharrak" });
		table.setModel(modelo);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);


		DAO dao = new DAO();
		ArrayList<formularioa> lista = dao.getFormularioa();

		

		for (formularioa b : lista) {
			modelo.addRow(new Object[] {
				b.getId(),
				b.getBezero(),
				b.getHornitzaile(),
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
