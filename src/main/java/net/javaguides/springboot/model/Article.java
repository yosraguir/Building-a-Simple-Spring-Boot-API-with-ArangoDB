package net.javaguides.springboot.model;

import org.springframework.data.annotation.Id;

import com.arangodb.springframework.annotation.Document;

/**
 * The Article model
 * @author dassiorleando
 */
@Document("article")
public class Article {
    @Id
    private String id;
    private String title;
    private String content;
    private String author;
    public Article() {
    }
    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}