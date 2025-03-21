package com.metacoding.storev1.log;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LogController {

    private LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/log")
    public String list(HttpServletRequest request) {

        List<LogResponse.ListPage> listPage = logService.구매목록();
        request.setAttribute("models", listPage);
        return "log/list";
    }
}

// @GetMapping("/log/list")
// public String loglist(HttpServletRequest request) {
// List<Log> log = logService.구매목록();
// request.setAttribute("log",log);
// return "store/update-form";
// }