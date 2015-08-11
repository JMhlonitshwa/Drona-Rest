//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.drona.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.drona.common.exception.EnityNotFoundException;

@Component
public class GenericRepository {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public <E extends Object> Object findSingle(String query) throws EnityNotFoundException {
        List<E> objects = hibernateTemplate.find(query);
        if (objects.isEmpty()) {
            throw new EnityNotFoundException();
        }
        return objects.get(0);
    }

    public <E extends Object> List<E> find(String query) {
        List<E> objects = hibernateTemplate.find(query);
        return objects;
    }

    public Long save(Object obj) {
        return (Long) hibernateTemplate.save(obj);
    }

    public void update(Object obj) {
        hibernateTemplate.update(obj);
    }

    public void deleteSingle(String query) throws EnityNotFoundException, DataAccessException {
        hibernateTemplate.delete(findSingle(query));

    }

}
