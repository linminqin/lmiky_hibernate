package com.lmiky.jdp.user.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lmiky.jdp.database.dao.hibernate.BaseDAOImpl;
import com.lmiky.jdp.database.exception.DatabaseException;
import com.lmiky.jdp.user.dao.UserDAO;
import com.lmiky.jdp.user.pojo.Operator;
import com.lmiky.jdp.user.pojo.Role;

/**
 * @author lmiky
 * @date 2014年8月13日 下午10:52:30
 */
@Repository("userDAO")
public class UserDAOImpl extends BaseDAOImpl implements UserDAO {

	/* (non-Javadoc)
	 * @see com.lmiky.jdp.user.dao.UserDAO#listNoUserRoles(java.lang.Long)
	 */
	@Override
	public List<Role> listNoUserRoles(Long userId) throws DatabaseException {
		try {
			String hql = "from Role Role where not exists (select 1 from Role r join r.users u where u.id = " + userId + " and Role.id = r.id) ORDER BY Role.name ";
			return list(hql);
		} catch (Exception e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see com.lmiky.jdp.user.dao.UserDAO#listNoRoleUser(java.lang.Long)
	 */
	@Override
	public List<Operator> listNoRoleUser(Long roleId) throws DatabaseException {
		try {
			String hql = "from Operator Operator where not exists (select 1 from Operator u join u.roles r where r.id = " + roleId + " and Operator.id = u.id) ORDER BY Operator.name ";
			return list(hql);
		} catch (Exception e) {
			throw new DatabaseException(e.getMessage());
		}
	}

}
