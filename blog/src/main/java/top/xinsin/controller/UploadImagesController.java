package top.xinsin.controller;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.xinsin.service.UploadImagesService;
import top.xinsin.util.ResultData;

/**
 * Created On 7/20/22 9:36 AM
 *
 * @author xinsin
 * @version 1.0.0
 */

@RestController()
public class UploadImagesController {

    private final UploadImagesService uploadImagesService;

    @Autowired
    public UploadImagesController(UploadImagesService uploadImagesService) {
        this.uploadImagesService = uploadImagesService;
    }

    @PostMapping("/api/upload/images")
    public ResultData<JSONObject> uploadImages(@RequestPart("file")MultipartFile file) {
        return uploadImagesService.UploadImages(file);
    }
}
