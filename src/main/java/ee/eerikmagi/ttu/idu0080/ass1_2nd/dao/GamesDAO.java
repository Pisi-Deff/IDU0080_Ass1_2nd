package ee.eerikmagi.ttu.idu0080.ass1_2nd.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import ee.eerikmagi.ttu.idu0080.ass1_2nd.model.db.Game;

public class GamesDAO {
	@Inject
	private Provider<Session> sessionProvider;
	
	public List<Game> list() {
		Session s = session();
		CriteriaBuilder builder = s.getCriteriaBuilder();
		CriteriaQuery<Game> crit = builder.createQuery(Game.class);
		Root<Game> root = crit.from(Game.class);
		crit.select(root);
		return s.createQuery(crit).getResultList();
	}
	
	private Session session() {
		return sessionProvider.get();
	}
}
