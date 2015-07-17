package com.aol.obi.article.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aol.obi.article.dto.Article;
import com.aol.obi.article.repository.ArticleRepository;


@Service
public class ArticleServiceImpl implements ArticleService {

    private static final Log LOG = LogFactory.getLog(ArticleServiceImpl.class);

    @Value("${customer.setup.welcome.mail.template}")
    private String welcomeMailTemplate;

    @Value("${customer.setup.welcome.mail.subject}")
    private String welcomeMailSubject;
    
    @Value("${password.reset.mail.template}")
    private String changePasswordEmailTemplate;

    @Value("${password.reset.mail.subject}")
    private String changePasswordEmailSubject;

    @Value("${customer.setup.welcome.mail.from}")
    private String welcomeMailFrom;

    @Value("${customer.setup.welcome.mail.from.name}")
    private String welcomeMailFromName;

    @Autowired
    private ArticleRepository articleRepository;
    
   
    @Override
    @Transactional
    public com.aol.obi.article.dto.Article register(final com.aol.obi.article.dto.Article user, final String feedbackURL) {
        LOG.debug("Register user information: " + user.getEmail());
        user.setUsername(user.getEmail());
        Article userEntity = articleRepository.findByUsername(user.getEmail());
        

        // Create new user entity and persist
        Date now = new Date();
        userEntity = new Article();
        userEntity.setUserUUID(UUID.randomUUID().toString());
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPin(user.getPin());
        userEntity.setActive(Boolean.TRUE);
        userEntity.setCreatedDate(now);
        userEntity.setCreatedBy("createdBY");
        userEntity.setLastUpdatedDate(now);
        //userEntity.setUpdatedBy("updatedBY");

        userEntity = articleRepository.save(userEntity);
        LOG.debug("User [" + user.getEmail() + "] has been registed");
        //sendWelcomeMail(userEntity, feedbackURL);
        return toModel(userEntity);
    }



    private com.aol.obi.article.dto.Article toModel(Article entity) {
    	com.aol.obi.article.dto.Article model = new com.aol.obi.article.dto.Article();
        model.setUserUUID(entity.getUserUUID());
        model.setUsername(entity.getUsername());
        model.setFirstName(entity.getFirstName());
        model.setLastName(entity.getLastName());
        model.setEmail(entity.getEmail());
        model.setPin(entity.getPin());
        model.setActive(entity.isActive());
        model.setCreatedDate(entity.getCreatedDate());
        model.setCreatedBy(entity.getCreatedBy());
        model.setLastUpdatedDate(entity.getLastUpdatedDate());
        //model.setLastUpdatedBy(entity.getUpdatedBy());
        return model;
    }
}
