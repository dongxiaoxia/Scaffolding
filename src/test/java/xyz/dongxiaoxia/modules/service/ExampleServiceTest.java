package xyz.dongxiaoxia.modules.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.dongxiaoxia.base.BaseTest;
import xyz.dongxiaoxia.modules.entity.Example;

/**
 * Created by dongxiaoxia on 2016/10/12.
 */
public class ExampleServiceTest extends BaseTest {

    @Autowired
    private ExampleService service;

    @Test
    public void test(){
        Example example = new Example();
        example.setValue("example");
        service.save(example);
    }

}