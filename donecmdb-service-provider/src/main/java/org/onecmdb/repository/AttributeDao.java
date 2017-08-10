package org.onecmdb.repository;


import org.onecmdb.entity.AttributeEntity;

import java.util.List;

/**
 * 属性信息
* Created by tom on 2016-12-27 13:42:04.
 **/
public interface AttributeDao extends DaoBase<AttributeEntity> {
    /**
     * 根据 所属者和别名获取 属性
     *
     * @param ownerId 所属id
     * @param alias 别名
     * @return
     */
    List<AttributeEntity> findByOwnerIdAndAlias(Long ownerId, String alias);

    /**
     * 根据 所属者 获取 属性列表
     *
     * @param ownerId 所属id
     *
     * @return
     */
    List<AttributeEntity> findByOwnerId(Long ownerId);
}
