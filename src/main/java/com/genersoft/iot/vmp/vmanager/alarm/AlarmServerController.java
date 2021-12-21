package com.genersoft.iot.vmp.vmanager.alarm;

import com.alibaba.fastjson.JSONObject;
import com.genersoft.iot.vmp.gb28181.utils.XmlUtil;
import com.genersoft.iot.vmp.utils.FileUtils;
import com.genersoft.iot.vmp.utils.IpUtil;
import com.genersoft.iot.vmp.utils.JarFileUtils;
import com.genersoft.iot.vmp.vmanager.bean.EventNotificationAlert;
import com.genersoft.iot.vmp.vmanager.bean.XMLElementNotify;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import okhttp3.MultipartBody;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

/**
 * @author chenlw
 * @date 2021/12/20 5:02 下午
 */
@Api(tags = "报警信息管理")
@CrossOrigin
@RestController
@RequestMapping("/api/server/alarm")
public class AlarmServerController {

    private static Logger log = LoggerFactory.getLogger(JarFileUtils.class);

    @ApiOperation("接收报警消息")
    @PostMapping(value = "/receiveMsg")
    public void save(HttpServletRequest request) {
        log.info("接收报警消息:{}", request.getContentType());
        MultipartHttpServletRequest params = ((MultipartHttpServletRequest) request);
        Iterator<String> fileNameIterator = params.getFileNames();
        String ip = IpUtil.getIpAddr(request);
        log.info("接收报警消息来源:{}", ip);
        while (fileNameIterator.hasNext()) {
            String fileKey = fileNameIterator.next();
            List<MultipartFile> files = params.getFiles(fileKey);
            for (int i = 0; i < files.size(); ++i) {
                MultipartFile file = files.get(i);
                if (!file.isEmpty()) {
                    String fileName = file.getOriginalFilename();
                    FileUtils.saveFile(file, "./files/", fileKey + fileName);
                } else {
                    log.info("You failed to upload " + i
                            + " because the file was empty.");
                }
            }
            log.info("upload successful");
        }
    }

    @ApiOperation("接收报警消息")
    @PostMapping(value = "/receiveMsg2")
    public void receiveMsg(HttpServletRequest httpServletRequest) {
        log.info("接收报警消息:{}", httpServletRequest.getContentType());
    }

    @ApiOperation("接收报警消息")
    @PostMapping(value = "/receiveMsg1", produces = "application/xml")
    public void receiveMsg1(@RequestBody byte[] data, HttpServletRequest httpServletRequest) {
        String xmlContent = new String(data, 0, data.length, Charset.forName("UTF-8"));
        log.info("接收报警消息:{}", httpServletRequest.getContentType());
        Element element = XmlUtil.parseXml(xmlContent);
        JSONObject jsonObject = new JSONObject();
        XmlUtil.node2Json(element, jsonObject);
        EventNotificationAlert eventNotificationAlert = JSONObject.toJavaObject(jsonObject, EventNotificationAlert.class);
        log.info("转换Java对象格式ToString:{}", eventNotificationAlert.toString());
    }
}
