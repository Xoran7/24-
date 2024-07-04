package org.example.app00.vo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Result<T> {

    private Integer code;

    private String message;

    private T data;

    public static <T> Result<T> success(String message) {
        return Result.<T>builder().code(200).message(message).build();
    }

    public static <T> Result<T> success(String message, T data) {
        return Result.<T>builder().code(200).message(message).data(data).build();
    }

    public static <T> Result<T> fail(String message) {
        return Result.<T>builder().code(500).message(message).build();
    }

    public static <T>Result<T> fail(String message, T data) {
        return Result.<T>builder().code(500).message(message).data(data).build();
    }

    public static <T> Result<T> notLogin(String message) {
        return Result.<T>builder().code(400).message(message).build();
    }

}
