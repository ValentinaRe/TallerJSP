package serviciosweb;



import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;

import org.orm.PersistentException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import capanegocio.Contacto;

public class WebServiceProveedor {
  
	@WebMethod(operationName="BusquedaSimpleContacto")
	public String busquedaSimple(@WebParam(name="busqueda")String busqueda) throws PersistentException{
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
}