package com.lrz.model;

import javax.persistence.*;

@Table(name = "tbk_item_info")
public class TbkItemInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 商品id
     */
    @Column(name = "item_id")
    private String itemId;

    /**
     * 图片链接
     */
    @Column(name = "item_images")
    private String itemImages;

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
     * 获取商品id
     *
     * @return item_id - 商品id
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * 设置商品id
     *
     * @param itemId 商品id
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * 获取图片链接
     *
     * @return item_images - 图片链接
     */
    public String getItemImages() {
        return itemImages;
    }

    /**
     * 设置图片链接
     *
     * @param itemImages 图片链接
     */
    public void setItemImages(String itemImages) {
        this.itemImages = itemImages;
    }
}