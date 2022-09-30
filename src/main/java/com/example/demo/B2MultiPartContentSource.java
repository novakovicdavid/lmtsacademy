package com.example.demo;

import com.backblaze.b2.client.contentSources.B2ContentSource;
import java.io.InputStream;

public class B2MultiPartContentSource implements B2ContentSource {
    InputStream inputStream;
    long contentLength;

    public B2MultiPartContentSource(InputStream inputStream, long contentLength) {
        this.inputStream = inputStream;
        this.contentLength = contentLength;
    }

    @Override
    public long getContentLength() {
        return contentLength;
    }

    @Override
    public String getSha1OrNull() {
        return null;
    }

    @Override
    public Long getSrcLastModifiedMillisOrNull() {
        return null;
    }

    @Override
    public InputStream createInputStream() {
        return inputStream;
    }
}
