package br.com.alepedidos.domain.service;

import br.com.alepedidos.application.request.user.UserRequest;
import br.com.alepedidos.application.response.user.UserResponse;

import java.beans.Transient;

public interface IUserService {
    @Transient
    UserResponse createUser(UserRequest request);
}
