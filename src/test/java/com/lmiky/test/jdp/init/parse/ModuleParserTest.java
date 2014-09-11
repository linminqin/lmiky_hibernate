package com.lmiky.test.jdp.init.parse;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.lmiky.jdp.exception.ParseException;
import com.lmiky.jdp.init.parser.ModuleParser;
import com.lmiky.jdp.module.pojo.Function;
import com.lmiky.jdp.module.pojo.Module;
import com.lmiky.jdp.module.pojo.ModuleGroup;
import com.lmiky.test.BaseTest;

/**
 * 模块解析测试类
 * @author lmiky
 * @date 2013-10-13
 */
public class ModuleParserTest extends BaseTest {
	private ModuleParser moduleParser;

	@Test
	public void testParse() throws ParseException {
		List<ModuleGroup> groups = moduleParser.parse();
		System.out.println(groups.size());
		for(ModuleGroup group : groups) {
			System.out.println(group.getName());
			for(Module module : group.getModules()) {
				System.out.println("---" + module.getName() + ":" + module.getPath());
				for(Function function : module.getFunctions()) {
					System.out.println("------" + function.getName() + ":" + function.getAuthorityCode() + ":" + function.getSort());
				}
			}
		}
	}
	
	/**
	 * @return the moduleParser
	 */
	public ModuleParser getModuleParser() {
		return moduleParser;
	}

	/**
	 * @param moduleParser the moduleParser to set
	 */
	@Resource(name="moduleParser")
	public void setModuleParser(ModuleParser moduleParser) {
		this.moduleParser = moduleParser;
	}
}
