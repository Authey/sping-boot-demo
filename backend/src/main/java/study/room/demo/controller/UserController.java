package study.room.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.room.demo.common.Response;
import study.room.demo.utils.JwtUtil;
import study.room.demo.utils.ThreadLocalUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Authey
 * @since 2025-04-01
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping(value = "/login")
    public Response<String> login(@RequestBody JSONObject json) {
        String username = json.getString("username");
        String password = json.getString("password");

        if (!"pwd".equals(password)) {
            return Response.failure("密码错误");
        }

        Map<String, Object> claims = new HashMap<>();
        claims.put("username", username);

        ThreadLocalUtil.set(claims);
        String token = JwtUtil.getToken(claims);

        return Response.success(token);
    }

    @PostMapping(value = "/logout")
    public Response<String> logout() {
        ThreadLocalUtil.remove();
        return Response.success();
    }

}
