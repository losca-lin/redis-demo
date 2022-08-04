package cn.itcast.redisdemo;

import io.lettuce.core.ReadFrom;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.LettuceClientConfigurationBuilderCustomizer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RedisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisDemoApplication.class, args);
    }

    /**
     * 优先从slave（replica）节点读取，所有的slave都不可用才读取master
     * @return
     */
    @Bean
    public LettuceClientConfigurationBuilderCustomizer getLettuceClientConfigurationBuilderCustomizer(){
        return clientConfigurationBuilder -> clientConfigurationBuilder.readFrom(ReadFrom.REPLICA_PREFERRED);
    }
}
