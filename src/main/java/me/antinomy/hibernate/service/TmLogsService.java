package me.antinomy.hibernate.service;

import me.antinomy.hibernate.entity.TmLogsEntity;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ginvan on 15/10/9.
 */
@SuppressWarnings("unused")
@Service("logsService")
public class TmLogsService extends AbstractService {

    @Transactional
    @CacheEvict(value="logs", allEntries = true)
    public void save(TmLogsEntity log) {
        logsDao.save(log);
    }
}
