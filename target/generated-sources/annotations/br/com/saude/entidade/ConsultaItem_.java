package br.com.saude.entidade;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ConsultaItem.class)
public abstract class ConsultaItem_ {

	public static volatile SingularAttribute<ConsultaItem, Medicamento> medicamento;
	public static volatile SingularAttribute<ConsultaItem, Long> id;
	public static volatile SingularAttribute<ConsultaItem, BigDecimal> quantidade;
	public static volatile SingularAttribute<ConsultaItem, Consulta> consulta;

}

