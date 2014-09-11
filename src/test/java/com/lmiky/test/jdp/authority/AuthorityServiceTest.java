package com.lmiky.test.jdp.authority;

import javax.annotation.Resource;

import org.junit.Test;

import com.lmiky.jdp.authority.service.AuthorityService;
import com.lmiky.test.BaseTest;

/**
 * @author lmiky
 * @date 2013-5-24
 */
public class AuthorityServiceTest extends BaseTest {
	private AuthorityService authorityService;

	@Test
	public void testCheckAuthority() {
		try {
			System.out.println(authorityService.checkAuthority("jdp_authorize", 1l));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the authorityService
	 */
	public AuthorityService getAuthorityService() {
		return authorityService;
	}

	/**
	 * @param authorityService the authorityService to set
	 */
	@Resource(name="authorityService")
	public void setAuthorityService(AuthorityService authorityService) {
		this.authorityService = authorityService;
	}
}
