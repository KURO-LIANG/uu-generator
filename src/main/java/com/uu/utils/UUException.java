/**
 * Copyright (c) 2016-2019 炫酷游 All rights reserved.
 *
 * https://www.xkygame.com
 *
 * 版权所有，侵权必究！
 */

package com.uu.utils;

/**
 * 自定义异常
 *
 * @author KURO clarence_liang@163.com
 */
public class UUException extends RuntimeException {
	private static final long serialVersionUID = 1L;

    private String msg;
    private int code = 500;

    public UUException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public UUException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}

	public UUException(String msg, int code) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}

	public UUException(String msg, int code, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}


}
