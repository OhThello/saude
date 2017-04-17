package br.com.saude.entidade;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EntradaMedicamento.class)
public abstract class EntradaMedicamento_ {

	public static volatile SingularAttribute<EntradaMedicamento, String> observacao;
	public static volatile ListAttribute<EntradaMedicamento, ItensEntrada> itensEntradas;
	public static volatile SingularAttribute<EntradaMedicamento, Long> id;
	public static volatile SingularAttribute<EntradaMedicamento, Date> dataentrada;

}

