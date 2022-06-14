package com.lab.lupang.search.service;

import com.lab.lupang.search.domain.SearchDTO;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexService {
    @Autowired
    private DirectoryManager directoryManager;

    public String add(SearchDTO searchDto) {
        try {
            IndexWriter indexWriter = new IndexWriter(directoryManager.getDirectory(), new IndexWriterConfig(new StandardAnalyzer()));

            Document document = new Document();
            document.add(new StringField("title", searchDto.getTitle(), Field.Store.YES));
            indexWriter.addDocument(document);
            indexWriter.commit();
            indexWriter.close();
            return "Success";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
