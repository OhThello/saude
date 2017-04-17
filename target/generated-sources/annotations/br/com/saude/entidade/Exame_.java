package br.com.saude.entidade;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Exame.class)
public abstract class Exame_ {

	public static volatile SingularAttribute<Exame, String> laudo;
	public static volatile SingularAttribute<Exame, Date> data;
	public static volatile SingularAttribute<Exame, Date> horario;
	public static volatile SingularAttribute<Exame, Paciente> paciente;
	public static volatile SingularAttribute<Exame, TipoExame> tipoExame;
	public static volatile SingularAttribute<Exame, Long> id;
	public static volatile SingularAttribute<Exame, String> status;

}

