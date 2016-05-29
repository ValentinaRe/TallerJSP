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

/**
 * Método get para obtener el id de anotacion
 * @return idAnotacion de tipo int
 */
public int getIdAnotacion() {
	return idAnotacion;
}
/**
 * Método set para pasar id de anotación 
 * @param idAnotacion de tipo int
 */
public void setIdAnotacion(int idAnotacion) {
	this.idAnotacion = idAnotacion;
}
/**
 * Método get para obtener título de la anotación
 * @return un nombre de tipo String
 */
public String getNombre() {
	return nombre;
}
/**
 * Método para pasar el título de la anotación
 * @param nombre
 */
public void setNombre(String nombre) {
	this.nombre = nombre;
}
/**
 * Método para obtener descripción de anotación
 * @return descipción de tipo String 
 */
public String getDescripcion() {
	return descripcion;
}
/**
 * Método para pasar la descripción de la anotación
 * @param descripcion de tipo String
 */
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
/**
 * Método para obtener id de la clase Contacto
 * @return contactouid de tipo Contacto
 */
public Contacto getContactouid() {
	return contactouid;
}
/**
 * Método para pasar el id de la clase Contacto
 * @param contactouid
 */
public void setContactouid(Contacto contactouid) {
	this.contactouid = contactouid;
}
/**
 * Método  para ingresar bitácora al contacto
 * @param anotacion de tipo Anotación
 * @return mensaje de tipo String
 * @throws PersistentException
 */
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
