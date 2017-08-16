package org.onecmdb.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.onecmdb.entity.AttributeEntity;

/**
 * Created by tom on 2017/8/16.
 */
@Getter
@Setter
@ToString
public class AttributeDTO {
    /**
     * id
     */
    private Long id;
    /**
     * 别名
     */
    private String alias;
    /**
     * 值
     */
    private String value;

    public AttributeDTO(AttributeEntity attributeEntity) {
        this.alias = attributeEntity.getAlias();
        this.value = attributeEntity.getValueAsString();
    }
    public String getValue(){
        return value;
    }
}
