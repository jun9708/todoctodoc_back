package kr.co.todoctodoc_back._core.filter;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.todoctodoc_back._core.errors.exception.Exception401;
import kr.co.todoctodoc_back._core.utils.JwtTokenUtils;
import kr.co.todoctodoc_back.user.User;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.io.PrintWriter;

public class JwtAuthorizationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String jwt = request.getHeader("Authorization");
        if (jwt == null || jwt.isEmpty()){
            onError(response, "토큰이 없습니다.");
            return;
        }
        try {
            DecodedJWT decodedJWT = JwtTokenUtils.verify(jwt);
            int userId = decodedJWT.getClaim("id").asInt();
            String username = decodedJWT.getClaim("username").asString();

            User sessionUser = User.builder().userId(String.valueOf(userId)).username(username).build();

            HttpSession session = request.getSession();
            session.setAttribute("sessionUser", sessionUser);
            chain.doFilter(request, response);

        } catch (SignatureVerificationException | JWTDecodeException e1) {
            onError(response, "토큰 검증 실패");
        } catch (TokenExpiredException e2){
            onError(response, "토큰 시간 만료");
        }
    }
    private void onError(HttpServletResponse response, String msg){
        Exception401 e401 = new Exception401(msg);

        try {
            String body = new ObjectMapper().writeValueAsString(e401.body());
            response.setStatus(e401.status().value());
            //response.setHeader("Content-Type", "application/json; charset=utf-8");
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            PrintWriter out = response.getWriter();
            out.println(body);
        } catch (Exception e) {

        }

    }
}