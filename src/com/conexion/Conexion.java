package com.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
	private Connection conexion;
	
	public Connection getConexion() {
		return conexion;
	}
	
	public void setConexion(Connection con) {
		this.conexion = con;
	}
	
	
	public void conectar() throws Exception {
		
		try {
			conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/hotel_alura?TimeZone=true&serverTimeZone=UTC",
					"root",
					"admin"
					);
			System.out.println("Conectado a la Base de Datos");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void desconectar() throws Exception {
		
		try {
			if(conexion.isClosed() == false) {
				conexion.close();
				System.out.println("desconectado de la Base de Datos");
			}			
		} catch (Exception e) {
			throw e;
		}
	}

}
