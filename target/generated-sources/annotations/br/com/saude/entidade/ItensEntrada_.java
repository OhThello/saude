package br.com.saude.entidade;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ItensEntrada.class)
public abstract class ItensEntrada_ {

	public static volatile SingularAttribute<ItensEntrada, EntradaMedicamento> entradaMedicamento;
	public static volatile SingularAttribute<ItensEntrada, Medicamento> medicamento;
	public static volatile SingularAttribute<ItensEntrada, Long> id;
	public static volatile SingularAttribute<ItensEntrada, BigDecimal> quantidade;

}

