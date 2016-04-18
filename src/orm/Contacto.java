/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package orm;

public class Contacto {
	public Contacto() {
	}
	
	private int uid;
	
	private String nombre;
	
	private String apellido;
	
	private String mail;
	
	private String telefono;
	
	private String pais;
	
	private String region;
	
	private String ciudad;
	
	private int contactouid;
	
	private void setUid(int value) {
		this.uid = value;
	}
	
	public int getUid() {
		return uid;
	}
	
	public int getORMID() {
		return getUid();
	}
	
	public void setNombre(String value) {
		this.nombre = value;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setApellido(String value) {
		this.apellido = value;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setMail(String value) {
		this.mail = value;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setTelefono(String value) {
		this.telefono = value;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setPais(String value) {
		this.pais = value;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setRegion(String value) {
		this.region = value;
	}
	
	public String getRegion() {
		return region;
	}
	
	public void setCiudad(String value) {
		this.ciudad = value;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public void setContactouid(int value) {
		this.contactouid = value;
	}
	
	public int getContactouid() {
		return contactouid;
	}
	
	public String toString() {
		return String.valueOf(getUid());
	}
	
}
