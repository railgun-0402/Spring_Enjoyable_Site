package com.su.enjoy.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.su.enjoy.model.user.User;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;
import java.util.ArrayList;

public class JsonAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    /**
     * param: authenticationManager
     *
     * 認証時のユーザー情報取得の際に、後に実装するUserDetailsServiceが呼ばれる
     */
    public JsonAuthenticationFilter(AuthenticationManager authenticationManager) {
        // AuthenticationManagerの設定
        this.authenticationManager = authenticationManager;

        // ログインパス設定
        setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login", "POST"));
        // ログイン用パラメータの設定
        setUsernameParameter("username");
        setPasswordParameter("password");

        // ログイン成功時はtokenを発行してレスポンスにセット
        this.setAuthenticationSuccessHandler(((request, response, authentication) -> {
            // token
            String token = JWT.create()
                    .withIssuer("com.su.enjoy")
                    .withClaim("username", authentication.getName()) //keyに対してvalueの設定。汎用的な様々な値を保持できる
            .sign(Algorithm.HMAC256("secret")); // 利用アルゴリズムを指定してJWTを新規作成

            // tokenにX-AUTH-TOKENを設定
            response.setHeader("X-AUTH-TOKEN", token);
            response.setStatus(200);
        }));

        // ログイン失敗時は失敗コード(401エラー)を設定
        this.setAuthenticationFailureHandler(((request, response, exception) -> {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }));
    }

    /**
     * ログイン処理メソッド
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            ServletInputStream stream = request.getInputStream();
            // リクエストのJSON値をUserFormにマッピング
            User user = new ObjectMapper().readValue(stream, User.class);

            return this.authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword(), new ArrayList<>()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
