package com.ego.commons.pojo;

/**
 * @author 辉
 * 座右铭:坚持总能遇见更好的自己!
 * @date 2019/7/13
 *
 * 专门封装 EasyUI 中 Tree
 * 组件每个节点对象的数据
 *
 * iconCls：显示的节点图标CSS类ID。
 * checked：该节点是否被选中。
 * attributes：绑定该节点的自定义属性。
 * target：目标DOM对象。
 */
public class EasyUiTree {

    //id：绑定节点的标识值。
    private long id;
    //text：显示的节点文本。
    private String text;
    //state：节点状态，'open' 或 'closed'。
    private String state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
