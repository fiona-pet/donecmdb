package org.onecmdb.service;

import lombok.Getter;
import org.onecmdb.dto.ConfigurationItem;
import org.onecmdb.dto.ICi;
import org.onecmdb.dto.Path;
import org.onecmdb.entity.AttributeEntity;
import org.onecmdb.entity.CiEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  模型 接口 服务
 * Created by tom on 2017/8/10.
 */
@Service
@Getter
public class ModelServiceImpl implements ModelService{
    private String rootAlias = "Ci";

    @Autowired
    private CiEntityService ciEntityService;
    @Autowired
    private AttributeEntityService attributeEntityService;

    @Override
    public ICi getRoot() {
        CiEntity ciEntity = ciEntityService.findCi(new Path<>(rootAlias));
        AttributeEntity attributeEntity = null;//attributeEntityService

        return toIci(ciEntity, attributeEntity);
    }

    private ICi toIci(CiEntity ciEntity, AttributeEntity attributeEntity) {
        ICi ci = new ConfigurationItem(ciEntity, attributeEntity);

        return ci;
    }
}
