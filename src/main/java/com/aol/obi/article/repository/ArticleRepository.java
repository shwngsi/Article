package com.aol.obi.article.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aol.obi.article.dto.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    /**
     * Get the user entity with the specified username, if one exists.
     * @param username Username.
     * @return <code>User</code> entity.
     */
    public Article findByUsername(String username);

    /**
     * Get the user entity with the specified user UUID, if one exists.
     * @param userUUID User UUID.
     * @return <code>User</code> entity.
     */
    public Article findByUserUUID(String userUUID);

    /**
     * Get the user entity with the specified email address, if one exists.
     * @param email Email address.
     * @return <code>User</code> entity.
     */
    public Article findByEmail(String email);
}
