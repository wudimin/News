package com.xm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xm.pojo.Article;
import java.util.List;
import com.xm.mapper.NewsMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsTest {
	@Autowired
	private NewsMapper newsMapper;

        @Test
	public void select() {
            List<Article> articles=newsMapper.list();
            System.out.println(articles.toString());
        }
        
        @Test
	public void insert() {
            Article article = new Article();
            article.setTitle("头条新闻");
            article.setContent("佩奇");
            article.setCdate("2020-03-29");

            newsMapper.insert(article);
            System.out.println(article.getId());
	}
        
	@Test
	public void update() {
            Article article = new Article();
            article.setId(3);
            article.setTitle("头条新闻小猪佩奇");
            article.setContent("小猪佩奇");
            article.setCdate("2020-03-29");

            int a=newsMapper.update(article);
            System.out.println(a);
	}
        
        @Test
	public void delete() {
            int a=newsMapper.delete(3);
            System.out.println(a);
		
	}	

}
