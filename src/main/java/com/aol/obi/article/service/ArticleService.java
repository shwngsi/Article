package com.aol.obi.article.service;

import com.aol.obi.article.dto.Article;

/**
 * User management service.
 */
public interface ArticleService {
    /**
     * Register a new user with the information provided by the specified
     * <code>User</code> model object.
     * @param user <code>User</code> model object.
     * @param feedbackURL
     * @return Fully-populated <code>User</code> model object.
     */
    public Article register(Article article, String feedbackURL);

    }
