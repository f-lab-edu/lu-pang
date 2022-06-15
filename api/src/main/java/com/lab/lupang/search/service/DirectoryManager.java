package com.lab.lupang.search.service;

import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class DirectoryManager {
    @Value("${index.file.path}")
    private File file;

    public Directory getDirectory() throws IOException {
        return FSDirectory.open(this.file.toPath());
    }
}
