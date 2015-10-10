package me.antinomy.service;

import org.springframework.stereotype.Service;

/**
 * Created by ginvan on 15/10/8.
 */
@Service
public interface AnalysisLogPackageService {

    /**
     * 解析上传的log文件
     * @param packagePath
     * @param appId
     * @return
     */
    boolean analysisLogPackage(String packagePath, String appId);
}
