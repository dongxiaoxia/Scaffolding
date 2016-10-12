package xyz.dongxiaoxia.modules.entity;

import xyz.dongxiaoxia.common.persistence.DataEntity;

/**
 * Created by dongxiaoxia on 2016/10/12.
 */
public class Example extends DataEntity<Example> {
    private static final long serialVersionUID = -1L;

    private String value;

    public Example() {
        super();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
