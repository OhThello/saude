package br.com.saude.entidade;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Funcionario.class)
public abstract class Funcionario_ extends br.com.saude.entidade.Pessoa_ {

	public static volatile SingularAttribute<Funcionario, Date> dataDemissao;
	public static volatile SingularAttribute<Funcionario, Setor> setor;
	public static volatile SingularAttribute<Funcionario, BigDecimal> salario;
	public static volatile SingularAttribute<Funcionario, Date> dataAdmissao;

}

