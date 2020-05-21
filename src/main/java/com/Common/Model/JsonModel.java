package com.Common.Model;

import java.io.Serializable;

public class JsonModel implements Serializable {
	private static final long serialVersionUID = -2519518733795311561L;

	private Integer code=0;
	private String msg;
	private Object obj;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	@Override
	public String toString() {
		return "JsonModel [code=" + code + ", msg=" + msg + ", obj=" + obj + "]";
	}

}
