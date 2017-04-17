package br.com.saude.entidade;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SaidaMedicamento.class)
public abstract class SaidaMedicamento_ {

	public static volatile SingularAttribute<SaidaMedicamento, String> observacao;
	public static volatile ListAttribute<SaidaMedicamento, ItensSaida> itensSaidas;
	public static volatile SingularAttribute<SaidaMedicamento, Long> id;
	public static volatile SingularAttribute<SaidaMedicamento, Date> dataSaida;

}

