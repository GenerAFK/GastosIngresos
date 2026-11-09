
package com.mycompany.gastosingresos.vista;

import com.mycompany.gastosingresos.config.ConfiguracionVentanas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
import javax.swing.plaf.basic.BasicTextFieldUI;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Abrah
 */
public class InterfazIngresos extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(InterfazIngresos.class.getName());

    /**
     * Creates new form InterfazIngresos
     */
    public InterfazIngresos() {
        initComponents();

        ConfiguracionVentanas.aplicarIcono(this);

        lblIcon.setIcon(
                redimensionarIcono("/imagenes/icono_ingresos.png", 65, 65)
        );

        aplicarEstilosIngresos();

        setSize(850, 700);
        setLocationRelativeTo(null);
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

    // =================================================================
    // ESTILOS (misma línea que InterfazBienvenida / InterfazGastos, en verde)
    // Todo esto va FUERA de initComponents() para que NetBeans no lo borre.
    // =================================================================
    private static final Color FONDO = new Color(245, 247, 250);
    private static final Color BLANCO = Color.WHITE;
    private static final Color TEXTO = new Color(31, 41, 55);
    private static final Color SECUNDARIO = new Color(107, 114, 128);
    private static final Color BORDE = new Color(225, 230, 237);

    private static final Color VERDE = new Color(25, 135, 84);
    private static final Color VERDE_OSCURO = new Color(18, 100, 62);
    private static final Color VERDE_CLARO = new Color(232, 246, 238);
    private static final Color VERDE_BORDE = new Color(190, 224, 205);

    private static final int TAM_ICONO = 72;

    private void aplicarEstilosIngresos() {

        // ---------- FONDOS GENERALES ----------
        getContentPane().setBackground(FONDO);
        pnlCentral.setBackground(FONDO);
        pnlCentral.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // ---------- CABECERA VERDE CON ICONO ----------
        // Se recompone la cabecera: icono | título + subtítulo | hueco simétrico
        pnlSuperior.removeAll();
        pnlSuperior.setLayout(new BorderLayout(15, 0));
        pnlSuperior.setBackground(VERDE);
        pnlSuperior.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(0, 0, 4, 0, VERDE_OSCURO),
                        BorderFactory.createEmptyBorder(10, 20, 10, 20)
                )
        );

        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 30));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        lblSubtitulo.setFont(new Font("SansSerif", Font.PLAIN, 15));
        lblSubtitulo.setForeground(new Color(220, 245, 230));
        lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel textos = new JPanel(new GridLayout(2, 1));
        textos.setOpaque(false);
        textos.add(lblTitulo);
        textos.add(lblSubtitulo);

        // Icono (dentro de un círculo) en el label lblIcon
        lblIcon.setText("");
        lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
        lblIcon.setPreferredSize(new Dimension(TAM_ICONO, TAM_ICONO));
        ImageIcon icono = crearIconoCircular("/imagenes/icono_cartera.png", TAM_ICONO);
        if (icono == null) {
            // Si aún no está la cartera, usa el icono de ingresos que ya tenías
            icono = crearIconoCircular("/imagenes/icono_ingresos.png", TAM_ICONO);
        }
        if (icono != null) {
            lblIcon.setIcon(icono);
        }

        // Hueco del mismo tamaño que el icono para que el título quede centrado
        JPanel espejo = new JPanel();
        espejo.setOpaque(false);
        espejo.setPreferredSize(new Dimension(TAM_ICONO, TAM_ICONO));

        pnlSuperior.add(lblIcon, BorderLayout.WEST);
        pnlSuperior.add(textos, BorderLayout.CENTER);
        pnlSuperior.add(espejo, BorderLayout.EAST);

        // ---------- COLUMNA DE ETIQUETAS (tinte verde, con separadores) ----------
        pnlLabels.setBackground(VERDE_CLARO);
        pnlLabels.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, VERDE_BORDE));

        lblConcepto.setText("Concepto");
        lblbImporte.setText("Importe (€)");
        lblCategoria.setText("Categoría");
        lblFecha.setText("Fecha");
        lblNotas.setText("Notas adicionales");

        estilizarEtiqueta(lblConcepto, true);
        estilizarEtiqueta(lblbImporte, true);
        estilizarEtiqueta(lblCategoria, true);
        estilizarEtiqueta(lblFecha, true);
        estilizarEtiqueta(lblNotas, false);   // la última no lleva línea

        // ---------- COLUMNA DE CAMPOS (blanca, con separadores) ----------
        pnlDatosIngresos.setBackground(BLANCO);
        pnlDatosIngresos.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, BORDE));

        configurarFilaCampo(pnlConcepto, txtfConcepto, true);
        configurarFilaCampo(pnlImport, spinImporte, true);
        configurarFilaCampo(pnlCategoria, comboxCategoria, true);
        configurarFilaCampo(pnlFecha, pnlControlFecha, true);
        configurarFilaCampo(pnlNotasAd, jScrollPane1, false);

        // Campo de concepto con placeholder
        estilizarCampoTexto(txtfConcepto);
        configurarPlaceholder(txtfConcepto, "Motivo del ingreso");

        // Importe: formato de dinero (el editor se cambia ANTES de estilizar)
        spinImporte.setEditor(new JSpinner.NumberEditor(spinImporte, "#,##0.00"));
        estilizarSpinner(spinImporte, 0);

        // Combo
        estilizarCombo(comboxCategoria);

        // Fecha
        pnlControlFecha.setBackground(BLANCO);
        pnlControlFecha.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        JLabel[] etiquetasFecha = {lblDia, lblMes, lblAnio};
        for (JLabel l : etiquetasFecha) {
            l.setFont(new Font("SansSerif", Font.BOLD, 12));
            l.setForeground(VERDE_OSCURO);
        }
        estilizarSpinner(spinDia, 70);
        estilizarSpinner(spinMes, 70);
        estilizarSpinner(spinAnio, 90);

        // Área de notas
        txtAreaNotas.setFont(new Font("SansSerif", Font.PLAIN, 13));
        txtAreaNotas.setForeground(TEXTO);
        txtAreaNotas.setBackground(BLANCO);
        txtAreaNotas.setLineWrap(true);
        txtAreaNotas.setWrapStyleWord(true);
        txtAreaNotas.setMargin(new Insets(8, 10, 8, 10));
        txtAreaNotas.setCaretColor(VERDE);
        txtAreaNotas.setSelectionColor(VERDE_BORDE);
        txtAreaNotas.setSelectedTextColor(TEXTO);

        jScrollPane1.setBorder(BorderFactory.createLineBorder(BORDE, 1));
        jScrollPane1.getViewport().setBackground(BLANCO);
        estilizarScrollBar(jScrollPane1);

        txtAreaNotas.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                jScrollPane1.setBorder(BorderFactory.createLineBorder(VERDE, 2));
            }

            @Override
            public void focusLost(FocusEvent e) {
                jScrollPane1.setBorder(BorderFactory.createLineBorder(BORDE, 1));
            }
        });

        // ---------- PIE CON BOTONES ----------
        pnlInferior.setBackground(BLANCO);
        pnlInferior.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(1, 0, 0, 0, BORDE),
                        BorderFactory.createEmptyBorder(10, 15, 10, 15)
                )
        );

        btnGuardar.setText("Guardar ingreso");
        btnCancelar.setText("Cancelar");
        estilizarBoton(btnGuardar, true);    // relleno verde
        estilizarBoton(btnCancelar, false);  // contorno verde

        btnCancelar.addActionListener(e -> dispose());
    }

    // -----------------------------------------------------------------
    // HELPERS
    // -----------------------------------------------------------------
    /**
     * Crea un icono redondo: círculo blanco con un aro verde suave y el logo
     * centrado dentro, para que resalte sobre el fondo verde de la cabecera.
     * Devuelve null (y avisa en el log) si no encuentra la imagen.
     */
    private ImageIcon crearIconoCircular(String ruta, int diametro) {

        java.net.URL url = getClass().getResource(ruta);
        if (url == null) {
            logger.warning("No se encontró el icono: " + ruta);
            return null;
        }

        java.awt.image.BufferedImage logo;
        try {
            logo = javax.imageio.ImageIO.read(url);
        } catch (java.io.IOException ex) {
            logger.log(java.util.logging.Level.WARNING, "No se pudo leer el icono: " + ruta, ex);
            return null;
        }
        if (logo == null) {
            return null;
        }

        // Se dibuja al doble de tamaño y luego se reduce: bordes más suaves
        final int ESC = 2;
        int d = diametro * ESC;

        java.awt.image.BufferedImage grande
                = new java.awt.image.BufferedImage(d, d, java.awt.image.BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = grande.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        // Aro exterior y círculo blanco
        int aro = 3 * ESC;
        g.setColor(VERDE_BORDE);
        g.fillOval(0, 0, d, d);
        g.setColor(BLANCO);
        g.fillOval(aro, aro, d - 2 * aro, d - 2 * aro);

        // Logo centrado, ocupa el 68 % del círculo y conserva sus proporciones
        int maxLado = (int) (d * 0.68);
        double escala = Math.min(
                (double) maxLado / logo.getWidth(),
                (double) maxLado / logo.getHeight());
        int w = (int) Math.round(logo.getWidth() * escala);
        int h = (int) Math.round(logo.getHeight() * escala);
        g.drawImage(logo, (d - w) / 2, (d - h) / 2, w, h, null);
        g.dispose();

        // Reducción final al tamaño real
        java.awt.image.BufferedImage fin
                = new java.awt.image.BufferedImage(diametro, diametro, java.awt.image.BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = fin.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(grande, 0, 0, diametro, diametro, null);
        g2.dispose();

        return new ImageIcon(fin);
    }

    /**
     * Etiqueta de la columna izquierda: tinte verde y línea inferior opcional.
     */
    private void estilizarEtiqueta(JLabel etiqueta, boolean separador) {
        etiqueta.setFont(new Font("SansSerif", Font.BOLD, 14));
        etiqueta.setForeground(VERDE_OSCURO);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setOpaque(true);
        etiqueta.setBackground(VERDE_CLARO);
        etiqueta.setBorder(separador
                ? BorderFactory.createMatteBorder(0, 0, 1, 0, VERDE_BORDE)
                : BorderFactory.createEmptyBorder());
    }

    /**
     * Fila de la columna derecha (GridBagLayout con un solo campo): fondo
     * blanco, margen alrededor del campo y línea inferior opcional.
     */
    private void configurarFilaCampo(JPanel fila, Component campo, boolean separador) {

        fila.setBackground(BLANCO);
        fila.setBorder(separador
                ? BorderFactory.createMatteBorder(0, 0, 1, 0, BORDE)
                : BorderFactory.createEmptyBorder());

        GridBagLayout gbl = (GridBagLayout) fila.getLayout();
        GridBagConstraints cc = gbl.getConstraints(campo);
        cc.insets = new Insets(8, 14, 8, 14);
        gbl.setConstraints(campo, cc);
    }

    private void estilizarCampoTexto(JTextField campo) {
        campo.setFont(new Font("SansSerif", Font.PLAIN, 13));
        campo.setForeground(TEXTO);
        campo.setBackground(BLANCO);
        campo.setCaretColor(VERDE);
        campo.setSelectionColor(VERDE_BORDE);
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
                BorderFactory.createLineBorder(enfocado ? VERDE : BORDE, enfocado ? 2 : 1),
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

    /**
     * @param ancho ancho preferido del spinner (0 = dejar el de por defecto)
     */
    private void estilizarSpinner(JSpinner spinner, int ancho) {

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

        if (ancho > 0) {
            spinner.setPreferredSize(new Dimension(ancho, 28));
        }

        JComponent editor = spinner.getEditor();
        if (editor instanceof JSpinner.DefaultEditor) {
            JTextField tf = ((JSpinner.DefaultEditor) editor).getTextField();
            // Nimbus pinta su propio reborde grueso; con la UI básica desaparece
            tf.setUI(new BasicTextFieldUI());
            tf.setOpaque(true);
            editor.setOpaque(true);
            editor.setBackground(BLANCO);
            tf.setFont(new Font("SansSerif", Font.BOLD, 13));
            tf.setForeground(TEXTO);
            tf.setBackground(BLANCO);
            tf.setCaretColor(VERDE);
            tf.setSelectionColor(VERDE_BORDE);
            tf.setSelectedTextColor(TEXTO);
            tf.setHorizontalAlignment(SwingConstants.CENTER);
            tf.setBorder(BorderFactory.createEmptyBorder(3, 4, 3, 4));

            tf.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    spinner.setBorder(BorderFactory.createLineBorder(VERDE, 2));
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

                Color fondoBtn = VERDE_CLARO;
                if (pulsado) {
                    fondoBtn = VERDE;
                } else if (hover) {
                    fondoBtn = VERDE_BORDE;
                }
                g2.setColor(fondoBtn);
                g2.fillRect(0, 0, getWidth(), getHeight());

                g2.setColor(VERDE_BORDE);
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
                g2.setColor(pulsado ? Color.WHITE : VERDE_OSCURO);
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
     * Botón redondeado con hover/pressed. relleno = true -> fondo verde, texto
     * blanco; relleno = false -> fondo blanco, borde y texto verdes.
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
                    Color color = VERDE;
                    if (pressed) {
                        color = VERDE_OSCURO;
                    } else if (hover) {
                        color = VERDE.brighter();
                    }
                    g2.setColor(color);
                    g2.fillRoundRect(0, 0, b.getWidth(), b.getHeight(), 18, 18);
                } else {
                    Color fondoBtn = BLANCO;
                    if (pressed) {
                        fondoBtn = VERDE_BORDE;
                    } else if (hover) {
                        fondoBtn = VERDE_CLARO;
                    }
                    g2.setColor(fondoBtn);
                    g2.fillRoundRect(0, 0, b.getWidth(), b.getHeight(), 18, 18);

                    g2.setColor(VERDE);
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
        boton.setForeground(relleno ? Color.WHITE : VERDE);
        boton.setFont(new Font("SansSerif", Font.BOLD, 12));
        boton.setPreferredSize(new Dimension(150, 38));
        boton.setRolloverEnabled(true);
        boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    /**
     * Barra de scroll fina, sin flechas y con "pulgar" redondeado verde.
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
                thumbColor = VERDE_BORDE;
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

                Color color = VERDE_BORDE;
                if (isDragging) {
                    color = VERDE_OSCURO;
                } else if (isThumbRollover()) {
                    color = VERDE;
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
        java.awt.GridBagConstraints gridBagConstraints;

        pnlSuperior = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblSubtitulo = new javax.swing.JLabel();
        lblIcon = new javax.swing.JLabel();
        pnlCentral = new javax.swing.JPanel();
        pnlLabels = new javax.swing.JPanel();
        lblConcepto = new javax.swing.JLabel();
        lblbImporte = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblNotas = new javax.swing.JLabel();
        pnlDatosIngresos = new javax.swing.JPanel();
        pnlConcepto = new javax.swing.JPanel();
        txtfConcepto = new javax.swing.JTextField();
        pnlImport = new javax.swing.JPanel();
        spinImporte = new javax.swing.JSpinner();
        pnlCategoria = new javax.swing.JPanel();
        comboxCategoria = new javax.swing.JComboBox<>();
        pnlFecha = new javax.swing.JPanel();
        pnlControlFecha = new javax.swing.JPanel();
        lblDia = new javax.swing.JLabel();
        spinDia = new javax.swing.JSpinner();
        lblMes = new javax.swing.JLabel();
        spinMes = new javax.swing.JSpinner();
        lblAnio = new javax.swing.JLabel();
        spinAnio = new javax.swing.JSpinner();
        pnlNotasAd = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaNotas = new javax.swing.JTextArea();
        pnlInferior = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlSuperior.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("NUEVO INGRESO FINANCIERO");

        lblSubtitulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSubtitulo.setForeground(new java.awt.Color(153, 153, 153));
        lblSubtitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubtitulo.setText("Introduce los detalles de la entrada monetaria");

        javax.swing.GroupLayout pnlSuperiorLayout = new javax.swing.GroupLayout(pnlSuperior);
        pnlSuperior.setLayout(pnlSuperiorLayout);
        pnlSuperiorLayout.setHorizontalGroup(
            pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSuperiorLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSubtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(189, Short.MAX_VALUE))
        );
        pnlSuperiorLayout.setVerticalGroup(
            pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSuperiorLayout.createSequentialGroup()
                .addGroup(pnlSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlSuperiorLayout.createSequentialGroup()
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSubtitulo))
                    .addGroup(pnlSuperiorLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lblIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        getContentPane().add(pnlSuperior, java.awt.BorderLayout.NORTH);

        pnlCentral.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));
        pnlCentral.setLayout(new java.awt.GridLayout(1, 2));

        pnlLabels.setLayout(new java.awt.GridLayout(5, 0));

        lblConcepto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblConcepto.setText("Concepto:");
        lblConcepto.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlLabels.add(lblConcepto);

        lblbImporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblbImporte.setText("Importe:");
        lblbImporte.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlLabels.add(lblbImporte);

        lblCategoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCategoria.setText("Categoría");
        lblCategoria.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlLabels.add(lblCategoria);

        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFecha.setText("Fecha:");
        lblFecha.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlLabels.add(lblFecha);

        lblNotas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNotas.setText("Notas Adicionales:");
        pnlLabels.add(lblNotas);

        pnlCentral.add(pnlLabels);

        pnlDatosIngresos.setLayout(new java.awt.GridLayout(5, 0));

        pnlConcepto.setLayout(new java.awt.GridBagLayout());

        txtfConcepto.setToolTipText("");
        txtfConcepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfConceptoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        pnlConcepto.add(txtfConcepto, gridBagConstraints);

        pnlDatosIngresos.add(pnlConcepto);

        pnlImport.setLayout(new java.awt.GridBagLayout());

        spinImporte.setModel(new javax.swing.SpinnerNumberModel(0.0f, 0.0f, null, 1.0f));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        pnlImport.add(spinImporte, gridBagConstraints);

        pnlDatosIngresos.add(pnlImport);

        pnlCategoria.setLayout(new java.awt.GridBagLayout());

        comboxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nómina", "Horas Extras", "Propinas", "Otros" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        pnlCategoria.add(comboxCategoria, gridBagConstraints);

        pnlDatosIngresos.add(pnlCategoria);

        pnlFecha.setLayout(new java.awt.GridBagLayout());

        pnlControlFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlControlFecha.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        lblDia.setText("Día:");
        pnlControlFecha.add(lblDia);

        spinDia.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));
        pnlControlFecha.add(spinDia);

        lblMes.setText("Mes:");
        pnlControlFecha.add(lblMes);

        spinMes.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        pnlControlFecha.add(spinMes);

        lblAnio.setText("Año:");
        pnlControlFecha.add(lblAnio);

        spinAnio.setModel(new javax.swing.SpinnerNumberModel(2026, 2026, null, 1));
        pnlControlFecha.add(spinAnio);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        pnlFecha.add(pnlControlFecha, gridBagConstraints);

        pnlDatosIngresos.add(pnlFecha);

        pnlNotasAd.setLayout(new java.awt.GridBagLayout());

        txtAreaNotas.setColumns(20);
        txtAreaNotas.setRows(5);
        jScrollPane1.setViewportView(txtAreaNotas);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        pnlNotasAd.add(jScrollPane1, gridBagConstraints);

        pnlDatosIngresos.add(pnlNotasAd);

        pnlCentral.add(pnlDatosIngresos);

        getContentPane().add(pnlCentral, java.awt.BorderLayout.CENTER);

        pnlInferior.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        pnlInferior.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlInferior.add(btnCancelar);

        btnGuardar.setText("Guardar");
        pnlInferior.add(btnGuardar);

        getContentPane().add(pnlInferior, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void txtfConceptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfConceptoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfConceptoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        
        InterfazBienvenida bienvenida = new InterfazBienvenida();

        bienvenida.setSize(getSize());
        bienvenida.setLocationRelativeTo(null);
        bienvenida.setVisible(true);

        dispose();
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
        java.awt.EventQueue.invokeLater(() -> new InterfazIngresos().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> comboxCategoria;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnio;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblConcepto;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblNotas;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblbImporte;
    private javax.swing.JPanel pnlCategoria;
    private javax.swing.JPanel pnlCentral;
    private javax.swing.JPanel pnlConcepto;
    private javax.swing.JPanel pnlControlFecha;
    private javax.swing.JPanel pnlDatosIngresos;
    private javax.swing.JPanel pnlFecha;
    private javax.swing.JPanel pnlImport;
    private javax.swing.JPanel pnlInferior;
    private javax.swing.JPanel pnlLabels;
    private javax.swing.JPanel pnlNotasAd;
    private javax.swing.JPanel pnlSuperior;
    private javax.swing.JSpinner spinAnio;
    private javax.swing.JSpinner spinDia;
    private javax.swing.JSpinner spinImporte;
    private javax.swing.JSpinner spinMes;
    private javax.swing.JTextArea txtAreaNotas;
    private javax.swing.JTextField txtfConcepto;
    // End of variables declaration//GEN-END:variables
}
