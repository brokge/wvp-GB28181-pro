package com.genersoft.iot.vmp.utils;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @author chenlw
 * @date 2021/12/21 1:15 下午
 */
public class FileUtils {
    public static void saveFile(MultipartFile fileContent, String targetPath, String newFileName) {
        OutputStream os = null;
        InputStream inputStream = null;
        try {
            inputStream = fileContent.getInputStream();
            if (StringUtils.isEmpty(newFileName)) {
                newFileName = fileContent.getOriginalFilename();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            // 2、保存到临时文件
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流保存到本地文件
            File tempFile = new File(targetPath);
            if (!tempFile.exists()) {
                tempFile.mkdirs();
            }
            os = new FileOutputStream(tempFile.getPath() + File.separator + newFileName);
            // 开始读取
            while ((len = inputStream.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 完毕，关闭所有链接
            try {
                os.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
