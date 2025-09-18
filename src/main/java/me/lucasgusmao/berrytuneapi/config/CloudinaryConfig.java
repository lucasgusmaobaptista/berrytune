package me.lucasgusmao.berrytuneapi.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = Map.of(
                "cloud_name", "dktstsdl1",
                "api_key", "627281215297798",
                "api_secret", "QhxFu01wUaAv79i5IEKXwESIVno");

        return new Cloudinary(config);
    }
}
