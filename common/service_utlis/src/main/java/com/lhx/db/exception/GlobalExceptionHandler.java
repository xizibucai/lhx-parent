package com.lhx.db.exception;

import com.lhx.db.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author hc
 * @version 1.0
 *  统一异常处理类
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    //全局异常
    @ExceptionHandler(Exception.class)
    public R error(Exception e){
        e.printStackTrace();
        return R.error().message("执行了全局异常");
    }

    @ExceptionHandler(ArithmeticException.class)
    public R error(ArithmeticException e){
        e.printStackTrace();
        return R.error().message("执行了ArithmeticException异常");
    }

    @ExceptionHandler(HuanXiException.class)
    public R error(HuanXiException e){
        e.printStackTrace();
        //getMsg:是返回的json提示错误信息。getMessage:返回的是错误信息。。
        log.error(e.getMessage());
        return R.error().message(e.getMsg()).code(e.getCode());
    }
}
