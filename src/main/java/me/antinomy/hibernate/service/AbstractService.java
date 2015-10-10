package me.antinomy.hibernate.service;

import me.antinomy.hibernate.dao.TmApplicationDao;
import me.antinomy.hibernate.dao.TmCompanyDao;
import me.antinomy.hibernate.dao.TmLogsDao;
import me.antinomy.hibernate.dao.TmUserDao;
import me.antinomy.util.Util;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ginvan on 15/10/9.
 */
public abstract class AbstractService {
    protected Logger logger = Util.logger;

    @Autowired
    protected TmLogsDao logsDao;

    @Autowired
    protected TmApplicationDao applicationDao;

    @Autowired
    protected TmCompanyDao companyDao;

    @Autowired
    protected TmUserDao userDao;
}
