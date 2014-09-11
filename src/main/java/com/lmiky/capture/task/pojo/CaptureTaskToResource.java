package com.lmiky.capture.task.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.lmiky.capture.resource.pojo.CaptureResource;
import com.lmiky.jdp.database.pojo.BasePojo;

/**
 * 抓取人物-资源中间表
 * @author lmiky
 * @date 2013-11-12
 */
@Entity
@Table(name="t_capture_task_resource")
public class CaptureTaskToResource extends BasePojo {
	private static final long serialVersionUID = -264636793559917662L;
	private CaptureTask task;
	private CaptureResource resource;
	
	/**
	 * @return the task
	 */
	@ManyToOne(fetch=FetchType.LAZY)  
    @JoinColumn(name="task_id", updatable = false) 
	public CaptureTask getTask() {
		return task;
	}
	/**
	 * @param task the task to set
	 */
	public void setTask(CaptureTask task) {
		this.task = task;
	}
	/**
	 * @return the resource
	 */
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="resource_id")
	public CaptureResource getResource() {
		return resource;
	}
	/**
	 * @param resource the resource to set
	 */
	public void setResource(CaptureResource resource) {
		this.resource = resource;
	}
}
