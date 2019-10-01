package com.yuan.io;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * 上传小工具类
 * @author Yuan-9826
 */
public class UploadUtils {
    /**
     * 单文件上传
     *
     * @param request
     * @param uploadPath 文件要上传到的路径
     */
    public static String uploadFile(HttpServletRequest request, String uploadPath) {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(factory);
        /**
         * 1.工厂：DiskFileItemFactory
         * 2.解析器：ServletFileUpload
         * 3.表单项：FileItem
         */
        try {
            List<FileItem> fileItems = sfu.parseRequest(request);
            FileItem item = fileItems.get(0);
            String fileName = item.getName();
            //保存
            File savePath = new File(uploadPath + fileName);
            item.write(savePath);
            return savePath.toString();
        } catch (Exception e) {
            throw new RuntimeException("文件上传未成功");
        }
    }
}

