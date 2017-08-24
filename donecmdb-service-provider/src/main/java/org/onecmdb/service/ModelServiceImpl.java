package org.onecmdb.service;

import lombok.Getter;
import org.apache.commons.collections.map.HashedMap;
import org.onecmdb.dto.*;
import org.onecmdb.entity.AttributeEntity;
import org.onecmdb.entity.CiEntity;
import org.onecmdb.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(ModelServiceImpl.class);
    private String rootAlias = "Ci";

    @Autowired
    private CiEntityService ciEntityService;
    @Autowired
    private AttributeEntityService attributeEntityService;

    @Override
    public CiDTO getRoot() {
        CiEntity ciEntity = ciEntityService.findCi(new Path<>(rootAlias));

        return toIci(ciEntity, true);
    }


    @Override
    public List<CiDTO> list(String alias, ListFilter listFilter) {
        List<CiEntity> ciEntityList = ciEntityService.getInstanceByAlias(alias, listFilter);

        List<CiDTO> result = new ArrayList<>();

        for (CiEntity ciEntity: ciEntityList){
            CiDTO ciDTO = toIci(ciEntity, true);

            result.add(ciDTO);
        }

        return result;
    }

    @Override
    public CiDTO getCiById(Long id, boolean isRef) {

        if (null == id){
            return null;
        }

        LOGGER.debug("get ci by id:{}", id);
        CiEntity ciEntity = ciEntityService.detail(id);

        return toIci(ciEntity, isRef);
    }

    @Override
    public CiDTO getCiByPath(Path<String> path) {
        CiEntity ciEntity = ciEntityService.findCi(path);

        return toIci(ciEntity, true);
    }


    private CiDTO toIci(CiEntity ciEntity, boolean isRef) {
        CiDTO ciDTO = new CiDTO(ciEntity);
        String displayNameExpress = ciEntity.getDisplayName();

        Map<String, String> map = new HashMap<String, String>();

        List<AttributeEntity> attributeEntityList = attributeEntityService.getAttributesWithOwnerId(ciEntity.getId());
        List<AttributeDTO> attributeDTOs = new ArrayList<AttributeDTO>();

        for (AttributeEntity attributeEntity: attributeEntityList){
            LOGGER.debug("attribute id:{}", attributeEntity.getId());

            AttributeDTO attributeDTO = new AttributeDTO(attributeEntity);

            if (attributeEntity.getComplexValue() && isRef) {
                ItemId itemId = new ItemId(attributeEntity.getReftypename());

                LOGGER.debug("ref ci id:{}", itemId.asLong());
                CiEntity refCiEntity= ciEntityService.detail(itemId.asLong());

                CiDTO targetCiDTO = getCiById(refCiEntity.getTargetId(), false);

                if (null ==  targetCiDTO){
                    continue;
                }

                map.put(attributeEntity.getAlias(), targetCiDTO.getDisplayName());

                attributeDTO.setValue(targetCiDTO.getDisplayName());
            }else{
                map.put(attributeEntity.getAlias(), attributeDTO.getValue());
            }

            attributeDTOs.add(attributeDTO);
        }

        ciDTO.setAttributeDTOList(attributeDTOs);
        ciDTO.setDisplayName(StringUtils.renderString(displayNameExpress, map));

        return ciDTO;
    }
}
