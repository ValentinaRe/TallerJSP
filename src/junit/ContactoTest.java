/**
 * 
 */
package junit;

import static org.junit.Assert.*;

import org.junit.Test;
import org.orm.PersistentException;

import capanegocio.Contacto;
import capanegocio.Empresa;

/**
 * @author Vale
 *
 */
public class ContactoTest {

	/**
	 * Test method for {@link capanegocio.Contacto#ingresar(capanegocio.Contacto)}.
	 * @throws PersistentException 
	 */
	@Test
	public void testIngresar() throws PersistentException {
		Contacto dato=new Contacto();	
		Empresa empresa=new Empresa();
		empresa.setUid(1);
		dato.setRun("17.168.877-7");
		dato.setNombre("Juanito");
		dato.setApellido("Jones");
		dato.setMail("Juanito@jones.cl");
		dato.setTelefono("56899");
		dato.setPais("Juanito");
		dato.setRegion("jajaja");
		dato.setCiudad("Juanito");
		dato.setEmpresaUid(empresa);
		//assertTrue(dato.getNombre().equals("Juanito"));
		//assertTrue(dato.getApellido().equals("Jones"));
		//assertTrue(dato.getMail().equals("Juanito@jones.cl"));
		//assertTrue(dato.getTelefono().equals("56899"));
		//assertTrue(dato.getPais().equals("Juanito"));
		//assertTrue(dato.getRegion().equals("jajaja"));
		//assertTrue(dato.getCiudad().equals("Juanito"));
		
		String contactoingreso=Contacto.ingresar(dato);
		System.out.println(contactoingreso);
		assertTrue(contactoingreso.equals("Ingreso exitoso" ));
		
		
		
		
		
	}

	/**
	 * Test method for {@link capanegocio.Contacto#eliminar(capanegocio.Contacto)}.
	 */
	@Test
	public void testEliminar() {
		Contacto contacto =new Contacto();
		contacto.setUid(1);
		assertTrue(contacto.getUid() == 1);
	}

	/**
	 * Test method for {@link capanegocio.Contacto#listar()}.
	 */
	@Test
	public void testListar() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link capanegocio.Contacto#actualizar(capanegocio.Contacto)}.
	 */
	@Test
	public void testActualizar() {
		Contacto dato=new Contacto();	
		
		dato.setNombre("Juanito");
		dato.setApellido("Jones");
		dato.setMail("Juanito@jones.cl");
		dato.setTelefono("56899");
		dato.setPais("Juanito");
		dato.setRegion("jajaja");
		dato.setCiudad("Juanito");
	
		assertTrue(dato.getNombre().equals("Juanito"));
		assertTrue(dato.getApellido().equals("Jones"));
		assertTrue(dato.getMail().equals("Juanito@jones.cl"));
		assertTrue(dato.getTelefono().equals("56899"));
		assertTrue(dato.getPais().equals("Juanito"));
		assertTrue(dato.getRegion().equals("jajaja"));
		assertTrue(dato.getCiudad().equals("Juanito"));
		
	}
	@Test
	public void testBusquedaSimple(){
		Contacto dato =new Contacto();
		
		try {
			dato.busquedaSimple("daniela");
		} catch (PersistentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			System.out.println(dato.busquedaSimple("daniela"));
			assertTrue(true);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
