package com.mycompany.gastosingresos.vista;

import com.mycompany.gastosingresos.config.ConfiguracionVentanas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.basic.BasicSpinnerUI;
import javax.swing.text.JTextComponent;

public class InterfazGastos extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(InterfazGastos.class.getName());

    /**
     * Creates new form InterfazGastos
     */
    public InterfazGastos() {
        
        initComponents();
        
        getContentPane().setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanelGeneral, java.awt.BorderLayout.CENTER);
        
        ConfiguracionVentanas.aplicarIcono(this);

        aplicarEstilosGastos();

        pack();
        setLocationRelativeTo(null);
    }
    
    // ---------- PALETA (compartida con el resto de la app + rojos) ----------
    private static final Color FONDO = new Color(245, 247, 250);
    private static final Color BLANCO = Color.WHITE;
    private static final Color TEXTO = new Color(31, 41, 55);
    private static final Color SECUNDARIO = new Color(107, 114, 128);
    private static final Color BORDE = new Color(225, 230, 237);

    private static final Color ROJO = new Color(220, 53, 69);
    private static final Color ROJO_OSCURO = new Color(176, 32, 48);
    private static final Color ROJO_CLARO = new Color(253, 236, 238);
    private static final Color ROJO_BORDE = new Color(246, 200, 205);

    private void aplicarEstilosGastos() {

        // ---------- FONDOS GENERALES ----------
        getContentPane().setBackground(FONDO);
        jPanelGeneral.setBackground(FONDO);
        jPanelCuerpo.setBackground(FONDO);
        jPanelAddGastos.setBackground(FONDO);

        // ---------- CABECERA ROJA ----------
        jPanelCabecera.setBackground(ROJO);
        jPanelCabecera.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(0, 0, 4, 0, ROJO_OSCURO),
                        BorderFactory.createEmptyBorder(14, 20, 14, 20)
                )
        );

        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 30));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        lblSubtitulo.setFont(new Font("SansSerif", Font.PLAIN, 15));
        lblSubtitulo.setForeground(new Color(255, 225, 229));
        lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);

        // ---------- COLUMNA DE ETIQUETAS (tinte rojo suave) ----------
        jPanelConceptos.setBackground(ROJO_CLARO);
        jPanelConceptos.setBorder(
                BorderFactory.createMatteBorder(0, 0, 0, 1, ROJO_BORDE)
        );

        JPanel[] panelesEtiqueta = {
            jPanelConcepto, jPanelImporte, jPanelCategoria, jPanelFecha, jPanelNotas
        };
        for (JPanel p : panelesEtiqueta) {
            p.setBackground(ROJO_CLARO);
            p.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, ROJO_BORDE));
        }

        JLabel[] etiquetas = {
            lblConcepto, lblImporte, lblCategoria, Fecha, lblNotas
        };
        for (JLabel l : etiquetas) {
            estilizarEtiqueta(l);
        }

        lblConcepto.setText("Concepto");
        lblImporte.setText("Importe (€)");
        lblCategoria.setText("Categoría");
        Fecha.setText("Fecha");
        lblNotas.setText("Notas adicionales");

        // ---------- COLUMNA DE CAMPOS (blanca) ----------
        jPanelInsertar.setBackground(BLANCO);

        JPanel[] panelesCampo = {
            jPanel1, jPanel2, jPanel4, jPanel5, jPanelTextArea,
            jPanelLblDia, jPanelSpinnerDia,
            jPanelLblMes, jPanelSpinnerMes,
            jPanelLblAnio, jPanelAnio
        };
        for (JPanel p : panelesCampo) {
            p.setBackground(BLANCO);
        }

        // Etiquetas Día / Mes / Año
        JLabel[] etiquetasFecha = {jLabelDia, lblMes, LblAnio};
        for (JLabel l : etiquetasFecha) {
            l.setFont(new Font("SansSerif", Font.BOLD, 12));
            l.setForeground(ROJO_OSCURO);
            l.setHorizontalAlignment(SwingConstants.CENTER);
        }
        jLabelDia.setText("Día");
        LblAnio.setText("Año");

        // Campos de texto con placeholder
        estilizarCampoTexto(jTextField1);
        estilizarCampoTexto(jTextField2);
        configurarPlaceholder(jTextField1, "Motivo del gasto");
        configurarPlaceholder(jTextField2, "Cantidad");

        // Combo y spinners
        estilizarCombo(jComboBox1);
        estilizarSpinner(SpinnerDia);
        estilizarSpinner(SpinnerMes);
        estilizarSpinner(SpinnerAnio);

        // Área de notas
        NotasAdd.setFont(new Font("SansSerif", Font.PLAIN, 13));
        NotasAdd.setForeground(TEXTO);
        NotasAdd.setBackground(BLANCO);
        NotasAdd.setLineWrap(true);
        NotasAdd.setWrapStyleWord(true);
        NotasAdd.setMargin(new java.awt.Insets(8, 10, 8, 10));
        NotasAdd.setCaretColor(ROJO);
        NotasAdd.setSelectionColor(ROJO_BORDE);
        NotasAdd.setSelectedTextColor(TEXTO);

        TextAreaNotasAdd.setBorder(BorderFactory.createLineBorder(BORDE, 1));
        TextAreaNotasAdd.getViewport().setBackground(BLANCO);
        estilizarScrollBar(TextAreaNotasAdd);

        NotasAdd.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                TextAreaNotasAdd.setBorder(BorderFactory.createLineBorder(ROJO, 2));
            }

            @Override
            public void focusLost(FocusEvent e) {
                TextAreaNotasAdd.setBorder(BorderFactory.createLineBorder(BORDE, 1));
            }
        });

        // ---------- PIE CON BOTONES ----------
        jPanelBotones.setBackground(BLANCO);
        jPanelBotones.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(1, 0, 0, 0, BORDE),
                        BorderFactory.createEmptyBorder(10, 15, 10, 15)
                )
        );

        jPanelOrdenacionIzq.setBackground(BLANCO);
        jPanelOrdenacionDrch.setBackground(BLANCO);
        jPanelBtnCancelar.setBackground(BLANCO);
        jPanelBtnAceptar.setBackground(BLANCO);

        btnAceptar.setText("Guardar gasto");
        btnCancelar.setText("Cancelar");

        estilizarBoton(btnAceptar, true);    // relleno rojo
        estilizarBoton(btnCancelar, false);  // contorno rojo
    }

    // -----------------------------------------------------------------
    // HELPERS
    // -----------------------------------------------------------------
    private void estilizarEtiqueta(JLabel label) {
        label.setFont(new Font("SansSerif", Font.BOLD, 14));
        label.setForeground(ROJO_OSCURO);
        label.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void estilizarCampoTexto(JTextField campo) {
        campo.setFont(new Font("SansSerif", Font.PLAIN, 13));
        campo.setForeground(TEXTO);
        campo.setBackground(BLANCO);
        campo.setCaretColor(ROJO);
        campo.setSelectionColor(ROJO_BORDE);
        campo.setSelectedTextColor(TEXTO);
        campo.setBorder(bordeCampo(false));

        campo.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                campo.setBorder(bordeCampo(true));
            }

            @Override
            public void focusLost(FocusEvent e) {
                campo.setBorder(bordeCampo(false));
            }
        });
    }

    private javax.swing.border.Border bordeCampo(boolean enfocado) {
        return BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(enfocado ? ROJO : BORDE, enfocado ? 2 : 1),
                BorderFactory.createEmptyBorder(
                        enfocado ? 3 : 4, enfocado ? 7 : 8,
                        enfocado ? 3 : 4, enfocado ? 7 : 8)
        );
    }

    private void estilizarCombo(JComboBox<?> combo) {
        combo.setFont(new Font("SansSerif", Font.PLAIN, 13));
        combo.setForeground(TEXTO);
        combo.setBackground(BLANCO);
        combo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void estilizarSpinner(JSpinner spinner) {

        // UI propia con flechas personalizadas
        spinner.setUI(new BasicSpinnerUI() {
            @Override
            protected Component createNextButton() {
                JButton b = crearFlechaSpinner(SwingConstants.NORTH);
                b.setName("Spinner.nextButton");
                installNextButtonListeners(b);
                return b;
            }

            @Override
            protected Component createPreviousButton() {
                JButton b = crearFlechaSpinner(SwingConstants.SOUTH);
                b.setName("Spinner.previousButton");
                installPreviousButtonListeners(b);
                return b;
            }
        });

        // El borde se aplica DESPUÉS de setUI, si no se pierde
        spinner.setFont(new Font("SansSerif", Font.PLAIN, 13));
        spinner.setBackground(BLANCO);
        spinner.setBorder(BorderFactory.createLineBorder(BORDE, 1));

        JComponent editor = spinner.getEditor();
        if (editor instanceof JSpinner.DefaultEditor) {
            JTextField tf = ((JSpinner.DefaultEditor) editor).getTextField();
            tf.setFont(new Font("SansSerif", Font.BOLD, 13));
            tf.setForeground(TEXTO);
            tf.setBackground(BLANCO);
            tf.setCaretColor(ROJO);
            tf.setSelectionColor(ROJO_BORDE);
            tf.setSelectedTextColor(TEXTO);
            tf.setHorizontalAlignment(SwingConstants.CENTER);
            tf.setBorder(BorderFactory.createEmptyBorder(3, 4, 3, 4));

            tf.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    spinner.setBorder(BorderFactory.createLineBorder(ROJO, 2));
                }

                @Override
                public void focusLost(FocusEvent e) {
                    spinner.setBorder(BorderFactory.createLineBorder(BORDE, 1));
                }
            });
        }
    }

    /**
     * Botón de flecha (arriba/abajo) para los spinners.
     */
    private JButton crearFlechaSpinner(int direccion) {

        JButton boton = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {

                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON
                );

                boolean pulsado = getModel().isPressed();
                boolean hover = getModel().isRollover();

                Color fondoBtn = ROJO_CLARO;
                if (pulsado) {
                    fondoBtn = ROJO;
                } else if (hover) {
                    fondoBtn = ROJO_BORDE;
                }
                g2.setColor(fondoBtn);
                g2.fillRect(0, 0, getWidth(), getHeight());

                g2.setColor(ROJO_BORDE);
                g2.drawLine(0, 0, 0, getHeight());

                int cx = getWidth() / 2;
                int cy = getHeight() / 2;
                Polygon flecha = new Polygon();
                if (direccion == SwingConstants.NORTH) {
                    flecha.addPoint(cx - 4, cy + 2);
                    flecha.addPoint(cx + 4, cy + 2);
                    flecha.addPoint(cx, cy - 2);
                } else {
                    flecha.addPoint(cx - 4, cy - 2);
                    flecha.addPoint(cx + 4, cy - 2);
                    flecha.addPoint(cx, cy + 2);
                }
                g2.setColor(pulsado ? Color.WHITE : ROJO_OSCURO);
                g2.fillPolygon(flecha);

                g2.dispose();
            }
        };

        boton.setPreferredSize(new Dimension(20, 10));
        boton.setBorder(BorderFactory.createEmptyBorder());
        boton.setContentAreaFilled(false);
        boton.setFocusable(false);
        boton.setRolloverEnabled(true);
        boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return boton;
    }

    /**
     * Texto gris de ayuda que desaparece al enfocar y vuelve si queda vacío.
     */
    private void configurarPlaceholder(JTextComponent campo, String placeholder) {
        campo.setText(placeholder);
        campo.setForeground(SECUNDARIO);

        campo.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (campo.getText().equals(placeholder)) {
                    campo.setText("");
                    campo.setForeground(TEXTO);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (campo.getText().trim().isEmpty()) {
                    campo.setText(placeholder);
                    campo.setForeground(SECUNDARIO);
                }
            }
        });
    }

    /**
     * Botón redondeado con hover/pressed. relleno = true -> fondo rojo, texto
     * blanco relleno = false -> fondo blanco, borde y texto rojos
     */
    private void estilizarBoton(JButton boton, boolean relleno) {

        boton.setUI(new BasicButtonUI() {

            @Override
            public void paint(Graphics g, JComponent c) {

                JButton b = (JButton) c;
                Graphics2D g2 = (Graphics2D) g.create();

                g2.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON
                );

                boolean pressed = b.getModel().isPressed();
                boolean hover = b.getModel().isRollover();

                if (relleno) {
                    Color color = ROJO;
                    if (pressed) {
                        color = ROJO_OSCURO;
                    } else if (hover) {
                        color = ROJO.brighter();
                    }
                    g2.setColor(color);
                    g2.fillRoundRect(0, 0, b.getWidth(), b.getHeight(), 18, 18);
                } else {
                    Color fondoBtn = BLANCO;
                    if (pressed) {
                        fondoBtn = ROJO_BORDE;
                    } else if (hover) {
                        fondoBtn = ROJO_CLARO;
                    }
                    g2.setColor(fondoBtn);
                    g2.fillRoundRect(0, 0, b.getWidth(), b.getHeight(), 18, 18);

                    g2.setColor(ROJO);
                    g2.drawRoundRect(0, 0, b.getWidth() - 1, b.getHeight() - 1, 18, 18);
                }

                g2.dispose();

                super.paint(g, c);
            }
        });

        boton.setContentAreaFilled(false);
        boton.setOpaque(false);
        boton.setBorderPainted(false);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        boton.setForeground(relleno ? Color.WHITE : ROJO);
        boton.setFont(new Font("SansSerif", Font.BOLD, 12));
        boton.setPreferredSize(new Dimension(150, 38));
        boton.setRolloverEnabled(true);
        boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    /**
     * Barra de scroll fina: sin flechas, pista blanca y "pulgar" redondeado que
     * se enrojece al pasar el ratón o arrastrar.
     */
    private void estilizarScrollBar(JScrollPane scroll) {

        JScrollBar barra = scroll.getVerticalScrollBar();
        barra.setPreferredSize(new Dimension(12, 0));
        barra.setBackground(BLANCO);
        barra.setOpaque(true);
        barra.setUnitIncrement(14);

        barra.setUI(new BasicScrollBarUI() {

            @Override
            protected void configureScrollBarColors() {
                thumbColor = ROJO_BORDE;
                trackColor = BLANCO;
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                return botonVacio();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return botonVacio();
            }

            @Override
            protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
                g.setColor(BLANCO);
                g.fillRect(r.x, r.y, r.width, r.height);
            }

            @Override
            protected void paintThumb(Graphics g, JComponent c, Rectangle r) {

                if (r.isEmpty() || !scrollbar.isEnabled()) {
                    return;
                }

                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON
                );

                Color color = ROJO_BORDE;
                if (isDragging) {
                    color = ROJO_OSCURO;
                } else if (isThumbRollover()) {
                    color = ROJO;
                }

                g2.setColor(color);
                g2.fillRoundRect(r.x + 2, r.y + 2, r.width - 4, r.height - 4, 8, 8);
                g2.dispose();
            }

            private JButton botonVacio() {
                JButton b = new JButton();
                b.setPreferredSize(new Dimension(0, 0));
                b.setMinimumSize(new Dimension(0, 0));
                b.setMaximumSize(new Dimension(0, 0));
                return b;
            }
        });
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelGeneral = new javax.swing.JPanel();
        jPanelCabecera = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblSubtitulo = new javax.swing.JLabel();
        jPanelCuerpo = new javax.swing.JPanel();
        jPanelBotones = new javax.swing.JPanel();
        jPanelOrdenacionIzq = new javax.swing.JPanel();
        jPanelOrdenacionDrch = new javax.swing.JPanel();
        jPanelBtnCancelar = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        jPanelBtnAceptar = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        jPanelAddGastos = new javax.swing.JPanel();
        jPanelConceptos = new javax.swing.JPanel();
        jPanelConcepto = new javax.swing.JPanel();
        lblConcepto = new javax.swing.JLabel();
        jPanelImporte = new javax.swing.JPanel();
        lblImporte = new javax.swing.JLabel();
        jPanelCategoria = new javax.swing.JPanel();
        lblCategoria = new javax.swing.JLabel();
        jPanelFecha = new javax.swing.JPanel();
        Fecha = new javax.swing.JLabel();
        jPanelNotas = new javax.swing.JPanel();
        lblNotas = new javax.swing.JLabel();
        jPanelInsertar = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jPanelLblDia = new javax.swing.JPanel();
        jLabelDia = new javax.swing.JLabel();
        jPanelSpinnerDia = new javax.swing.JPanel();
        SpinnerDia = new javax.swing.JSpinner();
        jPanelLblMes = new javax.swing.JPanel();
        lblMes = new javax.swing.JLabel();
        jPanelSpinnerMes = new javax.swing.JPanel();
        SpinnerMes = new javax.swing.JSpinner();
        jPanelLblAnio = new javax.swing.JPanel();
        LblAnio = new javax.swing.JLabel();
        jPanelAnio = new javax.swing.JPanel();
        SpinnerAnio = new javax.swing.JSpinner();
        jPanelTextArea = new javax.swing.JPanel();
        TextAreaNotasAdd = new javax.swing.JScrollPane();
        NotasAdd = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelGeneral.setLayout(new java.awt.BorderLayout());

        jPanelCabecera.setLayout(new java.awt.GridLayout(2, 0));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Gestion de gastos");
        lblTitulo.setToolTipText("");
        jPanelCabecera.add(lblTitulo);

        lblSubtitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblSubtitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubtitulo.setText("Introduce los detalles de tus gastos");
        jPanelCabecera.add(lblSubtitulo);

        jPanelGeneral.add(jPanelCabecera, java.awt.BorderLayout.PAGE_START);

        jPanelCuerpo.setLayout(new java.awt.BorderLayout());

        jPanelBotones.setLayout(new java.awt.GridLayout(1, 0, 2, 0));

        javax.swing.GroupLayout jPanelOrdenacionIzqLayout = new javax.swing.GroupLayout(jPanelOrdenacionIzq);
        jPanelOrdenacionIzq.setLayout(jPanelOrdenacionIzqLayout);
        jPanelOrdenacionIzqLayout.setHorizontalGroup(
            jPanelOrdenacionIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 407, Short.MAX_VALUE)
        );
        jPanelOrdenacionIzqLayout.setVerticalGroup(
            jPanelOrdenacionIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanelBotones.add(jPanelOrdenacionIzq);

        jPanelOrdenacionDrch.setLayout(new java.awt.GridLayout(1, 2));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        javax.swing.GroupLayout jPanelBtnCancelarLayout = new javax.swing.GroupLayout(jPanelBtnCancelar);
        jPanelBtnCancelar.setLayout(jPanelBtnCancelarLayout);
        jPanelBtnCancelarLayout.setHorizontalGroup(
            jPanelBtnCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanelBtnCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelBtnCancelarLayout.createSequentialGroup()
                    .addGap(0, 61, Short.MAX_VALUE)
                    .addComponent(btnCancelar)
                    .addGap(0, 62, Short.MAX_VALUE)))
        );
        jPanelBtnCancelarLayout.setVerticalGroup(
            jPanelBtnCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(jPanelBtnCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelBtnCancelarLayout.createSequentialGroup()
                    .addGap(0, 36, Short.MAX_VALUE)
                    .addComponent(btnCancelar)
                    .addGap(0, 37, Short.MAX_VALUE)))
        );

        jPanelOrdenacionDrch.add(jPanelBtnCancelar);

        btnAceptar.setText("Aceptar");

        javax.swing.GroupLayout jPanelBtnAceptarLayout = new javax.swing.GroupLayout(jPanelBtnAceptar);
        jPanelBtnAceptar.setLayout(jPanelBtnAceptarLayout);
        jPanelBtnAceptarLayout.setHorizontalGroup(
            jPanelBtnAceptarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanelBtnAceptarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelBtnAceptarLayout.createSequentialGroup()
                    .addGap(0, 63, Short.MAX_VALUE)
                    .addComponent(btnAceptar)
                    .addGap(0, 64, Short.MAX_VALUE)))
        );
        jPanelBtnAceptarLayout.setVerticalGroup(
            jPanelBtnAceptarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(jPanelBtnAceptarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelBtnAceptarLayout.createSequentialGroup()
                    .addGap(0, 36, Short.MAX_VALUE)
                    .addComponent(btnAceptar)
                    .addGap(0, 37, Short.MAX_VALUE)))
        );

        jPanelOrdenacionDrch.add(jPanelBtnAceptar);

        jPanelBotones.add(jPanelOrdenacionDrch);

        jPanelCuerpo.add(jPanelBotones, java.awt.BorderLayout.PAGE_END);

        jPanelAddGastos.setLayout(new java.awt.GridLayout(1, 2));

        jPanelConceptos.setLayout(new java.awt.GridLayout(5, 1));

        lblConcepto.setText("Concepto:");

        javax.swing.GroupLayout jPanelConceptoLayout = new javax.swing.GroupLayout(jPanelConcepto);
        jPanelConcepto.setLayout(jPanelConceptoLayout);
        jPanelConceptoLayout.setHorizontalGroup(
            jPanelConceptoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
            .addGroup(jPanelConceptoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelConceptoLayout.createSequentialGroup()
                    .addGap(0, 176, Short.MAX_VALUE)
                    .addComponent(lblConcepto)
                    .addGap(0, 177, Short.MAX_VALUE)))
        );
        jPanelConceptoLayout.setVerticalGroup(
            jPanelConceptoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
            .addGroup(jPanelConceptoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelConceptoLayout.createSequentialGroup()
                    .addGap(0, 37, Short.MAX_VALUE)
                    .addComponent(lblConcepto)
                    .addGap(0, 37, Short.MAX_VALUE)))
        );

        jPanelConceptos.add(jPanelConcepto);

        lblImporte.setText("Importe");

        javax.swing.GroupLayout jPanelImporteLayout = new javax.swing.GroupLayout(jPanelImporte);
        jPanelImporte.setLayout(jPanelImporteLayout);
        jPanelImporteLayout.setHorizontalGroup(
            jPanelImporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
            .addGroup(jPanelImporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelImporteLayout.createSequentialGroup()
                    .addGap(0, 183, Short.MAX_VALUE)
                    .addComponent(lblImporte)
                    .addGap(0, 183, Short.MAX_VALUE)))
        );
        jPanelImporteLayout.setVerticalGroup(
            jPanelImporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
            .addGroup(jPanelImporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelImporteLayout.createSequentialGroup()
                    .addGap(0, 37, Short.MAX_VALUE)
                    .addComponent(lblImporte)
                    .addGap(0, 37, Short.MAX_VALUE)))
        );

        jPanelConceptos.add(jPanelImporte);

        lblCategoria.setText("Categoria");

        javax.swing.GroupLayout jPanelCategoriaLayout = new javax.swing.GroupLayout(jPanelCategoria);
        jPanelCategoria.setLayout(jPanelCategoriaLayout);
        jPanelCategoriaLayout.setHorizontalGroup(
            jPanelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
            .addGroup(jPanelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelCategoriaLayout.createSequentialGroup()
                    .addGap(0, 178, Short.MAX_VALUE)
                    .addComponent(lblCategoria)
                    .addGap(0, 179, Short.MAX_VALUE)))
        );
        jPanelCategoriaLayout.setVerticalGroup(
            jPanelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
            .addGroup(jPanelCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelCategoriaLayout.createSequentialGroup()
                    .addGap(0, 37, Short.MAX_VALUE)
                    .addComponent(lblCategoria)
                    .addGap(0, 37, Short.MAX_VALUE)))
        );

        jPanelConceptos.add(jPanelCategoria);

        Fecha.setText("Fecha");

        javax.swing.GroupLayout jPanelFechaLayout = new javax.swing.GroupLayout(jPanelFecha);
        jPanelFecha.setLayout(jPanelFechaLayout);
        jPanelFechaLayout.setHorizontalGroup(
            jPanelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
            .addGroup(jPanelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelFechaLayout.createSequentialGroup()
                    .addGap(0, 188, Short.MAX_VALUE)
                    .addComponent(Fecha)
                    .addGap(0, 189, Short.MAX_VALUE)))
        );
        jPanelFechaLayout.setVerticalGroup(
            jPanelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
            .addGroup(jPanelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelFechaLayout.createSequentialGroup()
                    .addGap(0, 37, Short.MAX_VALUE)
                    .addComponent(Fecha)
                    .addGap(0, 37, Short.MAX_VALUE)))
        );

        jPanelConceptos.add(jPanelFecha);

        lblNotas.setText("Notas Adicionales");

        javax.swing.GroupLayout jPanelNotasLayout = new javax.swing.GroupLayout(jPanelNotas);
        jPanelNotas.setLayout(jPanelNotasLayout);
        jPanelNotasLayout.setHorizontalGroup(
            jPanelNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
            .addGroup(jPanelNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelNotasLayout.createSequentialGroup()
                    .addGap(0, 156, Short.MAX_VALUE)
                    .addComponent(lblNotas)
                    .addGap(0, 157, Short.MAX_VALUE)))
        );
        jPanelNotasLayout.setVerticalGroup(
            jPanelNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
            .addGroup(jPanelNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelNotasLayout.createSequentialGroup()
                    .addGap(0, 37, Short.MAX_VALUE)
                    .addComponent(lblNotas)
                    .addGap(0, 37, Short.MAX_VALUE)))
        );

        jPanelConceptos.add(jPanelNotas);

        jPanelAddGastos.add(jPanelConceptos);

        jPanelInsertar.setLayout(new java.awt.GridLayout(5, 1));

        jTextField1.setText("Motivo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                    .addGap(144, 144, 144)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(jTextField1)
                    .addGap(32, 32, 32)))
        );

        jPanelInsertar.add(jPanel1);

        jTextField2.setText("Cantidad");
        jTextField2.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                    .addGap(144, 144, 144)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(jTextField2)
                    .addGap(32, 32, 32)))
        );

        jPanelInsertar.add(jPanel2);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alquiler/Hipoteca", "Agua", "Electricidad", "Telefono", "Plataformas Streaming", "Otros" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, 0, 150, Short.MAX_VALUE)
                .addGap(252, 252, 252))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jComboBox1)
                .addGap(29, 29, 29))
        );

        jPanelInsertar.add(jPanel4);

        jPanel5.setLayout(new java.awt.GridLayout(1, 6));

        jLabelDia.setText("Dia");

        javax.swing.GroupLayout jPanelLblDiaLayout = new javax.swing.GroupLayout(jPanelLblDia);
        jPanelLblDia.setLayout(jPanelLblDiaLayout);
        jPanelLblDiaLayout.setHorizontalGroup(
            jPanelLblDiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 68, Short.MAX_VALUE)
            .addGroup(jPanelLblDiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelLblDiaLayout.createSequentialGroup()
                    .addGap(0, 25, Short.MAX_VALUE)
                    .addComponent(jLabelDia)
                    .addGap(0, 26, Short.MAX_VALUE)))
        );
        jPanelLblDiaLayout.setVerticalGroup(
            jPanelLblDiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
            .addGroup(jPanelLblDiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelLblDiaLayout.createSequentialGroup()
                    .addGap(0, 37, Short.MAX_VALUE)
                    .addComponent(jLabelDia)
                    .addGap(0, 37, Short.MAX_VALUE)))
        );

        jPanel5.add(jPanelLblDia);

        javax.swing.GroupLayout jPanelSpinnerDiaLayout = new javax.swing.GroupLayout(jPanelSpinnerDia);
        jPanelSpinnerDia.setLayout(jPanelSpinnerDiaLayout);
        jPanelSpinnerDiaLayout.setHorizontalGroup(
            jPanelSpinnerDiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 68, Short.MAX_VALUE)
            .addGroup(jPanelSpinnerDiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelSpinnerDiaLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(SpinnerDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanelSpinnerDiaLayout.setVerticalGroup(
            jPanelSpinnerDiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
            .addGroup(jPanelSpinnerDiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelSpinnerDiaLayout.createSequentialGroup()
                    .addGap(0, 32, Short.MAX_VALUE)
                    .addComponent(SpinnerDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 32, Short.MAX_VALUE)))
        );

        jPanel5.add(jPanelSpinnerDia);

        lblMes.setText("Mes");

        javax.swing.GroupLayout jPanelLblMesLayout = new javax.swing.GroupLayout(jPanelLblMes);
        jPanelLblMes.setLayout(jPanelLblMesLayout);
        jPanelLblMesLayout.setHorizontalGroup(
            jPanelLblMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 68, Short.MAX_VALUE)
            .addGroup(jPanelLblMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelLblMesLayout.createSequentialGroup()
                    .addGap(0, 23, Short.MAX_VALUE)
                    .addComponent(lblMes)
                    .addGap(0, 23, Short.MAX_VALUE)))
        );
        jPanelLblMesLayout.setVerticalGroup(
            jPanelLblMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
            .addGroup(jPanelLblMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelLblMesLayout.createSequentialGroup()
                    .addGap(0, 37, Short.MAX_VALUE)
                    .addComponent(lblMes)
                    .addGap(0, 37, Short.MAX_VALUE)))
        );

        jPanel5.add(jPanelLblMes);

        javax.swing.GroupLayout jPanelSpinnerMesLayout = new javax.swing.GroupLayout(jPanelSpinnerMes);
        jPanelSpinnerMes.setLayout(jPanelSpinnerMesLayout);
        jPanelSpinnerMesLayout.setHorizontalGroup(
            jPanelSpinnerMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 68, Short.MAX_VALUE)
            .addGroup(jPanelSpinnerMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelSpinnerMesLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(SpinnerMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanelSpinnerMesLayout.setVerticalGroup(
            jPanelSpinnerMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
            .addGroup(jPanelSpinnerMesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelSpinnerMesLayout.createSequentialGroup()
                    .addGap(0, 32, Short.MAX_VALUE)
                    .addComponent(SpinnerMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 32, Short.MAX_VALUE)))
        );

        jPanel5.add(jPanelSpinnerMes);

        LblAnio.setText("Año");

        javax.swing.GroupLayout jPanelLblAnioLayout = new javax.swing.GroupLayout(jPanelLblAnio);
        jPanelLblAnio.setLayout(jPanelLblAnioLayout);
        jPanelLblAnioLayout.setHorizontalGroup(
            jPanelLblAnioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 68, Short.MAX_VALUE)
            .addGroup(jPanelLblAnioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelLblAnioLayout.createSequentialGroup()
                    .addGap(0, 23, Short.MAX_VALUE)
                    .addComponent(LblAnio)
                    .addGap(0, 23, Short.MAX_VALUE)))
        );
        jPanelLblAnioLayout.setVerticalGroup(
            jPanelLblAnioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
            .addGroup(jPanelLblAnioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelLblAnioLayout.createSequentialGroup()
                    .addGap(0, 37, Short.MAX_VALUE)
                    .addComponent(LblAnio)
                    .addGap(0, 37, Short.MAX_VALUE)))
        );

        jPanel5.add(jPanelLblAnio);

        javax.swing.GroupLayout jPanelAnioLayout = new javax.swing.GroupLayout(jPanelAnio);
        jPanelAnio.setLayout(jPanelAnioLayout);
        jPanelAnioLayout.setHorizontalGroup(
            jPanelAnioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 68, Short.MAX_VALUE)
            .addGroup(jPanelAnioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelAnioLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(SpinnerAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanelAnioLayout.setVerticalGroup(
            jPanelAnioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
            .addGroup(jPanelAnioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelAnioLayout.createSequentialGroup()
                    .addGap(0, 32, Short.MAX_VALUE)
                    .addComponent(SpinnerAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 32, Short.MAX_VALUE)))
        );

        jPanel5.add(jPanelAnio);

        jPanelInsertar.add(jPanel5);

        jPanelTextArea.setLayout(new java.awt.GridLayout());

        TextAreaNotasAdd.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        NotasAdd.setColumns(20);
        NotasAdd.setRows(5);
        TextAreaNotasAdd.setViewportView(NotasAdd);

        jPanelTextArea.add(TextAreaNotasAdd);

        jPanelInsertar.add(jPanelTextArea);

        jPanelAddGastos.add(jPanelInsertar);

        jPanelCuerpo.add(jPanelAddGastos, java.awt.BorderLayout.CENTER);

        jPanelGeneral.add(jPanelCuerpo, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 816, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanelGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 646, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanelGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new InterfazGastos().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fecha;
    private javax.swing.JLabel LblAnio;
    private javax.swing.JTextArea NotasAdd;
    private javax.swing.JSpinner SpinnerAnio;
    private javax.swing.JSpinner SpinnerDia;
    private javax.swing.JSpinner SpinnerMes;
    private javax.swing.JScrollPane TextAreaNotasAdd;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabelDia;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelAddGastos;
    private javax.swing.JPanel jPanelAnio;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JPanel jPanelBtnAceptar;
    private javax.swing.JPanel jPanelBtnCancelar;
    private javax.swing.JPanel jPanelCabecera;
    private javax.swing.JPanel jPanelCategoria;
    private javax.swing.JPanel jPanelConcepto;
    private javax.swing.JPanel jPanelConceptos;
    private javax.swing.JPanel jPanelCuerpo;
    private javax.swing.JPanel jPanelFecha;
    private javax.swing.JPanel jPanelGeneral;
    private javax.swing.JPanel jPanelImporte;
    private javax.swing.JPanel jPanelInsertar;
    private javax.swing.JPanel jPanelLblAnio;
    private javax.swing.JPanel jPanelLblDia;
    private javax.swing.JPanel jPanelLblMes;
    private javax.swing.JPanel jPanelNotas;
    private javax.swing.JPanel jPanelOrdenacionDrch;
    private javax.swing.JPanel jPanelOrdenacionIzq;
    private javax.swing.JPanel jPanelSpinnerDia;
    private javax.swing.JPanel jPanelSpinnerMes;
    private javax.swing.JPanel jPanelTextArea;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblConcepto;
    private javax.swing.JLabel lblImporte;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblNotas;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
