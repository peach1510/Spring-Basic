package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

// request 스코프는 HTTP 요청이 들어와서 나갈 때까지만 유지되는데
// HTTP 요청이 들어오기도 전에 스프링이 뜨면서 MyLogger 빈 달라고 하니까
// 완전 어리둥절 되면서 오류 남.
@Component
@RequiredArgsConstructor // 생성자 자동 주입
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

    // log-demo라는 요청이 오면
    @RequestMapping("log-demo")
    @ResponseBody // View 화면 없이 문자열을 바로 반환하고 싶음
    // 고객 요청 정보를 받을 수 있음.
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testId");

        return "OK";
    }

}
