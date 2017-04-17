package br.com.saude.entidade;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Consulta.class)
public abstract class Consulta_ {

	public static volatile SingularAttribute<Consulta, String> observacao;
	public static volatile SingularAttribute<Consulta, Date> data;
	public static volatile ListAttribute<Consulta, ConsultaItem> consultaItens;
	public static volatile SingularAttribute<Consulta, TipoConsulta> tipoConsulta;
	public static volatile SingularAttribute<Consulta, Paciente> paciente;
	public static volatile SingularAttribute<Consulta, Long> id;

}

