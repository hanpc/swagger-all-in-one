package ai.shanshu.swagger.overview.controller;

import ai.shanshu.swagger.overview.dto.SwaggerUrlDto;
import ai.shanshu.swagger.overview.service.SwaggerUrlService;
import ai.shanshu.swagger.overview.vo.BasicResponse;
import ai.shanshu.swagger.overview.vo.NewUrlVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author hannannan ( hannannan@shanshu.ai )
 * @date 2019/04/28
 **/
@RestController
@RequestMapping("/api")
@Slf4j
public class HomeApiController {


    private SwaggerUrlService swaggerUrlService;

    @Autowired
    public HomeApiController(SwaggerUrlService swaggerUrlService){
        this.swaggerUrlService= swaggerUrlService;
    }

    @GetMapping("/url/list")
    @ApiOperation("获取所有的url")
    public List<SwaggerUrlDto> getAllUrls(){
        List<SwaggerUrlDto> re= swaggerUrlService.getAllUrlsAvaliable();
        List<SwaggerUrlDto> res = re.stream().sorted(Comparator.comparingInt(o -> o.getTag().hashCode())
        ).collect(Collectors.toList());
        return res;
    }

    @PostMapping("/url/add")
    @ApiOperation("新增url")
    public BasicResponse<Integer> add(@RequestBody @Valid @ApiParam(value = "新的url") NewUrlVo newUrlVo){
        int newId = swaggerUrlService.addOne(newUrlVo);
        BasicResponse<Integer> re = new BasicResponse<>();
        re.setMsg("insert success");
        re.setData(newId);
        return re;
    }

    @DeleteMapping("/url/delete/{id}")
    @ApiOperation("删除url")
    public BasicResponse<Integer> delete(@PathVariable("id")int id){
        BasicResponse<Integer> response= new BasicResponse<>();
        response.setData(swaggerUrlService.delete(id));
        response.setCode(0);
        return response;
    }

}
