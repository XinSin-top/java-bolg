package top.xinsin.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.xinsin.pojo.Images;

/**
 * Created On 7/20/22 10:18 AM
 *
 * @author xinsin
 * @version 1.0.0
 */

@Mapper
@Repository
public interface UploadImagesMapper {
    Integer insertImages(Images images);
}
