package study.room.demo.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.room.demo.common.Response;

@RestController
@RequestMapping(value = "/home")
public class HomeController {

    @PostMapping(value = "/test")
    public Response<String> test() {
        return Response.success("登录状态测试成功");
    }

}
