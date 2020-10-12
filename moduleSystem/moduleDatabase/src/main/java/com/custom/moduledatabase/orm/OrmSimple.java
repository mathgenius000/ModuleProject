package com.custom.moduledatabase.orm;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Example 实体类
 * <p>
 * 注解：
 * DatabaseTable：通过其中的tableName属性指定数据库名称
 * DatabaseField：代表数据表中的一个字段
 * ForeignCollectionField：一对多关联，表示一个UserBean关联着多个ArticleBean（必须使用ForeignCollection集合）
 * <p>
 * 属性：
 * id：当前字段是不是id字段（一个实体类中只能设置一个id字段）
 * columnName：表示当前属性在表中代表哪个字段
 * generatedId：设置属性值在数据表中的数据是否自增
 * useGetSet：是否使用Getter/Setter方法来访问这个字段
 * canBeNull：字段是否可以为空，默认值是true
 * unique：是否唯一
 * defaultValue：设置这个字段的默认值
 */
@DatabaseTable(tableName = "orm_simple")
public class OrmSimple {

    // 定义字段在数据库中的字段名
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USER_ID = "userId";
    public static final String COLUMN_USER_NAME = "userName";

    // 参数1 generatedId 表示 id 为主键且自动生成
    @DatabaseField(generatedId = true, columnName = COLUMN_ID, useGetSet = true)
    private int id;

    // 用户Id
    @DatabaseField(columnName = COLUMN_USER_ID, useGetSet = true, canBeNull = false, unique = true)
    private int userId;

    @DatabaseField(columnName = COLUMN_USER_NAME, useGetSet = true, defaultValue = "")
    private String userName;

    public OrmSimple() {
        this(0);
    }

    public OrmSimple(int userId) {
        this(userId, "");
    }

    public OrmSimple(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "OrmSimple{" +
                "id=" + id +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
