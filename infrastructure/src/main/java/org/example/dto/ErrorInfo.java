package org.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

import java.util.Map;

@Data
@NoArgsConstructor
@Slf4j
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorInfo {
    // ERROR CODE 1000 -> 1999 for common error codes. MUST DEFINED IN COMMON PROJECT
    public static final String UNKNOWN_ERROR_CODE = "1001";
    public static final ErrorInfo ACCESS_DENIED_ERROR = new ErrorInfo("1002", "Access denied");
    public static final ErrorInfo METHOD_ARGUMENT_NOT_VALID = new ErrorInfo("1003", "Method argument not valid!");
    // ERROR CODE FOR IMPORTING EXCEL
    public static final String IMPORT_UNKNOWN_ERROR_CODE = "1100";
    public static final String IMPORT_PERSISTENCE_ERROR_CODE = "1101";
    public static final String IMPORT_VALIDATE_ERROR_CODE = "1102";
    private String code;
    private String message;
    private HttpStatus status;
    private Map<String, Object> details;

    public ErrorInfo(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ErrorInfo(@Nullable HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
    // ERROR CODE 2000 -> 2999 for Catalog  error codes. MUST DEFINED IN CATALOG PROJECT


    public ErrorInfo(Map<String, Object> details, String code, String message) {
        this.details = details;
        this.code = code;
        this.message = message;
    }

    public static ErrorInfo from(String code, String message) {
        return new ErrorInfo(code, message);
    }

    public static ErrorInfo from(@Nullable HttpStatus status, String code, String message) {
        return new ErrorInfo(code, message);
    }


}
