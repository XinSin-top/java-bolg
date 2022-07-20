package top.xinsin.service;

import com.alibaba.fastjson2.JSONObject;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import top.xinsin.dao.UploadImagesMapper;
import top.xinsin.pojo.Images;
import top.xinsin.util.ResultData;
import top.xinsin.util.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Created On 7/20/22 9:49 AM
 *
 * @author xinsin
 * @version 1.0.0
 */
@Service
@Slf4j
public class UploadImagesService {

    private final UploadImagesMapper uploadImagesMapper;

    @Autowired
    public UploadImagesService(UploadImagesMapper uploadImagesMapper) {
        this.uploadImagesMapper = uploadImagesMapper;
    }

    @Value("${savePath}")
    public String savePath;

    @SneakyThrows
    public ResultData<JSONObject> UploadImages(MultipartFile file) {
        JSONObject jsonObject = new JSONObject();
        File newFile =new File(savePath);
        if(!newFile.exists()){
            log.info("文件夹不存在，创建文件夹");
            newFile.mkdirs();
        }
        System.out.println(file);
        String fileName = file.getOriginalFilename();
        //文件类型
        String fileType = fileName.substring(fileName.lastIndexOf(".")+1);
        //md5
        String md5Hex = DigestUtils.md5Hex(file.getBytes());
        //size
        Long size = file.getSize();

        String url = StringUtils.getImageUrl + md5Hex;

        uploadImagesMapper.insertImages(new Images(url,fileType,size,md5Hex));

        InputStream inputStream = file.getInputStream();

        FileOutputStream fileOutputStream = new FileOutputStream(savePath + md5Hex);

        IOUtils.copy(inputStream,fileOutputStream);

        jsonObject.put("url",url);

        return ResultData.success(jsonObject);
    }
}
