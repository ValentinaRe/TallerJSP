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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class EmpresaCriteria extends AbstractORMCriteria {
	public final IntegerExpression uid;
	public final StringExpression rut;
	public final StringExpression nombre;
	public final StringExpression ciudad;
	public final StringExpression direccion;
	public final StringExpression pais;
	public final StringExpression telefono;
	public final StringExpression razonSocial;
	public final CollectionExpression contacto;
	
	public EmpresaCriteria(Criteria criteria) {
		super(criteria);
		uid = new IntegerExpression("uid", this);
		rut = new StringExpression("rut", this);
		nombre = new StringExpression("nombre", this);
		ciudad = new StringExpression("ciudad", this);
		direccion = new StringExpression("direccion", this);
		pais = new StringExpression("pais", this);
		telefono = new StringExpression("telefono", this);
		razonSocial = new StringExpression("razonSocial", this);
		contacto = new CollectionExpression("ORM_Contacto", this);
	}
	
	public EmpresaCriteria(PersistentSession session) {
		this(session.createCriteria(Empresa.class));
	}
	
	public EmpresaCriteria() throws PersistentException {
		this(orm.Taller1MagisterInformaticaPersistentManager.instance().getSession());
	}
	
	public ContactoCriteria createContactoCriteria() {
		return new ContactoCriteria(createCriteria("ORM_Contacto"));
	}
	
	public Empresa uniqueEmpresa() {
		return (Empresa) super.uniqueResult();
	}
	
	public Empresa[] listEmpresa() {
		java.util.List list = super.list();
		return (Empresa[]) list.toArray(new Empresa[list.size()]);
	}
}

