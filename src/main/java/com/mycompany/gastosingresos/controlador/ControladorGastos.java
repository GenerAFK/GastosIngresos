package com.mycompany.gastosingresos.controlador;

import com.mycompany.gastosingresos.modelo.Gasto;
import java.math.BigDecimal;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

public class ControladorGastos {

    private List<Gasto> gastos;

    public ControladorGastos() {
        this.gastos = new ArrayList<>();
    }

    public List<Gasto> getGastos() {
        return gastos;
    }
    
    
    // metodo mejorado por IA el mio, no tenia validacion de datos y tampoco sabia como incluir la fecha
    public Gasto addGasto(String concepto, BigDecimal importe,
            String categoria, LocalDate fecha, String notas) {

        if (concepto == null || concepto.isBlank()) {
            throw new IllegalArgumentException("El concepto es obligatorio.");
        }
        if (importe == null || importe.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El importe debe ser mayor que 0.");
        }
        if (categoria == null || categoria.isBlank()) {
            throw new IllegalArgumentException("La categoría es obligatoria.");
        }
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha es obligatoria.");
        }

        Gasto gasto;
        if (notas == null || notas.isBlank()) {
            gasto = new Gasto(concepto.trim(), importe, categoria.trim(), fecha);
        } else {
            gasto = new Gasto(concepto.trim(), importe, categoria.trim(), fecha, notas.trim());
        }
        gastos.add(gasto);
        return gasto;
    }

    public Gasto addGasto(String concepto, BigDecimal importe,
            String categoria, LocalDate fecha) {
        return addGasto(concepto, importe, categoria, fecha, "");
    }
}
