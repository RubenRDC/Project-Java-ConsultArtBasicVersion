package com.rubenrdc.consultartbasicversion.models.interfaces;

import com.rubenrdc.consultartbasicversion.models.Deposito;
import java.awt.BorderLayout;
import java.awt.Component;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Ruben
 */
public interface Utilities {

    default public void JComboBoxDepositos(javax.swing.JComboBox listDeposito, List<Deposito> listDeps) {
        listDeposito.removeAllItems();
        for (Deposito d : listDeps) {
            if (d != null) {
                listDeposito.addItem(d.getNombre());
            }
        }
    }

    default public void clearTable(javax.swing.JTable jTable) {
        jTable.clearSelection();
        javax.swing.table.DefaultTableModel dm = (javax.swing.table.DefaultTableModel) (jTable.getModel());
        dm.setNumRows(0);
        jTable.setModel(dm);
    }

    default public void centrarTable(javax.swing.JTable tb) {
        javax.swing.table.DefaultTableCellRenderer Alinear = new javax.swing.table.DefaultTableCellRenderer();
        Alinear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        for (int i = 0; i < tb.getColumnModel().getColumnCount(); i++) {
            tb.getColumnModel().getColumn(i).setCellRenderer(Alinear);
        }
    }

    default public <T extends Exportable> void fillTable(javax.swing.JTable tb, List<T> lista) {
        //No se va a llamar a este metodo si la lista esta vacia.
        javax.swing.table.DefaultTableModel dm = (javax.swing.table.DefaultTableModel) (tb.getModel());
        for (int i = 0; i < lista.size(); i++) {
            dm.addRow(lista.get(i).getRow());
        }
        tb.setModel(dm);
    }

    default public void fillTable(javax.swing.JTable tb, Map<String, Integer> mapListStock) {
        javax.swing.table.DefaultTableModel dm = (javax.swing.table.DefaultTableModel) (tb.getModel());
        dm.setNumRows(0);
        if (mapListStock != null) {
            if (!mapListStock.isEmpty()) {
                Set<String> keySet = mapListStock.keySet();
                for (String string : keySet) {
                    dm.addRow(new Object[]{string, mapListStock.get(string)});
                }
            }
        }
        tb.setModel(dm);
    }

    default public void setPanelEnabled(javax.swing.JPanel panel, Boolean isEnabled) {
        //panel.setEnabled(isEnabled);
        Component[] components = panel.getComponents();
        for (Component component : components) {
            componentsInPanel(component, isEnabled);
        }
    }

    private void componentsInPanel(Component component, Boolean isEnabled) {
        Component[] compsInternos;
        if (component != null) {
            if (component instanceof JPanel jPanel) {
                compsInternos = jPanel.getComponents();
                for (Component c : compsInternos) {
                    if (c != null) {
                        if (c instanceof JPanel) {
                            componentsInPanel(c, isEnabled);
                        } else {
                            c.setEnabled(isEnabled);
                        }
                    }
                }
            } else {
                component.setEnabled(isEnabled);
            }
        }
    }

    default public void pinterJFrame(javax.swing.JFrame window, boolean setVisible, Component setLocationRelativeTo, boolean setResizable) {
        window.setVisible(setVisible);
        window.setLocationRelativeTo(setLocationRelativeTo);
        window.setResizable(setResizable);
    }

    default public void showPanel(javax.swing.JPanel panel, int SizeWhidth, int Sizeheight, int setLocationX, int setLocationY, javax.swing.JPanel InPanel) {
        panel.setSize(SizeWhidth, Sizeheight);
        panel.setLocation(setLocationX, setLocationY);
        InPanel.removeAll();
        InPanel.add(panel, BorderLayout.CENTER);
        InPanel.revalidate();
        InPanel.repaint();
    }

    default public void filtrarKeyEvent(java.awt.event.KeyEvent evt) {
        String cadena;
        char keyAscii;
        int intKeyAscii;

        cadena = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890-" + (char) 32;// + (char)32
        keyAscii = evt.getKeyChar();
        intKeyAscii = (int) keyAscii;

        if (intKeyAscii > 26) {

            if (cadena.indexOf(keyAscii) == -1) {
                evt.setKeyChar((char) 0);//Si el keyAscii recibida no corresponde a ninguno de la cadena de caracteres permitadas setea la key a null para anular la entrada del digito
                JOptionPane.showMessageDialog(null, "Intento ingresar digitos no permitidos.", "Advertencia!", JOptionPane.ERROR_MESSAGE);
            } else {

                evt.setKeyChar(keyAscii);

            }
        }
    }
}
