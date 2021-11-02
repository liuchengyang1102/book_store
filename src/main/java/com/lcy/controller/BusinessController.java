package com.lcy.controller;

import com.lcy.po.Business;
import com.lcy.service.BusinessService;
import com.lcy.util.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @author 刘呈洋
 */
@Controller
public class BusinessController {
    private final static Log logger = LogFactory.getLog(BusinessController.class);
    private final String filePathDir = "D:\\JAVA\\IDEA\\java_code\\ssm_code\\book_store\\src\\main\\webapp\\images\\";

    @Autowired
    private BusinessService businessService;

    @RequestMapping("/business")
    public String businessHome() {
        return "/business";
    }

    @RequestMapping("businessRegister")
    public String businessRegister() {
        return "/businessRegister";
    }

    @RequestMapping("businessLogin")
    @ResponseBody
    public Result<Business> businessLogin(String username, String password, HttpServletRequest request) {
        logger.debug("username:" + username + ",password:" + password);
        Result<Business> businessResult = businessService.businessLogin(username, password);
        logger.debug("businessResult:" + businessResult.getTotal());
        if (businessResult != null) {
            Business business = (Business) businessResult.getData();
            request.getSession().setAttribute("loginBusiness", business);
        }
        return businessResult;
    }

    @RequestMapping("uploadImage")
    @ResponseBody
    public String uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        // 旧的文件名称
        String oldFileName = file.getOriginalFilename();
        //获取文件扩展名
        String extname = oldFileName.substring(file.getOriginalFilename().lastIndexOf("."));

        //防止重名
        String newFlieName = UUID.randomUUID().toString() + extname;
        //返回是整个文件的大小
        String savePath = filePathDir + newFlieName;
        File file1 = new File(savePath);
        if (!file1.exists()) {
            file1.createNewFile();
        }
        Integer n = FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(new File(savePath)));
        long size = file.getSize();
        if (n != size) {
            return "文件上传失败! ";
        } else {
            return newFlieName;
        }
    }

    @RequestMapping("addBusiness")
    public void addBusiness(String userName, String password, String name, String address, String type,
                               double registeredCapital, String logPicture) {
        logger.debug("userName:" + userName + ",password:" + password + ",name:" + name + ",address:" + address
                + ",type:" + type + ",registeredCapital:" + registeredCapital + ",logPicture:" + logPicture);
        businessService.addBusiness(userName, password, name, address, type, registeredCapital, logPicture);
    }
}