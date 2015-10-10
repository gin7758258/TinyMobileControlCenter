package me.antinomy.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ginvan on 15/10/8.
 */
public class Util {
    public static final Logger logger = LogManager.getLogger("TMCC");

    /**
     * 封装返回
     * @param viewName
     * @param model
     * @param request
     * @return
     */
    public static ModelAndView createModelAndView(String viewName, Map<String, Object> model, HttpServletRequest request) {
        if (model == null) {
            model = new HashMap<String, Object>();
        }
        model.put("baseURL", request.getContextPath());
        return new ModelAndView(viewName, model);
    }

    /**
     * Java文件操作 获取文件扩展名
     *
     *  Created on: 2011-8-2
     *      Author: blueeagle
     */
        public static String getExtensionName(String filename) {
            if ((filename != null) && (filename.length() > 0)) {
                int dot = filename.lastIndexOf('.');
                if ((dot >-1) && (dot < (filename.length() - 1))) {
                    return filename.substring(dot + 1);
                }
            }
            return filename;
        }
        /**
         * Java文件操作 获取不带扩展名的文件名
         *
         *  Created on: 2011-8-2
         *      Author: blueeagle
         */
        public static String getFileNameNoEx(String filename) {
            if ((filename != null) && (filename.length() > 0)) {
                int dot = filename.lastIndexOf('.');
                if ((dot >-1) && (dot < (filename.length()))) {
                    return filename.substring(0, dot);
                }
            }
            return filename;
        }
}
