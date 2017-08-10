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
 * 变更信息
 * <p>
 * Created by tom on 2016-12-28 10:59:49.
 */
@Entity
@Table(name = "t_rfc")
@ApiModel("变更信息")

@Getter
@Setter
@ToString
public class RfcEntity extends IdEntity {

    /**
     * 变更类型
     */
    @ApiModelProperty(value = "变更类型")
    @Column(columnDefinition = "变更类型")
    private String rfcType;

    /**
     * 父级id
     */
    @ApiModelProperty(value = "父级id")
    @Column(columnDefinition = "父级id")
    private Integer parentId;
    
    /**
     * 目标id
     */
    @ApiModelProperty(value = "目标id")
    @Column(columnDefinition = "目标id")
    private Integer targetId;

    /**
     * 目标ci id
     */
    @ApiModelProperty(value = "目标ci id")
    @Column(columnDefinition = "目标ci id")
    private Integer targetCiId;

    /**
     * 目标 别名
     */
    @ApiModelProperty(value = "目标 别名")
    @Column(columnDefinition = "目标 别名")
    private String targetAlias;

    /**
     * 事务id
     */
    @ApiModelProperty(value = "事务id")
    @Column(columnDefinition = "事务id")
    private Integer txId;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    @Column(columnDefinition = "id")
    private String ts;

    /**
     * 销毁别名
     */
    @ApiModelProperty(value = "销毁别名")
    @Column(columnDefinition = "销毁别名")
    private String destroyedAlias;

    /**
     * 销毁id
     */
    @ApiModelProperty(value = "销毁id")
    @Column(columnDefinition = "销毁id")
    private Integer destroyedId;

    /**
     * 是否配置项
     */
    @ApiModelProperty(value = "是否配置项")
    @Column(columnDefinition = "是否配置项")
    private String wasCi;

    /**
     * 新别名
     */
    @ApiModelProperty(value = "新别名")
    @Column(columnDefinition = "新别名")
    private String newAlias;

    /**
     * 原别名
     */
    @ApiModelProperty(value = "原别名")
    @Column(columnDefinition = "原别名")
    private String oldAlias;

    /**
     * 新模版
     */
    @ApiModelProperty(value = "新模版")
    @Column(columnDefinition = "新模版")
    private String newTemplate;

    /**
     * 原摸版
     */
    @ApiModelProperty(value = "原摸版")
    @Column(columnDefinition = "原摸版")
    private String oldTemplate;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    @Column(columnDefinition = "描述")
    private String description;

    /**
     * 新显示名称表达式
     */
    @ApiModelProperty(value = "新显示名称表达式")
    @Column(columnDefinition = "新显示名称表达式")
    private String newDisplayNameExpression;

    /**
     * 原显示名称表达式
     */
    @ApiModelProperty(value = "原显示名称表达式")
    @Column(columnDefinition = "原显示名称表达式")
    private String oldDisplayNameExpression;

    /**
     * 源id
     */
    @ApiModelProperty(value = "源id")
    @Column(columnDefinition = "源id")
    private Integer fromId;

    /**
     * 目标id
     */
    @ApiModelProperty(value = "目标id")
    @Column(columnDefinition = "目标id")
    private Integer toId;

    /**
     * 目标别名
     */
    @ApiModelProperty(value = "目标别名")
    @Column(columnDefinition = "目标别名")
    private String toAlias;

    /**
     * 原引用类型别名
     */
    @ApiModelProperty(value = "原引用类型别名")
    @Column(columnDefinition = "原引用类型别名")
    private String oldReferenceTypeAlias;

    /**
     * 新引用类型名别
     */
    @ApiModelProperty(value = "新引用类型名别")
    @Column(columnDefinition = "新引用类型名别")
    private String newReferenceTypeAlias;

    /**
     * 原类型别名
     */
    @ApiModelProperty(value = "原类型别名")
    @Column(columnDefinition = "原类型别名")
    private String oldTypeAlias;

    /**
     * 新类型别名
     */
    @ApiModelProperty(value = "新类型别名")
    @Column(columnDefinition = "新类型别名")
    private String newTypeAlias;

    /**
     * 原长度
     */
    @ApiModelProperty(value = "原长度")
    @Column(columnDefinition = "原长度")
    private Integer oldMaxOccurs;

    /**
     * 新长度
     */
    @ApiModelProperty(value = "新长度")
    @Column(columnDefinition = "新长度")
    private Integer newMaxOccurs;

    /**
     * 原最短长度
     */
    @ApiModelProperty(value = "原最短长度")
    @Column(columnDefinition = "原最短长度")
    private Integer oldMinOccurs;

    /**
     * 新最长长度
     */
    @ApiModelProperty(value = "新最长长度")
    @Column(columnDefinition = "新最长长度")
    private Integer newMinOccurs;

    /**
     * 原值
     */
    @ApiModelProperty(value = "原值")
    @Column(columnDefinition = "原值")
    private String oldValue;

    /**
     * 新值
     */
    @ApiModelProperty(value = "新值")
    @Column(columnDefinition = "新值")
    private String newValue;

    /**
     * 新值别名
     */
    @ApiModelProperty(value = "新值别名")
    @Column(columnDefinition = "新值别名")
    private String newValueAsAlias;

    /**
     * 当前值
     */
    @ApiModelProperty(value = "当前值")
    @Column(columnDefinition = "当前值")
    private String value;

    /**
     * 事务
     */
    @ApiModelProperty(value = "事务")
    @Column(columnDefinition = "事务")
    private Integer indx;

    /**
     * 别名
     */
    @ApiModelProperty(value = "别名")
    @Column(columnDefinition = "别名")
    private String alias;

    /**
     * 值别名
     */
    @ApiModelProperty(value = "值别名")
    @Column(columnDefinition = "值别名")
    private String valueAsAlias;

    /**
     * 原所有者
     */
    @ApiModelProperty(value = "原所有者")
    @Column(columnDefinition = "原所有者")
    private Integer oldOwnerId;

    /**
     * 新所有者
     */
    @ApiModelProperty(value = "新所有者")
    @Column(columnDefinition = "新所有者")
    private Integer newOwnerId;

    /**
     * 源附件id
     */
    @ApiModelProperty(value = "源附件id")
    @Column(columnDefinition = "源附件id")
    private Integer sourceAttributeId;

    /**
     * 应用目标
     */
    @ApiModelProperty(value = "应用目标")
    @Column(columnDefinition = "应用目标")
    private String referenceTarget;

}

