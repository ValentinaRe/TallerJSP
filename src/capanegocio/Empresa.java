package capanegocio;

import java.util.ArrayList;
import java.util.List;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class Empresa {
	private int uid;
	private String rut;
	private String nombre;
	private String ciudad;
	private String direccion;
	private String pais;
	private String telefono;
	private String razonSocial;
/**
 * Constructor de la clase Empresa
 */
	public Empresa() {
		super();
		// TODO Auto-generated constructor stub
	}
/**
 * Metodo para obtener el valor de id
 * @return uid de tipo int 
 */
	public int getUid() {
		return uid;
	}
/**
 * Metodo para modificar el valor de id
 * @param uid de tipo int
 */
	public void setUid(int uid) {
		this.uid = uid;
	}
/**
 * Metodo para obtner el valor de rut
 * @return rut de tipo String
 */
	public String getRut() {
		return rut;
	}
/**
 * Metodo para modificar el valor de rut
 * @param rut de tipo String
 */

	public void setRut(String rut) {
		this.rut = rut;
	}
	/**
	 * Medoto para obtener el valor de nombre
	 * @return nombre de tipo String
	 */

	public String getNombre() {
		return nombre;
	}
/**
 * Metodo para modificar el valor de nombre
 * @param nombre de tipo String
 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
/**
 * Metodo para obtener el valor de ciudad
 * @return ciudad de tipo String
 */
	public String getCiudad() {
		return ciudad;
	}
/**
 * Metodo para modificar el valor de ciudad
 * @param ciudad de tipo String
 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
/**
 * Metodo para obtener el valo de direccion
 * @return direccion de tipo String
 */
	public String getDireccion() {
		return direccion;
	}
/**
 * Metodo para modificar el valor de direccion
 * @param direccion de tipo String
 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
/**
 * Metodo para obtener el valor de pais
 * @return pais de valos String
 */
	public String getPais() {
		return pais;
	}
/**
 * Metodo para modificar el valor de pais
 * @param pais de tipo String
 */
	public void setPais(String pais) {
		this.pais = pais;
	}
/**
 * Metodo para obtener el valor de telefono
 * @return telefono de tipo String
 */
	public String getTelefono() {
		return telefono;
	}
/**
 * Metodo para modificar el valor de telefono
 * @param telefono de tipo String
 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
/**
 * Metodo para obtener el valor de razon social
 * @return razon social de tipo String
 */
	public String getRazonSocial() {
		return razonSocial;
	}
/**
 * Metodo para modificar el valor de razon social
 * @param razonSocial de tipo String
 */

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	/**
	 * Este metodo ingresa datos de la empresa a la base de datos
	 * 
	 * @param empresa de tipo Empresa
	 * @return msg retorna un mensaje de tipo String
	 * @throws PersistentException
	 */
	public static String ingresar(Empresa empresa) throws PersistentException {
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession()
				.beginTransaction();
		String msg = "";
		//try {
			try {
				orm.Empresa lormEmpresa = orm.EmpresaDAO.createEmpresa();
				// Initialize the properties of the persistent object here
				try{
				lormEmpresa.setRut(empresa.getRut());
				} catch (NullPointerException e) {
					e.printStackTrace();
					msg = "Dato nulo";
				}
				try{
				lormEmpresa.setNombre(empresa.getNombre());
				} catch (NullPointerException e) {
					e.printStackTrace();
					msg = "Dato nulo";
				}
				try{
				lormEmpresa.setCiudad(empresa.getCiudad());
				} catch (NullPointerException e) {
					e.printStackTrace();
					msg = "Dato nulo";
				}
				try{
				lormEmpresa.setDireccion(empresa.getDireccion());
				} catch (NullPointerException e) {
					e.printStackTrace();
					msg = "Dato nulo";
				}
				try{
				lormEmpresa.setPais(empresa.getPais());
				} catch (NullPointerException e) {
					e.printStackTrace();
					msg = "Dato nulo";
				}
				try{
				lormEmpresa.setTelefono(empresa.getTelefono());
				} catch (NullPointerException e) {
					e.printStackTrace();
					msg = "Dato nulo";
				}
				try{
				lormEmpresa.setRazonSocial(empresa.getRazonSocial());
				} catch (NullPointerException e) {
					e.printStackTrace();
					msg = "Dato nulo";
				}
				
				msg = "Ingreso exitoso";
				orm.EmpresaDAO.save(lormEmpresa);
				t.commit();
			} catch (Exception e) {
				t.rollback();
				msg = "Ingreso fallido";
			}
	//	} catch (NullPointerException e) {
		//	e.printStackTrace();
	//	}
		return msg;
	}

	/**
	 * Metodo para eliminar datos de la base de datos
	 * 
	 * @param empresa de tipo Empresa
	 * @return msg retorna mensaje de tipo String
	 * @throws PersistentException
	 */
	public static String eliminar(Empresa empresa) throws PersistentException {
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession()
				.beginTransaction();
		String msg = "";
		try {
			try {
				orm.Empresa lormEmpresa = orm.EmpresaDAO.loadEmpresaByQuery("Empresa.rut = '" + empresa.rut + "'",
						null);// loadEmpresaByORMID(empresa.uid);//orm.ContactoDAO.loadContactoByQuery("Contacto.nombre='Victor'",
								// null);
				// Delete the persistent object
				orm.EmpresaDAO.delete(lormEmpresa);
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
	 * Metodo para listar los datos de empresa de la base de datos
	 * 
	 * @return ArrayList retorna un arreglo con la lista empresa
	 * @throws PersistentException
	 */
	private static final int ROW_COUNT = 100;

	public static List<Empresa> listar() throws PersistentException {

		List<orm.Empresa> listaEmpresaOrm = orm.EmpresaDAO.queryEmpresa(null, null);
		List<Empresa> listaEmpresa = new ArrayList<>();

		for (orm.Empresa empresaOrm : listaEmpresaOrm) {
			Empresa empresa = new Empresa();
			empresa.setRut(empresaOrm.getRut());
			empresa.setNombre(empresaOrm.getNombre());
			empresa.setCiudad(empresaOrm.getCiudad());
			empresa.setDireccion(empresaOrm.getDireccion());
			empresa.setPais(empresaOrm.getPais());
			empresa.setTelefono(empresaOrm.getTelefono());
			empresa.setRazonSocial(empresaOrm.getRazonSocial());
			listaEmpresa.add(empresa);
		}
		System.out.println(" record(s) retrieved.");
		return listaEmpresa;
	}

	/**
	 * Metodo que permite actualizar datos de empresa en la base de datos
	 * 
	 * @param empresa de tipo Empresa
	 * @return msg String retorna un mensaje
	 * @throws PersistentException
	 */
	public static String actualizar(Empresa empresa) throws PersistentException {
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession()
				.beginTransaction();
		String msg = "";
		//try {
			try {
				orm.Empresa lormEmpresa = orm.EmpresaDAO.loadEmpresaByORMID(empresa.uid);// orm.ContactoDAO.loadContactoByQuery("Contacto.nombre='"+
																							// +"'",
																							// null);
				// Update the properties of the persistent object
				System.out.println("id: " + empresa.uid);
				try{
				lormEmpresa.setRut(empresa.rut);
				} catch (NullPointerException e) {
					e.printStackTrace();
					msg = "Dato nulo";
				}
				try{
				lormEmpresa.setNombre(empresa.nombre);
				} catch (NullPointerException e) {
					e.printStackTrace();
					msg = "Dato nulo";
				}
				try{
				lormEmpresa.setCiudad(empresa.ciudad);
				} catch (NullPointerException e) {
					e.printStackTrace();
					msg = "Dato nulo";
				}
				try{
				lormEmpresa.setDireccion(empresa.direccion);
				} catch (NullPointerException e) {
					e.printStackTrace();
					msg = "Dato nulo";
				}
				try{
				lormEmpresa.setPais(empresa.pais);
				} catch (NullPointerException e) {
					e.printStackTrace();
					msg = "Dato nulo";
				}
				try{
				lormEmpresa.setTelefono(empresa.telefono);
				} catch (NullPointerException e) {
					e.printStackTrace();
					msg = "Dato nulo";
				}
				try{
				lormEmpresa.setRazonSocial(empresa.razonSocial);
				} catch (NullPointerException e) {
					e.printStackTrace();
					msg = "Dato nulo";
				}

				System.out.println("Ingreso exitoso");
				msg = "datos actualizados";
				orm.EmpresaDAO.save(lormEmpresa);
				t.commit();

			} catch (Exception e) {
				t.rollback();
			}
	//	} catch (NullPointerException e) {
		//	e.printStackTrace();
		//}
		return msg;
	}
}
