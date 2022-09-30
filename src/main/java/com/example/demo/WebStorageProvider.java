package com.example.demo;

import com.backblaze.b2.client.B2StorageClient;
import com.backblaze.b2.client.B2StorageClientFactory;
import com.backblaze.b2.client.contentSources.B2ContentTypes;
import com.backblaze.b2.client.exceptions.B2Exception;
import com.backblaze.b2.client.structures.B2UploadFileRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;

@Configuration
public class WebStorageProvider implements IWebStorageProvider {
    private B2StorageClient client;

    @Value("${B2_APPLICATION_KEY}")
    private String key;

    @Value("${B2_APPLICATION_KEY_ID}")
    private String secret;

    @Bean
    public IWebStorageProvider webClientProvider() {
        client = B2StorageClientFactory
                .createDefaultFactory()
                .create(key, secret, "bruh");
        return this;
    }

    @Override
    public void upload(String filename, InputStream stream, long contentLength) throws B2Exception {
        client.uploadSmallFile(B2UploadFileRequest.builder("9fd50648ed75132c7dce041e", filename, B2ContentTypes.B2_AUTO, new B2MultiPartContentSource(stream, contentLength)).build());
    }
}
