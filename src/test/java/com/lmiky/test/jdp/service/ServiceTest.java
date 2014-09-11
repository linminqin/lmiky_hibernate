package com.lmiky.test.jdp.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lmiky.jdp.database.model.PropertyCompareType;
import com.lmiky.jdp.database.model.PropertyFilter;
import com.lmiky.jdp.database.model.Sort;
import com.lmiky.jdp.module.pojo.Module;
import com.lmiky.jdp.module.pojo.ModuleGroup;
import com.lmiky.jdp.service.BaseService;
import com.lmiky.jdp.service.exception.ServiceException;
import com.lmiky.test.BaseTest;
import com.lmiky.tiger.goods.pojo.Goods;

/**
 * @author lmiky
 * @date 2013-4-16
 */
public class ServiceTest extends BaseTest {
	private BaseService baseService;
	
	@Test
	public void testFind() throws ServiceException {
		Goods goods = baseService.find(Goods.class, 1l);
		System.out.println(goods.getTitle());
	}
	
	@Test
	public void testFind2() throws ServiceException {
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
		filters.add(new PropertyFilter("marketPrice", 1.0, PropertyCompareType.EQ, Goods.class));
		filters.add(new PropertyFilter("couponDiscount", 0.5, PropertyCompareType.LE, Goods.class));
		Goods goods = baseService.find(Goods.class, filters);
		System.out.println(goods.getTitle());
	}
	
//	@Test
//	public void testFind3() throws ServiceException {
//		Goods goods = baseService.find("from Goods Goods where Goods.id = 1");
//		System.out.println(goods.getTitle());
//	}
	
	@Test
	public void testFind4() throws ServiceException {
		Goods goods = baseService.find(Goods.class, new PropertyFilter("title", "商品信息2", PropertyCompareType.EQ, Goods.class), new PropertyFilter("marketPrice", 1.0, PropertyCompareType.EQ, Goods.class), new PropertyFilter("couponDiscount", 0.5, PropertyCompareType.LE, Goods.class));
		System.out.println(goods.getTitle());
	}
	
//	@Test
//	public void testFind5() throws ServiceException {
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("id", 1l);
//		params.put("title", "测试添222加");
//		Goods goods = baseService.find("from Goods Goods where Goods.id = :id and Goods.title = :title", params);
//		System.out.println(goods.getTitle());
//	}
	
	@Test
	public void testFind6() throws ServiceException {
		Goods goods = baseService.find(Goods.class, "title", "测试添加1sads");
		System.out.println(goods.getTitle());
	}
	
	@Test
	public void testSave() throws ServiceException {
		Goods goods = new Goods();
		goods.setAudit(1);
		goods.setContent("111");
		goods.setCouponDiscount(2.0);
		goods.setCreateTime(new Date());
		goods.setMarketPrice(11.1);
		goods.setSalePrice(12.2);
		goods.setTitle("测试添加");
		goods.setUpdateTime(new Date());
		baseService.save(goods);
		System.out.println(goods.getId());
		goods.setTitle("测试添222加");
		baseService.save(goods);
	}
	
	@Test
	public void testSave2() throws ServiceException {
		Goods goods = baseService.find(Goods.class, 502l);
		goods.setContent("111222");
		baseService.save(goods);
	}
	
	@Test
	public void testSave3() {
		try {
		Goods goods = new Goods();
		goods.setAudit(1);
		goods.setContent("111");
		goods.setCouponDiscount(2.0);
		goods.setCreateTime(new Date());
		goods.setMarketPrice(11.1);
		goods.setSalePrice(12.2);
		goods.setTitle("测试添加");
		goods.setUpdateTime(new Date());
		baseService.save(goods);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testSave4() {
		try {
			List<Goods> goodses = new ArrayList<Goods>();
			for(int i=0; i<500; i++) {
				Goods goods = new Goods();
				goods.setAudit(1);
				goods.setContent("111");
				goods.setCouponDiscount(2.0);
				goods.setCreateTime(new Date());
				goods.setMarketPrice(11.1);
				goods.setSalePrice(12.2);
				goods.setTitle("测试添加");
				goods.setUpdateTime(new Date());
				goodses.add(goods);
			}
			baseService.save(goodses);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testUpdate() throws ServiceException {
		for(int i=0; i<100; i++) {
			Goods goods = new Goods();
			goods.setAudit(1);
			goods.setContent("111");
			goods.setCouponDiscount(2.0);
			goods.setCreateTime(new Date());
			goods.setMarketPrice(11.1);
			goods.setSalePrice(12.2);
			goods.setTitle("测试添加");
			goods.setUpdateTime(new Date());
			baseService.save(goods);
		}
	}
	
	@Test
	public void testUpdate2() throws ServiceException {
		baseService.update(Goods.class, 2l, "createTime", new Date());
	}
	
	@Test
	public void testUpdate3() throws ServiceException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("createTime", new Date());
		params.put("title", "222222222");
		baseService.update(Goods.class, 1l, params);
	}

	@Test
	public void testDelete() throws ServiceException {
		Goods goods = baseService.find(Goods.class, 6l);
		baseService.delete(goods);
	}
	
	@Test
	public void testDelete2() throws ServiceException {
		baseService.delete(Goods.class, 5l);
	}
	
	@Test
	public void testDelete3() throws ServiceException {
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
		filters.add(new PropertyFilter("id", 4l, PropertyCompareType.GE, Goods.class));
		System.out.println(baseService.delete(Goods.class, filters));
	}
	
	@Test
	public void testDelete4() throws ServiceException {
		System.out.println(baseService.delete(Goods.class, new PropertyFilter("id", 733l, PropertyCompareType.EQ, Goods.class)));
	}
	
//	@Test
//	public void testDelete5() throws ServiceException {
//		System.out.println(baseService.delete("delete from Goods Goods  where 1=1 and Goods. id > 5"));
//	}
	
//	@Test
//	public void testDelete6() throws ServiceException {
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("id", 1l);
//		params.put("title", "测试添222加");
//		System.out.println(baseService.delete("delete from Goods Goods  where 1=1 and Goods. id = :id", params));
//	}
	
	@Test
	public void testDelete7() throws ServiceException {
		Long[] ids = new Long[5];
		for(int i=0; i<5; i++) {
			ids[i] = (long) (i+1);
		}
		baseService.delete(Goods.class, ids);
	}
	
	@Test
	public void testDelete8() throws ServiceException {
		String propertyName = "title";
		String propertyValue = "测试添加1111";
		baseService.delete(Goods.class, propertyName, propertyValue);
	}
	
	@Test
	public void testDeleteCascade() throws ServiceException {
		baseService.delete(ModuleGroup.class);
	}
	
	@Test
	public void testList() throws ServiceException {
		System.out.println(baseService.list(Goods.class).size());
	}
	
	@Test
	public void testList2() throws ServiceException {
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
		filters.add(new PropertyFilter("title", null, PropertyCompareType.NNULL, Goods.class));
		List<Sort> sorts = new ArrayList<Sort>();
		sorts.add(new Sort("id", Sort.SORT_TYPE_ASC, Goods.class));
		sorts.add(new Sort("title", Sort.SORT_TYPE_DESC, Goods.class));
		System.out.println(baseService.list(Goods.class, filters, sorts).size());
	}
	
	@Test
	public void testList3() throws ServiceException {
		System.out.println(baseService.list(Goods.class, 1, 0).get(0).getTitle());
	}
	
	@Test
	public void testList4() throws ServiceException {
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
		filters.add(new PropertyFilter("title", null, PropertyCompareType.NNULL, Goods.class));
		List<Sort> sorts = new ArrayList<Sort>();
		sorts.add(new Sort("id", Sort.SORT_TYPE_ASC, Goods.class));
		sorts.add(new Sort("title", Sort.SORT_TYPE_DESC, Goods.class));
		System.out.println(baseService.list(Goods.class, filters, sorts, 1, 0).size());
	}
	
//	@Test
//	public void testList5() throws ServiceException {
//		System.out.println(baseService.list("from Goods Goods").size());
//	}
	
//	@Test
//	public void testList6() throws ServiceException {
//		System.out.println(baseService.list("from Goods Goods", 1, 3).size());
//	}
	
	@Test
	public void testList7() throws ServiceException {
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
		Calendar calendar = Calendar.getInstance();
		filters.add(new PropertyFilter("createTime", calendar.getTime(), PropertyCompareType.LE, Goods.class));
		System.out.println(baseService.list(Goods.class, filters, null).size());
	}
	
	@Test
	public void testList9() throws ServiceException {
		System.out.println(baseService.list(Goods.class, new PropertyFilter("title", null, PropertyCompareType.NNULL, Goods.class)).size());
	}
	
	@Test
	public void testList10() throws ServiceException {
		System.out.println(baseService.list(Goods.class, new Sort("id", Sort.SORT_TYPE_ASC, Goods.class), new Sort("title", Sort.SORT_TYPE_DESC, Goods.class)).size());
	}
	
	@Test
	public void testList11() throws ServiceException {
		System.out.println(baseService.list(Module.class, 1, 10, new PropertyFilter("group.id", 1l, PropertyCompareType.EQ, Module.class)).size());
	}
	
	@Test
	public void testList12() throws ServiceException {
		System.out.println(baseService.list(Goods.class, 1, 10, new Sort("id", Sort.SORT_TYPE_ASC, Goods.class), new Sort("title", Sort.SORT_TYPE_DESC, Goods.class)).size());
	}
	
//	@Test
//	public void testList13() throws ServiceException {
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("id", 1l);
//		System.out.println(baseService.list("from Goods Goods where Goods.id >= :id", params).size());
//	}
	
//	@Test
//	public void testList14() throws ServiceException {
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("id", 1l);
//		System.out.println(baseService.list("from Goods Goods where Goods.id >= :id", params, 0, 10).size());
//	}
	
	@Test
	public void testCount() throws ServiceException {
		System.out.println(baseService.count(Goods.class));
	}
	
	@Test
	public void testCount2() throws ServiceException {
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
		filters.add(new PropertyFilter("id", 4l, PropertyCompareType.GE, Goods.class));
		System.out.println(baseService.count(Goods.class, filters));
	}
	
//	@Test
//	public void testCount3() throws ServiceException {
//		System.out.println(baseService.count("select count(*) from Goods Goods"));
//	}
	
	@Test
	public void testCount4() throws ServiceException {
		System.out.println(baseService.count(Goods.class, new PropertyFilter("id", 4l, PropertyCompareType.GE, Goods.class)));
	}
	
	
//	@Test
//	public void testCount5() throws ServiceException {
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("id", 2l);
//		System.out.println(baseService.count("select count(*) from Goods Goods where Goods.id = :id", params));
//	}
	
	@Test
	public void testExist() throws ServiceException {
		List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
		filters.add(new PropertyFilter("id",4l, PropertyCompareType.GE, Goods.class));
		System.out.println(baseService.exist(Goods.class, filters));
	}
	
//	@Test
//	public void testExist2() throws ServiceException {
//		System.out.println(baseService.exist("select Goods from Goods Goods"));
//	}
	
	@Test
	public void testExist3() throws ServiceException {
		System.out.println(baseService.exist(Goods.class, new PropertyFilter("id", 4l, PropertyCompareType.GE, Goods.class)));
	}
	
//	@Test
//	public void testExist4() throws ServiceException {
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("id", 2l);
//		System.out.println(baseService.exist("select Goods from Goods Goods where Goods.id = :id", params));
//	}
	
//	@Test
//	public void testQuery() throws ServiceException {
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("id", 2l);
//		System.out.println(baseService.executeQuery(" from Goods Goods where Goods.id = :id", params).size());
//	}
	
//	@Test
//	public void testExecuteUpdate() throws ServiceException {
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("id", 2l);
//		params.put("newId", 1l);
//		System.out.println(baseService.executeUpdate(" update Goods g set g.id=:newId  where g.id = :id", params));
//	}
	
	/**
	 * @return the baseService
	 */
	public BaseService getBaseService() {
		return baseService;
	}

	/**
	 * @param baseService the baseService to set
	 */
	@Autowired
	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}
}
