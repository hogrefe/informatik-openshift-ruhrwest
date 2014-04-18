package org.insultapp.generators;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@InsultGeneratorQualifier(type = InsultGeneratorType.POSTGRES)
public class PostgresInsultGenerator implements InsultGenerator {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public String insult() {
		return "Thou " + generateResult() + "!";
	}

	@Override
	public String namedInsult(String name) {
		return name + " , thou " + generateResult() + "!";
	}

	private String generateResult() {
		return getWord("short_adjective") + " " + getWord("long_adjective")
				+ " " + getWord("noun");
	}

	private String getWord(String table) {
		String sql = "select string from " + table
				+ " offset random()* (select count(*) from " + table
				+ ") limit 1;";
		List results = entityManager.createNativeQuery(sql).getResultList();
		return (String)results.get(0);
	}

}
