package org.onecmdb.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by tom on 2017/8/8.
 */
@Entity
@Table(name = "t_ci")
@ApiModel("配置信息")

@Getter
@Setter
@ToString
public class CiEntity extends IdEntity {
    /**
     * 继承id
     */
    @ApiModelProperty(value = "继承id")
    @Column(columnDefinition = "继承id")
    private String derivedFromId;

    /**
     * 显示名称
     */
    @ApiModelProperty(value = "显示名称")
    @Column(columnDefinition = "显示名称")
    private String displayName;

    /**
     * 别名
     */
    @ApiModelProperty(value = "别名")
    @Column(columnDefinition = "别名")
    private String alias;

    /**
     * 组id
     */
    @ApiModelProperty(value = "组id")
    @Column(columnDefinition = "组id")
    private Long gid;

    /**
     * id路径
     */
    @ApiModelProperty(value = "id路径")
    @Column(columnDefinition = "id路径")
    private String path;

    /**
     * 大纲
     */
    @ApiModelProperty(value = "大纲")
    @Column(columnDefinition = "大纲")
    private Boolean isBlueprint;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    @Column(columnDefinition = "描述")
    private String description;

    /**
     * 关联关系 源id
     */
    @ApiModelProperty(value = "源id")
    @Column(columnDefinition = "源id")
    private String sourceId;

    /**
     * 源属性id
     */
    @ApiModelProperty(value = "源属性id")
    @Column(columnDefinition = "源属性id")
    private String sourceAttributeid;

    /**
     * 关联关系 目标id
     */
    @ApiModelProperty(value = "指标id")
    @Column(columnDefinition = "指标id")
    private String targetId;

    /**
     * 模版id
     */
    @ApiModelProperty(value = "模版id")
    @Column(columnDefinition = "模版id")
    private String sourceTemplatePath;

    /**
     * 指标模版id
     */
    @ApiModelProperty(value = "指标模版id")
    @Column(columnDefinition = "指标模版id")
    private String targetTemplatePath;

    /**
     * 最后修改时间
     */
    @ApiModelProperty(value = "最后修改时间")
    @Column(columnDefinition = "最后修改时间")
    private String lastModified;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @Column(columnDefinition = "创建时间")
    private String createTime;
}
