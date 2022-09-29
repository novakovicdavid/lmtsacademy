package com.example.demo;

import com.backblaze.b2.client.B2StorageClient;
import com.backblaze.b2.client.B2StorageClientFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebStorageProvider {
    @Value("${B2_APPLICATION_KEY}")
    private String key;

    @Value("${B2_APPLICATION_KEY_ID}")
    private String secret;

    /**
     * <b>Use with dependency injection:</b>
     * <br>
     * &#064;Autowired<br>
     * private B2StorageClient webStorageClient;
     */
    @Bean
    public B2StorageClient cloudinary() {
        return B2StorageClientFactory
                .createDefaultFactory()
                .create(key, secret, "bruh");
    }
}
