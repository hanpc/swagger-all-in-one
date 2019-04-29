package ai.shanshu.swagger.overview.service;

import ai.shanshu.swagger.overview.dao.SwaggerUrl;
import ai.shanshu.swagger.overview.dao.SwaggerUrlExample;
import ai.shanshu.swagger.overview.dao.SwaggerUrlKey;
import ai.shanshu.swagger.overview.dao.mapper.SwaggerUrlMapper;
import ai.shanshu.swagger.overview.dto.SwaggerUrlDto;
import ai.shanshu.swagger.overview.vo.NewUrlVo;
import io.swagger.models.Swagger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hannannan ( hannannan@shanshu.ai )
 * @date 2019/04/28
 **/
@Service
public class SwaggerUrlService {
    @Autowired
    private SwaggerUrlMapper swaggerUrlMapper;


    public List<SwaggerUrlDto> getAllUrlsAvaliable(){
        SwaggerUrlExample swaggerUrlExample= new SwaggerUrlExample();
        swaggerUrlExample.createCriteria().andValidEqualTo(true);
        List<SwaggerUrl> result = swaggerUrlMapper.selectByExample(swaggerUrlExample);
        List<SwaggerUrlDto> rt=new ArrayList<>();
        result.forEach(v-> {
            SwaggerUrlDto dto = new SwaggerUrlDto();
            BeanUtils.copyProperties(v,dto);
            rt.add(dto);
        });
        return rt;
    }

    public int addOne(NewUrlVo newUrlVo){

        SwaggerUrl newUrl= new SwaggerUrl();
        BeanUtils.copyProperties(newUrlVo,newUrl);
        newUrl.setCreateTime(LocalDateTime.now());
        newUrl.setUpdateTime(LocalDateTime.now());
        newUrl.setValid(true);
        int result = swaggerUrlMapper.insertSelective(newUrl);
        if(result != 0 ){
            return newUrl.getId();
        }
        return 0;
    }
    public int delete(int id){
        SwaggerUrlExample example = new SwaggerUrlExample();
        example.createCriteria().andIdEqualTo(id).andValidEqualTo(true);

        SwaggerUrl updateDto= new SwaggerUrl();
        updateDto.setValid(false);
        return swaggerUrlMapper.updateByExampleSelective(updateDto,example);
    }
}
