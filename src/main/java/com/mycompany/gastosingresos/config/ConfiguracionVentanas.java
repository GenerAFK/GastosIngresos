package com.mycompany.gastosingresos.config;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class ConfiguracionVentanas {
    
    public static void aplicarIcono(JFrame ventana) {

    ImageIcon icono = new ImageIcon(
        ConfiguracionVentanas.class.getResource(
            "/imagenes/logo.png"
        )
    );

    ventana.setIconImage(icono.getImage());
}
    
}
