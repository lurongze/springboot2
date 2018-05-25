package com.lrz.handler;

import com.lrz.utils.Response;
import com.lrz.utils.Result;
import org.springframework.web.bind.annotation.*;

/**
 * Created by gz000172 on 2018/5/20.
 */
@ControllerAdvice(annotations = RestController.class)
@ResponseBody
public class RestExceptionHandler {
    @ExceptionHandler
    @ResponseStatus
    public Result runtimeExceptionHandler(Exception e) {
        return Response.fail(e.getMessage());
    }
}
