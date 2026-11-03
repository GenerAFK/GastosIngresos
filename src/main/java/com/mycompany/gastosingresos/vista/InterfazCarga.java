package com.mycompany.gastosingresos.vista;

import com.mycompany.gastosingresos.config.ConfiguracionVentanas;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;

public class InterfazCarga extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(InterfazCarga.class.getName());

    public InterfazCarga() {

        setUndecorated(true);

        initComponents();
        
        setSize(850, 700);

        lblIcon.setIcon(redimensionarIcono("/imagenes/icono_ingresos.png", 100, 100));

        ConfiguracionVentanas.aplicarIcono(this);
        
        CargarEstilos();

        setLocationRelativeTo(null);
        
        iniciarCarga();
    }

    private ImageIcon redimensionarIcono(String ruta, int ancho, int alto) {

        ImageIcon iconoOriginal = new ImageIcon(
                getClass().getResource(ruta)
        );

        Image imagen = iconoOriginal.getImage();

        Image imagenEscalada = imagen.getScaledInstance(
                ancho,
                alto,
                Image.SCALE_SMOOTH
        );

        return new ImageIcon(imagenEscalada);
    }
    
    
    private void CargarEstilos() {

        // PALETA DE COLORES
        Color fondo = new Color(245, 247, 250);
        Color blanco = Color.WHITE;
        Color texto = new Color(31, 41, 55);
        Color secundario = new Color(107, 114, 128);
        Color borde = new Color(225, 230, 237);
        Color verde = new Color(25, 135, 84);

        // FONDO GENERAL
        getContentPane().setBackground(fondo);

        jPanelSuperior.setBackground(blanco);
        jPanelCentral.setBackground(fondo);
        jPanelInferior.setBackground(blanco);

        jPanelImgLogo.setBackground(fondo);
        jPanelNameApp.setBackground(fondo);
        jPanelBarraCarga.setBackground(fondo);
        jPanelCarga.setBackground(fondo);

        // ENCABEZADO
        jPanelSuperior.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(
                                0, 0, 1, 0, borde
                        ),
                        BorderFactory.createEmptyBorder(
                                18, 20, 18, 20
                        )
                )
        );

        lblEncabezado.setFont(
                new Font("SansSerif", Font.BOLD, 22)
        );
        lblEncabezado.setForeground(texto);
        lblEncabezado.setHorizontalAlignment(SwingConstants.CENTER);

        // NOMBRE DE LA APLICACIÓN
        lblNombreAplicacion.setFont(
                new Font("SansSerif", Font.PLAIN, 14)
        );
        lblNombreAplicacion.setForeground(secundario);
        lblNombreAplicacion.setHorizontalAlignment(SwingConstants.CENTER);

        // MENSAJES DE CARGA
        lblMensajeCarga.setFont(
                new Font("SansSerif", Font.PLAIN, 13)
        );
        lblMensajeCarga.setForeground(secundario);
        lblMensajeCarga.setHorizontalAlignment(SwingConstants.CENTER);

        // BARRA DE PROGRESO
        barraCarga.setMinimum(0);
        barraCarga.setMaximum(100);
        barraCarga.setValue(0);
        barraCarga.setStringPainted(false);
        barraCarga.setIndeterminate(false);
        barraCarga.setForeground(verde);
        barraCarga.setBackground(borde);
        barraCarga.setBorderPainted(false);
        barraCarga.setOpaque(true);

        // PIE DE VENTANA
        jPanelInferior.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(
                                1, 0, 0, 0, borde
                        ),
                        BorderFactory.createEmptyBorder(
                                12, 15, 12, 15
                        )
                )
        );

        Font fuentePie = new Font("SansSerif", Font.PLAIN, 11);

        lblCreditosSuperior.setFont(fuentePie);
        lblCreditosInferior.setFont(fuentePie);
        lblVersion.setFont(fuentePie);

        lblCreditosSuperior.setForeground(secundario);
        lblCreditosInferior.setForeground(secundario);
        lblVersion.setForeground(secundario);

        lblCreditosSuperior.setHorizontalAlignment(SwingConstants.CENTER);
        lblCreditosInferior.setHorizontalAlignment(SwingConstants.CENTER);
        lblVersion.setHorizontalAlignment(SwingConstants.CENTER);
    }


    private void iniciarCarga() {

        temporizadorCarga = new javax.swing.Timer(50, e -> {

            progresoCarga++;

            barraCarga.setValue(progresoCarga);

            int indiceMensaje = (progresoCarga * (mensajesCarga.length - 1)) / 100;

            lblMensajeCarga.setText(mensajesCarga[indiceMensaje]);

            if (progresoCarga >= 100) {

                temporizadorCarga.stop();

                InterfazBienvenida bienvenida = new InterfazBienvenida();

                bienvenida.setSize(getSize());
                bienvenida.setLocationRelativeTo(null);
                bienvenida.setVisible(true);

                dispose();
            }
        });

        temporizadorCarga.start();
    }

    private final String[] mensajesCarga = {
        "Nosotros te queremos sin importar cuantos 0 a la derecha tenga tu cuenta, no como tu ex...",
        "Buscando dónde se ha ido tu dinero...",
        "Calculando cuánto te queda para llegar a fin de mes...",
        "Ocultando los gastos innecesarios...",
        "Todo bajo control... o eso esperamos."
    };

    private int progresoCarga = 0;

    private javax.swing.Timer temporizadorCarga;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelSuperior = new javax.swing.JPanel();
        lblEncabezado = new javax.swing.JLabel();
        jPanelInferior = new javax.swing.JPanel();
        lblCreditosSuperior = new javax.swing.JLabel();
        lblCreditosInferior = new javax.swing.JLabel();
        lblVersion = new javax.swing.JLabel();
        jPanelCentral = new javax.swing.JPanel();
        jPanelImgLogo = new javax.swing.JPanel();
        lblIcon = new javax.swing.JLabel();
        jPanelNameApp = new javax.swing.JPanel();
        lblNombreAplicacion = new javax.swing.JLabel();
        jPanelBarraCarga = new javax.swing.JPanel();
        lblMensajeCarga = new javax.swing.JLabel();
        jPanelCarga = new javax.swing.JPanel();
        barraCarga = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.BorderLayout(10, 10));

        jPanelSuperior.setLayout(new java.awt.GridLayout(1, 0, 0, 20));

        lblEncabezado.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblEncabezado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEncabezado.setText("Iniciando tu aplicacion de finanzas");
        jPanelSuperior.add(lblEncabezado);

        getContentPane().add(jPanelSuperior, java.awt.BorderLayout.PAGE_START);

        jPanelInferior.setLayout(new java.awt.GridLayout(3, 0, 0, 8));

        lblCreditosSuperior.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCreditosSuperior.setText("Desarrollado por tus panchitos de confianza de 2 de dam");
        jPanelInferior.add(lblCreditosSuperior);

        lblCreditosInferior.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCreditosInferior.setText(" agradecemos cualquier ayuda economica para financiar la comida.");
        jPanelInferior.add(lblCreditosInferior);

        lblVersion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVersion.setText("Version 1.0 y posiblemente la unica si nos deportan despues de las elecciones");
        jPanelInferior.add(lblVersion);

        getContentPane().add(jPanelInferior, java.awt.BorderLayout.PAGE_END);

        jPanelCentral.setLayout(new java.awt.GridLayout(3, 0));

        javax.swing.GroupLayout jPanelImgLogoLayout = new javax.swing.GroupLayout(jPanelImgLogo);
        jPanelImgLogo.setLayout(jPanelImgLogoLayout);
        jPanelImgLogoLayout.setHorizontalGroup(
            jPanelImgLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 658, Short.MAX_VALUE)
            .addGroup(jPanelImgLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelImgLogoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblIcon)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanelImgLogoLayout.setVerticalGroup(
            jPanelImgLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 132, Short.MAX_VALUE)
            .addGroup(jPanelImgLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelImgLogoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblIcon)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanelCentral.add(jPanelImgLogo);

        lblNombreAplicacion.setText("Gestor de finanzas personales");

        javax.swing.GroupLayout jPanelNameAppLayout = new javax.swing.GroupLayout(jPanelNameApp);
        jPanelNameApp.setLayout(jPanelNameAppLayout);
        jPanelNameAppLayout.setHorizontalGroup(
            jPanelNameAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 658, Short.MAX_VALUE)
            .addGroup(jPanelNameAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelNameAppLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblNombreAplicacion)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanelNameAppLayout.setVerticalGroup(
            jPanelNameAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 132, Short.MAX_VALUE)
            .addGroup(jPanelNameAppLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelNameAppLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblNombreAplicacion)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanelCentral.add(jPanelNameApp);

        jPanelBarraCarga.setLayout(new java.awt.GridLayout(2, 0));

        lblMensajeCarga.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMensajeCarga.setText("mensajes subliminales");
        jPanelBarraCarga.add(lblMensajeCarga);

        jPanelCarga.add(barraCarga);

        jPanelBarraCarga.add(jPanelCarga);

        jPanelCentral.add(jPanelBarraCarga);

        getContentPane().add(jPanelCentral, java.awt.BorderLayout.CENTER);

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new InterfazCarga().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraCarga;
    private javax.swing.JPanel jPanelBarraCarga;
    private javax.swing.JPanel jPanelCarga;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JPanel jPanelImgLogo;
    private javax.swing.JPanel jPanelInferior;
    private javax.swing.JPanel jPanelNameApp;
    private javax.swing.JPanel jPanelSuperior;
    private javax.swing.JLabel lblCreditosInferior;
    private javax.swing.JLabel lblCreditosSuperior;
    private javax.swing.JLabel lblEncabezado;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblMensajeCarga;
    private javax.swing.JLabel lblNombreAplicacion;
    private javax.swing.JLabel lblVersion;
    // End of variables declaration//GEN-END:variables
}
