package model;

public class Nomina {
	private static final int SUELDO_BASE[] = {50000, 70000, 90000, 110000, 130000,
			150000, 170000, 190000, 210000, 230000};
	
	/**
	 * Calcula el sueldo de un empleado
	 * @param emp
	 * @return salario
	 */
	public static int sueldo(Empleado emp) {
		int sueldoBase = SUELDO_BASE[emp.getCategoria()-1]; //extraemos del array el sueldo correspondiente a la categoría del empleado
		return sueldoBase + 5000 * emp.anyos;
	}
}
