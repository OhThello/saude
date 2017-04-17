package br.com.saude.entidade;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Paciente.class)
public abstract class Paciente_ extends br.com.saude.entidade.Pessoa_ {

	public static volatile SingularAttribute<Paciente, String> numeroProtuario;
	public static volatile SingularAttribute<Paciente, String> nomeMae;
	public static volatile SingularAttribute<Paciente, String> cartaoSus;

}

