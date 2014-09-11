package com.lmiky.jdp.user.dao;

import java.util.List;

import com.lmiky.jdp.database.dao.BaseDAO;
import com.lmiky.jdp.database.exception.DatabaseException;
import com.lmiky.jdp.user.pojo.Operator;
import com.lmiky.jdp.user.pojo.Role;

/**
 * @author lmiky
 * @date 2014年8月13日 下午10:44:59
 */
public interface UserDAO extends BaseDAO {

	/**
	 * 列出非用户所拥有的角色
	 * @author lmiky
	 * @date 2014-2-6
	 * @param userId
	 * @return
	 * @throws DatabaseException
	 */
	public List<Role> listNoUserRoles(Long userId) throws DatabaseException;
	
	/**
	 * 获取非角色用户
	 * @author lmiky
	 * @date 2013-5-14
	 * @param roleId
	 * @return
	 * @throws DatabaseException
	 */
	public List<Operator> listNoRoleUser(Long roleId) throws DatabaseException;
}
