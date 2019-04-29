package ai.shanshu.swagger.overview.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * @author hannannan ( hannannan@shanshu.ai )
 * @date 2019/04/28
 **/
@Data
@ApiModel
@Validated
public class NewUrlVo {

    @NotNull
    @ApiModelProperty("名称")
    private String name;

    @NotNull
    @ApiModelProperty("地址")
    private String url;

    @ApiModelProperty("标签")
    private String tag ="";
}
