package pe.edu.leadyourway.usermicroservice.infrastructure.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.edu.leadyourway.usermicroservice.domain.mapping.UserMapper;

@Configuration("enhancedModelMapperConfiguration")
public class MappingConfiguration {
    @Bean
    public EnhancedModelMapper modelMapper() {
        return new EnhancedModelMapper();
    }

    @Bean
    public UserMapper userMapper(){ return new UserMapper(); }
}