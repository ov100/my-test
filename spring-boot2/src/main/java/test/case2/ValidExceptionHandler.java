package test.case2;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @description: 参数验证异常
 * @author: gb
 * @create: 2020/09/25
 */
@RestControllerAdvice("test.case2")
public class ValidExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST) //设置状态码为 400
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public String paramExceptionHandler(MethodArgumentNotValidException e) {
        BindingResult exceptions = e.getBindingResult();
        // 判断异常中是否有错误信息，如果存在就使用异常中的消息，否则使用默认消息
        String msg = null;
        if (exceptions.hasErrors()) {
            List<ObjectError> errors = exceptions.getAllErrors();
            if (!errors.isEmpty()) {
                // 这里列出了全部错误参数，按正常逻辑，只需要第一条错误即可
                FieldError fieldError = (FieldError) errors.get(0);
                msg = fieldError.getDefaultMessage();
            }
        }else{
            msg = "请求参数错误";
        }
        ErrorMsg o = buildErrMsg(msg);

        return JSON.toJSONString(o);
    }

    @Data
    @Accessors(chain = true)
    class ErrorMsg{
        private int code;
        private String errMsg;
    }

    private ErrorMsg buildErrMsg(String msg){
        return new ErrorMsg().setCode(400).setErrMsg(msg);
    }

}
