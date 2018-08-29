package com.lrz.model;

import javax.persistence.*;

@Table(name = "product_type")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "union_id")
    private String unionId;

    /**
     * 分类名称
     */
    @Column(name = "cate_name")
    private String cateName;

    /**
     * 分类图标
     */
    @Column(name = "cate_logo")
    private String cateLogo;

    @Column(name = "is_show")
    private Byte isShow;

    @Column(name = "is_delete")
    private Byte isDelete;

    @Column(name = "sort_order")
    private Integer sortOrder;

    @Column(name = "pid")
    private Integer pid;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return union_id
     */
    public String getUnionId() {
        return unionId;
    }

    /**
     * @param unionId
     */
    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    /**
     * 获取分类名称
     *
     * @return cate_name - 分类名称
     */
    public String getCateName() {
        return cateName;
    }

    /**
     * 设置分类名称
     *
     * @param cateName 分类名称
     */
    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    /**
     * 获取分类图标
     *
     * @return cate_logo - 分类图标
     */
    public String getCateLogo() {
        return cateLogo;
    }

    /**
     * 设置分类图标
     *
     * @param cateLogo 分类图标
     */
    public void setCateLogo(String cateLogo) {
        this.cateLogo = cateLogo;
    }

    /**
     * @return is_show
     */
    public Byte getIsShow() {
        return isShow;
    }

    /**
     * @param isShow
     */
    public void setIsShow(Byte isShow) {
        this.isShow = isShow;
    }

    /**
     * @return is_delete
     */
    public Byte getIsDelete() {
        return isDelete;
    }

    /**
     * @param isDelete
     */
    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * @return sort_order
     */
    public Integer getSortOrder() {
        return sortOrder;
    }

    /**
     * @param sortOrder
     */
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }
}