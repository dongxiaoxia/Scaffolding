package xyz.dongxiaoxia.modules.exception;

/**
 * Created by dongxiaoxia on 2016/10/12.
 * <p>
 * 验证码错误类
 */
public class ExampleException extends RuntimeException {

    public ExampleException() {
        super();
    }

    public ExampleException(String message) {
        super(message);
    }

    public ExampleException(String message, Throwable cause) {
        super(message, cause);
    }
}
