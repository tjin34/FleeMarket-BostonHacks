package com.shinji.fleemarket.Bean;

/**
 * Created by KimuraShin on 17/10/29.
 */

public class BaseEntity<T> {


    /**
     * success : true
     * error :
     */
    private T data;
    private boolean success;
    private String error;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
