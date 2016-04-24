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
	private Empresa empresaUid;
	private int uid;

	private String nombre;

	private String apellido;

	private String mail;

	private String telefono;

	private String pais;

	private String region;

	private String ciudad;

	private String run;

	/**
	 * Constructor de la clase Contacto
	 */
	public Contacto() {
		super();
	}

	/**
	 * Método get para obtener el valor de id
	 * 
	 * @return int
	 */
	public int getUid() {
		return uid;
	}

	/**
	 * Método set para modificar el valor de id
	 * 
	 * @param uid de tipo int
	 */

	public void setUid(int uid) {
		this.uid = uid;
	}

	/**
	 * método get para obtener el valor de el nombre
	 * 
	 * @return nombre de tipo String
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método set para modificar el valor de el nombre
	 * 
	 * @param nombre de tipo String
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método get para obtener el valor de el apellido
	 * 
	 * @return apellido de tipo String
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Método set para modificar el valor de el apellido
	 * 
	 * @param apellido de tipo String
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Método get para obtener el valor de el mail
	 * 
	 * @return mail de tipo String
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * Método set para modificar el valor de el mail
	 * 
	 * @param mail de tipo String
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * Método get para obtener el valor de el teléfono
	 * 
	 * @return telefono de tipo String
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Método set para modificar el valor de el teléfono
	 * 
	 * @param telefono de tipo String
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Método get para obtener el valor del país
	 * 
	 * @return pais de tipo String
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * Método set para modificar el valor de el paés
	 * 
	 * @param pais de tipo String
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * Método get para obtener el valor de la región
	 * 
	 * @return region de tipo String
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * Método set para modificar el valor de la región
	 * 
	 * @param region de tipo String
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * Método get para obtener el valor de la ciudad
	 * 
	 * @return ciudad de tipo String
	 */
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * Método set para modificar el valor de la ciudad
	 * 
	 * @param ciudad  de tipo String
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * Método para obtener valor de run 
	 * 
	 * @return run de tipo String
	 */
	public String getRun() {
		return run;
	}

	/**
	 * Método get para modificar el valor de run
	 * 
	 * @param run de tipo String
	 */
	public void setRun(String run) {
		this.run = run;
	}
/**
 * Método para modificar el valor de empresa
 * @param empresaUid de tipo Empresa
 */
	
	public void setEmpresaUid(Empresa empresaUid) {
		this.empresaUid = empresaUid;
	}
/**
 * Método para obtener el valor de empresa
 * @return empresa de tipo Empresa
 */
	public Empresa getEmpresaUid() {
		return empresaUid;
	}

	/**
	 * Este método ingresa datos de contacto en la base de datos
	 * 
	 * @param contacto de tipo Contacto
	 * @return msg retorna un mensaje de tipo String
	 * @throws PersistentException
	 */
	public static String ingresar(Contacto contacto) throws PersistentException {

		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession()
				.beginTransaction();
		String msg = "";

		// try {
		try {

			orm.Contacto lormContacto = orm.ContactoDAO.createContacto();
			orm.Empresa empresa = orm.EmpresaDAO.loadEmpresaByORMID(contacto.getEmpresaUid().getUid());
			// Initialize the properties of the persistent object here
			try {
				lormContacto.setRun(contacto.getRun());
			} catch (NullPointerException e) {
				e.printStackTrace();
				msg = "Dato nulo";
			}
			try {
				lormContacto.setNombre(contacto.getNombre());
			} catch (NullPointerException e) {
				e.printStackTrace();
				msg = "Dato nulo";
			}
			try {
				lormContacto.setApellido(contacto.getApellido());
			} catch (NullPointerException e) {
				e.printStackTrace();
				msg = "Dato nulo";
			}
			try {
				lormContacto.setMail(contacto.getMail());
			} catch (NullPointerException e) {
				e.printStackTrace();
				msg = "Dato nulo";
			}
			try {
				lormContacto.setTelefono(contacto.getTelefono());
			} catch (NullPointerException e) {
				e.printStackTrace();
				msg = "Dato nulo";
			}
			try {
				lormContacto.setPais(contacto.getPais());
			} catch (NullPointerException e) {
				e.printStackTrace();
				msg = "Dato nulo";
			}
			try {
				lormContacto.setRegion(contacto.getRegion());
			} catch (NullPointerException e) {
				e.printStackTrace();
				msg = "Dato nulo";
			}
			try {
				lormContacto.setCiudad(contacto.getCiudad());
			} catch (NullPointerException e) {
				e.printStackTrace();
				msg = "Dato nulo";
			}
			try {
				lormContacto.setEmpresauid(empresa);
			} catch (NullPointerException e) {
				e.printStackTrace();
				msg = "Dato nulo";
			}
		
			msg = "Ingreso exitoso";
			orm.ContactoDAO.save(lormContacto);
			t.commit();

		} catch (Exception e) {
			t.rollback();
			msg = "Ingreso fallido";
		} // }catch (NullPointerException e) {
			// e.printStackTrace();
			// msg="Dato nulo";
			// }
		return msg;
	}

	/**
	 * Método para eliminar datos de la Base de datos
	 * 
	 * @param contacto de tipo Contacto
	 * @return msg retorna un mensaje de tipo String
	 * @throws PersistentException
	 */
	public static String eliminar(Contacto contacto) throws PersistentException {
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession()
				.beginTransaction();
		String msg = "";
		try {
			try {
				orm.Contacto lormContacto = orm.ContactoDAO.loadContactoByORMID(contacto.uid);
				// orm.Contacto lormContacto =
				// orm.ContactoDAO.loadContactoByQuery("Contacto.run =
				// '"+contacto.run+"'",
				// null);//orm.ContactoDAO.loadContactoByQuery("Contacto.nombre='Victor'",
				// null);
				// Delete the persistent object
				orm.ContactoDAO.delete(lormContacto);
				t.commit();
				msg = "datos eliminados";
			} catch (Exception e) {
				t.rollback();
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return msg;
	}

	/**
	 * 
	 */
	private static final int ROW_COUNT = 100;

	/**
	 * Método para listar los datos de la base de datos
	 * 
	 * @return ArrayList arreglo con la lista de contacto
	 * @throws PersistentException
	 */
	public static List<Contacto> listar() throws PersistentException {

		List<orm.Contacto> listaContactoOrm = orm.ContactoDAO.queryContacto(null, null);
		List<Contacto> listaContacto = new ArrayList<>();

		for (orm.Contacto contactoOrm : listaContactoOrm) {
			 Empresa empreNegocio=new Empresa();
	          orm.Empresa empresaORM = orm.EmpresaDAO.loadEmpresaByORMID(contactoOrm.getEmpresauid().getUid());
	           
			Contacto contacto = new Contacto();
			contacto.setRun(contactoOrm.getRun());
			contacto.setNombre(contactoOrm.getNombre());
			contacto.setApellido(contactoOrm.getApellido());
			contacto.setMail(contactoOrm.getMail());
			contacto.setTelefono(contactoOrm.getTelefono());
			contacto.setPais(contactoOrm.getPais());
			contacto.setRegion(contactoOrm.getRegion());
			contacto.setCiudad(contactoOrm.getCiudad());
			
		    empreNegocio.setUid(empresaORM.getUid());
	        empreNegocio.setRut(empresaORM.getRut());
	        empreNegocio.setNombre(empresaORM.getNombre());
	        empreNegocio.setCiudad(empresaORM.getCiudad());
	        empreNegocio.setDireccion(empresaORM.getDireccion());
	        empreNegocio.setPais(empresaORM.getPais());
	        empreNegocio.setTelefono(empresaORM.getTelefono());
	        empreNegocio.setRazonSocial(empresaORM.getRazonSocial());
	            
	            contacto.setEmpresaUid(empreNegocio);
			listaContacto.add(contacto);
		}
		System.out.println(" record(s) retrieved.");
		return listaContacto;
	}

	/**
	 * Método que permite actualizar datos de contacto en la base de datos
	 * 
	 * @param contacto de tipo Contacto
	 * @return msg retorna un mensaje de tipo String
	 * @throws PersistentException
	 */
	public static String actualizar(Contacto contacto) throws PersistentException {
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession()
				.beginTransaction();
		String msg = "";
		try {
			try {
				orm.Contacto lormContacto = orm.ContactoDAO.loadContactoByORMID(contacto.getUid());// orm.ContactoDAO.loadContactoByQuery("Contacto.nombre='"+
				orm.Empresa empresa = orm.EmpresaDAO.loadEmpresaByORMID(contacto.getEmpresaUid().getUid());
																								// +"'",
																								// null);
				// Update the properties of the persistent object
				System.out.println("id: " + contacto.getUid());
				lormContacto.setRun(contacto.getRun());
				lormContacto.setNombre(contacto.getNombre());
				lormContacto.setApellido(contacto.getApellido());
				lormContacto.setMail(contacto.getMail());
				lormContacto.setTelefono(contacto.getTelefono());
				lormContacto.setPais(contacto.getPais());
				lormContacto.setRegion(contacto.getRegion());
				lormContacto.setCiudad(contacto.getCiudad());
				lormContacto.setEmpresauid(empresa);
				
				System.out.println("Ingreso exitoso");
				msg = "datos actualizados";
				orm.ContactoDAO.save(lormContacto);
				t.commit();

			} catch (Exception e) {
				t.rollback();
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return msg;
	}

	public List<Contacto> busquedaSimple(String busqueda) throws PersistentException {
		List<Contacto> listaContacto = new ArrayList<Contacto>();
		List<orm.Contacto> listarContacto = new ArrayList<orm.Contacto>();
		
		if (busqueda != null || !busqueda.equals("")) {
		listarContacto = orm.ContactoDAO.queryContacto("Contacto.run='" + busqueda +
				"' OR Contacto.nombre ='" + busqueda + 
				"' OR Contacto.apellido ='"+ busqueda + 
				"' OR Contacto.mail = '" + busqueda + 
				"' OR Contacto.telefono = '"+ busqueda+
				"' OR Contacto.pais ='"+busqueda+
				"' OR Contacto.region ='"+busqueda+
				"' OR Contacto.ciudad ='"+busqueda+"'" ,null);
		}
		//modificar la variable recibida desde el formulario:
		//a minusculas 
		//a mayusculas
		//buscar ñ como n
		//buscar n como ñ
		//buscar normal
		for (orm.Contacto contactoOrm : listarContacto) {
            Contacto contactoCon = new Contacto();
            Empresa empreNegocio=new Empresa();
            orm.Empresa empresaORM = orm.EmpresaDAO.loadEmpresaByORMID(contactoOrm.getEmpresauid().getUid());
           
            contactoCon.setUid(contactoOrm.getUid());
            contactoCon.setRun(contactoOrm.getRun());
            contactoCon.setNombre(contactoOrm.getNombre());
            contactoCon.setApellido(contactoOrm.getApellido());
            contactoCon.setMail(contactoOrm.getMail());
            contactoCon.setTelefono(contactoOrm.getTelefono());
            contactoCon.setPais(contactoOrm.getPais());
            contactoCon.setRegion(contactoOrm.getRegion());
            contactoCon.setCiudad(contactoOrm.getCiudad());
           
            empreNegocio.setUid(empresaORM.getUid());
            empreNegocio.setRut(empresaORM.getRut());
            empreNegocio.setNombre(empresaORM.getNombre());
            empreNegocio.setCiudad(empresaORM.getCiudad());
            empreNegocio.setDireccion(empresaORM.getDireccion());
            empreNegocio.setPais(empresaORM.getPais());
            empreNegocio.setTelefono(empresaORM.getTelefono());
            empreNegocio.setRazonSocial(empresaORM.getRazonSocial());
            
            contactoCon.setEmpresaUid(empreNegocio);
           
            
            listaContacto.add(contactoCon);
        }
		return listaContacto;
	}
	
	public static List<Contacto> busquedaAvanzada(Contacto contacto) throws PersistentException {
		List<Contacto> listaContacto = new ArrayList<Contacto>();
		List<orm.Contacto> listarContacto = new ArrayList<orm.Contacto>();
		String query="";
		if(contacto.getRun() != null && contacto.getRun().trim().equals("")){
			query+=
		}
		if(contacto.getNombre() != null && contacto.getNombre().trim().equals("")){
		query+="Contacto.run='" + contacto.getNombre()+"'";}
		
		
		
		
		
		
		return listaContacto;
		
		}
	

}
