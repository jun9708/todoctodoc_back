package kr.co.todoctodoc_back._core.interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.todoctodoc_back._core.utils.ScriptUtils;
import kr.co.todoctodoc_back.user.User;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.PrintWriter;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("sessionUser");

        String startEndPoint = request.getRequestURI().split("/")[1];

        if (sessionUser == null) {
                response.setHeader("Content-Type", "text/html; charset=utf-8");
                PrintWriter out = response.getWriter();
                Object Script;
                out.println(ScriptUtils.href("/admin/login", "로그인 후 사용 가능합니다"));
        }
        return true;
    }
}