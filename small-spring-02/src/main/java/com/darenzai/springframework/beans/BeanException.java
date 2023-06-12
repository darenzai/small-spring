package com.darenzai.springframework.beans;

/**
 * <p>
 * description: BeanException
 * <p>
 *
 * @author 40233-胡佳艺 2023/06/08 9:12
 */
public class BeanException extends RuntimeException {

    public BeanException(String msg) {
        super(msg);
    }

    public BeanException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
