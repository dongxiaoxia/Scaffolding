package xyz.dongxiaoxia.modules.listener;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import xyz.dongxiaoxia.modules.schedule.ExampleSchedule;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

/**
 * 项目监听器
 */
public class WebContextListener extends ContextLoaderListener {

    @Override
    public WebApplicationContext initWebApplicationContext(ServletContext servletContext) {
        //WEB容器 初始化时调用
        WebApplicationContext webApplicationContext = super.initWebApplicationContext(servletContext);
        //任务调度初始化
        ExampleSchedule.init();
        return webApplicationContext;
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        //WEB容器  关闭时调用
        //任务调度销毁
        ExampleSchedule.destroyed();
        super.contextDestroyed(event);
    }
}
