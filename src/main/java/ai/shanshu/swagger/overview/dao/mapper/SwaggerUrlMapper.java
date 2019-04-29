package ai.shanshu.swagger.overview.dao.mapper;

import ai.shanshu.swagger.overview.dao.SwaggerUrl;
import ai.shanshu.swagger.overview.dao.SwaggerUrlExample;
import ai.shanshu.swagger.overview.dao.SwaggerUrlKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SwaggerUrlMapper {
    long countByExample(SwaggerUrlExample example);

    int deleteByExample(SwaggerUrlExample example);

    int deleteByPrimaryKey(SwaggerUrlKey key);

    int insert(SwaggerUrl record);

    int insertSelective(SwaggerUrl record);

    List<SwaggerUrl> selectByExample(SwaggerUrlExample example);

    SwaggerUrl selectByPrimaryKey(SwaggerUrlKey key);

    int updateByExampleSelective(@Param("record") SwaggerUrl record, @Param("example") SwaggerUrlExample example);

    int updateByExample(@Param("record") SwaggerUrl record, @Param("example") SwaggerUrlExample example);

    int updateByPrimaryKeySelective(SwaggerUrl record);

    int updateByPrimaryKey(SwaggerUrl record);
}