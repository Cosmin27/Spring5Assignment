package com.cgm.assignment5spring.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cgm.assignment5spring.domain.User;

@Repository
public class UserDAO extends AbstractDAO<User>{
	protected UserDAO() {
		super(User.class);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Map<String, Boolean> getAllUsers(User user) {
		Map<String, Boolean> users = new HashMap<String, Boolean>();
		List<User> usersList = (List<User>) em().createQuery(new StringBuilder().append("SELECT user FROM ")
				.append((User.class).getCanonicalName())
				.append(" user WHERE user.id != ")
				.append(user.getId())
				.toString()).getResultList();
		//System.out.println("TEST: " + user.getFriends().contains(super.findById(4)));
		for(User userFromList : usersList) {
			if(user.getFriends().contains(userFromList)) {
				users.put(userFromList.getUser_name(), true);
				//System.out.println(userFromList.getUser_name() + "  true");
			}
			else {
				users.put(userFromList.getUser_name(), false);
				//System.out.println(userFromList.getUser_name() + "   false");
			}
		}
		return users;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Map<String, Boolean> getAllUsersSearch(User user, String search) {
		Map<String, Boolean> users = new HashMap<String, Boolean>();
		List<User> usersList = (List<User>) em().createQuery(new StringBuilder().append("SELECT user FROM ")
				.append((User.class).getCanonicalName())
				.append(" user WHERE user.id != ")
				.append(user.getId())
				.append(" AND user.user_name LIKE '%")
				.append(search).append("%'").toString()).getResultList();
		//System.out.println("TEST: " + user.getFriends().contains(super.findById(4)));
		for(User userFromList : usersList) {
			if(user.getFriends().contains(userFromList)) {
				users.put(userFromList.getUser_name(), true);
				//System.out.println(userFromList.getUser_name() + "  true");
			}
			else {
				users.put(userFromList.getUser_name(), false);
				//System.out.println(userFromList.getUser_name() + "   false");
			}
		}
		return users;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public User getUserWithUsername(String username) {
		CriteriaBuilder criteriaBuilder = em().getCriteriaBuilder();
		CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
		Root<User> userToSelect = criteriaQuery.from(User.class);
		criteriaQuery.select(userToSelect);
		
		
		criteriaQuery.where(criteriaBuilder.equal(userToSelect.get("user_name"), username));
		Query query = em().createQuery(criteriaQuery);
		User result = (User) query.getSingleResult();

		return result;
		/*return (User) em().createQuery(new StringBuilder().append("SELECT u FROM ")
				.append((User.class).getCanonicalName())
				.append(" u WHERE u.user_name = '")
				.append(username)
				.append("'")
				.toString()).getSingleResult();*/
	}
}
