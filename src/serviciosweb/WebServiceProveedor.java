package serviciosweb;



import java.util.List;

import org.orm.PersistentException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import capanegocio.Contacto;

public class WebServiceProveedor {
  
	public String listar(){
		String listaResultado="";
		try {
		    Gson gson = new GsonBuilder().create();
			List<Contacto> listaContacto=Contacto.listar();
			listaResultado = gson.toJson(listaContacto);
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaResultado;
	}
	
	
	public String eliminar( int uid){
		String respuesta="";
		Contacto contacto=new Contacto();
		contacto.setUid(uid);
		try {
			Contacto.eliminar(contacto);
   		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return respuesta;
}
	
  public String ingreso(String nombre,String apellido,String mail,String telefono,String pais,String region,
				String ciudad){
			        String respuesta = "no se pudo almacenar el contacto";
			        
			        Contacto contacto = new Contacto();
			        contacto.setNombre(nombre);
			        contacto.setApellido(apellido);
			        contacto.setTelefono(telefono);
			        contacto.setPais(pais);
			        contacto.setRegion(region);
			        contacto.setCiudad(ciudad);

			        try {
			            Contacto.ingresar(contacto);
			           
			        } catch (PersistentException ex) {
			        	// TODO Auto-generated catch block
			 			ex.printStackTrace();
			        }
			        return respuesta;
			    }
			   
     public String actualizar(int uid,String nombre,String apellido,String mail,String telefono,String pais,String region,
						String ciudad) {

			        String respuesta = "";
			    
			        Contacto contacto = new Contacto();
			        contacto.setUid(uid);
			        contacto.setNombre(nombre);
			        contacto.setApellido(apellido);
			        contacto.setTelefono(telefono);
			        contacto.setPais(pais);
			        contacto.setRegion(region);
			        contacto.setCiudad(ciudad);
			        try {
			         Contacto.actualizar(contacto);
			          
			        } catch (PersistentException ex) {
			        	// TODO Auto-generated catch block
			 			ex.printStackTrace();
			        }
			        return respuesta;
			    }
		

	
}
