package com.lmiky.test.cms.resource;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Hibernate;
import org.junit.Test;

import com.lmiky.cms.directory.pojo.CmsDirectory;
import com.lmiky.cms.resource.pojo.CmsResource;
import com.lmiky.cms.resource.pojo.CmsResourceContent;
import com.lmiky.cms.resource.pojo.CmsResourcePictureSnapshot;
import com.lmiky.jdp.service.BaseService;
import com.lmiky.jdp.service.exception.ServiceException;
import com.lmiky.jdp.user.pojo.User;
import com.lmiky.test.BaseTest;

/**
 * @author lmiky
 * @date 2013-5-7
 */
public class CmsResourceTest extends BaseTest {
	private BaseService baseService;

	@Test
	public void testSave() throws ServiceException {
		CmsResource resource = new CmsResource();
		resource.setTitle("标题常长长长长长长长长长长长长长长");
		resource.setSubtitle("副标题长长长长长长长长长长长长长长长长长长");
		resource.setAuthor("林大家");
		resource.setCreateTime(new Date());
		CmsResourceContent cmsResourceContent = new CmsResourceContent();
		cmsResourceContent.setContent("内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容");
		Set<CmsResourceContent> contents = new HashSet<CmsResourceContent>();
		resource.setResourceContents(contents);
		CmsDirectory directory = new CmsDirectory();
		directory.setId(1l);
		resource.setDirectory(directory);
		User user = new User();
		user.setId(1l);
		resource.setCreator(user);
		baseService.save(resource);
	}
	
	@Test
	public void testSave2() throws ServiceException {
		for(int i=0; i< 100; i++) {
			testSave();
		}
	}
	
	@Test
	public void testSave3() throws ServiceException {
		CmsResource resource = baseService.find(CmsResource.class, 128l);
		resource.setTitle(resource.getTitle() + (int)(Math.random() * 100));
		baseService.save(resource);
	}
	
	@Test
	public void testSave4() throws ServiceException {
		CmsResource resource = baseService.find(CmsResource.class, 132l);
		resource.setTitle("test" + (int)(Math.random() * 100));
		Set<CmsResourcePictureSnapshot> pictureSnapshots = new HashSet<CmsResourcePictureSnapshot>();
		CmsResourcePictureSnapshot shot = new CmsResourcePictureSnapshot();
		shot.setPath("/test");
		shot.setCmsResource(resource);
		pictureSnapshots.add(shot);
		resource.setPictureSnapshots(pictureSnapshots);
		baseService.save(resource);
	}
	
	@Test
	public void testClone() throws ServiceException, ClassNotFoundException, IOException, IllegalAccessException, InvocationTargetException {
		CmsResource resource = baseService.find(CmsResource.class, 132l);
		Hibernate.initialize(resource);
		System.out.println( resource.getTitle());
		System.out.println(System.currentTimeMillis());
		CmsResource c1 = (CmsResource) resource.deepClone();
		System.out.println(c1.getPictureSnapshots().size());
		System.out.println(System.currentTimeMillis());
		CmsResource c2 = new CmsResource();
		BeanUtils.copyProperties(c2, resource);
		System.out.println(c2.getPictureSnapshots().size());
		System.out.println(System.currentTimeMillis());
	}

	/**
	 * @param baseService the baseService to set
	 */
	@Resource(name="cmsResourceService")
	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}
}
