package xyz.dongxiaoxia.modules.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.dongxiaoxia.base.BaseTest;
import xyz.dongxiaoxia.modules.entity.Example;

/**
 * Created by dongxiaoxia on 2016/10/13.
 */
public class ExampleDaoTest extends BaseTest{

    @Autowired
    private ExampleDao dao;

    @Test
    public void test(){
        Example example = new Example();
        example.setValue("123");
        example.setId("111");
        dao.insert(example);
    }

}