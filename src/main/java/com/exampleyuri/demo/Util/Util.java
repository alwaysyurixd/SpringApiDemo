package com.exampleyuri.demo.Util;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.exampleyuri.demo.Model.*;

public class Util {

	public static double[] obtenerListaEdad(List<Client> listaClientes) {

		double[] listaEdades = new double[listaClientes.size()];
		int i = 0;
		for (Client cliente : listaClientes) {
			double val = Double.valueOf(cliente.getEdad());
			listaEdades[i++] = val;
		}

		System.out.println(listaEdades.length);

		return listaEdades;
	}

	public static double calcularPromedio(double numArray[]) {
		double suma = 0.0;
		double promedio = 0.0;

		for (double num : numArray) {
			suma += num;
		}

		promedio = suma / numArray.length;

		return promedio;
	}

	public static double calcularDesviacionEstandar(double numArray[]) {
		double desviacionEstandar = 0.0;
		double promedio = Util.calcularPromedio(numArray);

		for (double num : numArray) {
			desviacionEstandar += Math.pow(num - promedio, 2);
		}

		return Math.sqrt(desviacionEstandar / numArray.length);
	}

	public static Date calcularFechaDeceso(Client cliente) {
		// Date fechaNacimiento = cliente.getFechaNacimiento();
		Double anhosRestante = (Constants.ESPERANZA_VIDA_PERU - cliente.getEdad());
		System.out.println("anhos restantes"+anhosRestante);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.YEAR, anhosRestante.intValue());
		
		return calendar.getTime();

	}

}