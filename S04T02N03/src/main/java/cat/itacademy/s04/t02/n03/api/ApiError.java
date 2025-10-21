package cat.itacademy.s04.t02.n03.api;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.OffsetDateTime;
import java.util.List;

public class ApiError {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OffsetDateTime timestamp = OffsetDateTime.now();
    private int status;
    private String error;
    private String message;
    private String code;
    private String path;
    private List<FieldErrorItem> errors;

    public ApiError() {}

    public ApiError(int status, String error, String message, String code, String path, List<FieldErrorItem> errors) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.code = code;
        this.path = path;
        this.errors = errors;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<FieldErrorItem> getErrors() {
        return errors;
    }

    public void setErrors(List<FieldErrorItem> errors) {
        this.errors = errors;
    }

    public static class FieldErrorItem {
        private String field;
        private String reason;

        public FieldErrorItem() {}
        public FieldErrorItem(String field, String reason) {
            this.field = field;
            this.reason = reason;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }
    }
}
