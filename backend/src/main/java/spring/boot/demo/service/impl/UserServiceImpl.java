package spring.boot.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import spring.boot.demo.entity.User;
import spring.boot.demo.mapper.UserMapper;
import spring.boot.demo.service.UserService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Authey
 * @since 2025-04-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
