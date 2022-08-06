package co.edu.univalle.businessmanagment.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class SplashScreen extends javax.swing.JFrame {

    private Integer n = 0;
    private Timer timer;

    public SplashScreen() {
        initComponents();
        this.setLocationRelativeTo(null);
        loadSplashScreen();
    }

    private void loadSplashScreen() {
        progress_bar.setValue(0);

        ActionListener action = (ActionEvent e) -> {
            if (n <= 100) {
                progress_bar.setValue(n);
                n = n + 1;
                porcentaje.setText(progress_bar.getValue() + "%");
                if (progress_bar.getValue() > 50) {
                    porcentaje.setForeground(new java.awt.Color(70, 58, 64));
                }
            } else {
                timer.stop();
                dispose();

                Dashboard home = new Dashboard();
//                home.setIconImage(new ImageIcon(home.getClass().getResource("/resources/tpv.png")).getImage());
                home.setTitle("Sistema de Gestión");
                home.setVisible(true);
            }
        };

        timer = new Timer(50, action);
        timer.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inicioProyecto = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        porcentaje = new javax.swing.JLabel();
        progress_bar = new javax.swing.JProgressBar();
        backgroundSplash = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inicioProyecto.setBackground(new java.awt.Color(255, 255, 255));
        inicioProyecto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ACMA300.png"))); // NOI18N
        inicioProyecto.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, -1, -1));

        porcentaje.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        porcentaje.setForeground(new java.awt.Color(0, 0, 0));
        porcentaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        porcentaje.setText("0%");
        inicioProyecto.add(porcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 470, 60, 30));

        progress_bar.setBackground(new java.awt.Color(102, 102, 102));
        progress_bar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        progress_bar.setForeground(new java.awt.Color(51, 0, 51));
        progress_bar.setBorderPainted(false);
        inicioProyecto.add(progress_bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 500, 600, 30));

        backgroundSplash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BackgroundS.png"))); // NOI18N
        backgroundSplash.setText("jLabel1");
        inicioProyecto.add(backgroundSplash, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 540));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inicioProyecto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inicioProyecto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SplashScreen().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundSplash;
    private javax.swing.JPanel inicioProyecto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel porcentaje;
    private javax.swing.JProgressBar progress_bar;
    // End of variables declaration//GEN-END:variables
}
