package capanegocio;

import java.util.ArrayList;
import java.util.List;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class Usuario {

	private int uid;
	private String user;
	private String pass;
	
	public Usuario() {
		super();
	}
	
	public int getUid() {
		return uid;
	}
	public String getUser() {
			return user;
	}
	public String getPass() {
		return pass;
     }
	public void setUid(int uid) {
		this.uid = uid;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	/**
	 * Permite ingresar los datos de usuario a la base de datos
	 * @param usuario de tipo Usuario
	 * @return msg un mensaje que muestra si hubo un ingreso exitoso
	 * @throws PersistentException
	 */
	public static String ingresar(Usuario usuario) throws PersistentException {
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().beginTransaction();
		String msg="";
		try {
			try{
			orm.Usuario lormUsuario = orm.UsuarioDAO.createUsuario();
			// Initialize the properties of the persistent object here
			
			lormUsuario.setUser(usuario.user);
			lormUsuario.setPass(usuario.pass);
		
			
			msg="Ingreso exitoso";
			orm.UsuarioDAO.save(lormUsuario);
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
	 * Permite eliminar un usuario de la base de datos
	 * @param usuario de tipo Usuario
	 * @return msg mensaje que avisa que los datos fueron eliminados
	 * @throws PersistentException
	 */
	public static String eliminar(Usuario usuario) throws PersistentException {
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().beginTransaction();
		String msg="";
		try {
			try{
			orm.Usuario lormUsuario = orm.UsuarioDAO.loadUsuarioByORMID(usuario.uid);//orm.ContactoDAO.loadContactoByQuery("Contacto.nombre='Victor'", null);
			// Delete the persistent object
			orm.UsuarioDAO.delete(lormUsuario);
			t.commit();
			msg="datos eliminados";
		}
		catch (Exception e) {
			t.rollback();
		}}catch (NullPointerException e) {
			e.printStackTrace();
		}
		return msg;
	}
	/**
	 * Metodo que muestra los datos que estan en la base de datos
	 * @return listaUSuario
	 * @throws PersistentException
	 */
	public static List <Usuario> listar() throws PersistentException {
		
		List <orm.Usuario> listaUsuarioOrm = orm.UsuarioDAO.queryUsuario(null, null);
		List <Usuario> listaUsuario = new ArrayList<>(); 
		
		for (orm.Usuario usuarioOrm:listaUsuarioOrm) {
			Usuario usuario= new Usuario();
			usuario.setUser(usuarioOrm.getUser());
			usuario.setPass(usuarioOrm.getPass());
			
			listaUsuario.add(usuario);
		}
		System.out.println( " record(s) retrieved.");
		return listaUsuario;
	}
	
	/**
	 * Metodo que permite actualizar los datos en la base de datos
	 * @param usuario
	 * @return msg retorna un mensaje que avisa que los datos fueron actualizados
	 * @throws PersistentException
	 */
	public static String actualizar(Usuario usuario) throws PersistentException {
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().beginTransaction();
		String msg="";
		try {
			try{
			orm.Usuario lormUsuario = orm.UsuarioDAO.loadUsuarioByORMID(usuario.uid);//orm.ContactoDAO.loadContactoByQuery("Contacto.nombre='"+ +"'", null);
			// Update the properties of the persistent object
			System.out.println("id: "+usuario.uid);
			lormUsuario.setUser(usuario.user);
			lormUsuario.setPass(usuario.pass);
			
			System.out.println("Ingreso exitoso");
			msg="datos actualizados";
			orm.UsuarioDAO.save(lormUsuario);
			t.commit();
			
		}
		catch (Exception e) {
			t.rollback();
		}}catch (NullPointerException e) {
			e.printStackTrace();
		}
		return msg;
	}
	
public static Usuario busquedaUsuario(Usuario usuarioRec) throws PersistentException {
		Usuario usuario=new Usuario();
		try{
		orm.Usuario usuarioOrm = orm.UsuarioDAO.loadUsuarioByQuery("Usuario.user='"+usuarioRec.getUser()+"'& usuario.pass='"+usuarioRec.getPass()+"'", null);
		
		
		
			usuario.setUser(usuarioOrm.getUser());
			usuario.setPass(usuarioOrm.getPass());
			
			
		
		System.out.println(" record(s) retrieved.");
		return usuario;
		}catch(NullPointerException e){
			e.printStackTrace();
			
			return usuario;
		}
	}
}
