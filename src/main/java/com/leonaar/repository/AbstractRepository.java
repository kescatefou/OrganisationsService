package com.leonaar.repository;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Page;

import java.util.List;

public class AbstractRepository<T extends PanacheEntity> implements PanacheRepository<T> {
    public List<T> list(int page, int pageSize) {
        PanacheQuery<T> query = T.findAll();
        query.page(Page.ofSize(pageSize));
        return query.page(Page.of(page, pageSize)).list();
    }
}
