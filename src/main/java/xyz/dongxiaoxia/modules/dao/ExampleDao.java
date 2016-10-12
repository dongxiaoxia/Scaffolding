package xyz.dongxiaoxia.modules.dao;

import xyz.dongxiaoxia.common.persistence.CrudDao;
import xyz.dongxiaoxia.common.persistence.annotation.MyBatisDao;
import xyz.dongxiaoxia.modules.entity.Example;

/**
 * Created by dongxiaoxia on 2016/10/12.
 */
@MyBatisDao
public interface ExampleDao  extends CrudDao<Example> {
}
