/**
 * Copyright (c) 2016-2019 炫酷游 All rights reserved.
 *
 * https://www.xkygame.com
 *
 * 版权所有，侵权必究！
 */

package com.uu.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.uu.dao.GeneratorDao;
import com.uu.utils.GenUtils;
import com.uu.utils.PageUtils;
import com.uu.utils.Query;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * 代码生成器
 *
 * @author KURO clarence_liang@163.com
 */
@Service
public class SysGeneratorService {
	@Autowired
	private GeneratorDao generatorDao;

	public PageUtils queryList(Query query) {
		Page<?> page = PageHelper.startPage(query.getPage(), query.getLimit());
		List<Map<String, Object>> list = generatorDao.queryList(query);

		return new PageUtils(list, (int)page.getTotal(), query.getLimit(), query.getPage());
	}

	public Map<String, String> queryTable(String tableName) {
		return generatorDao.queryTable(tableName);
	}

	public List<Map<String, String>> queryColumns(String tableName) {
		return generatorDao.queryColumns(tableName);
	}

	public byte[] generatorCode(String[] tableNames) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ZipOutputStream zip = new ZipOutputStream(outputStream);

		for(String tableName : tableNames){
			//查询表信息
			Map<String, String> table = queryTable(tableName);
			//查询列信息
			List<Map<String, String>> columns = queryColumns(tableName);
			//生成代码
			GenUtils.generatorCode(table, columns, zip);
		}
		IOUtils.closeQuietly(zip);
		return outputStream.toByteArray();
	}
}
