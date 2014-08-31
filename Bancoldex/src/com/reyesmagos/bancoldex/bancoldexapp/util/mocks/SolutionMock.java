package com.reyesmagos.bancoldex.bancoldexapp.util.mocks;

import java.util.ArrayList;
import java.util.List;

public class SolutionMock {

	List<String> arraySolutions;

	public SolutionMock() {

	}

	public void setArraySolutions() {
		arraySolutions = new ArrayList<String>();
		arraySolutions
				.add("Generar recursos para capital de trabajo descontando directamente con Bancóldex, las facturas de venta o letras originadas en sus operaciones comerciales en Colombia o en el exterior a través del producto Liquidex.");
		arraySolutions
				.add("Solicitar a través de un intermediario financiero, un crédito con recursos de Bancóldex bajo una línea para capital de trabajo ya sea en pesos o en dólares, a corto, mediano o largo plazo.");
		arraySolutions
				.add("Vender a un intermediario financiero, mediante una operación de Leaseback, uno o varios activos productivos de su empresa, manteniendo su tenencia en calidad de arrendatario, con pacto de recompra.");
		arraySolutions
				.add("Solicitar a través de un intermediario financiero un crédito con recursos Bancóldex, bajo una línea para consolidación de pasivos");
		
	}
	
	public List<String> getArraySolutions() {
		setArraySolutions();
		return arraySolutions;
	}
}
