package capanegocio;

import java.util.ArrayList;
import java.util.List;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

/**
 * 
 * @author Vale
 *
 */
public class Contacto {
private int uid;
	

	private String nombre;
	
	private String apellido;
	
	private String mail;
	
	private String telefono;
	
	private String pais;
	
	private String region;
	
	private String ciudad;
	/**
	 * Constructor de la clase
	 */
	public Contacto() {
	super();
}
/**
 * metodo get para obtener el valor de id
 * @return int
 */
	public int getUid() {
		return uid;
	}
/**
 * Metodo set para modificar el valor de id
 * @param uid de tipo int
 */
	
	public void setUid(int uid) {
		this.uid = uid;
	}
/**
 * metodo get para obtener el valor de el  nombre
 * @return  nombre de tipo String 
 */
	public String getNombre() {
		return nombre;
	}
/**
 * Metodo set para modificar el valor de el  nombre
 * @param nombre de tipo String
 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
/**
 * metodo get para obtener el valor de el apellido
 * @return apellido de tipo String
 */
	public String getApellido() {
		return apellido;
	}
/**
 * Metodo set para modificar el valor de el apellido
 * @param apellido de tipo String
 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
/**
 * metodo get para obtener el valor de el mail
 * @return mail de tipo String
 */
	public String getMail() {
		return mail;
	}
/**
 * Metodo set para modificar el valor de el mail
 * @param mail de tipo String
 */
	public void setMail(String mail) {
		this.mail = mail;
	}
/**
 * metodo get para obtener el valor de el telefono
 * @return telefono de tipo String
 */
	public String getTelefono() {
		return telefono;
	}
/**
 * Metodo set para modificar el valor de el telefono
 * @param telefono de tipo String
 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
/**
 * metodo get para obtener el valor del pais
 * @return pais de tipo String
 */
	public String getPais() {
		return pais;
	}
/**
 * Metodo set para modificar el valor de el pais
 * @param pais de tipo String
 */
	public void setPais(String pais) {
		this.pais = pais;
	}
/**
 * metodo get para obtener el valor de la region
 * @return region de tipo String
 */
	public String getRegion() {
		return region;
	}
/**
 * Metodo set para modificar el valor de la region
 * @param region de tipo String
 */
	public void setRegion(String region) {
		this.region = region;
	}
/**
 * metodo get para obtener el valor de la ciudad
 * @return ciudad de tipo String
 */
	public String getCiudad() {
		return ciudad;
	}
/**
 * Metodo set para modificar el valor de la ciudad
 * @param ciudad de tipo String
 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	/**
	 * Este metodo ingresa datos de contacto en la base de datos
	 * @param contacto
	 * @return String 
	 * @throws PersistentException
	 */
	public static String ingresar(Contacto contacto) throws PersistentException {
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().beginTransaction();
		String msg="";
		try {
			orm.Contacto lormContacto = orm.ContactoDAO.createContacto();
			// Initialize the properties of the persistent object here
			
			lormContacto.setNombre(contacto.nombre);
			lormContacto.setApellido(contacto.apellido);
			lormContacto.setMail(contacto.mail);
			lormContacto.setTelefono(contacto.telefono);
			lormContacto.setPais(contacto.pais);
			lormContacto.setRegion(contacto.region);
			lormContacto.setCiudad(contacto.ciudad);
			lormContacto.setContactouid(0);
			msg="Ingreso exitoso";
			orm.ContactoDAO.save(lormContacto);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		return msg; 
	}
	
	/**
	 * Metodo para eliminar datos de la Base de datos
	 * @param contacto de tipo Contacto
	 * @return  msg mensaje de tipo String
	 * @throws PersistentException
	 */
	public static String eliminar(Contacto contacto) throws PersistentException {
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().beginTransaction();
		String msg="";
		try {
			orm.Contacto lormContacto = orm.ContactoDAO.loadContactoByORMID(contacto.uid);//orm.ContactoDAO.loadContactoByQuery("Contacto.nombre='Victor'", null);
			// Delete the persistent object
			orm.ContactoDAO.delete(lormContacto);
			t.commit();
			msg="datos eliminados";
		}
		catch (Exception e) {
			t.rollback();
		}
		return msg;
	}
	/**
	 * 
	 */
	private static final int ROW_COUNT = 100;
	/**
	 * Metodo para listar los datos de la base de datos
	 * @return ArrayList arreglo con la lista de contacto
	 * @throws PersistentException
	 */
	public static List <Contacto> listar() throws PersistentException {
	
		List <orm.Contacto> listaContactoOrm = orm.ContactoDAO.queryContacto(null, null);
		List <Contacto> listaContacto = new ArrayList<>(); 
		
		for (orm.Contacto contactoOrm:listaContactoOrm) {
			Contacto contacto= new Contacto();
			contacto.setNombre(contactoOrm.getNombre());
			contacto.setApellido(contactoOrm.getApellido());
			contacto.setMail(contactoOrm.getMail());
			contacto.setTelefono(contactoOrm.getTelefono());
			contacto.setPais(contactoOrm.getPais());
			contacto.setRegion(contactoOrm.getRegion());
			contacto.setCiudad(contactoOrm.getCiudad());
			listaContacto.add(contacto);
		}
		System.out.println( " record(s) retrieved.");
		return listaContacto;
	}
	/**
	 * Metodo que permite actualizar datos de contacto en la base de datos
	 * @param contacto
	 * @return String
	 * @throws PersistentException
	 */
	public static String actualizar(Contacto contacto) throws PersistentException {
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().beginTransaction();
		String msg="";
		try {
			orm.Contacto lormContacto = orm.ContactoDAO.loadContactoByORMID(contacto.uid);//orm.ContactoDAO.loadContactoByQuery("Contacto.nombre='"+ +"'", null);
			// Update the properties of the persistent object
			System.out.println("id: "+contacto.uid);
			lormContacto.setNombre(contacto.nombre);
			lormContacto.setApellido(contacto.apellido);
			lormContacto.setMail(contacto.mail);
			lormContacto.setTelefono(contacto.telefono);
			lormContacto.setPais(contacto.pais);
			lormContacto.setRegion(contacto.region);
			lormContacto.setCiudad(contacto.ciudad);
			System.out.println("Ingreso exitoso");
			msg="datos actualizados";
			orm.ContactoDAO.save(lormContacto);
			t.commit();
			
		}
		catch (Exception e) {
			t.rollback();
		}
		return msg;
	}
}
