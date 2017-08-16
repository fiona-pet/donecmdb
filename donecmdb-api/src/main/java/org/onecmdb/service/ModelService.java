package org.onecmdb.service;

import org.onecmdb.dto.CiDTO;
import org.onecmdb.dto.ListFilter;

import java.util.List;

/**
 * 模型服务
 * Created by tom on 2017/8/10.
 */
public interface ModelService {
    /**
     *
     * @return
     */
    CiDTO getRoot();

    List<CiDTO> list(String alias, ListFilter listFilter);

    /**
     * 根据 id 获取Ci 对象
     * @param id
     * @return
     */
    CiDTO getCiById(Long id, boolean isRef);
}
