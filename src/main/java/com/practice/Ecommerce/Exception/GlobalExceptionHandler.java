package com.practice.Ecommerce.Exception;
import com.practice.Ecommerce.Model.UserRegisterModel;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler (MyException.class)
    public String MyException(MyException exception){
        return exception.getMessage();
    }

    @ExceptionHandler (MethodArgumentNotValidException.class)
    public List<UserRegisterModel> MethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<UserRegisterModel> userRegisterModels = new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
            userRegisterModels.add(new UserRegisterModel(fieldError.getField(),fieldError.getDefaultMessage()));
        });
        return userRegisterModels;
    }

    @ExceptionHandler (Exception.class)
    public String Exception(Exception ex){
        return ex.getMessage();
    }
    //    @ExceptionHandler (SQLIntegrityConstraintViolationException.class)
//    public List<DuplicationUserModel> SQLIntegrityConstraintViolationException (SQLIntegrityConstraintViolationException ex){
//        List<DuplicationUserModel> duplicateList = new ArrayList<>();
//        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
//            duplicateList.add(new DuplicationUserModel(fieldError.getField(),fieldError.getDefaultMessage()));
//    });
//        return duplicateList;





}



