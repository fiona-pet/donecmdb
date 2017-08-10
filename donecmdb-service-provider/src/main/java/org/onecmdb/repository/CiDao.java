package org.onecmdb.repository;

import org.onecmdb.entity.CiEntity;

import java.util.List;

/**
 * 配置信息
* Created by tom on 2016-12-27 13:42:04.
 **/
public interface CiDao extends DaoBase<CiEntity> {
    CiEntity findByAlias(String alias);

    List<CiEntity> findByDerivedFromId(String id);

    CiEntity findByAliasAndIsBlueprint(String alias, boolean isBlueprint);

    List<CiEntity> findByDerivedFromIdAndIsBlueprint(String id, boolean isBlueprint);

    List<CiEntity> findByPathLikeAndIsBlueprint(String s, boolean b);

    CiEntity findById(String targetId);
}
