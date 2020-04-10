package com.xm.mapper;

import java.util.List;

import com.xm.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsMapper {

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Article getById(Integer id);
	
	/**
	 * 查询全部
	 * @return
	 */
	public List<Article> list();
	
	/**
	 * 插入
	 * @param article
         * @return 
	 */
	public int insert(Article article);

	/**
	 * 根据student的id修改
	 * @param article
         * @return 
	 */
	public int update(Article article);
	
	/**
	 * 根据id删除
         * @return 
	 * @param id
	 */
	public int delete(Integer id);


	
}
