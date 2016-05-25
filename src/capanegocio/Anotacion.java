/**
 * 
 */
package capanegocio;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

/**
 * @author vale
 *
 */
public class Anotacion {
private int idAnotacion;
private String nombre;
private String descripcion;
private Contacto contactouid;

public int getIdAnotacion() {
	return idAnotacion;
}
public void setIdAnotacion(int idAnotacion) {
	this.idAnotacion = idAnotacion;
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

public Contacto getContactouid() {
	return contactouid;
}
public void setContactouid(Contacto contactouid) {
	this.contactouid = contactouid;
}
public static String ingresar(Anotacion anotacion) throws PersistentException {

	PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession()
			.beginTransaction();
	String msg = "";

	
	try {

		orm.Anotacion lormAnotaciones = orm.AnotacionDAO.createAnotacion();
		orm.Contacto contacto = orm.ContactoDAO.loadContactoByORMID(anotacion.getContactouid().getUid());
		try{
		lormAnotaciones.setNombre(anotacion.getNombre());
		}catch(NullPointerException e){
			e.printStackTrace();
			msg = "Dato nulo";
		}
		try{
	lormAnotaciones.setDescripcion(anotacion.getDescripcion());
		}catch(NullPointerException e){
			e.printStackTrace();
			msg = "Dato nulo";
		}
		
		lormAnotaciones.setContactouid(contacto);
		orm.AnotacionDAO.save(lormAnotaciones);
		t.commit();
	}catch (Exception e) {
		t.rollback();
		msg = "Ingreso fallido";
	}
	return msg;
}


}
