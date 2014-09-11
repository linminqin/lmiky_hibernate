package com.lmiky.test.jdp.system.menu;

import javax.annotation.Resource;

import org.junit.Test;

import com.lmiky.jdp.system.menu.service.MenuService;
import com.lmiky.test.BaseTest;

/**
 * @author lmiky
 * @date 2013-6-16
 */
public class MenuServiceTest extends BaseTest {
	private MenuService menuService;
	
	@Test
	public void testParse() throws Exception {
		/*
		List<TopMenu> topMenus = menuService.parse();
		for(TopMenu topMenu : topMenus) {
			System.out.println(topMenu.getLabel());
			for(LeftMenu leftMenu : topMenu.getLeftMenus()) {
				System.out.println("--" + leftMenu.getLabel());
				for(SubMenu subMenu : leftMenu.getSubMenus()) {
					System.out.println("----" + subMenu.getLabel());
				}
			}
		}
		*/
	}

	/**
	 * @return the menuService
	 */
	public MenuService getMenuService() {
		return menuService;
	}

	/**
	 * @param menuService the menuService to set
	 */
	@Resource(name="menuService")
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	
}
