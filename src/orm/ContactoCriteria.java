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

public class ContactoCriteria extends AbstractORMCriteria {
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
	
	public ContactoCriteria(Criteria criteria) {
		super(criteria);
		uid = new IntegerExpression("uid", this);
		run = new StringExpression("run", this);
		nombre = new StringExpression("nombre", this);
		apellido = new StringExpression("apellido", this);
		mail = new StringExpression("mail", this);
		telefono = new StringExpression("telefono", this);
		pais = new StringExpression("pais", this);
		region = new StringExpression("region", this);
		ciudad = new StringExpression("ciudad", this);
		fotoCont = new StringExpression("fotoCont", this);
		empresauidId = new IntegerExpression("empresauid.uid", this);
		empresauid = new AssociationExpression("empresauid", this);
		anotacion = new CollectionExpression("ORM_Anotacion", this);
	}
	
	public ContactoCriteria(PersistentSession session) {
		this(session.createCriteria(Contacto.class));
	}
	
	public ContactoCriteria() throws PersistentException {
		this(orm.Taller1MagisterInformaticaPersistentManager.instance().getSession());
	}
	
	public EmpresaCriteria createEmpresauidCriteria() {
		return new EmpresaCriteria(createCriteria("empresauid"));
	}
	
	public AnotacionCriteria createAnotacionCriteria() {
		return new AnotacionCriteria(createCriteria("ORM_Anotacion"));
	}
	
	public Contacto uniqueContacto() {
		return (Contacto) super.uniqueResult();
	}
	
	public Contacto[] listContacto() {
		java.util.List list = super.list();
		return (Contacto[]) list.toArray(new Contacto[list.size()]);
	}
}

