package erronka2;

import java.util.ArrayList;

public class login {

    public static String logina() {
       

        DAO dao = new DAO();
        ArrayList<langileak> langileZerrenda = dao.getLangileak();

        for (langileak l : langileZerrenda) {
            if (l.getErabiltzailea().equals(interfazeLogin.textField.getText()) &&
                l.getPasahitza().equals(interfazeLogin.textField_1.getText())) {

                System.out.println("Ongi etorri, " + l.getIzena() + " " +
                                   l.getAbizena() + " (" + l.getRola() + ")");
                return l.getRola();
            }
        }

        System.out.println("Erabiltzailea edo pasahitza okerra da.");
        return null;
    }
}
