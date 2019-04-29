package ai.shanshu.swagger.overview.vo;

import lombok.Data;

/**
 * @author hannannan ( hannannan@shanshu.ai )
 * @date 2019/04/28
 **/
@Data
public class BasicResponse <T>{

    private int code=0;

    private String msg;

    private T data;

    public BasicResponse<String> error(String message){
        return error(-1,message);
    }
    public BasicResponse<String> error(int code,String message){
        BasicResponse<String> resp= new BasicResponse<>();
        resp.setCode(code);
        resp.setMsg(message);
        return resp;
    }
}
