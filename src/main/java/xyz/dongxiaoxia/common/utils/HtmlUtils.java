package xyz.dongxiaoxia.common.utils;

/**
 * Created in 2016/5/19 by Tong zhenke <br>
 */
public class HtmlUtils {

    public static String htmlUnescape(String str){
        return org.springframework.web.util.HtmlUtils.htmlUnescape(str);
    }

}
