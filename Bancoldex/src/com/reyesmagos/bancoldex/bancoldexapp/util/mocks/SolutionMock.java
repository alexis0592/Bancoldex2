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
				.add("Generar recursos para capital de trabajo descontando directamente con Banc�ldex, las facturas de venta o letras originadas en sus operaciones comerciales en Colombia o en el exterior a trav�s del producto Liquidex.");
		arraySolutions
				.add("Solicitar a trav�s de un intermediario financiero, un cr�dito con recursos de Banc�ldex bajo una l�nea para capital de trabajo ya sea en pesos o en d�lares, a corto, mediano o largo plazo.");
		arraySolutions
				.add("Vender a un intermediario financiero, mediante una operaci�n de Leaseback, uno o varios activos productivos de su empresa, manteniendo su tenencia en calidad de arrendatario, con pacto de recompra.");
		arraySolutions
				.add("Solicitar a trav�s de un intermediario financiero un cr�dito con recursos Banc�ldex, bajo una l�nea para consolidaci�n de pasivos");
		
	}
	
	public List<String> getArraySolutions() {
		setArraySolutions();
		return arraySolutions;
	}
}
