package xyz.dongxiaoxia.modules.controller;

/**
 * Created by dongxiaoxia on 2016/9/12.
 */

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import xyz.dongxiaoxia.base.BaseControllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ExampleControllerTest extends BaseControllerTest {
    @Test
    public void controllerExceptionHandler() throws Exception {
        long start = System.currentTimeMillis();
        ResultActions actions = this.mockMvc.perform(post("/examples").contentType(MediaType.APPLICATION_JSON).header("token", "").content(""));
        System.out.println(actions.andReturn().getResponse().getContentAsString());
        long end = System.currentTimeMillis();
        System.out.println("用时：" + (end - start)  + "毫秒");
        actions.andExpect(status().isOk());
    }
}