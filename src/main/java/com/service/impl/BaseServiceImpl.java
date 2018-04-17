package com.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.BaseService;

import tk.mybatis.mapper.common.BaseMapper;

/**
 * 基础操作
 */
@Service
public abstract class BaseServiceImpl<T> implements BaseService<T> {

	@Autowired
	private BaseMapper<T> mapper;

	@Transactional(rollbackFor = Exception.class)
	public boolean insert(T entity) {
		return mapper.insertSelective(entity) > 0;
	}

	@Transactional(rollbackFor = Exception.class)
	public boolean insertSelective(T entity) {
		return mapper.insertSelective(entity) > 0;
	}

	@Transactional(rollbackFor = Exception.class)
	public boolean deleteById(Object key) {
		return mapper.deleteByPrimaryKey(key) > 0;
	}

	public Optional<T> queryById(Object key) {
		return Optional.ofNullable(mapper.selectByPrimaryKey(key));
	}

	@Transactional(rollbackFor = Exception.class)
	public boolean updateById(T entity) {
		return mapper.updateByPrimaryKey(entity) > 0;
	}

	@Transactional(rollbackFor = Exception.class)
	public boolean updateSelectiveById(T entity) {
		return mapper.updateByPrimaryKeySelective(entity) > 0;
	}

	public List<T> queryAll() {
		return this.mapper.selectAll();
	}
	// 条件查询
	public List<T> queryListByWhere(T param) {
		return this.mapper.select(param);
	}

	// 查询记录数
	public Integer queryCount(T param) {
		return this.mapper.selectCount(param);
	}

	// 分页
	public PageInfo<T> queryPageListByWhere(T param, Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<T> list = this.queryListByWhere(param);
		return new PageInfo<T>(list);

	}

	// 查询一条记录
	public T queryOne(T param) {
		return this.mapper.selectOne(param);
	}
	// 根据主键删除
	public Integer deleteById(Long id) {
		return this.mapper.deleteByPrimaryKey(id);
	}
}
