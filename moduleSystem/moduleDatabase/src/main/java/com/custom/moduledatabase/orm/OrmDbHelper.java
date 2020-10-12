package com.custom.moduledatabase.orm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;


/**
 * 数据库帮助类，单例模式
 */
public class OrmDbHelper extends OrmLiteSqliteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "orm-db";

    //1.私有构造函数
    private OrmDbHelper(Context context) {
        //参数1：上下文 参数2：数据库的名称 参数3：游标 参数4 数据库的版本
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //2.私有静态的对象
    private static OrmDbHelper ormDbHelper = null;

    //3.共有静态的获取对象实例的方法
    public static synchronized OrmDbHelper getInstance(Context context) {
        if(ormDbHelper == null){
            synchronized (OrmDbHelper.class) {
                if (ormDbHelper == null) {
                    ormDbHelper = new OrmDbHelper(context);
                }
            }
        }
        return ormDbHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        //建表的方法
//        try {
//            //参数1：连接资源 参数2：定义好的实体类
//            TableUtils.createTableIfNotExists(connectionSource, OrmSimple.class);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        //如果再建表，可以通过上面的方法，在写一个实体类就行了
    }

    //升级数据库的方法（只有当应用在访问数据库时，发现数据库版本增加，才会调用此方法）
    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        //1如果数据库升级，要先删除之前的表
//        try {
//            //参数1：连接资源，参数2：实体类 参数3：忽略错误
//            TableUtils.dropTable(connectionSource, OrmSimple.class, true);
//            //2.重新执行oncreate
//            onCreate(database, connectionSource);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

}
