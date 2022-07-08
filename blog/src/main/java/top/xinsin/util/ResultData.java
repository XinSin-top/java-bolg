package top.xinsin.util;

import lombok.Data;
import top.xinsin.enums.HttpCodes;

/**
 * Created On 7/8/22 9:01 PM
 *
 * @author xinsin
 * @version 1.0.0
 */
@Data
public class ResultData<T> {
    private int status;
    private String message;
    private T data;
    private long timestamp;

    public ResultData() {
        this.timestamp = System.currentTimeMillis();
    }
    public static<T> ResultData<T> success(T data){
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(HttpCodes.HTTP_CODES200.getCode());
        resultData.setMessage(HttpCodes.HTTP_CODES200.getMessage());
        resultData.setData(data);
        return resultData;
    }
    public static<T> ResultData<T> failed(HttpCodes httpCodes,T data){
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(httpCodes.getCode());
        resultData.setMessage(httpCodes.getMessage());
        resultData.setData(data);
        return resultData;
    }
}
