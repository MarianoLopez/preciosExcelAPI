package com.z.precios.Controller
import com.z.precios.Model.Message
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class GlobalErrorHandler{
    private val logger = LoggerFactory.getLogger(GlobalErrorHandler::class.java)

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception::class)
    fun conflict(req: HttpServletRequest, ex:Exception): Message {
        logger.debug(ex.toString())
        return Message(ex.message?:ex.toString(), 400, req.requestURI)
    }
}