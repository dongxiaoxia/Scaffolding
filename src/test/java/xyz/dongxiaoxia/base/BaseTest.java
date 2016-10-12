package xyz.dongxiaoxia.base;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by dongxiaoxia on 2016/10/12.
 */
//指定bean注入的配置文件
@ContextConfiguration({"classpath*: spring-*.xml"})
//使用标准的JUnit @RunWith注释来告诉JUnit使用Spring TestRunner
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseTest extends AbstractJUnit4SpringContextTests {
}
