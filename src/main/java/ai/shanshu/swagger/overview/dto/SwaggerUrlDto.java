package ai.shanshu.swagger.overview.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author hannannan ( hannannan@shanshu.ai )
 * @date 2019/04/28
 **/
@Data
public class SwaggerUrlDto {
    private int id;

    private String name;

    private String url;

    private String tag;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Boolean valid;


    @Override
    public int hashCode(){
        return name.hashCode() + tag.hashCode();
    }

}
