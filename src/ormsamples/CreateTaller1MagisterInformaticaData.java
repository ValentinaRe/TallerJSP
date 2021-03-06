/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateTaller1MagisterInformaticaData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().beginTransaction();
		try {
			orm.Contacto lormContacto = orm.ContactoDAO.createContacto();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : anotacion, empresauid, ciudad, region, pais, telefono, mail, apellido, nombre, run
			orm.ContactoDAO.save(lormContacto);
			orm.Usuario lormUsuario = orm.UsuarioDAO.createUsuario();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : pass, usuario
			orm.UsuarioDAO.save(lormUsuario);
			orm.Empresa lormEmpresa = orm.EmpresaDAO.createEmpresa();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : contacto, razonSocial, telefono, pais, direccion, ciudad, nombre, rut
			orm.EmpresaDAO.save(lormEmpresa);
			orm.Anotacion lormAnotacion = orm.AnotacionDAO.createAnotacion();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : contactouid, descripcion, nombre
			orm.AnotacionDAO.save(lormAnotacion);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateTaller1MagisterInformaticaData createTaller1MagisterInformaticaData = new CreateTaller1MagisterInformaticaData();
			try {
				createTaller1MagisterInformaticaData.createTestData();
			}
			finally {
				orm.Taller1MagisterInformaticaPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
