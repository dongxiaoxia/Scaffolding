package xyz.dongxiaoxia.common.constants;

/**
 * Created in 2016/4/21 by Tong zhenke <br>
 */
public enum Sex {

    MAN("1", "男"), WOMEN("2", "女");

    private String sex;
    private String name;

    private Sex(String sex, String name) {
        this.sex = sex;
        this.name = name;
    }

    public static String getNameBySex(String sex){
        for(Sex type : Sex.values()){
            if(type.sex.equals(sex)){
                return type.name;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return this.sex;
    }

}
