package br.com.saude.entidade;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Medicamento.class)
public abstract class Medicamento_ {

	public static volatile SingularAttribute<Medicamento, String> controlado;
	public static volatile SingularAttribute<Medicamento, BigDecimal> estoque;
	public static volatile SingularAttribute<Medicamento, String> nome;
	public static volatile SingularAttribute<Medicamento, Long> id;
	public static volatile SingularAttribute<Medicamento, String> descricao;

}

