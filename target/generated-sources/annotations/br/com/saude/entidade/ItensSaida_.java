package br.com.saude.entidade;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ItensSaida.class)
public abstract class ItensSaida_ {

	public static volatile SingularAttribute<ItensSaida, SaidaMedicamento> saidaMedicamento;
	public static volatile SingularAttribute<ItensSaida, Medicamento> medicamento;
	public static volatile SingularAttribute<ItensSaida, Long> id;
	public static volatile SingularAttribute<ItensSaida, BigDecimal> quantidade;

}

