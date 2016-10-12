package xyz.dongxiaoxia.modules.service;

import org.springframework.stereotype.Service;
import xyz.dongxiaoxia.common.service.CrudService;
import xyz.dongxiaoxia.modules.dao.ExampleDao;
import xyz.dongxiaoxia.modules.entity.Example;

/**
 * Created by dongxiaoxia on 2016/10/12.
 */
@Service
public class ExampleService extends CrudService<ExampleDao, Example> {
}
