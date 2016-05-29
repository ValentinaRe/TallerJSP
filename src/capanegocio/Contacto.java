package capanegocio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import orm.ContactoCriteria;

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
	
	private String fotoCont;
	/**
	 * Constructor de la clase Contacto
	 */
	public Contacto() {
		super();
	}

	/**
	 * M�todo get para obtener el valor de id
	 * 
	 * @return int
	 */
	public int getUid() {
		return uid;
	}

	/**
	 * M�todo set para modificar el valor de id
	 * 
	 * @param uid de tipo int
	 */

	public void setUid(int uid) {
		this.uid = uid;
	}

	/**
	 * m�todo get para obtener el valor de el nombre
	 * 
	 * @return nombre de tipo String
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * M�todo set para modificar el valor de el nombre
	 * 
	 * @param nombre de tipo String
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * M�todo get para obtener el valor de el apellido
	 * 
	 * @return apellido de tipo String
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * M�todo set para modificar el valor de el apellido
	 * 
	 * @param apellido de tipo String
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * M�todo get para obtener el valor de el mail
	 * 
	 * @return mail de tipo String
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * M�todo set para modificar el valor de el mail
	 * 
	 * @param mail de tipo String
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * M�todo get para obtener el valor de el tel�fono
	 * 
	 * @return telefono de tipo String
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * M�todo set para modificar el valor de el tel�fono
	 * 
	 * @param telefono de tipo String
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * M�todo get para obtener el valor del pa�s
	 * 
	 * @return pais de tipo String
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * M�todo set para modificar el valor de el pa�s
	 * 
	 * @param pais de tipo String
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * M�todo get para obtener el valor de la regi�n
	 * 
	 * @return region de tipo String
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * M�todo set para modificar el valor de la regi�n
	 * 
	 * @param region de tipo String
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * M�todo get para obtener el valor de la ciudad
	 * 
	 * @return ciudad de tipo String
	 */
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * M�todo set para modificar el valor de la ciudad
	 * 
	 * @param ciudad  de tipo String
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * M�todo para obtener valor de run 
	 * 
	 * @return run de tipo String
	 */
	public String getRun() {
		return run;
	}

	/**
	 * M�todo get para modificar el valor de run
	 * 
	 * @param run de tipo String
	 */
	public void setFotoCont(String fotoCont) {
		this.fotoCont = fotoCont;
	}
	public String getFotoCont() {
		return fotoCont;
	}

	/**
	 * M�todo get para modificar el valor de run
	 * 
	 * @param run de tipo String
	 */
	public void setRun(String run) {
		this.run = run;
	}
/**
 * M�todo para modificar el valor de empresa
 * @param empresaUid de tipo Empresa
 */
	
	public void setEmpresaUid(Empresa empresaUid) {
		this.empresaUid = empresaUid;
	}
/**
 * M�todo para obtener el valor de empresa
 * @return empresa de tipo Empresa
 */
	public Empresa getEmpresaUid() {
		return empresaUid;
	}

	/**
	 * Este m�todo ingresa datos de contacto en la base de datos
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
			//try {
				lormContacto.setFotoCont(contacto.getFotoCont());
			//} catch (NullPointerException e) {
			//	e.printStackTrace();
			//	msg = "Dato nulo";
			//}
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
	 * M�todo para eliminar datos de la Base de datos
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
				 //orm.Contacto lormContacto =
				// orm.ContactoDAO.loadContactoByQuery("Contacto.run ='"+contacto.getRun()+"'" ,
				 //null);//orm.ContactoDAO.loadContactoByQuery("Contacto.nombre='Victor'",
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
	 * M�todo para listar los datos de la base de datos
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
			
			contacto.setUid(contactoOrm.getUid());
			contacto.setRun(contactoOrm.getRun());
			contacto.setNombre(contactoOrm.getNombre());
			contacto.setApellido(contactoOrm.getApellido());
			contacto.setMail(contactoOrm.getMail());
			contacto.setTelefono(contactoOrm.getTelefono());
			contacto.setPais(contactoOrm.getPais());
			contacto.setRegion(contactoOrm.getRegion());
			contacto.setCiudad(contactoOrm.getCiudad());
			contacto.setFotoCont(contactoOrm.getFotoCont());
			
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
	 * M�todo que permite actualizar datos de contacto en la base de datos
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
			
				orm.Contacto lormContacto = orm.ContactoDAO.loadContactoByORMID(contacto.getUid());// orm.ContactoDAO.loadContactoByQuery("Contacto.nombre='"+
				orm.Empresa empresa = orm.EmpresaDAO.loadEmpresaByORMID(contacto.getEmpresaUid().getUid());
																								// +"'",
																								// null);
				// Update the properties of the persistent object
				System.out.println("id: " + contacto.getUid());
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

			
				
				
				System.out.println("Ingreso exitoso");
				msg = "datos actualizados";
				orm.ContactoDAO.save(lormContacto);
				t.commit();
		}
			 catch (Exception e) {
				t.rollback();
			} 
		return msg;
	}
/**
 * M�todo para realizar una b�squeda simple a la base de datos de contacto asociado a empresa por medio de una query realizada con un or
 * @param busqueda de tipo String
 * @return listaContacto de tipo List<Contacto>
 * @throws PersistentException
 */
	public List<Contacto> busquedaSimple(String busqueda) throws PersistentException {
		List<Contacto> listaContacto = new ArrayList<Contacto>();
		List<orm.Contacto> listarContacto = new ArrayList<orm.Contacto>();
		/**
		if (busqueda != null || !busqueda.equals("")) {
		listarContacto = orm.ContactoDAO.queryContacto("Contacto.run='" + busqueda +
				"' OR Contacto.nombre ='" + busqueda + 
				"' OR Contacto.apellido ='"+ busqueda + 
				"' OR Contacto.mail = '" + busqueda + 
				"' OR Contacto.telefono = '"+ busqueda+
				"' OR Contacto.pais ='"+busqueda+
				"' OR Contacto.region ='"+busqueda+
				"' OR Contacto.ciudad ='"+busqueda+"'" ,null);
		}**/
		ContactoCriteria ccr= new ContactoCriteria();
		Criterion run= Restrictions.ilike("run", busqueda.toLowerCase());
		Criterion nombre= Restrictions.ilike("nombre", busqueda.toLowerCase());
		Criterion apellido= Restrictions.ilike("apellido", busqueda.toLowerCase());
		Criterion mail= Restrictions.ilike("mail", busqueda.toLowerCase());
		Criterion telefono= Restrictions.ilike("telefono", busqueda.toLowerCase());
		Criterion pais= Restrictions.ilike("pais", busqueda.toLowerCase());
		Criterion region= Restrictions.ilike("region", busqueda.toLowerCase());
		Criterion ciudad= Restrictions.ilike("ciudad", busqueda.toLowerCase());
		Disjunction or= Restrictions.or(nombre,apellido,mail,telefono,pais,region,ciudad);
		ccr.add(or);
		listarContacto= Arrays.asList(orm.ContactoDAO.listContactoByCriteria(ccr));
		
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
            contactoCon.setFotoCont(contactoOrm.getFotoCont());
           
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
	/**
	 * Método para realizar busqueda avazada
	 * @param contacto de tipo Contacto
	 * @return lista de busqueda avanzada de tipo contacto
	 * @throws PersistentException
	 */
	public static List<Contacto> busquedaAvanzada(Contacto contacto) throws PersistentException {
		List<Contacto> listaContacto = new ArrayList<Contacto>();
		List<orm.Contacto> listarContactos = new ArrayList<orm.Contacto>();
		String query="";
		ContactoCriteria ccr= new ContactoCriteria();
		if(contacto.getRun()!= null && !contacto.getRun().trim().equals("")){
			ccr.add(Restrictions.ilike("run", contacto.getRun().toLowerCase()));
			query += "Contacto.run='"+contacto.getRun()+"' ";
		}
		
		//if((contacto.getRun()!= null && !contacto.getRun().equals(""))
		//		&& (contacto.getNombre()!=null && !contacto.getNombre().equals(""))){
		//	query += "AND ";
		//}
		if(contacto.getNombre()!=null && !contacto.getNombre().equals("")){
			ccr.add(Restrictions.ilike("nombre", contacto.getNombre().toLowerCase()));
			query += "Contacto.nombre='"+contacto.getNombre()+"' ";
		}
		
		//if(((contacto.getRun()!=null && !contacto.getRun().equals(""))
		//		|| (contacto.getNombre()!=null && !contacto.getNombre().equals("")))
		//		&& (contacto.getApellido()!=null && !contacto.getApellido().equals(""))){
		//	query += "AND ";
		//}
		if(contacto.getApellido()!=null && !contacto.getApellido().trim().equals("")){
			ccr.add(Restrictions.ilike("apellido", contacto.getApellido().toLowerCase()));
			query += "Contacto.apellido='"+contacto.getApellido()+"' ";
		}
		
		//if((contacto.getRun()!=null && !contacto.getRun().equals("")
		//		|| contacto.getNombre()!=null && !contacto.getNombre().equals("")
		//		|| contacto.getApellido()!=null && !contacto.getApellido().equals(""))
		//		&& (contacto.getMail() != null && !contacto.getMail().equals(""))){
		//	query += "AND ";
		//}
		if(contacto.getMail() != null && !contacto.getMail().trim().equals("")){
			ccr.add(Restrictions.ilike("mail", contacto.getMail().toLowerCase()));
			query += "Contacto.mail='"+contacto.getMail()+"' ";
		}
		
		/*if((contacto.getRun()!=null && !contacto.getRun().equals("")
				|| contacto.getNombre()!=null && !contacto.getNombre().equals("")
				|| contacto.getApellido()!=null && !contacto.getApellido().equals("")
				|| contacto.getMail() != null && !contacto.getMail().equals(""))
				&&(contacto.getTelefono() != null && !contacto.getTelefono().equals(""))){
			query += "AND ";
		}*/
		if(contacto.getTelefono() != null && !contacto.getTelefono().trim().equals("")){
			ccr.add(Restrictions.ilike("telefono", contacto.getTelefono().toLowerCase()));
			query += "Contacto.telefono='"+contacto.getTelefono()+ "' ";
		}
		/*if((contacto.getRun()!=null && !contacto.getRun().equals("")
				|| contacto.getNombre()!=null && !contacto.getNombre().equals("")
				|| contacto.getApellido()!=null && !contacto.getApellido().equals("")
				|| contacto.getMail() != null && !contacto.getMail().equals("")
				|| contacto.getTelefono() != null && !contacto.getTelefono().equals(""))
				&& (contacto.getPais() != null && !contacto.getPais().equals(""))){
				
			query += "AND ";
		}*/
		if(contacto.getPais() != null && !contacto.getPais().trim().equals("")){
			ccr.add(Restrictions.ilike("pais", contacto.getPais().toLowerCase()));
			query += "Contacto.pais='"+contacto.getPais()+ "' ";
		}	
		/*if((contacto.getRun()!=null && !contacto.getRun().equals("")
				|| contacto.getNombre()!=null && !contacto.getNombre().equals("")
				|| contacto.getApellido()!=null && !contacto.getApellido().equals("")
				|| contacto.getMail() != null && !contacto.getMail().equals("")
				|| contacto.getTelefono() != null && !contacto.getTelefono().equals("")
				|| contacto.getPais() != null && !contacto.getPais().equals(""))
				&& (contacto.getRegion() != null && !contacto.getRegion().equals(""))){
				
			query += "AND ";
		}*/
		if(contacto.getRegion() != null && !contacto.getRegion().trim().equals("")){
			ccr.add(Restrictions.ilike("region", contacto.getRegion().toLowerCase()));
			query += "Contacto.region='"+contacto.getRegion()+ "' ";
			
		}
		/*if((contacto.getRun()!=null && !contacto.getRun().equals("")
				|| contacto.getNombre()!=null && !contacto.getNombre().equals("")
				|| contacto.getApellido()!=null && !contacto.getApellido().equals("")
				|| contacto.getMail() != null && !contacto.getMail().equals("")
				|| contacto.getTelefono() != null && !contacto.getTelefono().equals("")
				|| contacto.getPais() != null && !contacto.getPais().equals("")
				|| contacto.getRegion() != null && !contacto.getRegion().equals(""))
				&&(contacto.getCiudad() != null && !contacto.getCiudad().equals(""))){
				
			query += "AND ";
		}*/	
		if(contacto.getCiudad() != null && !contacto.getCiudad().trim().equals("")){
			ccr.add(Restrictions.ilike("ciudad", contacto.getCiudad().toLowerCase()));
			query += "Contacto.ciudad='"+contacto.getCiudad()+ "' ";
		}
		
		listarContactos=Arrays.asList(orm.ContactoDAO.listContactoByCriteria(ccr));
		
		//listarContactos=orm.ContactoDAO.queryContacto(query,null);
		
		if (!listarContactos.isEmpty()) {
			for (orm.Contacto contactoOrm : listarContactos) {
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
	            contactoCon.setFotoCont(contactoOrm.getFotoCont());
	           
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
		}
		
		
		return listaContacto;
		
		}
	/**
	 * Método para ver perfil de Contacto
	 * @param idContacto
	 * @return contactoCon de tipo Contacto
	 * @throws PersistentException
	 */
public static Contacto verPerfilContacto(int idContacto) throws PersistentException{
	
	Contacto contactoCon=new Contacto();
    orm.Contacto contactoOrm = orm.ContactoDAO.loadContactoByORMID(idContacto);
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
    contactoCon.setFotoCont(contactoOrm.getFotoCont());
   
  
    empreNegocio.setUid(empresaORM.getUid());
    empreNegocio.setRut(empresaORM.getRut());
    empreNegocio.setNombre(empresaORM.getNombre());
    empreNegocio.setCiudad(empresaORM.getCiudad());
    empreNegocio.setDireccion(empresaORM.getDireccion());
    empreNegocio.setPais(empresaORM.getPais());
    empreNegocio.setTelefono(empresaORM.getTelefono());
    empreNegocio.setRazonSocial(empresaORM.getRazonSocial());
    
  
    contactoCon.setEmpresaUid(empreNegocio);
    
    return  contactoCon;
}
}


	 
	