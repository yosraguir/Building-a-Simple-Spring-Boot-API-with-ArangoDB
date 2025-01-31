package net.javaguides.springboot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Article;
import net.javaguides.springboot.repository.ArticleRepository;


	@Service
	public class ArticleService {
	    @Autowired
	    private ArticleRepository articleRepository;
	    /**
	     * To create an article
	     * @param article
	     * @return article
	     */
	    public Article save(Article article) {
	        // Save the article
	        return articleRepository.save(article);
	    }
	    /**
	     * To update an article
	     * @param article 
	     * @return the updated article
	     */
	    public Article update(Article article) {
	        String articleId = article.getId();
	        if (articleId == null || articleId.isEmpty()) return null;
	        // Update the article
	        return articleRepository.save(article);
	    }
	    /**
	     * Find a single article by its id
	     * @param articleId
	     * @return article
	     */
	    public Optional<Article> findOne(String articleId) {
	        if (articleId == null || articleId.isEmpty()) return Optional.empty();
	        return articleRepository.findById(articleId);
	    }
	    /**
	     * Find all saved articles so far
	     * @return
	     */
	    public Iterable<Article> findAll() {
	        return articleRepository.findAll();
	    }
	    /**
	     * Delete a single article by its id
	     * @param articleId
	     */
	    public void delete(String articleId) {
	        if (articleId == null || articleId.isEmpty()) return;
	        articleRepository.deleteById(articleId);
	    }
}
