package com.lmiky.jdp.authority.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lmiky.jdp.authority.dao.AuthorityDAO;
import com.lmiky.jdp.database.dao.hibernate.BaseDAOImpl;
import com.lmiky.jdp.database.exception.DatabaseException;
import com.lmiky.jdp.service.exception.ServiceException;
import com.lmiky.jdp.user.pojo.Role;

/**
 * 权限dao
 * @author lmiky
 * @date 2014-8-13 下午5:03:53
 */
@Repository("authorityDAO")
public class AuthorityDAOImpl extends BaseDAOImpl implements AuthorityDAO {

	/* (non-Javadoc)
	 * @see com.lmiky.jdp.authority.dao.AuthorityDAO#listAuthorizedOperator(java.lang.String)
	 */
	public List<Role> listAuthorizedOperator(String modulePath) throws DatabaseException {
		try {
			String hql = "select distinct Role from Role Role where exists (select 1 from Authority Authority where Authority.modulePath = '" + modulePath
					+ "' and Authority.operator = Role.id)";
			return list(hql);
		} catch (Exception e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see com.lmiky.jdp.authority.dao.AuthorityDAO#listUnauthorizedOperator(java.lang.String)
	 */
	@Override
	public List<Role> listUnauthorizedOperator(String modulePath) throws DatabaseException {
		try {
			String hql = "select distinct Role from Role Role where not exists (select 1 from Authority Authority where Authority.modulePath = '" + modulePath
					+ "' and Authority.operator = Role.id)";
			return list(hql);
		} catch (Exception e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see com.lmiky.jdp.authority.dao.AuthorityDAO#checkAuthority(java.lang.String, java.lang.Long)
	 */
	@Override
	public boolean checkAuthority(String authorityCode, Long userId) throws ServiceException {
		try {
			StringBuffer hql = new StringBuffer();
			// 检查角色
			hql.append("select 1 from Operator Operator, Authority  Authority join Operator.roles Role where Operator.id = ").append(userId)
					.append(" and Role.id = Authority.operator and Authority.authorityCode = '").append(authorityCode).append("'");
			List<Object[]> result = executeQuery(hql.toString());
			if (result.size() > 0) {
				return true;
			}
		} catch (Exception e) {
			throw new DatabaseException(e.getMessage());
		}
		return false;
	}
}
