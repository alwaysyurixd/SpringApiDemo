package com.exampleyuri.demo.Util;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
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

	public static Date calcularFechaDeceso(Date fechaNacimiento) {
		LocalDate localdate = fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int añosCliente = Period.between(localdate, LocalDate.now()).getYears(); 
		Double anosRestante = (Constants.ESPERANZA_VIDA_PERU - añosCliente);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.YEAR, anosRestante.intValue());
		
		return calendar.getTime();

	}

}