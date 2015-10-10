package me.antinomy.service;

import me.antinomy.vo.UploadFileVo;
import org.springframework.stereotype.Service;

/**
 * Created by ginvan on 15/10/8.
 */

@Service
public interface UploadFileService {
    boolean uploadForm(UploadFileVo uploadFile) throws Exception;
}
