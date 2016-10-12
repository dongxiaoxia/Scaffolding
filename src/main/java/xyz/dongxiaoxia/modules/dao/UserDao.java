package xyz.dongxiaoxia.modules.dao;

import xyz.dongxiaoxia.common.persistence.CrudDao;
import xyz.dongxiaoxia.common.persistence.annotation.MyBatisDao;
import xyz.dongxiaoxia.modules.entity.User;

/**
 * Created by dongxiaoxia on 2016/10/12.
 */
@MyBatisDao
public interface UserDao extends CrudDao<User> {

    /**
     * 根据登录名称查询用户
     * @param user
     * @return
     */
    User getByUserName(User user);

}
