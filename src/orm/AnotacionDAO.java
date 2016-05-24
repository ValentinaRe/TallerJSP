/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package orm;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class AnotacionDAO {
	public static Anotacion loadAnotacionByORMID(int idAnotacion) throws PersistentException {
		try {
			PersistentSession session = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession();
			return loadAnotacionByORMID(session, idAnotacion);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Anotacion getAnotacionByORMID(int idAnotacion) throws PersistentException {
		try {
			PersistentSession session = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession();
			return getAnotacionByORMID(session, idAnotacion);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Anotacion loadAnotacionByORMID(int idAnotacion, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession();
			return loadAnotacionByORMID(session, idAnotacion, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Anotacion getAnotacionByORMID(int idAnotacion, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession();
			return getAnotacionByORMID(session, idAnotacion, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Anotacion loadAnotacionByORMID(PersistentSession session, int idAnotacion) throws PersistentException {
		try {
			return (Anotacion) session.load(orm.Anotacion.class, new Integer(idAnotacion));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Anotacion getAnotacionByORMID(PersistentSession session, int idAnotacion) throws PersistentException {
		try {
			return (Anotacion) session.get(orm.Anotacion.class, new Integer(idAnotacion));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Anotacion loadAnotacionByORMID(PersistentSession session, int idAnotacion, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Anotacion) session.load(orm.Anotacion.class, new Integer(idAnotacion), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Anotacion getAnotacionByORMID(PersistentSession session, int idAnotacion, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Anotacion) session.get(orm.Anotacion.class, new Integer(idAnotacion), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAnotacion(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession();
			return queryAnotacion(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAnotacion(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession();
			return queryAnotacion(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Anotacion[] listAnotacionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession();
			return listAnotacionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Anotacion[] listAnotacionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession();
			return listAnotacionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAnotacion(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Anotacion as Anotacion");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryAnotacion(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Anotacion as Anotacion");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Anotacion", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Anotacion[] listAnotacionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryAnotacion(session, condition, orderBy);
			return (Anotacion[]) list.toArray(new Anotacion[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Anotacion[] listAnotacionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryAnotacion(session, condition, orderBy, lockMode);
			return (Anotacion[]) list.toArray(new Anotacion[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Anotacion loadAnotacionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession();
			return loadAnotacionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Anotacion loadAnotacionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession();
			return loadAnotacionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Anotacion loadAnotacionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Anotacion[] anotacions = listAnotacionByQuery(session, condition, orderBy);
		if (anotacions != null && anotacions.length > 0)
			return anotacions[0];
		else
			return null;
	}
	
	public static Anotacion loadAnotacionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Anotacion[] anotacions = listAnotacionByQuery(session, condition, orderBy, lockMode);
		if (anotacions != null && anotacions.length > 0)
			return anotacions[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateAnotacionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession();
			return iterateAnotacionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAnotacionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession();
			return iterateAnotacionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAnotacionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Anotacion as Anotacion");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateAnotacionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Anotacion as Anotacion");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Anotacion", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Anotacion createAnotacion() {
		return new orm.Anotacion();
	}
	
	public static boolean save(orm.Anotacion anotacion) throws PersistentException {
		try {
			orm.Taller1MagisterInformaticaPersistentManager.instance().saveObject(anotacion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(orm.Anotacion anotacion) throws PersistentException {
		try {
			orm.Taller1MagisterInformaticaPersistentManager.instance().deleteObject(anotacion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(orm.Anotacion anotacion)throws PersistentException {
		try {
			if (anotacion.getContactouid() != null) {
				anotacion.getContactouid().anotacion.remove(anotacion);
			}
			
			return delete(anotacion);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(orm.Anotacion anotacion, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (anotacion.getContactouid() != null) {
				anotacion.getContactouid().anotacion.remove(anotacion);
			}
			
			try {
				session.delete(anotacion);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(orm.Anotacion anotacion) throws PersistentException {
		try {
			orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().refresh(anotacion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(orm.Anotacion anotacion) throws PersistentException {
		try {
			orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().evict(anotacion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Anotacion loadAnotacionByCriteria(AnotacionCriteria anotacionCriteria) {
		Anotacion[] anotacions = listAnotacionByCriteria(anotacionCriteria);
		if(anotacions == null || anotacions.length == 0) {
			return null;
		}
		return anotacions[0];
	}
	
	public static Anotacion[] listAnotacionByCriteria(AnotacionCriteria anotacionCriteria) {
		return anotacionCriteria.listAnotacion();
	}
}
