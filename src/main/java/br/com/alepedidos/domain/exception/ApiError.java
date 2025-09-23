package br.com.alepedidos.domain.exception;

import java.util.List;


public record ApiError(String message,
                       String error,
                       Integer status,
                       String path,
                       String timestamp,
                       List<String> errors) {

}
