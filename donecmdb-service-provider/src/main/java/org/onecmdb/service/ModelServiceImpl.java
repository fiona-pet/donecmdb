package org.onecmdb.service;

import lombok.Getter;
import org.apache.commons.collections.map.HashedMap;
import org.onecmdb.dto.*;
import org.onecmdb.entity.AttributeEntity;
import org.onecmdb.entity.CiEntity;
import org.onecmdb.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wildfly.swarm.config.jmx.configuration.Handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        List<AttributeEntity> attributeEntitys = attributeEntityService.getAttributesWithOwnerId(ciEntity.getId());

        return toIci(ciEntity, attributeEntitys);
    }

    @Override
    public List<CiDTO> list(String alias, ListFilter listFilter) {
        List<CiEntity> ciEntityList = ciEntityService.getInstanceByAlias(alias, listFilter);

        List<CiDTO> result = new ArrayList<>();

        for (CiEntity ciEntity: ciEntityList){
            CiDTO ciDTO = new CiDTO(ciEntity);
            String displayNameExpress = ciEntity.getDisplayName();

            List<AttributeEntity> attributeEntityList = attributeEntityService.getAttributesWithOwnerId(ciEntity.getId());

            Map<String, String> map = new HashMap<String, String>();

            for (AttributeEntity attributeEntity: attributeEntityList){
                map.put(attributeEntity.getAlias(), getValue(attributeEntity));
            }

            ciDTO.setDisplayName(StringUtils.renderString(displayNameExpress, map));

            result.add(ciDTO);
        }

        return result;
    }



    private String getValue(AttributeEntity attributeEntity) {
        if (attributeEntity.getTypeName().startsWith("oneCMDB:")){
            return attributeEntity.getValueAsString();
        }else{
            return attributeEntity.getValueAsString();
        }
    }

    private ICi toIci(CiEntity ciEntity, List<AttributeEntity>  attributeEntitys) {
        ICi ci = new ConfigurationItem(ciEntity, attributeEntitys);

        return ci;
    }
}
