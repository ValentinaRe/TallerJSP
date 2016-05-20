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

public class Empresa {
	public Empresa() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_EMPRESA_CONTACTO) {
			return ORM_contacto;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int uid;
	
	private String rut;
	
	private String nombre;
	
	private String ciudad;
	
	private String direccion;
	
	private String pais;
	
	private String telefono;
	
	private String razonSocial;
	
	private java.util.Set ORM_contacto = new java.util.HashSet();
	
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
	
	public void setCiudad(String value) {
		this.ciudad = value;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public void setDireccion(String value) {
		this.direccion = value;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setPais(String value) {
		this.pais = value;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setRut(String value) {
		this.rut = value;
	}
	
	public String getRut() {
		return rut;
	}
	
	public void setTelefono(String value) {
		this.telefono = value;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setRazonSocial(String value) {
		this.razonSocial = value;
	}
	
	public String getRazonSocial() {
		return razonSocial;
	}
	
	private void setORM_Contacto(java.util.Set value) {
		this.ORM_contacto = value;
	}
	
	private java.util.Set getORM_Contacto() {
		return ORM_contacto;
	}
	
	public final orm.ContactoSetCollection contacto = new orm.ContactoSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_EMPRESA_CONTACTO, orm.ORMConstants.KEY_CONTACTO_EMPRESAUID, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getUid());
	}
	
}
