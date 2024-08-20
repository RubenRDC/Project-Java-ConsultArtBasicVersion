package com.rubenrdc.consultartbasicversion.models.interfaces;

import javax.swing.JOptionPane;

/**
 *
 * @author Ruben
 */
public interface DialogsFunt {

    default public void msgInfoOperation(boolean exito) {
        if (exito) {
            msgInfo("Operacion realizada con exito.", "Exito!!", JOptionPane.INFORMATION_MESSAGE);

        } else {
            msgInfo("Ha Ocurrido un Error a la hora de realizar la operacion solicitada.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    default public void msgInfo(String message, String title, int JOptionPaneTypeMessg) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPaneTypeMessg);
    }

}
