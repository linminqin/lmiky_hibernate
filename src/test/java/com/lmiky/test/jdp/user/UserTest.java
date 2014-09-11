package com.lmiky.test.jdp.user;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import com.lmiky.jdp.service.BaseService;
import com.lmiky.jdp.service.exception.ServiceException;
import com.lmiky.jdp.user.pojo.Operator;
import com.lmiky.jdp.user.pojo.Role;
import com.lmiky.jdp.user.pojo.User;
import com.lmiky.test.BaseTest;

/**
 * @author lmiky
 * @date 2013-5-7
 */
public class UserTest extends BaseTest {
	private BaseService baseService;

	@Test
	public void testLoadUser() throws ServiceException {
		User user = baseService.find(User.class, 1l);
		System.out.println(user);
	}
	
	@Test
	public void testAddUser() throws Exception {
		User user = new User();
		user.setCreateTime(new Date());
		user.setLastSetPasswordTime(new Date());
		user.setName("测试");
		user.setLoginName("test" + Math.random());
		user.setPassword(DigestUtils.md5Hex(Math.random() + ""));
		user.setValid(User.VALID_YES);
		baseService.save(user);
	}
	
	@Test
	public void testAddRole() throws ServiceException {
		Role role = new Role();
		role.setName("测试角色");
		baseService.save(role);
	}
	
	@Test
	public void testAddUserRole() throws ServiceException {
		Operator user = baseService.find(Operator.class, 3l);
		Role role = baseService.find(Role.class, 2l);
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		user.setRoles(roles);
		baseService.save(user);
	}
	
	@Test
	public void testDeleteUser() throws ServiceException {
		baseService.delete(User.class, 2l);
	}
	
	/**
	 * @return the baseService
	 */
	public BaseService getBaseService() {
		return baseService;
	}

	/**
	 * @param baseService the baseService to set
	 */
	@Resource(name="baseService")
	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}
}
