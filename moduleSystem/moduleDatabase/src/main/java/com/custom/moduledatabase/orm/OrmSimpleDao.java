
package com.custom.moduledatabase.orm;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Example Dao
 */
public class OrmSimpleDao {

    private Context context;

    public OrmSimpleDao(Context context) {
        this.context = context;
    }

    //拿Hepler对象
    public OrmDbHelper getHelper() {
        return OrmDbHelper.getInstance(context);
    }

    //StudentDao对象
    public Dao<OrmSimple, Integer> getOrmSimpleDao() throws SQLException {
        //传入实体类拿到这个实体类的Dao对象
        return getHelper().getDao(OrmSimple.class);
    }

    /**
     * =============== 重要的事情说三遍 ================
     * <p>
     * 1.更新时，必须只更新特定的字段，否则将抹除之前的其他字段数据
     * 2.更新时，必须只更新特定的字段，否则将抹除之前的其他字段数据
     * 3.更新时，必须只更新特定的字段，否则将抹除之前的其他字段数据
     * <p>
     * /
     * <p>
     * /**
     * 插入数据集合
     *
     * @param data
     */
    public void insert(List<OrmSimple> data) {
        try {

            Dao<OrmSimple, Integer> ormSimpleDao = getOrmSimpleDao();
            if (!data.isEmpty()) {
                for (int i = 0; i < data.size(); i++) {
                    OrmSimple itemOrmSimple = data.get(i);
                    OrmSimple ormSimple = ormSimpleDao.queryBuilder().where().eq(OrmSimple.COLUMN_USER_ID, OrmSimple.COLUMN_USER_NAME).queryForFirst();
                    if (ormSimple != null) {
                        ormSimple.setUserId(itemOrmSimple.getUserId());
                        ormSimple.setUserName(itemOrmSimple.getUserName());
                        ormSimpleDao.update(ormSimple);
                    } else {
                        ormSimpleDao.create(
                                new OrmSimple(
                                        itemOrmSimple.getUserId(),
                                        itemOrmSimple.getUserName()
                                ));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新数据
     *
     * @param userId   用户Id
     * @param userName 昵称
     */
    public void update(int userId, String userName) {
        try {
            Dao<OrmSimple, Integer> ormSimpleDao = getOrmSimpleDao();
            OrmSimple ormSimple = ormSimpleDao.queryBuilder().where().eq(OrmSimple.COLUMN_USER_ID, OrmSimple.COLUMN_USER_NAME).queryForFirst();
            if (ormSimple != null) {
                ormSimple.setUserId(userId);
                ormSimple.setUserName(userName);
                ormSimpleDao.update(ormSimple);
            } else {
                ormSimpleDao.create(
                        new OrmSimple(
                                userId,
                                userName
                        ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
