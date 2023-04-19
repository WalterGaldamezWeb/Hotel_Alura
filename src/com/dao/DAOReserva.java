package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.conexion.Conexion;
import com.modelo.Reserva;

public class DAOReserva extends Conexion{
	
	public List<Reserva> mostrarReserva() throws Exception {
		
		ResultSet resultado;
		List<Reserva> listaReserva = new ArrayList<Reserva>();
		
		try {
			
			this.conectar();
			String sql = "SELECT * FROM reservas";
			PreparedStatement pst = this.getConexion().prepareStatement(sql);
			resultado = pst.executeQuery();
			
			while(resultado.next()) {
				
				Reserva reserva = new Reserva();
				
				reserva.setId(resultado.getInt("id"));
				reserva.setFecha_entrada(resultado.getDate("fecha_entrada"));
				reserva.setFecha_salida(resultado.getDate("fecha_salida"));
				reserva.setValor(resultado.getDouble("valor"));
				reserva.setForma_pago(resultado.getString("forma_pago"));
				
				listaReserva.add(reserva);
			}
			
		} catch (Exception e) {
			
			throw e;
			
		}finally {
			this.desconectar();
		}		
		
		return listaReserva;
	}// fin mostrarReserva()
	
	
	
	public void crearReserva(Reserva reserva) throws Exception {
		
		try {
			
			this.conectar();
			String sql = "INSERT INTO reservas (?,?,?,?)";
			PreparedStatement preparedStatement = this.getConexion().prepareStatement(sql);
			
			preparedStatement.setDate(1, java.sql.Date.valueOf(reserva.getFecha_entrada().toString()));
			preparedStatement.setDate(2, java.sql.Date.valueOf(reserva.getFecha_salida().toString()));
			preparedStatement.setDouble(3, reserva.getValor());
			preparedStatement.setString(4, reserva.getForma_pago());
			
			preparedStatement.executeUpdate();
			
			
		} catch (Exception e) {
			throw e;
		}finally {
			
			this.desconectar();
			
		}
		
	}
	
	
	
	
	
	
	
}
