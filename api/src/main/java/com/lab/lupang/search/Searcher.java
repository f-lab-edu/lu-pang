package com.lab.lupang.search;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.File;

public class Searcher {
    public String[] getAll() {
        try {
            File file = new File("src/main/java/resources/index");
            Directory directory = FSDirectory.open(file.toPath());
            IndexSearcher indexSearcher = new IndexSearcher(DirectoryReader.open(directory));

            BooleanQuery.Builder booleanQueryBuilder = new BooleanQuery.Builder();
            MatchAllDocsQuery matchAllQuery = new MatchAllDocsQuery();
            booleanQueryBuilder.add(matchAllQuery, BooleanClause.Occur.MUST);

            TopDocs topDocs = indexSearcher.search(booleanQueryBuilder.build(), 10);
            int totalHits = (int) topDocs.totalHits.value;
            String[] titles = new String[totalHits];
            for (int index = 0; index < totalHits; index++) {
                Document document = indexSearcher.doc(topDocs.scoreDocs[index].doc);
                titles[index] = document.get("title");
            }
            return titles;
        } catch(Exception e) {
            return new String[] { e.getMessage() };
        }
    }
}
