package com.lmiky.test.jdp.lock;

import javax.annotation.Resource;

import org.junit.Test;

import com.lmiky.jdp.lock.exception.LockException;
import com.lmiky.jdp.lock.service.LockService;
import com.lmiky.jdp.lock.service.impl.LockServiceImpl;
import com.lmiky.test.BaseTest;

/**
 * 锁
 * @author lmiky
 * @date 2013-4-23
 */
public class LockTest extends BaseTest {
	private LockService lockService;

	@Test
	public void test1() {
		System.out.println(lockService);
	}
	
	@Test
	public void test2() {
		System.out.println(((LockServiceImpl)lockService).getCacheName());
		System.out.println(((LockServiceImpl)lockService).getMaxLockMinutes());
		System.out.println(((LockServiceImpl)lockService).getCacheFactory());
		System.out.println(((LockServiceImpl)lockService).getMaxLockMillis());
	}
	
	@Test
	public void test3() throws LockException {
		String lockTarget = "123456";
		lockService.lock(lockTarget, 123l, "测试");
		System.out.println(lockService.isLock(lockTarget));
	}
	
	@Test
	public void test4() throws LockException {
		String lockTarget = "123456";
		System.out.println(lockService.isLock(lockTarget));
	}
	
	@Test
	public void test5() throws LockException {
		String lockTarget = "123456";
		Long userId = 123l;
		lockService.lock(lockTarget, userId, "测试");
		System.out.println(lockService.isLock(lockTarget));
		lockService.unlock(lockTarget, userId);
		System.out.println(lockService.isLock(lockTarget));
	}
	
	@Test
	public void test6() throws LockException {
		String lockTarget = "123456";
		Long userId = 123l;
		lockService.lock(lockTarget, userId, "测试");
		System.out.println(lockService.isLock(lockTarget));
		System.out.println(lockService.isLockByUser(lockTarget, userId));
		System.out.println(lockService.isLockByUser(lockTarget, 1234l));
	}
	
	/**
	 * @return the lockService
	 */
	public LockService getLockService() {
		return lockService;
	}

	/**
	 * @param lockService the lockService to set
	 */
	@Resource(name="formLockService")
	public void setLockService(LockService lockService) {
		this.lockService = lockService;
	}
}
