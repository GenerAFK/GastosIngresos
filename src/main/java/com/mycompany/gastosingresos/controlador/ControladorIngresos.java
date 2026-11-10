package com.mycompany.gastosingresos.controlador;

import com.mycompany.gastosingresos.modelo.Ingreso;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControladorIngresos {

	private List<Ingreso> ingresos;

	public ControladorIngresos() {
		this.ingresos = new ArrayList<>();
	}

	public List<Ingreso> getIngresos() {
		return ingresos;
	}

	public Ingreso addIngreso(String concepto, BigDecimal importe,
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

		Ingreso ingreso;
		if (notas == null || notas.isBlank()) {
			ingreso = new Ingreso(concepto.trim(), importe, categoria.trim(), fecha);
		} else {
			ingreso = new Ingreso(concepto.trim(), importe, categoria.trim(), fecha, notas.trim());
		}
		ingresos.add(ingreso);
		return ingreso;
	}

	public Ingreso addIngreso(String concepto, BigDecimal importe,
			String categoria, LocalDate fecha) {
		return addIngreso(concepto, importe, categoria, fecha, "");
	}
}
