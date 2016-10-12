package xyz.dongxiaoxia.modules.utils;

import xyz.dongxiaoxia.common.utils.CacheUtils;
import xyz.dongxiaoxia.common.utils.SpringContextHolder;
import xyz.dongxiaoxia.modules.dao.UserDao;
import xyz.dongxiaoxia.modules.entity.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户工具类
 * Created in 2016/4/11 by Tong zhenke <br>
 */
public class UserUtils {

    private static UserDao userDao = SpringContextHolder.getBean(UserDao.class);

    public static final String USER_CACHE = "userCache";
    public static final String USER_CACHE_ID_ = "id_";
    public static final String USER_CACHE_LOGIN_NAME_ = "ln";

    /**
     * 根据ID获取用户
     * @param id
     * @return 取不到返回null
     */
    public static User get(String id){
        User user = (User) CacheUtils.get(USER_CACHE, USER_CACHE_ID_ + id);
        if (user ==  null){
            user = userDao.get(id);
            if (user == null){
                return null;
            }
            CacheUtils.put(USER_CACHE, USER_CACHE_ID_ + user.getId(), user);
            CacheUtils.put(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getName(), user);
        }
        return user;
    }

    /**
     * 根据用户名获取用户
     * @param userName
     * @return 取不到返回null
     */
    public static User getByUserName(String userName){
        User user = (User)CacheUtils.get(USER_CACHE, USER_CACHE_LOGIN_NAME_ + userName);
        if (user == null){
            user = userDao.getByUserName(new User(null, userName));
            if (user == null){
                return null;
            }
            CacheUtils.put(USER_CACHE, USER_CACHE_ID_ + user.getId(), user);
            CacheUtils.put(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getName(), user);
        }
        return user;
    }

    /**
     * 清除当前用户缓存
     */
    public static void clearCache(){
        UserUtils.clearCache(getUser());
    }

    /**
     * 清除指定用户缓存
     * @param user
     */
    public static void clearCache(User user){
        CacheUtils.remove(USER_CACHE, USER_CACHE_ID_ + user.getId());
        CacheUtils.remove(USER_CACHE, USER_CACHE_LOGIN_NAME_ + user.getName());
    }

    /**
     * 获取当前用户
     * @return 取不到返回 new User()
     */
    public static User getUser(){
        //2016年8月17日 18:22:15
        if (getSession() == null){
            return new User();
        }
        User user = (User) getSession().getAttribute("user");
        if(user != null){
            return user;
        }

        // 如果没有登录，则返回实例化空的User对象。
        return new User();
    }

    /**
     * 获取所有用户列表
     * @return
     */
    public static List<User> getUserList(){
        List<User> userList=userDao.findAllList(UserUtils.getUser());
        return userList;
    }

    public static HttpSession getSession() {
        HttpSession session = null;
        try {
            session = getRequest().getSession();
        } catch (Exception e) {}
        return session;
    }

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        return attrs.getRequest();
    }

    // ============== User Cache ==============

    public static Object getCache(String key) {
        return getCache(key, null);
    }

    public static Object getCache(String key, Object defaultValue) {
        Object obj = getSession().getAttribute(key);
        return obj==null?defaultValue:obj;
    }

    public static void putCache(String key, Object value) {
        getSession().setAttribute(key, value);
    }

    public static void removeCache(String key) {
        getSession().removeAttribute(key);
    }


}
