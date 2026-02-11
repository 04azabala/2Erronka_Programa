package erronka2;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class interfazeFakturak extends JFrame {
    private JPanel contentPane;
    private JTable table;
    private JTextField textField;

    public interfazeFakturak() {
        setTitle("Fakturen Kudeaketa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        // --- BOTÓN IRTEN (Vuelve al menú según el rol) ---
        JButton btnIrten = new JButton("Irten");
        btnIrten.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                langileak l = login.logina(); // Obtener usuario logueado
                
                if (l != null) {
                    if (l.getRola().equalsIgnoreCase("admin")) {
                        AdminMenu am = new AdminMenu();
                        am.setVisible(true);
                    } else {
                        LangileMenu lm = new LangileMenu();
                        lm.setVisible(true);
                    }
                    dispose(); // Cierra esta ventana
                } else {
                    // Si por algún motivo no hay sesión, vuelve al login
                    dispose();
                }
            }
        });
        btnIrten.setBounds(530, 10, 90, 25);
        contentPane.add(btnIrten);
        
        // --- TABLA DE FACTURAS ---
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 45, 610, 250);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
        
        // --- BOTÓN GENERAR PDF ---
        JButton btnGenerar = new JButton("Faktura pdf-ra");
        btnGenerar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idText = textField.getText().trim();
                if (idText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Sartu ID bat.");
                    return;
                }
                try {
                    int idBuscado = Integer.parseInt(idText);
                    DAO dao = new DAO();
                    fakturak f = dao.getFacturaPorId(idBuscado);

                    if (f != null) {
                        // Llamada al método que ya arreglamos para subir por FTP
                        fakturaPDF.generarFactura(f.getId(), f.getBezeroa(), f.getHornitzailea(), 
                                                f.getProduktu(), f.getSaskia(), f.getData(), 
                                                f.getTotala(), f.getZenbatekoa());
                        
                        JOptionPane.showMessageDialog(null, "PDFa zerbitzarira ondo bidali da.");
                        kargatuTaula(); // Refrescar para ver la nueva ruta
                    } else {
                        JOptionPane.showMessageDialog(null, "Ez da faktura hori aurkitu.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID-ak zenbakia izan behar du.");
                }
            }
        });
        btnGenerar.setFont(new Font("Tahoma", Font.PLAIN, 9));
        btnGenerar.setBounds(10, 12, 120, 20);
        contentPane.add(btnGenerar);
        
        textField = new JTextField();
        textField.setBounds(208, 13, 96, 18);
        contentPane.add(textField);
        
        JLabel lblId = new JLabel("Sartu id-a:");
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 9));
        lblId.setBounds(162, 16, 90, 12);
        contentPane.add(lblId);
        
        // Cargar datos al iniciar
        kargatuTaula();
    }
    
    private void kargatuTaula() {
        DefaultTableModel modelo = new DefaultTableModel();
        // Columnas claras para el administrador/trabajador
        modelo.setColumnIdentifiers(new String[] { "ID", "Bezeroa/Hornit.", "Data", "Totala", "Ruta PDF" });
        table.setModel(modelo);
        
        DAO dao = new DAO();
        ArrayList<fakturak> lista = dao.getFakturak();
        
        for (fakturak f : lista) {
            // Mostramos el nombre del cliente si existe, si no el del proveedor
            String entidad = (f.getBezeroa() != null) ? f.getBezeroa().getIzena() : 
                             (f.getHornitzailea() != null ? f.getHornitzailea().getIzena() : "---");
            
            modelo.addRow(new Object[] { 
                f.getId(), 
                entidad, 
                f.getData(), 
                f.getTotala() + " €", 
                f.getFakturaRuta() // Aquí veremos si ya se ha subido al XAMPP
            });
        }
    }
}