package com.xm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import com.xm.pojo.Article;
import com.xm.mapper.NewsMapper;

@CrossOrigin
@RestController
public class NewsController {

	@Autowired
	private NewsMapper newsMapper;
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	@GetMapping("/article/{id}")
	public Article getById(@PathVariable("id") Integer id) {
            Article article = newsMapper.getById(id);
            return article;
	}
	
	/**
	 * 查询全部
	 * @return
	 */
	@GetMapping("/articles")
	public List<Article> list(){
            List<Article> articles = newsMapper.list();
            return articles; 
	}
	
        /**
	 * 插入
	 * @param article
         * @return
	 */
	@PostMapping("/article")
	public String insert(@RequestBody Article article) {
            int rows=newsMapper.insert(article);
            return "{\"rows\":\""+rows+"\"}" ;
	}
	
	/**
	 * 修改
	 * @param article
         * @return
	 */
	@PutMapping("/article")
	public String update(@RequestBody Article article) {
            int rows=newsMapper.update(article);
            return "{\"rows\":\""+rows+"\"}" ;
	}
	
	/**
	 * 根据id删除
	 * @param id
         * @return
	 */
	@DeleteMapping("/article/{id}")
	public String delete(@PathVariable("id") Integer id) {
            int rows=newsMapper.delete(id);
            return "{\"rows\":\""+rows+"\"}" ;
	}

}
