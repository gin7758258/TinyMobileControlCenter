package me.antinomy.hibernate.service;

import me.antinomy.hibernate.entity.TmCompanyEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by ginvan on 15/10/9.
 */
@SuppressWarnings("unused")
@Service("companyService")
public class TmCompanyService extends AbstractService {

    @Value("#{configProperties['constant.default.companyId']}")
    public int DEFAULT_COMPANY_ID;  /** 默认的公司ID */

    public TmCompanyEntity find(Integer id) {
        return companyDao.get(id);
    }

    public TmCompanyEntity getDefaultCompany() {
        return companyDao.get(DEFAULT_COMPANY_ID);
    }
}
