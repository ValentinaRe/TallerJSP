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

public class Anotacion {
	public Anotacion() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_ANOTACION_CONTACTOUID) {
			this.contactouid = (orm.Contacto) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int idAnotacion;
	
	private String nombre;
	
	private String descripcion;
	
	private orm.Contacto contactouid;
	
	private void setIdAnotacion(int value) {
		this.idAnotacion = value;
	}
	
	public int getIdAnotacion() {
		return idAnotacion;
	}
	
	public int getORMID() {
		return getIdAnotacion();
	}
	
	public void setNombre(String value) {
		this.nombre = value;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setDescripcion(String value) {
		this.descripcion = value;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setContactouid(orm.Contacto value) {
		if (contactouid != null) {
			contactouid.anotacion.remove(this);
		}
		if (value != null) {
			value.anotacion.add(this);
		}
	}
	
	public orm.Contacto getContactouid() {
		return contactouid;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Contactouid(orm.Contacto value) {
		this.contactouid = value;
	}
	
	private orm.Contacto getORM_Contactouid() {
		return contactouid;
	}
	
	public String toString() {
		return String.valueOf(getIdAnotacion());
	}
	
}
