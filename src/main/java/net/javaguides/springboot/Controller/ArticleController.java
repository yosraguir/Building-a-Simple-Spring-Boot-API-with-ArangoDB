package net.javaguides.springboot.Controller;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Article;
import net.javaguides.springboot.services.ArticleService;

@RestController
public class ArticleController {
    private final Logger log = LoggerFactory.getLogger(ArticleController.class);
    private final ArticleService articleService;
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }
    /**
     * To create an article
     * @param article
     * @return
     */
    @PostMapping("/articles")
    public Article create(@RequestBody @Validated Article article) {
        log.debug("Create an article with the properties {}", article);
        return articleService.save(article);
    }
    /**
     * To update an article
     * @param article
     * @return
     */
    @PutMapping("/articles")
    public Article update(@RequestBody @Validated Article article) {
        log.debug("Update the article of title {} with the properties {}", article.getTitle(), article);
        return articleService.update(article);
    }
    /**
     * Get the list of all articles
     * @return
     */
    @GetMapping("/articles")
    public Iterable<Article> list() {
        log.debug("We just get the list of articles one more time");
        return articleService.findAll();
    }
    /**
     * Find an article by its id
     * @param id
     * @return
     */
    @GetMapping("/articles/{id}")
    public Optional<Article> findByTitle(@PathVariable @NonNull String id) {
        log.debug("Load the article of id: {}", id);
        return articleService.findOne(id);
    }
    /**
     * Delete an article by its title
     * @param id
     */
    @DeleteMapping("/articles/{id}")
    public void deleteById(@PathVariable @NonNull String id) {
        log.debug("Delete the article of id: {}", id);
        articleService.delete(id);
    }
}
