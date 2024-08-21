package com.rubenrdc.consultartbasicversion.IGU.Auth;

import com.rubenrdc.consultartbasicversion.IGU.ConsArt;
import com.rubenrdc.consultartbasicversion.dao.DaoConnection;
import com.rubenrdc.consultartbasicversion.dao.UserDao;
import com.rubenrdc.consultartbasicversion.models.Articulo;
import com.rubenrdc.consultartbasicversion.models.ArticuloUbicacion;
import com.rubenrdc.consultartbasicversion.models.Deposito;
import com.rubenrdc.consultartbasicversion.models.Ubicacion;
import com.rubenrdc.consultartbasicversion.models.User;
import com.rubenrdc.consultartbasicversion.models.interfaces.Utilities;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.ImageIcon;

/**
 *
 * @author Ruben
 *
 */
public class Login extends javax.swing.JFrame implements Utilities {

    private ConsArt ventana;
    private ReentrantLock lock = new ReentrantLock();

    public Login() {
        initComponents();
        UserTxt.setText("Ruben");
        PsstTxt.setText("1234");
        //
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        UserTxt = new javax.swing.JTextField();
        PsstTxt = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iniciar Sesion");
        setIconImage((new ImageIcon("src/main/java/com/rubenrdc/consultartbasicversion/miselaneos/icon.png")).getImage());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Iniciar Sesion");
        jLabel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Usuario:");
        jLabel2.setToolTipText("");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Constraseña:");

        UserTxt.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        UserTxt.setToolTipText("");
        UserTxt.setBorder(null);
        UserTxt.setCaretColor(new java.awt.Color(0, 0, 0));
        UserTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        UserTxt.setDoubleBuffered(true);

        PsstTxt.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        PsstTxt.setBorder(null);
        PsstTxt.setMinimumSize(new java.awt.Dimension(15, 27));
        PsstTxt.setPreferredSize(new java.awt.Dimension(15, 27));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UserTxt)
            .addComponent(PsstTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(UserTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PsstTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnLogin.setText("Iniciar Sesion");
        btnLogin.setToolTipText("");
        btnLogin.setFocusPainted(false);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnLogin)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        if (ventana == null) {
            Thread r = new Thread(new Runnable() {
                public void run() {
                    lock.lock();
                    try {
                        btnLogin.setEnabled(false);
                        btnLogin.setText("...");
                        String u = UserTxt.getText();
                        String p = new String(PsstTxt.getPassword());
                        if (u.length() <= 10 && u.length() != 0 && p.length() != 0) {
                            User user = new User(u, p);
                            if (UserDao.findUser(user) != null) {
                                dispose();
                                ventana = new ConsArt();
                                pinterJFrame(ventana, true, null, false);
                            } else {
                                javax.swing.JOptionPane.showMessageDialog(null, "Contraseña o Usuarios Inexistente");
                            }

                        } else {
                            javax.swing.JOptionPane.showMessageDialog(null, "Contraseña o Usuarios Inexistente");
                        }
                    } finally {
                        btnLogin.setText("Iniciar Sesion");
                        btnLogin.setEnabled(true);
                        lock.unlock();
                    }
                }
            });
            r.start();
        }
    }//GEN-LAST:event_btnLoginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField PsstTxt;
    private javax.swing.JTextField UserTxt;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
