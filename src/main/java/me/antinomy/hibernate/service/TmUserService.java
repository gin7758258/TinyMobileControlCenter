package me.antinomy.hibernate.service;

import me.antinomy.hibernate.entity.TmUserEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ginvan on 15/10/9.
 */
@Service("userService")
public class TmUserService extends AbstractService {
    @Transactional(readOnly = true)
    public TmUserEntity find(Integer id) {
        return userDao.get(id);
    }
}
