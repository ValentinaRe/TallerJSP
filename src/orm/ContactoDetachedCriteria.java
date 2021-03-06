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

public class ContactoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression uid;
	public final StringExpression run;
	public final StringExpression nombre;
	public final StringExpression apellido;
	public final StringExpression mail;
	public final StringExpression telefono;
	public final StringExpression pais;
	public final StringExpression region;
	public final StringExpression ciudad;
	public final StringExpression fotoCont;
	public final IntegerExpression empresauidId;
	public final AssociationExpression empresauid;
	public final CollectionExpression anotacion;
	
	public ContactoDetachedCriteria() {
		super(orm.Contacto.class, orm.ContactoCriteria.class);
		uid = new IntegerExpression("uid", this.getDetachedCriteria());
		run = new StringExpression("run", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		apellido = new StringExpression("apellido", this.getDetachedCriteria());
		mail = new StringExpression("mail", this.getDetachedCriteria());
		telefono = new StringExpression("telefono", this.getDetachedCriteria());
		pais = new StringExpression("pais", this.getDetachedCriteria());
		region = new StringExpression("region", this.getDetachedCriteria());
		ciudad = new StringExpression("ciudad", this.getDetachedCriteria());
		fotoCont = new StringExpression("fotoCont", this.getDetachedCriteria());
		empresauidId = new IntegerExpression("empresauid.uid", this.getDetachedCriteria());
		empresauid = new AssociationExpression("empresauid", this.getDetachedCriteria());
		anotacion = new CollectionExpression("ORM_Anotacion", this.getDetachedCriteria());
	}
	
	public ContactoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.ContactoCriteria.class);
		uid = new IntegerExpression("uid", this.getDetachedCriteria());
		run = new StringExpression("run", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		apellido = new StringExpression("apellido", this.getDetachedCriteria());
		mail = new StringExpression("mail", this.getDetachedCriteria());
		telefono = new StringExpression("telefono", this.getDetachedCriteria());
		pais = new StringExpression("pais", this.getDetachedCriteria());
		region = new StringExpression("region", this.getDetachedCriteria());
		ciudad = new StringExpression("ciudad", this.getDetachedCriteria());
		fotoCont = new StringExpression("fotoCont", this.getDetachedCriteria());
		empresauidId = new IntegerExpression("empresauid.uid", this.getDetachedCriteria());
		empresauid = new AssociationExpression("empresauid", this.getDetachedCriteria());
		anotacion = new CollectionExpression("ORM_Anotacion", this.getDetachedCriteria());
	}
	
	public EmpresaDetachedCriteria createEmpresauidCriteria() {
		return new EmpresaDetachedCriteria(createCriteria("empresauid"));
	}
	
	public AnotacionDetachedCriteria createAnotacionCriteria() {
		return new AnotacionDetachedCriteria(createCriteria("ORM_Anotacion"));
	}
	
	public Contacto uniqueContacto(PersistentSession session) {
		return (Contacto) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Contacto[] listContacto(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Contacto[]) list.toArray(new Contacto[list.size()]);
	}
}

