package me.antinomy.controller;

import com.alibaba.fastjson.JSON;
import me.antinomy.hibernate.entity.TmApplicationEntity;
import me.antinomy.hibernate.entity.TmLogsEntity;
import me.antinomy.hibernate.service.TmApplicationService;
import me.antinomy.hibernate.service.TmLogsService;
import me.antinomy.service.AnalysisLogPackageService;
import me.antinomy.service.UploadFileService;
import me.antinomy.util.Util;
import me.antinomy.vo.UploadFileVo;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ginvan on 15/10/8.®
 */

@Controller
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private UploadFileService uploadFileService;

    @Autowired
    private AnalysisLogPackageService analysisLogPackageService;

    @Autowired
    private TmApplicationService applicationService;

    @Autowired
    private TmLogsService logsService;

    @Value("#{configProperties[savePath]}")
    private String savePath;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showUploadPage(HttpServletRequest request) {
        return Util.createModelAndView("upload", null, request);
    }

    @RequestMapping(value = "firstUpload", method = RequestMethod.POST)
    @ResponseBody
    public void uploadFile(HttpServletRequest request, UploadFileVo uploadFile,
                           @RequestParam("appid") String appid, PrintWriter printWriter) {
        Util.logger.info("firstUpload Info: " + uploadFile);
        uploadFile.randomFileName();    //重要！！随机化文件名
        boolean flag = false;
        String errorMessage = "";
        String logFilefullPath = "";
        try {
            flag = uploadFileService.uploadForm(uploadFile);
            if (flag) {
                //文件保存成功
                logFilefullPath = savePath + uploadFile.getFileName();

                //将文件名与appid映射并保存
                linkAppidWithFile(appid, logFilefullPath);
            }
            else {
                Util.logger.error("firstUpload failed!");
                errorMessage = "新增文件失败!";
            }
            errorMessage += "文件路径：" + savePath + uploadFile.getFileName();
        } catch (ServiceException serviceE) {
            Util.logger.error("firstUpload failed!" , serviceE);
            errorMessage = serviceE.getMessage();
        } catch (Exception e) {
            Util.logger.error("firstUpload failed!" , e);
            errorMessage = "上传文件失败!";
        }
        Map<String, Object> model = new HashMap<>();
        model.put("result", flag);
        model.put("message", errorMessage);

        String jsonString = JSON.toJSONString(model);
        printWriter.write(jsonString);
        printWriter.flush();
        printWriter.close();
    }

    private void linkAppidWithFile(String appId, String filePath) {
        TmApplicationEntity applicationEntity;
        if (appId != null && appId.length() > 0) {
            if (applicationService.exist(Integer.parseInt(appId))) {
                applicationEntity = applicationService.get(Integer.parseInt(appId));
            }
            else  {
                applicationEntity = new TmApplicationEntity();
                applicationEntity.setLastModifyModel("UploadController");
                applicationService.saveOrUpdate(applicationEntity);
            }
        }
        else {
            applicationEntity = new TmApplicationEntity();
            applicationEntity.setLastModifyModel("UploadController");
            applicationService.saveOrUpdate(applicationEntity);
        }

        int savedAppId = applicationEntity.getId();

        //Link
        TmLogsEntity logsEntity = new TmLogsEntity();
        logsEntity.setAppId(savedAppId);
        logsEntity.setTime(new Timestamp(System.currentTimeMillis()));
        logsEntity.setFilePath(filePath);
        logsEntity.setLastModifyModel("UploadController");
        logsService.save(logsEntity);
    }
}
