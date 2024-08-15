package kr.co.todoctodoc_back._core.interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.co.todoctodoc_back._core.utils.ScriptUtils;
import kr.co.todoctodoc_back.user.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

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

    
    //컨트롤러의 핸들러 메서드가 실행된 후, 뷰가 렌더링되기 전에 실행
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    
    //통합개발시
    //모든 요청 처리가 완료된 후 실행 (예외가 발생해도 실행)
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        
    }
}