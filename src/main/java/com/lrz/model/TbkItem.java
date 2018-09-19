package com.lrz.model;

import javax.persistence.*;

@Table(name = "tbk_item")
public class TbkItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 商品id
     */
    @Column(name = "item_id")
    private String itemId;

    /**
     * 商品名称
     */
    @Column(name = "item_name")
    private String itemName;

    /**
     * 商品主图
     */
    @Column(name = "item_picture")
    private String itemPicture;

    /**
     * 商品详情页链接地址
     */
    @Column(name = "item_address")
    private String itemAddress;

    /**
     * 商品一级类目
     */
    @Column(name = "item_cate")
    private String itemCate;

    /**
     * 淘宝客链接
     */
    @Column(name = "item_tbk_address")
    private String itemTbkAddress;

    /**
     * 商品价格(单位：元)
     */
    @Column(name = "item_price")
    private String itemPrice;

    /**
     * 商品月销量
     */
    @Column(name = "item_sales")
    private String itemSales;

    /**
     * 收入比率(%)
     */
    @Column(name = "item_ratio")
    private String itemRatio;

    /**
     * 佣金
     */
    @Column(name = "item_commission")
    private String itemCommission;

    /**
     * 卖家旺旺
     */
    @Column(name = "item_wangwang")
    private String itemWangwang;

    /**
     * 卖家id
     */
    @Column(name = "item_saler_id")
    private String itemSalerId;

    /**
     * 店铺名称
     */
    @Column(name = "item_store_name")
    private String itemStoreName;

    /**
     * 平台类型
     */
    @Column(name = "item_platform")
    private String itemPlatform;

    /**
     * 优惠券id
     */
    @Column(name = "item_coupon_id")
    private String itemCouponId;

    /**
     * 优惠券总量
     */
    @Column(name = "item_coupon_total")
    private String itemCouponTotal;

    /**
     * 优惠券剩余量
     */
    @Column(name = "item_coupon_remain")
    private String itemCouponRemain;

    /**
     * 优惠券面额
     */
    @Column(name = "item_coupon_value")
    private String itemCouponValue;

    /**
     * 优惠券开始时间
     */
    @Column(name = "item_coupon_start")
    private String itemCouponStart;

    /**
     * 优惠券结束时间
     */
    @Column(name = "item_coupon_end")
    private String itemCouponEnd;

    /**
     * 优惠券链接
     */
    @Column(name = "item_coupon_link")
    private String itemCouponLink;

    /**
     * 商品优惠券推广链接
     */
    @Column(name = "item_coupon_address")
    private String itemCouponAddress;

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
     * 获取商品名称
     *
     * @return item_name - 商品名称
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 设置商品名称
     *
     * @param itemName 商品名称
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * 获取商品主图
     *
     * @return item_picture - 商品主图
     */
    public String getItemPicture() {
        return itemPicture;
    }

    /**
     * 设置商品主图
     *
     * @param itemPicture 商品主图
     */
    public void setItemPicture(String itemPicture) {
        this.itemPicture = itemPicture;
    }

    /**
     * 获取商品详情页链接地址
     *
     * @return item_address - 商品详情页链接地址
     */
    public String getItemAddress() {
        return itemAddress;
    }

    /**
     * 设置商品详情页链接地址
     *
     * @param itemAddress 商品详情页链接地址
     */
    public void setItemAddress(String itemAddress) {
        this.itemAddress = itemAddress;
    }

    /**
     * 获取商品一级类目
     *
     * @return item_cate - 商品一级类目
     */
    public String getItemCate() {
        return itemCate;
    }

    /**
     * 设置商品一级类目
     *
     * @param itemCate 商品一级类目
     */
    public void setItemCate(String itemCate) {
        this.itemCate = itemCate;
    }

    /**
     * 获取淘宝客链接
     *
     * @return item_tbk_address - 淘宝客链接
     */
    public String getItemTbkAddress() {
        return itemTbkAddress;
    }

    /**
     * 设置淘宝客链接
     *
     * @param itemTbkAddress 淘宝客链接
     */
    public void setItemTbkAddress(String itemTbkAddress) {
        this.itemTbkAddress = itemTbkAddress;
    }

    /**
     * 获取商品价格(单位：元)
     *
     * @return item_price - 商品价格(单位：元)
     */
    public String getItemPrice() {
        return itemPrice;
    }

    /**
     * 设置商品价格(单位：元)
     *
     * @param itemPrice 商品价格(单位：元)
     */
    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    /**
     * 获取商品月销量
     *
     * @return item_sales - 商品月销量
     */
    public String getItemSales() {
        return itemSales;
    }

    /**
     * 设置商品月销量
     *
     * @param itemSales 商品月销量
     */
    public void setItemSales(String itemSales) {
        this.itemSales = itemSales;
    }

    /**
     * 获取收入比率(%)
     *
     * @return item_ratio - 收入比率(%)
     */
    public String getItemRatio() {
        return itemRatio;
    }

    /**
     * 设置收入比率(%)
     *
     * @param itemRatio 收入比率(%)
     */
    public void setItemRatio(String itemRatio) {
        this.itemRatio = itemRatio;
    }

    /**
     * 获取佣金
     *
     * @return item_commission - 佣金
     */
    public String getItemCommission() {
        return itemCommission;
    }

    /**
     * 设置佣金
     *
     * @param itemCommission 佣金
     */
    public void setItemCommission(String itemCommission) {
        this.itemCommission = itemCommission;
    }

    /**
     * 获取卖家旺旺
     *
     * @return item_wangwang - 卖家旺旺
     */
    public String getItemWangwang() {
        return itemWangwang;
    }

    /**
     * 设置卖家旺旺
     *
     * @param itemWangwang 卖家旺旺
     */
    public void setItemWangwang(String itemWangwang) {
        this.itemWangwang = itemWangwang;
    }

    /**
     * 获取卖家id
     *
     * @return item_saler_id - 卖家id
     */
    public String getItemSalerId() {
        return itemSalerId;
    }

    /**
     * 设置卖家id
     *
     * @param itemSalerId 卖家id
     */
    public void setItemSalerId(String itemSalerId) {
        this.itemSalerId = itemSalerId;
    }

    /**
     * 获取店铺名称
     *
     * @return item_store_name - 店铺名称
     */
    public String getItemStoreName() {
        return itemStoreName;
    }

    /**
     * 设置店铺名称
     *
     * @param itemStoreName 店铺名称
     */
    public void setItemStoreName(String itemStoreName) {
        this.itemStoreName = itemStoreName;
    }

    /**
     * 获取平台类型
     *
     * @return item_platform - 平台类型
     */
    public String getItemPlatform() {
        return itemPlatform;
    }

    /**
     * 设置平台类型
     *
     * @param itemPlatform 平台类型
     */
    public void setItemPlatform(String itemPlatform) {
        this.itemPlatform = itemPlatform;
    }

    /**
     * 获取优惠券id
     *
     * @return item_coupon_id - 优惠券id
     */
    public String getItemCouponId() {
        return itemCouponId;
    }

    /**
     * 设置优惠券id
     *
     * @param itemCouponId 优惠券id
     */
    public void setItemCouponId(String itemCouponId) {
        this.itemCouponId = itemCouponId;
    }

    /**
     * 获取优惠券总量
     *
     * @return item_coupon_total - 优惠券总量
     */
    public String getItemCouponTotal() {
        return itemCouponTotal;
    }

    /**
     * 设置优惠券总量
     *
     * @param itemCouponTotal 优惠券总量
     */
    public void setItemCouponTotal(String itemCouponTotal) {
        this.itemCouponTotal = itemCouponTotal;
    }

    /**
     * 获取优惠券剩余量
     *
     * @return item_coupon_remain - 优惠券剩余量
     */
    public String getItemCouponRemain() {
        return itemCouponRemain;
    }

    /**
     * 设置优惠券剩余量
     *
     * @param itemCouponRemain 优惠券剩余量
     */
    public void setItemCouponRemain(String itemCouponRemain) {
        this.itemCouponRemain = itemCouponRemain;
    }

    /**
     * 获取优惠券面额
     *
     * @return item_coupon_value - 优惠券面额
     */
    public String getItemCouponValue() {
        return itemCouponValue;
    }

    /**
     * 设置优惠券面额
     *
     * @param itemCouponValue 优惠券面额
     */
    public void setItemCouponValue(String itemCouponValue) {
        this.itemCouponValue = itemCouponValue;
    }

    /**
     * 获取优惠券开始时间
     *
     * @return item_coupon_start - 优惠券开始时间
     */
    public String getItemCouponStart() {
        return itemCouponStart;
    }

    /**
     * 设置优惠券开始时间
     *
     * @param itemCouponStart 优惠券开始时间
     */
    public void setItemCouponStart(String itemCouponStart) {
        this.itemCouponStart = itemCouponStart;
    }

    /**
     * 获取优惠券结束时间
     *
     * @return item_coupon_end - 优惠券结束时间
     */
    public String getItemCouponEnd() {
        return itemCouponEnd;
    }

    /**
     * 设置优惠券结束时间
     *
     * @param itemCouponEnd 优惠券结束时间
     */
    public void setItemCouponEnd(String itemCouponEnd) {
        this.itemCouponEnd = itemCouponEnd;
    }

    /**
     * 获取优惠券链接
     *
     * @return item_coupon_link - 优惠券链接
     */
    public String getItemCouponLink() {
        return itemCouponLink;
    }

    /**
     * 设置优惠券链接
     *
     * @param itemCouponLink 优惠券链接
     */
    public void setItemCouponLink(String itemCouponLink) {
        this.itemCouponLink = itemCouponLink;
    }

    /**
     * 获取商品优惠券推广链接
     *
     * @return item_coupon_address - 商品优惠券推广链接
     */
    public String getItemCouponAddress() {
        return itemCouponAddress;
    }

    /**
     * 设置商品优惠券推广链接
     *
     * @param itemCouponAddress 商品优惠券推广链接
     */
    public void setItemCouponAddress(String itemCouponAddress) {
        this.itemCouponAddress = itemCouponAddress;
    }
}