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

public class AnotacionCriteria extends AbstractORMCriteria {
	public final IntegerExpression idAnotacion;
	public final StringExpression nombre;
	public final StringExpression descripcion;
	public final IntegerExpression contactouidId;
	public final AssociationExpression contactouid;
	
	public AnotacionCriteria(Criteria criteria) {
		super(criteria);
		idAnotacion = new IntegerExpression("idAnotacion", this);
		nombre = new StringExpression("nombre", this);
		descripcion = new StringExpression("descripcion", this);
		contactouidId = new IntegerExpression("contactouid.uid", this);
		contactouid = new AssociationExpression("contactouid", this);
	}
	
	public AnotacionCriteria(PersistentSession session) {
		this(session.createCriteria(Anotacion.class));
	}
	
	public AnotacionCriteria() throws PersistentException {
		this(orm.Taller1MagisterInformaticaPersistentManager.instance().getSession());
	}
	
	public ContactoCriteria createContactouidCriteria() {
		return new ContactoCriteria(createCriteria("contactouid"));
	}
	
	public Anotacion uniqueAnotacion() {
		return (Anotacion) super.uniqueResult();
	}
	
	public Anotacion[] listAnotacion() {
		java.util.List list = super.list();
		return (Anotacion[]) list.toArray(new Anotacion[list.size()]);
	}
}

