package xyz.dongxiaoxia.modules.entity;

import xyz.dongxiaoxia.common.persistence.DataEntity;

/**
 * Created by dongxiaoxia on 2016/10/12.
 */
public class User extends DataEntity<User> {
    private static final long serialVersionUID = -1L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() {
        super();
    }

    public User(String id){
        super(id);
    }

    public User(String id,String name){
        this.id = id;
        this.name = name;
    }

}