package top.xinsin.controller;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.xinsin.service.GetImagesService;

/**
 * Created On 7/20/22 10:35 AM
 *
 * @author xinsin
 * @version 1.0.0
 */
@RestController()
public class GetImagesController {

    private final GetImagesService getImagesService;

    @Autowired
    public GetImagesController(GetImagesService getImagesService) {
        this.getImagesService = getImagesService;
    }

    @GetMapping(value = "/api/getImages/{md5}" , produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getImage(@PathVariable String md5) {
        return getImagesService.getImage(md5);
    }
}
