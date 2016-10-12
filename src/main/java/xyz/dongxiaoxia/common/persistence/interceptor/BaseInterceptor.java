package xyz.dongxiaoxia.common.persistence.interceptor;

import xyz.dongxiaoxia.common.config.Global;
import xyz.dongxiaoxia.common.persistence.Page;
import xyz.dongxiaoxia.common.persistence.dialect.Dialect;
import xyz.dongxiaoxia.common.persistence.dialect.db.DB2Dialect;
import xyz.dongxiaoxia.common.persistence.dialect.db.MySQLDialect;
import xyz.dongxiaoxia.common.persistence.dialect.db.OracleDialect;
import xyz.dongxiaoxia.common.utils.Reflections;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.plugin.Interceptor;

import java.io.Serializable;
import java.util.Properties;

/**
 * Mybatis分页拦截器基类
 * Created in 2016/4/12 by Tong zhenke <br>
 */
public abstract class BaseInterceptor implements Interceptor, Serializable {

    private static final long serialVersionUID = 6024453401815218932L;

    protected static final String PAGE = "page";

    protected static final String DELEGATE = "delegate";

    protected static final String MAPPED_STATEMENT = "mappedStatement";

    protected Log log = LogFactory.getLog(this.getClass());

    protected Dialect DIALECT;

    /**
     * 对参数进行转换和检查
     * @param parameterObject 参数对象
     * @param page            分页对象
     * @return 分页对象
     * @throws NoSuchFieldException 无法找到参数
     */
    @SuppressWarnings("unchecked")
    protected static Page<Object> convertParameter(Object parameterObject, Page<Object> page) {
        try{
            if (parameterObject instanceof Page) {
                return (Page<Object>) parameterObject;
            } else {
                return (Page<Object>) Reflections.getFieldValue(parameterObject, PAGE);
            }
        }catch (Exception e) {
            return null;
        }
    }

    /**
     * 设置属性，支持自定义方言类和制定数据库的方式
     * <code>dialectClass</code>,自定义方言类。可以不配置这项
     * <ode>dbms</ode> 数据库类型，插件支持的数据库
     * <code>sqlPattern</code> 需要拦截的SQL ID
     * @param p 属性
     */
    protected void initProperties(Properties p) {
        Dialect dialect = null;
        String dbType = Global.getConfig("jdbc.type");
        log.debug("--------------------------jdbc.type-------------------------- > " + dbType);
        if ("db2".equals(dbType)){
            dialect = new DB2Dialect();
        }else if("mysql".equals(dbType)){
            dialect = new MySQLDialect();
        }else if("oracle".equals(dbType)){
            dialect = new OracleDialect();
        }
        if (dialect == null) {
            throw new RuntimeException("mybatis dialect error.");
        }
        DIALECT = dialect;
    }

}
