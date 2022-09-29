package com.example.demo;

import com.backblaze.b2.client.contentSources.B2ContentSource;
import com.backblaze.b2.client.exceptions.B2Exception;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

public class B2MultiPartContentSource implements B2ContentSource {
    MultipartFile file;

    public B2MultiPartContentSource(MultipartFile multipartFile) {
        this.file = multipartFile;
    }

    @Override
    public long getContentLength() throws IOException {
        return file.getSize();
    }

    @Override
    public String getSha1OrNull() throws IOException {
        return null;
    }

    @Override
    public Long getSrcLastModifiedMillisOrNull() throws IOException {
        return null;
    }

    @Override
    public InputStream createInputStream() throws IOException, B2Exception {
        return file.getInputStream();
    }
}
