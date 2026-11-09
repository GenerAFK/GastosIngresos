package com.mycompany.gastosingresos.vista;

import com.mycompany.gastosingresos.config.ConfiguracionVentanas;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JComponent;


/**
 *
 * @author Abrah
 */
public class InterfazBienvenida extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(InterfazBienvenida.class.getName());

    /**
     * Creates new form InterfazBienvenida
     */
    public InterfazBienvenida() {
        initComponents();
        
        ConfiguracionVentanas.aplicarIcono(this);

        lblIconIngresos.setIcon(
                redimensionarIcono("/imagenes/icono_ingresos.png", 100, 100)
        );

        lblIconGastos.setIcon(
                redimensionarIcono("/imagenes/icono_gastos.png", 100, 100)
        );

        aplicarEstiloGlobal();

        pack();
        setLocationRelativeTo(null);

    
    lblIconBalances.setIcon(
        redimensionarIcono("/imagenes/icono_balances.png", 100, 100)
    );
    
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

    /*
    
    Toda esta parte de estilos es codigo generado por IA, no modifique por mi cuenta
    absolutamente nada de esta parte todo es desarollado por chatgpt a partir de toda
    la interfaz generada por mi.
    
     */

    private void aplicarEstiloGlobal() {

        // Paleta de colores
        Color fondo = new Color(245, 247, 250);
        Color blanco = Color.WHITE;
        Color texto = new Color(31, 41, 55);
        Color secundario = new Color(107, 114, 128);
        Color borde = new Color(225, 230, 237);

        Color verde = new Color(25, 135, 84);
        Color rojo = new Color(220, 53, 69);
        Color azul = new Color(37, 99, 235);

        // Fondo general
        getContentPane().setBackground(fondo);
        jpanelPrincipal.setBackground(fondo);
        jPanelFuncionalidad.setBackground(fondo);

        // ENCABEZADO
        jPanelSuperior.setBackground(blanco);

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

        lblBienvenida.setFont(
                new Font("SansSerif", Font.BOLD, 24)
        );

        lblBienvenida.setForeground(texto);

        // SUBTÍTULOS
        jPanelModulo.setBackground(fondo);

        // Conservamos GridLayout, pero reducimos el espacio vertical.
        jPanelModulo.setLayout(
                new GridLayout(2, 1, 0, 8)
        );

        jPanelModulo.setBorder(
                BorderFactory.createEmptyBorder(
                        15, 20, 15, 20
                )
        );

        lblSubTitulo.setText(
                "Controla tus finanzas de forma rápida, intuitiva y centralizada."
        );

        lblSubTitulo.setFont(
                new Font("SansSerif", Font.PLAIN, 13)
        );

        lblSubTitulo.setForeground(secundario);

        lblModulos.setText("MÓDULOS PRINCIPALES");

        lblModulos.setFont(
                new Font("SansSerif", Font.BOLD, 15)
        );

        lblModulos.setForeground(texto);

        // CONTENEDOR DE LAS TRES TARJETAS
        jPanelBotones.setBackground(fondo);

        // Seguimos utilizando GridLayout (1 fila, 3 columnas).
        // Añadimos 18 píxeles de separación entre tarjetas.
        jPanelBotones.setLayout(
                new GridLayout(1, 3, 18, 0)
        );

        // Quitamos el borde azul y añadimos márgenes.
        jPanelBotones.setBorder(
                BorderFactory.createEmptyBorder(
                        10, 22, 22, 22
                )
        );

        // TARJETA DE INGRESOS
        estilizarTarjeta(
                jPanelIngreso,
                lblIconIngresos,
                lblTituloIngresos,
                lblDescripcionIngresos,
                jPanelBotonIngresos,
                btnIngresos,
                verde
        );

        // TARJETA DE GASTOS
        estilizarTarjeta(
                jPanelGasto,
                lblIconGastos,
                lblTitulogastos,
                lblDescripcionGastos,
                jPanelBotonGastos,
                btnGastos,
                rojo
        );

        // TARJETA DE RESUMEN
        estilizarTarjeta(jPanelResumen,
                lblIconBalances,
                lblTituloResumen,
                lblDescripcionResumen,
                jPanelBotonResumen,
                btnResumen,
                azul
        );

        // Mejoramos las descripciones para que ocupen dos líneas.
        lblDescripcionIngresos.setText(
                "<html><center>Registra entradas monetarias,<br>"
                + "nóminas y rentas.</center></html>"
        );

        lblDescripcionGastos.setText(
                "<html><center>Controla compras, recibos,<br>"
                + "facturas y pagos periódicos.</center></html>"
        );

        lblDescripcionResumen.setText(
                "<html><center>Visualiza tu balance global,<br>"
                + "estadísticas y métricas.</center></html>"
        );

        // Quitamos el texto provisional del icono de balances.
        lblIconBalances.setText("");
    }

    private void estilizarTarjeta(
            JPanel panel,
            JLabel icono,
            JLabel titulo,
            JLabel descripcion,
            JPanel panelBoton,
            JButton boton,
            Color colorBoton) {

        // Fondo blanco
        panel.setBackground(Color.WHITE);
        panel.setOpaque(true);

        // Borde fino y espacio interior
        panel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(225, 230, 237), 1
                        ),
                        BorderFactory.createEmptyBorder(
                                12, 12, 12, 12
                        )
                )
        );

        // Icono
        icono.setHorizontalAlignment(
                JLabel.CENTER
        );

        // Título
        titulo.setFont(
                new Font("SansSerif", Font.BOLD, 17)
        );

        titulo.setForeground(
                new Color(31, 41, 55)
        );

        titulo.setHorizontalAlignment(
                JLabel.CENTER
        );

        // Descripción
        descripcion.setFont(
                new Font("SansSerif", Font.PLAIN, 12)
        );

        descripcion.setForeground(
                new Color(107, 114, 128)
        );

        descripcion.setHorizontalAlignment(
                JLabel.CENTER
        );

        // Panel que contiene el botón
        panelBoton.setBackground(Color.WHITE);
        panelBoton.setOpaque(true);

        panelBoton.setLayout(
                new FlowLayout(FlowLayout.CENTER, 0, 6)
        );

        // Botón

        boton.setUI(new BasicButtonUI() {

            @Override
            public void paint(Graphics g, JComponent c) {

                JButton b = (JButton) c;

                Graphics2D g2 = (Graphics2D) g.create();

                // Suavizado de los bordes
                g2.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON
                );

                // Color según el estado del botón
                Color color = colorBoton;

                if (b.getModel().isPressed()) {
                    color = colorBoton.darker();
                } else if (b.getModel().isRollover()) {
                    color = colorBoton.brighter();
                }

                // Dibujar fondo redondeado
                g2.setColor(color);

                g2.fillRoundRect(
                        0, 0,
                        b.getWidth(), b.getHeight(),
                        18, 18
                );

                g2.dispose();

                // Dibujar texto e iconos
                super.paint(g, c);
            }
        });

        // Configuración del botón
        boton.setContentAreaFilled(false);
        boton.setOpaque(false);
        boton.setBorderPainted(false);
        boton.setFocusPainted(false);

        boton.setBorder(
                BorderFactory.createEmptyBorder(8, 16, 8, 16)
        );

        boton.setForeground(Color.WHITE);

        boton.setFont(
                new Font("SansSerif", Font.BOLD, 12)
        );

        boton.setPreferredSize(
                new Dimension(160, 38)
        );

        boton.setRolloverEnabled(true);

        boton.setCursor(
                Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)
        );

    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanelPrincipal = new javax.swing.JPanel();
        jPanelSuperior = new javax.swing.JPanel();
        lblBienvenida = new javax.swing.JLabel();
        jPanelFuncionalidad = new javax.swing.JPanel();
        jPanelModulo = new javax.swing.JPanel();
        lblSubTitulo = new javax.swing.JLabel();
        lblModulos = new javax.swing.JLabel();
        jPanelBotones = new javax.swing.JPanel();
        jPanelIngreso = new javax.swing.JPanel();
        lblIconIngresos = new javax.swing.JLabel();
        lblTituloIngresos = new javax.swing.JLabel();
        lblDescripcionIngresos = new javax.swing.JLabel();
        jPanelBotonIngresos = new javax.swing.JPanel();
        btnIngresos = new javax.swing.JButton();
        jPanelGasto = new javax.swing.JPanel();
        lblIconGastos = new javax.swing.JLabel();
        lblTitulogastos = new javax.swing.JLabel();
        lblDescripcionGastos = new javax.swing.JLabel();
        jPanelBotonGastos = new javax.swing.JPanel();
        btnGastos = new javax.swing.JButton();
        jPanelResumen = new javax.swing.JPanel();
        lblIconBalances = new javax.swing.JLabel();
        lblTituloResumen = new javax.swing.JLabel();
        lblDescripcionResumen = new javax.swing.JLabel();
        jPanelBotonResumen = new javax.swing.JPanel();
        btnResumen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpanelPrincipal.setLayout(new java.awt.BorderLayout());

        jPanelSuperior.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 255)));
        jPanelSuperior.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 20));

        lblBienvenida.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lblBienvenida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBienvenida.setText("Bienvenido a tu gestor de finanzas personal");
        jPanelSuperior.add(lblBienvenida);

        jpanelPrincipal.add(jPanelSuperior, java.awt.BorderLayout.PAGE_START);

        jPanelFuncionalidad.setLayout(new java.awt.BorderLayout());

        jPanelModulo.setLayout(new java.awt.GridLayout(2, 0, 20, 80));

        lblSubTitulo.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        lblSubTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubTitulo.setText("Nosotros te queremos aunque en tu cuenta solo tengas 0 a la derecha, no como tu ex");
        jPanelModulo.add(lblSubTitulo);

        lblModulos.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        lblModulos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblModulos.setText("Modulos Principales");
        jPanelModulo.add(lblModulos);

        jPanelFuncionalidad.add(jPanelModulo, java.awt.BorderLayout.PAGE_START);

        jPanelBotones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        jPanelBotones.setLayout(new java.awt.GridLayout(1, 3));

        jPanelIngreso.setLayout(new java.awt.GridLayout(4, 0));

        lblIconIngresos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconIngresos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_ingresos.png"))); // NOI18N
        jPanelIngreso.add(lblIconIngresos);

        lblTituloIngresos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloIngresos.setText("Ingresos");
        jPanelIngreso.add(lblTituloIngresos);

        lblDescripcionIngresos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDescripcionIngresos.setText("Registra entradas monetarias, nóminas, rentas, etc.");
        jPanelIngreso.add(lblDescripcionIngresos);

        btnIngresos.setText("Gestionar ingresos");
        btnIngresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresosActionPerformed(evt);
            }
        });
        jPanelBotonIngresos.add(btnIngresos);

        jPanelIngreso.add(jPanelBotonIngresos);

        jPanelBotones.add(jPanelIngreso);

        jPanelGasto.setLayout(new java.awt.GridLayout(4, 0));

        lblIconGastos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconGastos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_gastos.png"))); // NOI18N
        jPanelGasto.add(lblIconGastos);

        lblTitulogastos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulogastos.setText("Gastos");
        jPanelGasto.add(lblTitulogastos);

        lblDescripcionGastos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDescripcionGastos.setText("Controla los gastos, las facturas y los pagos periodicos");
        lblDescripcionGastos.setToolTipText("");
        jPanelGasto.add(lblDescripcionGastos);

        btnGastos.setText("Gestionar gastos");
        btnGastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGastosActionPerformed(evt);
            }
        });
        jPanelBotonGastos.add(btnGastos);

        jPanelGasto.add(jPanelBotonGastos);

        jPanelBotones.add(jPanelGasto);

        jPanelResumen.setLayout(new java.awt.GridLayout(4, 0));

        lblIconBalances.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconBalances.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_balances.png"))); // NOI18N
        lblIconBalances.setText("IconResumen");
        jPanelResumen.add(lblIconBalances);

        lblTituloResumen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloResumen.setText("Resumen");
        jPanelResumen.add(lblTituloResumen);

        lblDescripcionResumen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDescripcionResumen.setText("Visualiza el balance global");
        jPanelResumen.add(lblDescripcionResumen);

        btnResumen.setText("Visualizar resumen");
        btnResumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResumenActionPerformed(evt);
            }
        });
        jPanelBotonResumen.add(btnResumen);

        jPanelResumen.add(jPanelBotonResumen);

        jPanelBotones.add(jPanelResumen);

        jPanelFuncionalidad.add(jPanelBotones, java.awt.BorderLayout.CENTER);

        jpanelPrincipal.add(jPanelFuncionalidad, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresosActionPerformed
        
        InterfazIngresos ingresos = new InterfazIngresos();

                ingresos.setSize(getSize());
                ingresos.setLocationRelativeTo(null);
                ingresos.setVisible(true);

                dispose();
    }//GEN-LAST:event_btnIngresosActionPerformed

    private void btnResumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResumenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResumenActionPerformed

    private void btnGastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGastosActionPerformed
        
        InterfazGastos gastos = new InterfazGastos();

                gastos.setSize(getSize());
                gastos.setLocationRelativeTo(null);
                gastos.setVisible(true);

                dispose();
    }//GEN-LAST:event_btnGastosActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new InterfazBienvenida().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGastos;
    private javax.swing.JButton btnIngresos;
    private javax.swing.JButton btnResumen;
    private javax.swing.JPanel jPanelBotonGastos;
    private javax.swing.JPanel jPanelBotonIngresos;
    private javax.swing.JPanel jPanelBotonResumen;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JPanel jPanelFuncionalidad;
    private javax.swing.JPanel jPanelGasto;
    private javax.swing.JPanel jPanelIngreso;
    private javax.swing.JPanel jPanelModulo;
    private javax.swing.JPanel jPanelResumen;
    private javax.swing.JPanel jPanelSuperior;
    private javax.swing.JPanel jpanelPrincipal;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JLabel lblDescripcionGastos;
    private javax.swing.JLabel lblDescripcionIngresos;
    private javax.swing.JLabel lblDescripcionResumen;
    private javax.swing.JLabel lblIconBalances;
    private javax.swing.JLabel lblIconGastos;
    private javax.swing.JLabel lblIconIngresos;
    private javax.swing.JLabel lblModulos;
    private javax.swing.JLabel lblSubTitulo;
    private javax.swing.JLabel lblTituloIngresos;
    private javax.swing.JLabel lblTituloResumen;
    private javax.swing.JLabel lblTitulogastos;
    // End of variables declaration//GEN-END:variables
}
