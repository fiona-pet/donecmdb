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
 * 属性信息
 * <p>
 * Created by tom on 2016-12-28 10:59:49.
 */
@Entity
@Table(name = "t_attribute")
@ApiModel("属性信息")

@Getter
@Setter
@ToString
public class AttributeEntity extends IdEntity {

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
     * 复合
     */
    @ApiModelProperty(value = "复合")
    @Column(columnDefinition = "复合")
    private Boolean complexValue;

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
     * 类型名
     */
    @ApiModelProperty(value = "类型名")
    @Column(columnDefinition = "类型名")
    private String typeName;

    /**
     * 引用类型
     */
    @ApiModelProperty(value = "引用类型")
    @Column(columnDefinition = "引用类型")
    private String reftypename;

    /**
     * 字符串值
     */
    @ApiModelProperty(value = "字符串值")
    @Column(columnDefinition = "字符串值")
    private String valueAsString;

    /**
     * 长整型值
     */
    @ApiModelProperty(value = "长整型值")
    @Column(columnDefinition = "长整型值")
    private Long valueAsLong;

    /**
     * 日期类型值
     */
    @ApiModelProperty(value = "日期类型值")
    @Column(columnDefinition = "日期类型值")
    private String valueAsDate;

    /**
     * 所属者id
     */
    @ApiModelProperty(value = "所属者id")
    @Column(columnDefinition = "所属者id")
    private String ownerId;

    /**
     * 最长
     */
    @ApiModelProperty(value = "最长")
    @Column(columnDefinition = "最长")
    private Integer maxOccurs;

    /**
     * 最小
     */
    @ApiModelProperty(value = "最小")
    @Column(columnDefinition = "最小")
    private Integer minOccurs;

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

