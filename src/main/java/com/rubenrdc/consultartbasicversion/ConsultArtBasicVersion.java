package com.rubenrdc.consultartbasicversion;

import com.rubenrdc.consultartbasicversion.IGU.Auth.Login;
import com.rubenrdc.consultartbasicversion.dao.DaoConnection;

/**
 *
 * @author Ruben
 */
public class ConsultArtBasicVersion {

    public static void main(String[] args) {
        DaoConnection.loadPersistenceUnit();
        Login ventana = new Login();
        ventana.setResizable(false);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
    }
}
