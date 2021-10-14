/**
 * Copyright (c) 2016-2019 炫酷游 All rights reserved.
 *
 * https://www.xkygame.com
 *
 * 版权所有，侵权必究！
 */

package com.uu.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理器
 *
 * @author KURO clarence_liang@163.com
 */
@RestControllerAdvice
public class UUExceptionHandler {

	/**
	 * 处理自定义异常
	 */
	@ExceptionHandler(UUException.class)
	public R handleRRException(UUException e){
		R r = new R();
		r.put("code", e.getCode());
		r.put("msg", e.getMessage());

		return r;
	}

	@ExceptionHandler(Exception.class)
	public R handleException(Exception e){
		return R.error();
	}
}
