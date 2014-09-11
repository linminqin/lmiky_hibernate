package com.lmiky.test.jdp.sort;


import javax.annotation.Resource;

import org.junit.Test;

import com.lmiky.cms.directory.pojo.CmsDirectory;
import com.lmiky.jdp.service.exception.ServiceException;
import com.lmiky.jdp.sort.service.SortService;
import com.lmiky.test.BaseTest;

/**
 * @author lmiky
 * @date 2013-5-24
 */
public class SortServiceTest extends BaseTest {
	private SortService sortService;

	@Test
	public void testSort() {
		String[] sortedIds = new String[] {"27", "30", "17", "16"};
		try {
			sortService.sort(CmsDirectory.class, sortedIds);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param moduleService the moduleService to set
	 */
	@Resource(name="sortService")
	public void setModuleService(SortService sortService) {
		this.sortService = sortService;
	}

}
