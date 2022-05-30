package com.lab.lupang.search;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;

public class Indexer {
    public String add(String title) {
        try {
            File file = new File("src/main/java/resources/index");
            Directory directory = FSDirectory.open(file.toPath());
            IndexWriter indexWriter = new IndexWriter(directory, new IndexWriterConfig(new StandardAnalyzer()));

            Document document = new Document();
            document.add(new StringField("title", title, Field.Store.YES));
            indexWriter.addDocument(document);
            indexWriter.commit();
            indexWriter.close();
            return "Success";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}