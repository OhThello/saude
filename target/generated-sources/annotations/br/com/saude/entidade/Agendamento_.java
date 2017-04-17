package br.com.saude.entidade;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Agendamento.class)
public abstract class Agendamento_ {

	public static volatile SingularAttribute<Agendamento, String> observacao;
	public static volatile SingularAttribute<Agendamento, Date> data;
	public static volatile SingularAttribute<Agendamento, Paciente> paciente;
	public static volatile SingularAttribute<Agendamento, TipoAgenda> tipoAgenda;
	public static volatile SingularAttribute<Agendamento, Long> id;
	public static volatile SingularAttribute<Agendamento, String> status;

}

