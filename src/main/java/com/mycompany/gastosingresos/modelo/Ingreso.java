package com.mycompany.gastosingresos.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Ingreso {

	private static int contador = 1;
	private int id;
	private String concepto;
	private BigDecimal importe;
	private String categoria;
	private LocalDate fecha;
	private String notas;

	public Ingreso(String concepto, BigDecimal importe, String categoria,
			LocalDate fecha, String notas) {
		this.id = contador++;
		this.concepto = concepto;
		this.importe = importe;
		this.categoria = categoria;
		this.fecha = fecha;
		this.notas = notas;
	}

	public Ingreso(String concepto, BigDecimal importe,
			String categoria, LocalDate fecha) {
		this(concepto, importe, categoria, fecha, "");
	}

	public int getId() {
		return id;
	}

	public String getConcepto() {
		return concepto;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public String getCategoria() {
		return categoria;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public String getNotas() {
		return notas;
	}
    
}
