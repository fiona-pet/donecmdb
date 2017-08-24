package org.onecmdb.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.onecmdb.entity.CiEntity;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * 配置 对象
 * Created by tom on 2017/8/11.
 */
@Setter
@Getter
@ToString
public class CiDTO {
    /**
     * id
     */
    private Long id;
    /**
     * 别名
     */
    private String alias;
    /**
     * 显示名称
     */
    private String displayName;
    /**
     * 最后修改时间
     */
    private Date lastModified;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * id路径
     */
    private String path;

    private List<AttributeDTO> attributeDTOList;

    public CiDTO(@NotNull CiEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }


    public CiDTO() {

    }
}
