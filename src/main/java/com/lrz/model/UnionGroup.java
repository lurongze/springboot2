package com.lrz.model;

import javax.persistence.*;

@Table(name = "union_group")
public class UnionGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 组织名称
     */
    @Column(name = "union_name")
    private String unionName;

    /**
     * 组织id
     */
    @Column(name = "union_id")
    private String unionId;

    @Column(name = "union_description")
    private String unionDescription;

    /**
     * 创建时间
     */
    private Integer createtime;

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
     * 获取组织名称
     *
     * @return union_name - 组织名称
     */
    public String getUnionName() {
        return unionName;
    }

    /**
     * 设置组织名称
     *
     * @param unionName 组织名称
     */
    public void setUnionName(String unionName) {
        this.unionName = unionName;
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
     * @return union_description
     */
    public String getUnionDescription() {
        return unionDescription;
    }

    /**
     * @param unionDescription
     */
    public void setUnionDescription(String unionDescription) {
        this.unionDescription = unionDescription;
    }

    /**
     * 获取创建时间
     *
     * @return createtime - 创建时间
     */
    public Integer getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(Integer createtime) {
        this.createtime = createtime;
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