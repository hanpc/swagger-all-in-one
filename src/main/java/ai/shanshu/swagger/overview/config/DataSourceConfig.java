package ai.shanshu.swagger.overview.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author hannannan ( hannannan@shanshu.ai )
 * @date 2019/04/28
 **/
@Configuration
@MapperScan("ai.shanshu.swagger.overview.dao.mapper")
public class DataSourceConfig {
}
