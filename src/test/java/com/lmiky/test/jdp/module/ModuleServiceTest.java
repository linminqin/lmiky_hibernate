package com.lmiky.test.jdp.module;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.lmiky.jdp.module.pojo.Function;
import com.lmiky.jdp.module.pojo.Module;
import com.lmiky.jdp.module.service.ModuleService;
import com.lmiky.test.BaseTest;

/**
 * @author lmiky
 * @date 2013-5-24
 */
public class ModuleServiceTest extends BaseTest {
	private ModuleService moduleService;

	@Test
	public void testListFunctionByModulePath() {
		try {
			List<Function> functions = moduleService.listFunctionByModulePath("config", Module.MODULE_TYPE_GROUP);
			System.out.println(functions.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the moduleService
	 */
	public ModuleService getModuleService() {
		return moduleService;
	}

	/**
	 * @param moduleService the moduleService to set
	 */
	@Resource(name="moduleService")
	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}

}
