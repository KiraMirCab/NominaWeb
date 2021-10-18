package model;

import exceptions.DatosNoCorrectosException;

public class Empleado {
	private String dni;
	private String nombre;
	private char sexo;
	private int categoria;
	public int anyos;
	
	public Empleado(String dni, String nombre, char sexo, int categoria, int anyos) throws DatosNoCorrectosException {
		this.dni = dni;
		this.nombre = nombre;
		this.sexo = sexo;
		
		if (categoria >=1 && categoria <=10) {
			this.categoria = categoria;
		} else {
			throw new DatosNoCorrectosException("la categría debe estar entre 1 y 10");
		}
		
		if (anyos >= 0) {
			this.anyos = anyos;
		} else {
			throw new DatosNoCorrectosException("la categría debe estar entre 1 y 10");
		}		
	}
	
	
	public Empleado() {
		// TODO Auto-generated constructor stub
	}


	public String getDni() {
		return dni;
	}



	public void setDni(String dni) {
		this.dni = dni;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public char getSexo() {
		return sexo;
	}



	public void setSexo(char sexo) {
		this.sexo = sexo;
	}



	public int getAnyos() {
		return anyos;
	}



	public void setAnyos(int anyos) {
		this.anyos = anyos;
	}



	public int getCategoria() {
		return categoria;
	}



	public void setCategoria(int categoria) throws DatosNoCorrectosException {
		if (categoria >=1 && categoria <=10) {
			this.categoria = categoria;
		} else {
			throw new DatosNoCorrectosException("la categría debe estar entre 1 y 10");
		}	
	}
	
	//este método incrementa el valor de anyos en 1:
	public void incrAnyo() {	
		this.anyos++;
	}

	public String toString() {
		return dni + ", " + nombre + ", " + sexo + ", " + categoria + ", " + anyos;
	}
}
