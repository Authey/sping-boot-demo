package study.room.demo.exception;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import study.room.demo.common.Response;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public Response<String> handleException(Exception e) {
        logger.error(e.getMessage());
        return Response.failure(StringUtils.isNotBlank(e.getMessage()) ? e.getMessage() : "操作失败");
    }

}
