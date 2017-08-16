package org.onecmdb.service;

import org.onecmdb.entity.AttributeEntity;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by tom on 2017/8/10.
 */
public interface AttributeEntityService extends CURDService<AttributeEntity> {
    /**
     * 根据所属id和别名 查询 属性信息
     * @param ownerId
     * @param alias
     * @return
     */
    AttributeEntity getAttributesWithAlias(@NotNull Long ownerId, @NotNull String alias);

    /**
     * 根据所属id 查询 属性信息
     * @param ownerId
     * @return
     */
    List<AttributeEntity> getAttributesWithOwnerId(@NotNull Long ownerId);
}
