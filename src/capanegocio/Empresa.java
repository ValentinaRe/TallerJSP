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
private String razonSocial;
public Empresa() {
	super();
	// TODO Auto-generated constructor stub
}
public String getRut() {
	return pais;
}
public void setRut(String pais) {
	this.pais = pais;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getCiudad() {
	return ciudad;
}
public void setCiudad(String ciudad) {
	this.ciudad = ciudad;
}
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
public String getPais() {
	return pais;
}
public void setPais(String pais) {
	this.pais = pais;
}

public String getRazonSocial() {
	return pais;
}
public void setRazonSocial(String pais) {
	this.pais = pais;
}

/**
 * Este metodo ingresa datos de la empresa a la base de datos 
 * @param empresa de tipo Empresa
 * @return msg retorna un mensaje de tipo String
 * @throws PersistentException
 */
public static String ingresar(Empresa empresa) throws PersistentException {
	PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().beginTransaction();
	String msg="";
	try {
		try{
		orm.Empresa lormEmpresa = orm.EmpresaDAO.createEmpresa();
		// Initialize the properties of the persistent object here
		lormEmpresa.setRut(empresa.rut);
		lormEmpresa.setNombre(empresa.nombre);
		lormEmpresa.setCiudad(empresa.ciudad);
		lormEmpresa.setDireccion(empresa.direccion);
		lormEmpresa.setPais(empresa.pais);
		lormEmpresa.setRazonSocial(empresa.razonSocial);
        msg="Ingreso exitoso";
		orm.EmpresaDAO.save(lormEmpresa);
		t.commit();
	}
	catch (Exception e) {
		t.rollback();
	}}catch (NullPointerException e) {
		e.printStackTrace();
	}
	return msg; 
}
/**
 * Metodo para eliminar datos de la base de datos
 * @param empresa de tipo Empresa
 * @return msg retorna mensaje de tipo String
 * @throws PersistentException
 */
public static String eliminar(Empresa empresa) throws PersistentException {
	PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().beginTransaction();
	String msg="";
	try{
	  try {
		orm.Empresa lormEmpresa = orm.EmpresaDAO.loadEmpresaByQuery("Empresa.rut = '"+empresa.rut+"'", null);//loadEmpresaByORMID(empresa.uid);//orm.ContactoDAO.loadContactoByQuery("Contacto.nombre='Victor'", null);
		// Delete the persistent object
		orm.EmpresaDAO.delete(lormEmpresa);
		t.commit();
		msg="datos eliminados";
	}
	catch (Exception e) {
		t.rollback();
	} }catch (NullPointerException e) {
		e.printStackTrace();
	}
		return msg;
}
/**
 * Metodo para listar los datos de empresa de la base de datos
 * @return ArrayList retorna un arreglo con la lista empresa
 * @throws PersistentException
 */
private static final int ROW_COUNT = 100;
public static List <Empresa> listar() throws PersistentException {
	
	List <orm.Empresa> listaEmpresaOrm = orm.EmpresaDAO.queryEmpresa(null, null);
	List <Empresa> listaEmpresa = new ArrayList<>(); 
	
	for (orm.Empresa empresaOrm:listaEmpresaOrm) {
		Empresa empresa= new Empresa();
		empresa.setRut(empresaOrm.getRut());
		empresa.setNombre(empresaOrm.getNombre());
		empresa.setCiudad(empresaOrm.getCiudad());
		empresa.setDireccion(empresaOrm.getDireccion());
		empresa.setPais(empresaOrm.getPais());
		empresa.setRazonSocial(empresaOrm.getRazonSocial());
		listaEmpresa.add(empresa);
	}
	System.out.println( " record(s) retrieved.");
	return listaEmpresa;
}
/**
 * Metodo que permite actualizar datos de empresa en la base de datos
 * @param empresa de tipo Empresa
 * @return msg String retorna un mensaje 
 * @throws PersistentException
 */
public static String actualizar(Empresa empresa) throws PersistentException {
	PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().beginTransaction();
	String msg="";
	try {
		try{
		orm.Empresa lormEmpresa = orm.EmpresaDAO.loadEmpresaByORMID(empresa.uid);//orm.ContactoDAO.loadContactoByQuery("Contacto.nombre='"+ +"'", null);
		// Update the properties of the persistent object
		System.out.println("id: "+empresa.uid);
		lormEmpresa.setRut(empresa.rut);
		lormEmpresa.setNombre(empresa.nombre);
		lormEmpresa.setCiudad(empresa.ciudad);
		lormEmpresa.setDireccion(empresa.direccion);
		lormEmpresa.setPais(empresa.pais);
		lormEmpresa.setRazonSocial(empresa.razonSocial);
		
		System.out.println("Ingreso exitoso");
		msg="datos actualizados";
		orm.EmpresaDAO.save(lormEmpresa);
		t.commit();
		
	}
	catch (Exception e) {
		t.rollback();
	}}catch (NullPointerException e) {
		e.printStackTrace();
	}
	return msg;
}
}


