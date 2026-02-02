package erronka2;

import java.util.ArrayList;

import javax.swing.JOptionPane;


public class login {

    public static String logina() {
       

        DAO dao = new DAO();
        ArrayList<langileak> langileZerrenda = dao.getLangileak();

        for (langileak l : langileZerrenda) {
            if (l.getErabiltzailea().equals(interfazeLogin.textField.getText()) && l.getPasahitza().equals(interfazeLogin.textField_1.getText())) {            	
                return l.getRola();
            }
    }
        JOptionPane.showMessageDialog(null, "Erabiltzailea edo pasahitza okerra ");
        return null;
    }
		
}

