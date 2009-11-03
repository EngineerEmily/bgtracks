package org.csc480.projectsite.web.dataaccess;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.csc480.projectsite.web.data.Authority;
import org.csc480.projectsite.web.data.UserDetail;
import org.csc480.projectsite.web.data.UserDetailAuthority;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.security.providers.dao.salt.ReflectionSaltSource;
import org.springframework.security.providers.encoding.ShaPasswordEncoder;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UserDetailsService;

public class UserDetailAccess extends HibernateDaoSupport implements
		UserDetailsService {
	protected final Log logger = LogFactory.getLog(getClass());
	private static ShaPasswordEncoder encoder = new ShaPasswordEncoder(256);

	public void setEncoder(ShaPasswordEncoder encoder) {
		UserDetailAccess.encoder = encoder;
	}

	public ShaPasswordEncoder getEncoder() {
		return encoder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.springframework.security.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) {

		UserDetail ud = null;
		if (username != null) {
			HibernateTemplate ht = this.getHibernateTemplate();
			if (ht != null) {
				try {
					List<UserDetail> users = ht
							.find("from UserDetail ud where ud.username = '"
									+ username + "'");
					if (users != null && users.size() == 1) {
						ud = (UserDetail) users.get(0);
						ud
								.setUserDetailAuthorityCollection(loadUserAuthorities(ud
										.getId()));
					}
				} catch (Exception ex) {
					logger.error(ex.getMessage());
				}
			} else {
				logger.warn("The HibernateTemplate was null");
			}
		} else {
			logger.warn("An username must be supplied");
		}

		return ud;
	}

	public boolean deleteUserByUserId(int userId) {
		boolean result = false;
		HibernateTemplate ht = this.getHibernateTemplate();
		if (ht != null) {
			try {
				UserDetail ud = loadUserByUserId(userId);
				if (ud != null)
					ht.delete(ud);
				result = true;
			} catch (Exception ex) {
				logger.error(ex);
			}
		}
		return result;

	}

	public UserDetail loadUserByUserId(int userId) {
		UserDetail ud = null;
		HibernateTemplate ht = this.getHibernateTemplate();
		if (ht != null) {
			List<UserDetail> uds = ht.find("from UserDetail ud where ud.id = "
					+ userId);
			if (uds.size() == 1) {
				ud = uds.get(0);

			}

		}
		return ud;
	}

	/**
	 * Checks if the given user name is unique in the database
	 * 
	 * @param username
	 *            User name of the user you are checking uniqueness for
	 * @return True is the user name is unique, false otherwise
	 */
	public boolean checkUserNameAvailable(String username) {

		boolean result = true;
		if (username != null) {
			HibernateTemplate ht = this.getHibernateTemplate();
			if (ht != null) {
				try {
					List<UserDetail> users = ht
							.find("from UserDetail ud where ud.username = '"
									+ username + "'");
					if (users != null) {
						// if the user is not unique return false
						result = !(users.size() > 0);
					}
				} catch (Exception ex) {
					logger.error(ex.getMessage());
				}
			} else {
				logger.warn("The HibernateTemplate was null");
			}
		} else {
			logger.warn("An username must be supplied");
		}

		return result;
	}

	/**
	 * Loads the UserDetail objects from the database for use in a list. The
	 * result does not include the child data objects such as the Authorities.
	 * 
	 * @param page
	 *            Current page of data for the query
	 * @param rows
	 *            Row count per page for the query
	 * @param column
	 *            User Detail field that is to be sorted
	 * @param order
	 *            Order for the sorted column {desc,asc}
	 * @return Paged list of UserDetail objects based on the input parameters
	 */
	public List<UserDetail> loadUsers(int page, int rows, String column,
			String order, String searchField, String searchString) {
		List<UserDetail> details = null;
		try {
			Criteria crit = this.getSession().createCriteria(UserDetail.class);
			crit.setFirstResult(((page - 1) * rows));
			crit.setMaxResults(rows);
			crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			if (searchField != null && searchField.trim().length() > 0
					&& searchString != null && searchString.trim().length() > 0) {
				if (searchField.toLowerCase().equals("enabled")) {

					crit.add(Restrictions.eq(searchField, searchString
							.toLowerCase().equals("true") ? true : false));

				} else {
					crit.add(Restrictions.ilike(searchField, "%" + searchString
							+ "%"));
				}
			}
			if (column.trim().length() > 0) {
				if (order.toLowerCase().equals("desc")) {
					crit.addOrder(Order.desc(column));
				} else {
					crit.addOrder(Order.asc(column));
				}
			} else {
				crit.addOrder(Order.desc("username"));
			}

			List<UserDetail> users = crit.list();
			if (users != null && users.size() > 0) {
				details = users;
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		return details;
	}

	/**
	 * Loads the row count for a user detail query. Later this function will be
	 * augmented with a search criteria.
	 * 
	 * @return The row count for the user detail query
	 */
	public int getUserCount(String searchField, String searchString) {
		int rowCount = 0;
		try {
			Criteria crit = this.getSession().createCriteria(UserDetail.class);
			crit.setProjection(Projections.rowCount());
			crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			if (searchField != null && searchField.trim().length() > 0
					&& searchString != null && searchString.trim().length() > 0) {
				if (searchField.toLowerCase().equals("enabled")) {

					crit.add(Restrictions.eq(searchField, searchString
							.toLowerCase().equals("true") ? true : false));

				} else {
					crit.add(Restrictions.ilike(searchField, "%" + searchString
							+ "%"));
				}
			}
			List<Integer> rowCountList = crit.list();
			if (rowCountList != null && rowCountList.size() == 1) {
				rowCount = rowCountList.get(0);
			}

		} catch (Exception ex) {
			logger.error(ex);
		}
		return rowCount;
	}

	/**
	 * Loads the Authority objects that are available for use
	 * 
	 * @return List of authority objects from the lookup table in the database
	 */
	public List<Authority> loadAuthorities() {
		List<Authority> authorities = null;
		try {

			Criteria crit = this.getSession().createCriteria(Authority.class);
			crit.addOrder(Order.asc("authority"));
			List<Authority> lst = crit.list();
			if (lst != null && lst.size() > 0) {
				authorities = lst;
			}
		} catch (Exception ex) {
			logger.error(ex);
		}
		return authorities;
	}

	public boolean addRole(String role) {
		boolean result = false;
		if (role != null && role.trim().length() > 0) {
			if (!role.toLowerCase().startsWith("role_")) {
				role = "ROLE_" + role.toUpperCase();
			}
			try {
				HibernateTemplate ht = this.getHibernateTemplate();
				if (ht != null) {
					Authority a = new Authority();
					a.setAuthority(role);
					ht.save(a);

					result = true;
				}
			} catch (Exception ex) {
				logger.error(ex);
			}
		}
		return result;
	}

	/**
	 * Loads the UserDetailAuthoritys for the specified user
	 * 
	 * @param userid
	 *            User id of the the roles whose authorities are being loaded
	 * @return The list of UserDetailAuthority objects for the given user
	 */
	public List<UserDetailAuthority> loadUserAuthorities(int userid) {
		List<UserDetailAuthority> roles = null;
		try {
			Criteria crit = this.getSession().createCriteria(
					UserDetailAuthority.class);
			crit.add(Restrictions.eq("userDetailId", userid));
			crit.addOrder(Order.asc("authority"));

			List<UserDetailAuthority> lst = crit.list();
			if (lst != null && lst.size() > 0) {
				roles = lst;
			} else {
				logger
						.warn("This user does not have any roles or the user does not exist. This condition  where the user does not have roles should not exist");
			}
		} catch (Exception ex) {
			logger.error(ex);
		}
		return roles;
	}

	/**
	 * Loads the users roles from the database and the takes the new role list
	 * and finds that roles that are no longer attributed to the user. Once a
	 * role is determined to no longer be attributed to the user, it is deleted
	 * from the database.
	 * 
	 * @param list
	 *            List of UserDetailAuthority objects that are the new state for
	 *            the user
	 * @param username
	 *            User name for the user who is having the authorities updated
	 * @return true if the user's unreferenced roles were successfully deleted,
	 *         false otherwise
	 */
	private boolean deleteUnReferencedRoles(List<UserDetailAuthority> list,
			String username) {
		boolean result = false;
		HibernateTemplate ht = this.getHibernateTemplate();
		if (ht != null) {
			Criteria crit = this.getSession().createCriteria(UserDetail.class);
			crit.add(Restrictions.eq("username", username));
			crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			UserDetail user = (UserDetail) loadUserByUsername(username);
			if (user != null && user.getUserDetailAuthorityCollection() != null) {
				for (UserDetailAuthority uda : user
						.getUserDetailAuthorityCollection()) {
					boolean roleFound = false;
					for (UserDetailAuthority uda1 : list) {
						if (uda1.getAuthority().equals(uda.getAuthority())) {
							roleFound = true;
							continue;
						}
					}
					if (roleFound == false) {
						ht.delete(uda);
					}
				}
			}
		} else {
			logger.warn("The HibernateTemplate was null");
		}
		return result;
	}

	/**
	 * Updates the user and associated object data in the database
	 * 
	 * @param ud
	 *            User detail object for the the user that is being updated
	 * @return true if the user was successfully udpated, false otherwise
	 */
	public boolean updateUserDetail(UserDetail ud) {
		boolean result = false;
		HibernateTemplate ht = this.getHibernateTemplate();
		if (ht != null) {
			if (ud != null) {
				try {
					UserDetail oldUser = (UserDetail) loadUserByUserId(ud
							.getId());
					ud.setCreated(oldUser.getCreated());
					ud.setEmployeeId(oldUser.getEmployeeId());
					boolean passwordChangeSubmitted = ud.getPassword() != null
							&& ud.getPassword().trim().length() > 0;
					String encPassword = null;
					if (passwordChangeSubmitted) {
						encPassword = encryptPassword(ud.getPassword(), ud);
					}

					// The condition that should hold true is if the user has
					// not changed the password in the user interface or the new
					// password was successful in being encrypted. The attempt
					// here is to ensure that if the password failed to encrypt
					// that the whole user update is not committed. This will
					// lead to a user not being able to be logged in because the
					// password may not match.
					if (!passwordChangeSubmitted || encPassword != null) {
						// if the password was changed use it, else use the
						// oldpassword and update
						ud.setPassword(passwordChangeSubmitted ? encPassword
								: oldUser.getPassword());
						ht.update(ud);
						deleteUnReferencedRoles(ud
								.getUserDetailAuthorityCollection(), ud
								.getUsername());
						for (UserDetailAuthority uda : ud
								.getUserDetailAuthorityCollection()) {
							if (uda.getAddDeleteAction() == 1) {
								ht.delete(uda);
							} else if (uda.getAddDeleteAction() == 0) {
								uda.setUserDetailId(ud.getId());
								ht.save(uda);
							}
						}

						result = true;
					} else {
						logger
								.error("Password failed to encrypt. Updating user was cancelled");
					}
				} catch (Exception ex) {
					logger.error(ex);
				}
			}
		} else {
			logger.warn("The HibernateTemplate was null");
		}
		return result;
	}

	/**
	 * Adds a user detail object and associated data to the database
	 * 
	 * @param ud
	 *            User detail object representing the user that is being added
	 * @return true if the user was successfully added, false otherwise
	 */
	public boolean addUserDetail(UserDetail ud) {
		boolean result = false;
		HibernateTemplate ht = this.getHibernateTemplate();
		if (ht != null) {
			if (ud != null) {
				try {
					ud.setCreated(new Date());
					ud.setEmployeeId(ud.getId());
					ht.save(ud);
					UserDetail newUd = (UserDetail) loadUserByUsername(ud
							.getUsername());
					String encPassword = encryptPassword(newUd.getPassword(),
							newUd);
					if (encPassword != null) {
						newUd.setPassword(encPassword);
						ht.saveOrUpdate(newUd);

						if (ud.getUserDetailAuthorityCollection() != null) {
							for (UserDetailAuthority uda : ud
									.getUserDetailAuthorityCollection()) {
								uda.setUserDetailId(newUd.getId());
								ht.save(uda);
							}
						}
						result = true;
					} else {
						logger
								.error("Password failed to encrypt. Adding user was cancelled");
					}
				} catch (Exception ex) {
					logger.error(ex);
				}
			}
		} else {
			logger.warn("The HibernateTemplate was null");
		}
		return result;
	}

	/**
	 * Updates the user password once the old password was confirmed to match
	 * what is in the database.
	 * 
	 * @param ud
	 *            userdetail object for the user wishing to change the password
	 * @param oldPassword
	 *            current password that can be compared to ensure security
	 * @param newPassword
	 *            new password that is being set
	 * @return true if the password was successfully updated, false otherwise
	 */
	public boolean updatePassword(UserDetail ud, String oldPassword,
			String newPassword) {
		boolean result = false;
		if (ud != null && oldPassword != null && newPassword != null) {
			String oldEncrypted = encryptPassword(oldPassword, ud);
			if (oldEncrypted != null) {
				if (ud.getPassword().equals(oldEncrypted)) {
					ud.setPassword(newPassword);
					updateUserDetail(ud);
					result = true;

				}
			} else {
				logger
						.error("Old password failed to encrypt.  Update was cancelled");
			}
		}

		return result;
	}

	/**
	 * Encrypts the password using the hashing function and salt property
	 * specified in the applicationContext-security.xml
	 * 
	 * @param text
	 *            a unencrypted string that represents the cleartext password
	 * @param ud
	 *            a userdetail object for the user who is encrypting the
	 *            password
	 * @return the encrypted password
	 */
	public synchronized String encryptPassword(String text, UserDetail ud) {
		String password = null;
		try {
			if (ud != null && text != null) {
				ReflectionSaltSource rss = new ReflectionSaltSource();
				rss.setUserPropertyToUse("id");
				Object o = rss.getSalt(ud);
				password = encoder.encodePassword(text, rss.getSalt(ud));
			} else {
				logger
						.warn("A userdetail object and unencrypted text must be supplied");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
		return password;
	}

	/**
	 * Find users
	 * 
	 * @param searchString
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<UserDetail> findUsers(String searchString, String sortColumn,
			String sortDirection) {

		String[] tokens = searchString.split(" ");
		String[] columns = new String[] { "firstName", "lastName", "username" }; // Note,
		// there
		// has
		// to
		// be
		// at
		// least
		// 2
		// columns
		// or
		// this
		// algorithm
		// will
		// fail

		Criteria crit = this.getSession().createCriteria(UserDetail.class);
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		logger.info("Is Ascending ("+sortDirection+")" + sortDirection.toLowerCase().startsWith("a"));
		if (sortColumn.trim().length() > 0) {
			crit.addOrder(sortDirection.toLowerCase().startsWith("a") ? Order
					.asc(sortColumn) : Order.desc(sortColumn));
		} else {
			crit.addOrder(Order.asc("username"));
		}

		LogicalExpression orExp = null;
		Criterion firstCrit = null;
		for (String token : tokens) {
			if (token.trim().length() > 0) {
				// Loop through each column to compare
				for (String column : columns) {
					Criterion thisCrit = Restrictions.like(column, '%' + token
							.trim() + '%');

					// First iteration, set the first criteria as we need two to
					// create the orExp
					if (firstCrit == null) {
						firstCrit = thisCrit;
					}

					// Second iteration, create the or expression by combining
					// the first criteria and this one
					else if (orExp == null) {
						orExp = Restrictions.or(firstCrit, thisCrit);
					}

					// Subsequent iteration, compound the or expression
					else {
						orExp = Restrictions.or(orExp, thisCrit);
					}
				}

			}

		}
		if (orExp != null) {
			crit.add(orExp);
		}
		crit.add(Restrictions.ne("username", "system"));
		List<UserDetail> users = crit.list();
		return users;
	}
}
