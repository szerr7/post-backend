package edu.miu.postbackend.service;


import edu.miu.postbackend.dto.request.LoginRequest;
import edu.miu.postbackend.dto.request.RefreshTokenRequest;
import edu.miu.postbackend.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
