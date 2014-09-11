package com.lmiky.jdp.tree.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lmiky.jdp.database.pojo.BasePojo;
import com.lmiky.jdp.service.exception.ServiceException;
import com.lmiky.jdp.service.impl.BaseServiceImpl;
import com.lmiky.jdp.tree.pojo.BaseTreePojo;

/**
 * 树
 * @author lmiky
 * @date 2014-1-5
 */
@Service("treeService")
public class TreeServiceImpl extends BaseServiceImpl {

	/* (non-Javadoc)
	 * @see com.lmiky.jdp.service.impl.BaseServiceImpl#save(com.lmiky.jdp.database.pojo.BasePojo)
	 */
	@Override
	@Transactional(rollbackFor={Exception.class})
	public <T extends BasePojo> void save(T pojo) throws ServiceException {
		//如果是树
		if(pojo instanceof BaseTreePojo) {
			BaseTreePojo parent = ((BaseTreePojo) pojo).getParent();
			//新增且非顶层
			if(pojo.getId() == null && parent != null) {
				//修改父节点叶子数
				parent.setLeaf(parent.getLeaf() + 1);
				super.save(parent);
			}
		}
		super.save(pojo);
	}

	/* (non-Javadoc)
	 * @see com.lmiky.jdp.service.impl.BaseServiceImpl#delete(com.lmiky.jdp.database.pojo.BasePojo)
	 */
	@Override
	@Transactional(rollbackFor={Exception.class})
	public <T extends BasePojo> void delete(T pojo) throws ServiceException {
		if(pojo instanceof BaseTreePojo) {
			BaseTreePojo pojoTree = (BaseTreePojo) pojo;
			if(pojoTree.getLeaf() > 0) {
				throw new ServiceException("无法删除，该节点下有子节点！");
			}
			BaseTreePojo parent = pojoTree.getParent();
			//非顶层
			if(parent != null) {
				//修改父节点叶子数
				parent.setLeaf(parent.getLeaf() - 1);
				super.save(parent);
			}
		}
		super.delete(pojo);
	}
}
