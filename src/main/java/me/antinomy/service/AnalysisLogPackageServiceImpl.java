package me.antinomy.service;

import me.antinomy.util.GZip;
import me.antinomy.util.Util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ginvan on 15/10/8.
 */
@Service
public class AnalysisLogPackageServiceImpl implements AnalysisLogPackageService {

    private Lock lock = new ReentrantLock();

    @Value("#{configProperties[savePathTemp]}")
    private String workPath;

    @Value("#{configProperties[savePath]}")
    private String savePath;

    @Override
    public boolean analysisLogPackage(String packagePath, String appId) {

        // =====================================
        // Files Check Start
        File workFolder = new File(workPath);
        //检查工作区域是否存在
        if (!workFolder.exists()) {
            Util.logger.info("工作区域不存在，新建");
            workFolder.mkdir();
            return false;
        }
        else if (workFolder.exists() && !workFolder.isDirectory()) {
            //工作区域存在但不是文件夹
            Util.logger.info("工作区域不是文件夹，删除并新建文件夹");
            workFolder.delete();
            workFolder.mkdir();
            return false;
        }

        //检查工作目标文件是否存在
        File packageFile = new File(packagePath);
        if (!packageFile.exists()) {
            return false;
        }

        // File Check End
        // ======================================

        // Decompress
        decompress(packagePath);

        return false;
    }

    private static void decompress(String compressFilePath) {
        String desPath = compressFilePath.replace(".tar.gz", "");
        GZip.unTargzFile(compressFilePath, desPath);
    }

    private static void deleteDirectory(String filePath) {
        File file = new File(filePath);
        if(!file.exists()){
            return;
        }

        if(file.isFile()){
            file.delete();
        }else if(file.isDirectory()){
            File[] files = file.listFiles();
            for (File myfile : files) {
                deleteDirectory(filePath + "/" + myfile.getName());
            }

            file.delete();
        }
    }
}
