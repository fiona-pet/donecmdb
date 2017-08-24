package org.onecmdb.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 配置 对象
 * Created by tom on 2017/8/11.
 */
@Setter
@Getter
@ToString
public class RefDTO extends CiDTO{
    /**
     * 源id
     */
    private Long sourceId;
    /**
     * 目标id
     */
    private Long targetId;
}
