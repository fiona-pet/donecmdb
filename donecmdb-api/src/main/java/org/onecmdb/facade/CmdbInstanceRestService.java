package org.onecmdb.facade;

import org.onecmdb.dto.ListFilter;
import org.onecmdb.dto.RestResult;

import java.util.List;

/**
 * cmdb 实例 读取接口
 * Created by tom on 2017/8/11.
 */
public interface CmdbInstanceRestService {
    RestResult<List> list(String alias, ListFilter listFilter);
}
