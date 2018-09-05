package com.lrz.model;

import java.util.Date;
import javax.persistence.*;

/**
 *
 */
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 组织id
     */
    @Column(name = "union_id")
    private String unionId;

    private String title;

    /**
     * 产品封面图
     */
    private String picture;

    /**
     * 分类id
     */
    private Integer cid;

    /**
     * 商品价格，以分为单位保存
     */
    private Integer price;

    /**
     * 原价
     */
    @Column(name = "original_price")
    private Integer originalPrice;

    /**
     * 商品简介
     */
    @Column(name = "short_description")
    private String shortDescription;

    /**
     * 总库存
     */
    private Integer stock;

    @Column(name = "is_show")
    private Byte isShow;

    @Column(name = "is_recommend")
    private Byte isRecommend;

    /**
     * 是否删除
     */
    @Column(name = "is_delete")
    private Byte isDelete;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "sort_order")
    private Integer sortOrder;

    /**
     * 轮播图
     */
    @Column(name = "picture_list")
    private String pictureList;


    @Transient
    private Integer catePid;

    @Transient
    private String cateName;

    @Transient
    private String specifications;

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getPictureList() {
        return pictureList;
    }

    public void setPictureList(String pictureList) {
        this.pictureList = pictureList;
    }

    public Integer getCatePid() {
        return catePid;
    }

    public void setCatePid(Integer catePid) {
        this.catePid = catePid;
    }

    /**
     * 商品描述
     */
    private String description;

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
     * 获取组织id
     *
     * @return union_id - 组织id
     */
    public String getUnionId() {
        return unionId;
    }

    /**
     * 设置组织id
     *
     * @param unionId 组织id
     */
    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取产品封面图
     *
     * @return picture - 产品封面图
     */
    public String getPicture() {
        return picture;
    }

    /**
     * 设置产品封面图
     *
     * @param picture 产品封面图
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * 获取分类id
     *
     * @return cid - 分类id
     */
    public Integer getCid() {
        return cid;
    }

    /**
     * 设置分类id
     *
     * @param cid 分类id
     */
    public void setCid(Integer cid) {
        this.cid = cid;
    }

    /**
     * 获取商品价格，以分为单位保存
     *
     * @return price - 商品价格，以分为单位保存
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * 设置商品价格，以分为单位保存
     *
     * @param price 商品价格，以分为单位保存
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * 获取原价
     *
     * @return original_price - 原价
     */
    public Integer getOriginalPrice() {
        return originalPrice;
    }

    /**
     * 设置原价
     *
     * @param originalPrice 原价
     */
    public void setOriginalPrice(Integer originalPrice) {
        this.originalPrice = originalPrice;
    }

    /**
     * 获取商品简介
     *
     * @return short_description - 商品简介
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * 设置商品简介
     *
     * @param shortDescription 商品简介
     */
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     * 获取总库存
     *
     * @return stock - 总库存
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * 设置总库存
     *
     * @param stock 总库存
     */
    public void setStock(Integer stock) {
        this.stock = stock;
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
     * @return is_recommend
     */
    public Byte getIsRecommend() {
        return isRecommend;
    }

    /**
     * @param isRecommend
     */
    public void setIsRecommend(Byte isRecommend) {
        this.isRecommend = isRecommend;
    }

    /**
     * 获取是否删除
     *
     * @return is_delete - 是否删除
     */
    public Byte getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否删除
     *
     * @param isDelete 是否删除
     */
    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * @return created_at
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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

    /**
     * 获取商品描述
     *
     * @return description - 商品描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置商品描述
     *
     * @param description 商品描述
     */
    public void setDescription(String description) {
        this.description = description;
    }
}