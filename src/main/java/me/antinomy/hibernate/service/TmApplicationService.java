package me.antinomy.hibernate.service;

import me.antinomy.hibernate.entity.BaseEntity;
import me.antinomy.hibernate.entity.TmApplicationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ginvan on 15/10/9.
 */
@SuppressWarnings("unused")
@Service("applicationService")
public class TmApplicationService extends AbstractService {

    @Value("#{configProperties['constant.default.companyId']}")
    private int DEFAULT_COMPANY_ID;  /** 默认的公司ID */

    @Value("#{configProperties['constant.default.userId']}")
    private int DEFAULT_USER_ID;    /** 默认用户ID */

    @Transactional(readOnly = true)
    public TmApplicationEntity get(Integer id) {
        return applicationDao.get(id);
    }

    @Transactional(readOnly = true)
    public boolean exist(Integer id) {
        return applicationDao.exists(id);
    }

    @Transactional(readOnly = true)
    public TmApplicationEntity saveOrUpdate(TmApplicationEntity applicationEntity) {
        applicationEntity = this.vaildateAndSetDefaults(applicationEntity);
        applicationDao.saveOrUpdate(applicationEntity);
        return applicationEntity;
    }

    /**
     * 序列化前检查
     * @param applicationEntity
     * @return
     */
    private TmApplicationEntity vaildateAndSetDefaults(TmApplicationEntity applicationEntity) {
        if (applicationEntity.getName() == null) {
            applicationEntity.setName("");
        }

        if (applicationEntity.getCompanyId() == 0) {
            //使用默认公司
            applicationEntity.setCompanyId(DEFAULT_COMPANY_ID);
        }

        if (applicationEntity.getChargeUserId() == 0) {
            //使用默认负责人
            applicationEntity.setChargeUserId(DEFAULT_USER_ID);
        }
        return applicationEntity;
    }
}
