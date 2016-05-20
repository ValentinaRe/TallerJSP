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
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_CONTACTO_EMPRESAUID) {
			this.empresauid = (orm.Empresa) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int uid;
	
	private String run;
	
	private String nombre;
	
	private String apellido;
	
	private String mail;
	
	private String telefono;
	
	private String pais;
	
	private String region;
	
	private String ciudad;
	
	private String fotoCont;
	
	private orm.Empresa empresauid;
	
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
	
	public void setRun(String value) {
		this.run = value;
	}
	
	public String getRun() {
		return run;
	}
	
	public void setFotoCont(String value) {
		this.fotoCont = value;
	}
	
	public String getFotoCont() {
		return fotoCont;
	}
	
	public void setEmpresauid(orm.Empresa value) {
		if (empresauid != null) {
			empresauid.contacto.remove(this);
		}
		if (value != null) {
			value.contacto.add(this);
		}
	}
	
	public orm.Empresa getEmpresauid() {
		return empresauid;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Empresauid(orm.Empresa value) {
		this.empresauid = value;
	}
	
	private orm.Empresa getORM_Empresauid() {
		return empresauid;
	}
	
	public String toString() {
		return String.valueOf(getUid());
	}
	
}
