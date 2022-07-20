package top.xinsin.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created On 7/20/22 10:59 AM
 *
 * @author xinsin
 * @version 1.0.0
 */
@Service
@Slf4j
public class GetImagesService {

    @Value("${savePath}")
    public String savePath;
    @SneakyThrows
    public byte[] getImage(String md5){
        File file = new File(savePath + md5);
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        return bytes;
    }
}
