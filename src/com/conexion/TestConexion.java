package com.conexion;

public class TestConexion {

	public static void main(String[] args) {
		Conexion conexion = new Conexion();
		
		try {
			conexion.conectar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try {
			conexion.desconectar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
