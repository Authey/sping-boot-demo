package study.room.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import study.room.demo.entity.User;
import study.room.demo.mapper.UserMapper;
import study.room.demo.service.UserService;

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
