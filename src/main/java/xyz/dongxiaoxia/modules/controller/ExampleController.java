package xyz.dongxiaoxia.modules.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.dongxiaoxia.common.controller.BaseController;
import xyz.dongxiaoxia.modules.entity.Example;
import xyz.dongxiaoxia.modules.service.ExampleService;
import xyz.dongxiaoxia.modules.vo.AjaxResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dongxiaoxia on 2016/10/12.
 */
@Controller
@RequestMapping(value = "examples")
public class ExampleController extends BaseController {

    @Autowired
    private ExampleService service;

    @ResponseBody
    @RequestMapping(value = "")
    public ResponseEntity<AjaxResult> list(){
        List<Example> examples = new ArrayList<>();
        for (int i = 0;i<10;i++){
            Example e = new Example();
            e.setValue("value" + i);
            examples.add(e);
        }
        return new ResponseEntity<>(AjaxResult.success(examples), HttpStatus.OK);
    }
}
