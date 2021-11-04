package com.prueba.auth.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Usuarios")
public class Login {

	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private String LOGIN;
	@Column(name="USERNAME")
    private String userName;
	private String password;
	private Float cliente;
	private String email;
	private Date fechaalta;
	private Date fechabaja;
	private char status;
	private Long intentos;
	private Date fecharevocado;
	private Date fechavigencia;
	private Long noacceso;
	private String apellidopaterno;
	private String apellidomaterno;
	@Column(nullable=true)
	private Long area;
	private Date fechamodificacion;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
	public String getLOGIN() {
		return LOGIN;
	}
	public void setLOGIN(String lOGIN) {
		LOGIN = lOGIN;
	}
	public Float getCliente() {
		return cliente;
	}
	public void setCliente(Float cliente) {
		this.cliente = cliente;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getFechaalta() {
		return fechaalta;
	}
	public void setFechaalta(Date fechaalta) {
		this.fechaalta = fechaalta;
	}
	public Date getFechabaja() {
		return fechabaja;
	}
	public void setFechabaja(Date fechabaja) {
		this.fechabaja = fechabaja;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public Long getIntentos() {
		return intentos;
	}
	public void setIntentos(Long intentos) {
		this.intentos = intentos;
	}
	public Date getFecharevocado() {
		return fecharevocado;
	}
	public void setFecharevocado(Date fecharevocado) {
		this.fecharevocado = fecharevocado;
	}
	public Date getFechavigencia() {
		return fechavigencia;
	}
	public void setFechavigencia(Date fechavigencia) {
		this.fechavigencia = fechavigencia;
	}
	public Long getNoacceso() {
		return noacceso;
	}
	public void setNoacceso(Long noacceso) {
		this.noacceso = noacceso;
	}
	public String getApellidopaterno() {
		return apellidopaterno;
	}
	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}
	public String getApellidomaterno() {
		return apellidomaterno;
	}
	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}
	public Long getArea() {
		return area;
	}
	public void setArea(Long area) {
		this.area = area;
	}
	public Date getFechamodificacion() {
		return fechamodificacion;
	}
	public void setFechamodificacion(Date fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}
	public static long getFechaExpira() {
		return FECHA_EXPIRA;
	}
	private static final long FECHA_EXPIRA = 30L * 24L * 60L * 60L * 1000L;
	
	public boolean isvaluarExpiracion() {
	
		if (this.fechamodificacion == null) return false;
	    
		long fechaActual = System.currentTimeMillis();
		long fecharegistrada = this.fechamodificacion.getTime();
		
		return fechaActual > fecharegistrada + FECHA_EXPIRA;		
	}
	
	
}
