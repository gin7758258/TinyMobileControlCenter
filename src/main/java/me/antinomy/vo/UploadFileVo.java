package me.antinomy.vo;

import org.hibernate.service.spi.ServiceException;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * Created by ginvan on 15/10/8.
 */
public class UploadFileVo {
    /**
     * 上传日志文件
     */
    private MultipartFile logFile;
    private String fileName;

    public MultipartFile getLogFile() {
        return logFile;
    }

    public void setLogFile(MultipartFile logFile) {
        this.logFile = logFile;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public String toString() {
        return "UploadFileVo [logFile=" + logFile + "]";
    }

    public boolean vaildateFile() throws ServiceException {
        if (this.getLogFile().getSize() > 1000 * 1000) {
            throw new ServiceException("文件大小不能超过1M");
        }
        return true;
    }

    public void randomFileName() {
        fileName = UUID.randomUUID() + "_" + logFile.getOriginalFilename();
    }
}
