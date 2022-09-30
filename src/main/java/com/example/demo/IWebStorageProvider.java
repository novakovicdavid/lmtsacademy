package com.example.demo;

import com.backblaze.b2.client.exceptions.B2Exception;

import java.io.InputStream;

public interface IWebStorageProvider {
    void upload(String filename, InputStream stream, long contentLength) throws B2Exception;
}
