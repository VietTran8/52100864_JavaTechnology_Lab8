package vn.edu.tdtu.Lab08.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {
    @RequestMapping("/custom-error")
    public String errorHandler(HttpServletRequest request, Model model){
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        int statusCode = status != null ? Integer.valueOf(status.toString()) : 500;
        String errorMsg = "";
        switch (statusCode){
            case 404:
                errorMsg = "[Custom] Page not found";
                break;
            case 401:
                errorMsg = "[Custom] Unauthorized";
                break;
            default:
                errorMsg = "[Custom] Error";
                break;
        }
        model.addAttribute("errorMsg", errorMsg);
        return "error";
    }
}
