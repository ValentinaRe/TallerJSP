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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class AnotacionDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression idAnotacion;
	public final StringExpression nombre;
	public final StringExpression descripcion;
	public final IntegerExpression contactouidId;
	public final AssociationExpression contactouid;
	
	public AnotacionDetachedCriteria() {
		super(orm.Anotacion.class, orm.AnotacionCriteria.class);
		idAnotacion = new IntegerExpression("idAnotacion", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
		contactouidId = new IntegerExpression("contactouid.uid", this.getDetachedCriteria());
		contactouid = new AssociationExpression("contactouid", this.getDetachedCriteria());
	}
	
	public AnotacionDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.AnotacionCriteria.class);
		idAnotacion = new IntegerExpression("idAnotacion", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
		contactouidId = new IntegerExpression("contactouid.uid", this.getDetachedCriteria());
		contactouid = new AssociationExpression("contactouid", this.getDetachedCriteria());
	}
	
	public ContactoDetachedCriteria createContactouidCriteria() {
		return new ContactoDetachedCriteria(createCriteria("contactouid"));
	}
	
	public Anotacion uniqueAnotacion(PersistentSession session) {
		return (Anotacion) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Anotacion[] listAnotacion(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Anotacion[]) list.toArray(new Anotacion[list.size()]);
	}
}

