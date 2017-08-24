package org.onecmdb.service;

import lombok.Getter;
import org.onecmdb.dto.ListFilter;
import org.onecmdb.dto.PageSearch;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tom on 2017/8/22.
 */
@Service
@Getter
public class DBService implements CURDService{

    @Override
    public List list(ListFilter listFilter) {
        return null;
    }

    @Override
    public Page page(PageSearch pageSearch) {
        return null;
    }

    @Override
    public Object detail(Long id) {
        return null;
    }

    @Override
    public Object createOrUpdte(Object entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
