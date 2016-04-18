/**
 * 
 */
package capanegocio;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Vale
 *
 */
public class ContactoTest {

	/**
	 * Test method for {@link capanegocio.Contacto#ingresar(capanegocio.Contacto)}.
	 */
	@Test
	public void testIngresar() {
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

}
