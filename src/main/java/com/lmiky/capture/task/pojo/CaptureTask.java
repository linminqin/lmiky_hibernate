package com.lmiky.capture.task.pojo;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.lmiky.jdp.database.pojo.BasePojo;

/**
 * 抓取任务
 * @author lmiky
 * @date 2013-11-6
 */
@Entity
@Table(name="t_capture_task")
public class CaptureTask extends BasePojo {
	private static final long serialVersionUID = 4738636498170998167L;
	
	//状态
	public static final int STATE_STOP = 0;				//停止
	public static final int STATE_START = 1;				//启动
	public static final int STATE_CAPTURING = 2;		//抓取中
	
	private String name;
	private Date createTime;
	private Date startTime;
	private Integer executeInterval = 0;
	private Date lastExecuteTime;
	private String captureUrl;
	private Integer state = STATE_STOP;
	private String pagination;
	private String titleStartPoint;
	private String titleEndPoint;
	private String subtitleStartPoint;
	private String subtitleEndPoint;
	private String authorStartPoint;
	private String authorEndPoint;
	private String pubtimeStartPoint;
	private String pubtimeEndPoint;
	private String contentStartPoint;
	private String contentEndPoint;
	private Set<CaptureTaskToResource> resource;
	
	/**
	 * @return the name
	 */
	@Column(name="name")
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the createTime
	 */
	@Column(name="create_time")
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the startTime
	 */
	@Column(name="start_time")
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the executeInterval
	 */
	@Column(name="execute_interval")
	public Integer getExecuteInterval() {
		return executeInterval;
	}
	/**
	 * @param executeInterval the executeInterval to set
	 */
	public void setExecuteInterval(Integer executeInterval) {
		this.executeInterval = executeInterval;
	}
	/**
	 * @return the lastExecuteTime
	 */
	@Column(name="last_execute_time")
	public Date getLastExecuteTime() {
		return lastExecuteTime;
	}
	/**
	 * @param lastExecuteTime the lastExecuteTime to set
	 */
	public void setLastExecuteTime(Date lastExecuteTime) {
		this.lastExecuteTime = lastExecuteTime;
	}
	/**
	 * @return the captureUrl
	 */
	@Column(name="capture_url")
	public String getCaptureUrl() {
		return captureUrl;
	}
	/**
	 * @param captureUrl the captureUrl to set
	 */
	public void setCaptureUrl(String captureUrl) {
		this.captureUrl = captureUrl;
	}
	/**
	 * @return the state
	 */
	@Column(name="state")
	public Integer getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * @return the pagination
	 */
	@Column(name="pagination")
	public String getPagination() {
		return pagination;
	}
	/**
	 * @param pagination the pagination to set
	 */
	public void setPagination(String pagination) {
		this.pagination = pagination;
	}
	/**
	 * @return the titleStartPoint
	 */
	@Column(name="title_start_point")
	public String getTitleStartPoint() {
		return titleStartPoint;
	}
	/**
	 * @param titleStartPoint the titleStartPoint to set
	 */
	public void setTitleStartPoint(String titleStartPoint) {
		this.titleStartPoint = titleStartPoint;
	}
	/**
	 * @return the titleEndPoint
	 */
	@Column(name="title_end_point")
	public String getTitleEndPoint() {
		return titleEndPoint;
	}
	/**
	 * @param titleEndPoint the titleEndPoint to set
	 */
	public void setTitleEndPoint(String titleEndPoint) {
		this.titleEndPoint = titleEndPoint;
	}
	/**
	 * @return the subtitleStartPoint
	 */
	@Column(name="subtitle_start_point")
	public String getSubtitleStartPoint() {
		return subtitleStartPoint;
	}
	/**
	 * @param subtitleStartPoint the subtitleStartPoint to set
	 */
	public void setSubtitleStartPoint(String subtitleStartPoint) {
		this.subtitleStartPoint = subtitleStartPoint;
	}
	/**
	 * @return the subtitleEndPoint
	 */
	@Column(name="subtitle_end_point")
	public String getSubtitleEndPoint() {
		return subtitleEndPoint;
	}
	/**
	 * @param subtitleEndPoint the subtitleEndPoint to set
	 */
	public void setSubtitleEndPoint(String subtitleEndPoint) {
		this.subtitleEndPoint = subtitleEndPoint;
	}
	/**
	 * @return the authorStartPoint
	 */
	@Column(name="author_start_point")
	public String getAuthorStartPoint() {
		return authorStartPoint;
	}
	/**
	 * @param authorStartPoint the authorStartPoint to set
	 */
	public void setAuthorStartPoint(String authorStartPoint) {
		this.authorStartPoint = authorStartPoint;
	}
	/**
	 * @return the authorEndPoint
	 */
	@Column(name="author_end_point")
	public String getAuthorEndPoint() {
		return authorEndPoint;
	}
	/**
	 * @param authorEndPoint the authorEndPoint to set
	 */
	public void setAuthorEndPoint(String authorEndPoint) {
		this.authorEndPoint = authorEndPoint;
	}
	/**
	 * @return the pubtimeStartPoint
	 */
	@Column(name="pubtime_start_point")
	public String getPubtimeStartPoint() {
		return pubtimeStartPoint;
	}
	/**
	 * @param pubtimeStartPoint the pubtimeStartPoint to set
	 */
	public void setPubtimeStartPoint(String pubtimeStartPoint) {
		this.pubtimeStartPoint = pubtimeStartPoint;
	}
	/**
	 * @return the pubtimeEndPoint
	 */
	@Column(name="pubtime_end_point")
	public String getPubtimeEndPoint() {
		return pubtimeEndPoint;
	}
	/**
	 * @param pubtimeEndPoint the pubtimeEndPoint to set
	 */
	public void setPubtimeEndPoint(String pubtimeEndPoint) {
		this.pubtimeEndPoint = pubtimeEndPoint;
	}
	/**
	 * @return the contentStartPoint
	 */
	@Column(name="content_start_point")
	public String getContentStartPoint() {
		return contentStartPoint;
	}
	/**
	 * @param contentStartPoint the contentStartPoint to set
	 */
	public void setContentStartPoint(String contentStartPoint) {
		this.contentStartPoint = contentStartPoint;
	}
	/**
	 * @return the contentEndPoint
	 */
	@Column(name="content_end_point")
	public String getContentEndPoint() {
		return contentEndPoint;
	}
	/**
	 * @param contentEndPoint the contentEndPoint to set
	 */
	public void setContentEndPoint(String contentEndPoint) {
		this.contentEndPoint = contentEndPoint;
	}
	/**
	 * @return the resource
	 */
	@OneToMany(mappedBy="task", fetch=FetchType.LAZY, cascade={CascadeType.ALL})
	public Set<CaptureTaskToResource> getResource() {
		return resource;
	}
	/**
	 * @param resource the resource to set
	 */
	public void setResource(Set<CaptureTaskToResource> resource) {
		this.resource = resource;
	}
}
