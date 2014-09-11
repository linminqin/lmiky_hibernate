package com.lmiky.jdp.database.pojo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 基本实体类
 * @author lmiky
 * @date 2013-4-15
 */
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class BasePojo implements Serializable, Cloneable {
	public static final String POJO_FIELD_NAME_ID = "id";
	
	private Long id;

	/**
	 * @return the id
	 */
	 @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	/**
	 * 深度克隆
	 * @author lmiky
	 * @date 2014年8月10日 下午5:30:05
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Object deepClone() throws IOException, ClassNotFoundException {
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		ObjectOutputStream oo = new ObjectOutputStream(bo);
		oo.writeObject(this);
		ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
		ObjectInputStream oi = new ObjectInputStream(bi);
		return oi.readObject();
	}
}
