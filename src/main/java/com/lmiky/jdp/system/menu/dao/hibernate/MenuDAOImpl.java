package com.lmiky.jdp.system.menu.dao.hibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lmiky.jdp.database.dao.hibernate.BaseDAOImpl;
import com.lmiky.jdp.database.exception.DatabaseException;
import com.lmiky.jdp.system.menu.dao.MenuDAO;

/**
 * 系统菜单
 * @author lmiky
 * @date 2014年8月13日 下午10:22:50
 */
@Repository("menuDAO")
public class MenuDAOImpl extends BaseDAOImpl implements MenuDAO {

	/*
	 * (non-Javadoc)
	 * @see com.lmiky.jdp.system.menu.dao.MenuDAO#listLatelyOperateMenuId(java.lang.Long, int)
	 */
	@Override
	public List<String> listLatelyOperateMenuId(Long userId, int size) throws DatabaseException {
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("userId", userId);
			return this.executeQuery("select distinct LatelyOperateMenu.menuId from LatelyOperateMenu LatelyOperateMenu where LatelyOperateMenu.userId = :userId order by LatelyOperateMenu.id desc", params, 0, size);
		} catch (Exception e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see com.lmiky.jdp.system.menu.dao.MenuDAO#listFavoriteMenuId(java.lang.Long)
	 */
	@Override
	public List<String> listFavoriteMenuId(Long userId) throws DatabaseException {
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("userId", userId);
			return this.executeQuery("select distinct MyFavoriteMenu.menuId from MyFavoriteMenu MyFavoriteMenu where MyFavoriteMenu.userId = :userId order by MyFavoriteMenu.id desc", params);
		} catch (Exception e) {
			throw new DatabaseException(e.getMessage());
		}
	}
}
