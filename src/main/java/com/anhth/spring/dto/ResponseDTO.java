package com.anhth.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO<T> {
    private int status = 1;
    private String message;
    private T data;
    private List<T> datas;

    public ResponseDTO(String message) {
        this.message = message;
    }

    public ResponseDTO(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
