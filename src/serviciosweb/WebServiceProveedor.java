package serviciosweb;



import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;

import org.orm.PersistentException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import capanegocio.Contacto;
import capanegocio.Usuario;

public class WebServiceProveedor {
  
	//@WebMethod(operationName="BusquedaSimpleContacto")
	public String busquedaSimple( String busqueda) throws PersistentException{
		String resultBusqueda="";
		List<Contacto> listaContactos=new ArrayList<Contacto>();
		Contacto contacto=new Contacto();
		Gson listarJson=new GsonBuilder().create();
	try{	
		listaContactos=contacto.busquedaSimple(busqueda);
		if(listaContactos.isEmpty()){
			return "no se encontraron datos";
		}else{
			resultBusqueda=listarJson.toJson(listaContactos);
			return resultBusqueda;
		}
		
	}catch(PersistentException e){
		return e.getMessage();
	}
	
	}
	@WebMethod(operationName = "busquedaAvanzada")
	public String busquedaAvanzada(
			@WebParam(name = "run") String run, 
			@WebParam(name = "nombre") String nombre, 
			@WebParam(name = "apellido") String apellido,
			@WebParam(name = "mail") String mail,
			@WebParam(name = "telefono") String telefono,
			@WebParam(name = "pais") String pais,
			@WebParam(name = "region") String region,
			@WebParam(name = "ciudad") String ciudad) throws PersistentException{
		
		String resultado = "";
		List<Contacto> listarContactos = new ArrayList<Contacto>();
		Contacto contacto = new Contacto();
		
	
		if(run != null){
			contacto.setRun(run);
		}			
		else{
			contacto.setRun("");
		}
		
		if(nombre != null){
			contacto.setNombre(nombre);
		}else{
			contacto.setNombre("");
		}
		
		if(apellido != null){
			contacto.setApellido(apellido);
		}else{
			contacto.setApellido("");
		}
		
		if(mail != null){
			contacto.setMail(mail);
		}else{
			contacto.setMail("");
		}
		
		if(telefono != null){
			contacto.setTelefono(telefono);
		}else{
			contacto.setTelefono("");
		}
		
		if(pais != null){
			contacto.setPais(pais);
		}else{
			contacto.setPais("");
		}
		
		if(region != null){
			contacto.setRegion(region);
		}else{
			contacto.setRegion("");
		}
		if(ciudad!= null){
			contacto.setCiudad(ciudad);
		}else{
			contacto.setCiudad("");
		}
	
		
		Gson listarJson = new GsonBuilder().create();
		
		try{
			listarContactos = contacto.busquedaAvanzada(contacto);
			if(listarContactos.isEmpty()){
				resultado = "no se encontraron datos";
			}else{
				resultado = listarJson.toJson(listarContactos);
			}			
		}catch(PersistentException p){
			resultado = p.getMessage();
		}
		return resultado;
	}
	@WebMethod(operationName = "validacionUsuario")
	public String validacionUsuario(
			@WebParam(name = "usser") String usser,
			@WebParam(name = "pass") String pass) throws PersistentException{
		
		Usuario usuario = new Usuario();
		String valido = "f";
		
		if(usser != null){
			usuario.setUsuario(usser);
		}			
		else{
			usuario.setUsuario("");
		}
		
		if(pass != null){
			usuario.setPass(pass);
		}			
		else{
			usuario.setPass("");
		}
		
		
		
		if(usuario.validacionUsuario(usuario)){
			valido = "verdadero";
		}else{
			valido = "falso";
		}
		
		return valido;
	}
	//@WebMethod(operationName = "busquedaAvanzada")
	/*public String busquedaAvanzada(String busquedaAvanzada)throws PersistentException{
		
		String resultado = "";
		List<Contacto> listarContactos = new ArrayList<Contacto>();
		Contacto contacto = new Contacto();
		Gson listarJson =new Gson();
		try{
			 contacto=listarJson.fromJson(busquedaAvanzada, Contacto.class);
			
		}catch(JsonSyntaxException e){
			return null;
		}
	
		if(contacto.getRun()!= null){
			contacto.setRun(contacto.getRun());
		}			
		else{
			contacto.setRun("");
		}
		
		if(contacto.getNombre() != null){
			contacto.setNombre(contacto.getNombre());
		}else{
			contacto.setNombre("");
		}
		
		if(contacto.getApellido() != null){
			contacto.setApellido(contacto.getApellido());
		}else{
			contacto.setApellido("");
		}
		
		if(contacto.getMail() != null){
			contacto.setMail(contacto.getMail());
		}else{
			contacto.setMail("");
		}
		
		if(contacto.getTelefono()!= null){
			contacto.setTelefono(contacto.getTelefono());
		}else{
			contacto.setTelefono("");
		}
		
		if(contacto.getPais() != null){
			contacto.setPais(contacto.getPais());
		}else{
			contacto.setPais("");
		}
		
		if(contacto.getRegion() != null){
			contacto.setRegion(contacto.getRegion());
		}else{
			contacto.setRegion("");
		}
		if(contacto.getCiudad()!= null){
			contacto.setCiudad(contacto.getCiudad());
		}else{
			contacto.setCiudad("");
		}
	
		
		 listarJson = new GsonBuilder().create();
		
		try{
			listarContactos = contacto.busquedaAvanzada(contacto);
			if(listarContactos.isEmpty()){
				resultado = "no se encontraron datos";
			}else{
				resultado = listarJson.toJson(listarContactos);
			}			
		}catch(PersistentException p){
			resultado = p.getMessage();
		}
		return resultado;
	}*/
}