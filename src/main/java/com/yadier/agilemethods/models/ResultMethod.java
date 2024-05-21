package com.yadier.agilemethods.models;

public class ResultMethod {
	private String nombre;
	private String	descripcion; 
	private String	image;
	private String	url;
	
	
	
	public ResultMethod(String nombre, String descripcion, String image, String url) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.image = image;
		this.url = url;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
		
	
	
}
