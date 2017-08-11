package org.onecmdb.service;

import org.onecmdb.dto.CiDTO;
import org.onecmdb.dto.ICi;
import org.onecmdb.dto.ListFilter;

import java.util.List;
import java.util.Map;

/**
 * 模型服务
 * Created by tom on 2017/8/10.
 */
public interface ModelService {
    /**
     *
     * @return
     */
    ICi getRoot();

    List<CiDTO> list(String alias, ListFilter listFilter);
}
