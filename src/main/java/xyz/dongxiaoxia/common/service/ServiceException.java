package xyz.dongxiaoxia.common.service;

/**
 * Service层公用的Exception, 从由Spring管理事务的函数中抛出时会触发事务回滚.
 * Created in 2016/6/1 by Tong zhenke <br>
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = -6716901610692536827L;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}
