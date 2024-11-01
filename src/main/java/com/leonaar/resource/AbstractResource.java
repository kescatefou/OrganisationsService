package com.leonaar.resource;

import com.leonaar.repository.AbstractRepository;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import java.util.List;

public  abstract class AbstractResource<T extends PanacheEntity> {
    protected abstract AbstractRepository<T> getRepository();

    public List<T> list(int page, int pageSize) {
        return getRepository().list(page, pageSize);
    }
}
