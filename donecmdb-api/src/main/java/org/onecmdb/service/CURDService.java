package org.onecmdb.service;

import org.onecmdb.dto.ListFilter;
import org.onecmdb.dto.PageSearch;
import org.onecmdb.dto.SearchFilter;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mq
 * Date: 2017/4/19
 * Time: 11:55
 * To change this template use File | Settings | File Templates.
 */
public interface CURDService<T> {

    List<T> list(ListFilter listFilter);

    Page<T> page(PageSearch pageSearch);

    T detail(Long id);

    T createOrUpdte(T entity);

    void delete(Long id);
}
