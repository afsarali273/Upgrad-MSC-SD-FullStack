/*
 * Copyright 2018-2019, https://beingtechie.io.
 *
 * File: UserDaoImpl.java
 * Date: May 5, 2018
 * Author: Thribhuvan Krishnamurthy
 */
package apps.proman.service.user.dao;

import java.util.List;
import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import apps.proman.service.common.dao.BaseDaoImpl;
import apps.proman.service.user.entity.UserEntity;
import apps.proman.service.common.model.SearchResult;
import apps.proman.service.user.model.UserStatus;

/**
 * Implementation of {@link UserDao}.
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<UserEntity> implements UserDao {

    @Override
    public UserEntity findByEmail(final String email) {
        try {
            return entityManager.createNamedQuery(UserEntity.BY_EMAIL, UserEntity.class).setParameter("email", email).getSingleResult();
        } catch (NoResultException noResultExc) {
            return null;
        }
    }

    @Override
    public SearchResult<UserEntity> findUsers(int page, int limit) {

        final int totalCount = entityManager.createNamedQuery(UserEntity.COUNT_BY_ALL, Long.class).getSingleResult().intValue();
        final List<UserEntity> payload = entityManager.createNamedQuery(UserEntity.BY_ALL, UserEntity.class).setFirstResult(getOffset(page, limit)).setMaxResults(limit).getResultList();
        return new SearchResult(totalCount, payload);
    }

    @Override
    public SearchResult<UserEntity> findUsers(UserStatus userStatus, int page, int limit) {

        final int totalCount = entityManager.createNamedQuery(UserEntity.COUNT_BY_STATUS, Long.class)
                                            .setParameter("status", userStatus.getCode())
                                            .getSingleResult().intValue();
        final List<UserEntity> payload = entityManager.createNamedQuery(UserEntity.BY_STATUS, UserEntity.class)
                                            .setParameter("status", userStatus.getCode())
                                            .setFirstResult(getOffset(page, limit)).setMaxResults(limit).getResultList();
        return new SearchResult(totalCount, payload);
    }

}