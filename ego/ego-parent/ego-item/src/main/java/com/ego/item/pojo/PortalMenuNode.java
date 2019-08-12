package com.ego.item.pojo;

import java.util.List;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/8/5
 */
public class PortalMenuNode {
    /**
     * 该类用于封装每个节点的类型
     */
    //对应ego-portal jsp中的 商品分类数据格式.txt u
    private String u;
    //对应ego-portal jsp中的 商品分类数据格式.txt n
    private String n;
    //对应ego-portal jsp中的 商品分类数据格式.txt i
    private List<Object> i;
    public String getU() {
        return u;
    }
    public void setU(String u) {
        this.u = u;
    }
    public String getN() {
        return n;
    }
    public void setN(String n) {
        this.n = n;
    }
    public List<Object> getI() {
        return i;
    }
    public void setI(List<Object> i) {
        this.i = i;
    }
}
