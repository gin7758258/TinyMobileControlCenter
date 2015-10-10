package me.antinomy.service;

import me.antinomy.util.Util;
import me.antinomy.vo.UploadFileVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ginvan on 15/10/8.
 */
@Service
public class UploadFileServiceImpl implements UploadFileService {

    @Value("#{configProperties[savePath]}")
    private String savePath;

    @Override
    public boolean uploadForm(UploadFileVo uploadFile) throws Exception {
        uploadFile.vaildateFile();
        return uploadFile(savePath, uploadFile.getLogFile(), uploadFile.getFileName());
    }

    private boolean uploadFile(String destinationDir, MultipartFile file, String filename) throws Exception{
        Util.logger.info("文件长度: " + file.getSize());
        Util.logger.info("文件类型: " + file.getContentType());
        Util.logger.info("文件名称: " + file.getName());
        Util.logger.info("文件原名: " + file.getOriginalFilename());
        Util.logger.info("文件最终命名: " + filename);
        Util.logger.info("========================================");
        try {
            saveFileFromInputStream(file.getInputStream(), destinationDir, filename);
        }
        catch (IOException e) {
            Util.logger.error(e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * 保存文件
     * @param stream
     * @param path
     * @param filename
     * @throws IOException
     */
    private void saveFileFromInputStream(InputStream stream,String path,String filename)
            throws IOException {
        FileOutputStream outputStream = new FileOutputStream( path + "/"+ filename);
        int byteCount = 0;
        byte[] bytes = new byte[1024];
        while ((byteCount = stream.read(bytes)) != -1){
            outputStream.write(bytes, 0, byteCount);
        }
        outputStream.close();
        stream.close();
    }

    public String getSavePath() {
        return savePath;
    }
}
