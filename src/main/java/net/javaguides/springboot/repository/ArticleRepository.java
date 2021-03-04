package net.javaguides.springboot.repository;

import com.arangodb.springframework.annotation.Query;
import com.arangodb.springframework.repository.ArangoRepository;

import net.javaguides.springboot.model.Article;

public interface ArticleRepository extends ArangoRepository<Article, String> {
	
	 // Supposing that article is the collection name to perform the query on
    @Query("FOR a IN article FILTER a.title == @0 RETURN a")
    Iterable<Article> getArticleByTitle(String title);
    Iterable<Article> findByTitle(String title);

}
