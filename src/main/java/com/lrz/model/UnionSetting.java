package com.lrz.model;

import javax.persistence.*;

@Table(name = "union_setting")
public class UnionSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "union_id")
    private String unionId;

    /**
     * 配置名
     */
    private String title;

    /**
     * 配置key 值
     */
    @Column(name = "key_name")
    private String keyName;

    @Column(name = "key_value")
    private String keyValue;

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
     * 获取配置名
     *
     * @return title - 配置名
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置配置名
     *
     * @param title 配置名
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取配置key 值
     *
     * @return key_name - 配置key 值
     */
    public String getKeyName() {
        return keyName;
    }

    /**
     * 设置配置key 值
     *
     * @param keyName 配置key 值
     */
    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    /**
     * @return key_value
     */
    public String getKeyValue() {
        return keyValue;
    }

    /**
     * @param keyValue
     */
    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }
}