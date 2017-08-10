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
 * 事务信息
 * <p>
 * Created by tom on 2016-12-28 10:59:49.
 */
@Entity
@Table(name = "t_cmdb_tx")
@ApiModel("事务信息")

@Getter
@Setter
@ToString
public class CmdbTxEntity extends IdEntity {

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    @Column(columnDefinition = "名称")
    private String name;

    /**
     * 发布者
     */
    @ApiModelProperty(value = "发布者")
    @Column(columnDefinition = "发布者")
    private String issuer;

    /**
     * 插入事务时间
     */
    @ApiModelProperty(value = "插入事务时间")
    @Column(columnDefinition = "插入事务时间")
    private String insertTs;

    /**
     * 事务开始时间
     */
    @ApiModelProperty(value = "事务开始时间")
    @Column(columnDefinition = "事务开始时间")
    private String beginTs;
    /**
     * 事务结束时间
     */
    @ApiModelProperty(value = "事务结束时间")
    @Column(columnDefinition = "事务结束时间")
    private String endTs;

    /**
     * 拒绝原因
     */
    @ApiModelProperty(value = "拒绝原因")
    @Column(columnDefinition = "拒绝原因")
    private String rejectCause;

    /**
     * 配置项修改
     */
    @ApiModelProperty(value = "配置项修改")
    @Column(columnDefinition = "配置项修改")
    private Integer ciModified;

    /**
     * 配置项添加
     */
    @ApiModelProperty(value = "配置项添加")
    @Column(columnDefinition = "配置项添加")
    private Integer ciAdded;

    /**
     * 配置项删除
     */
    @ApiModelProperty(value = "配置项删除")
    @Column(columnDefinition = "配置项删除")
    private Integer ciDeleted;
}

