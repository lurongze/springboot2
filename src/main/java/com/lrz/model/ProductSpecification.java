package com.lrz.model;

import javax.persistence.*;

@Table(name = "product_specification")
public class ProductSpecification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 关联的产品id
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 规格名称
     */
    private String title;

    /**
     * 规格库存
     */
    private Integer stock;

    /**
     * 规格价格
     */
    private Integer price;

    /**
     * 限购数量
     */
    private Integer max;

    @Column(name = "is_show")
    private Byte isShow;

    @Column(name = "is_delete")
    private Byte isDelete;

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
     * 获取关联的产品id
     *
     * @return product_id - 关联的产品id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置关联的产品id
     *
     * @param productId 关联的产品id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取规格名称
     *
     * @return title - 规格名称
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置规格名称
     *
     * @param title 规格名称
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取规格库存
     *
     * @return stock - 规格库存
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * 设置规格库存
     *
     * @param stock 规格库存
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * 获取规格价格
     *
     * @return price - 规格价格
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * 设置规格价格
     *
     * @param price 规格价格
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * 获取限购数量
     *
     * @return max - 限购数量
     */
    public Integer getMax() {
        return max;
    }

    /**
     * 设置限购数量
     *
     * @param max 限购数量
     */
    public void setMax(Integer max) {
        this.max = max;
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
}