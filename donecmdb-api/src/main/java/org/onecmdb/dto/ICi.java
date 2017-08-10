package org.onecmdb.dto;

/**
 * Created by tom on 2017/8/10.
 */
public interface ICi extends IType{
    public static final String NAMESPACE = "oneCMDB";
    public static final String SPLIT_STR = ":#";
    /**
     * 显示 表达式
     * @return
     */
    String getDisplayNameExpression();
}
