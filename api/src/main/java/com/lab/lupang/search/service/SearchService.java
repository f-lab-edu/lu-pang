package com.lab.lupang.search.service;

import com.lab.lupang.search.domain.SearchDTO;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.search.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Searcher {
    @Autowired
    private DirectoryManager directoryManager;

    private IndexSearcher indexSearcher;

    Searcher() throws IOException {
        indexSearcher = new IndexSearcher(DirectoryReader.open(directoryManager.getDirectory()));
    }

    public SearchDTO[] getAll() {
        try {
            BooleanQuery.Builder booleanQueryBuilder = new BooleanQuery.Builder();
            booleanQueryBuilder.add(new MatchAllDocsQuery(), BooleanClause.Occur.MUST);

            int size = 30;
            TopDocs topDocs = indexSearcher.search(booleanQueryBuilder.build(), size);
            int totalHits = (int) topDocs.totalHits.value;
            SearchDTO[] response = new SearchDTO[totalHits];
            for (int index = 0; index < totalHits; index++) {
                Document document = indexSearcher.doc(topDocs.scoreDocs[index].doc);
                response[index].setTitle(document.get("title"));
            }
            return response;
        } catch (Exception e) {
            return new SearchDTO[0];
        }
    }

    public SearchDTO get() {
        try {
            BooleanQuery.Builder booleanQueryBuilder = new BooleanQuery.Builder();
            booleanQueryBuilder.add(new MatchAllDocsQuery(), BooleanClause.Occur.MUST);

            int size = 10;
            TopDocs topDocs = indexSearcher.search(booleanQueryBuilder.build(), size);
            int totalHits = (int) topDocs.totalHits.value;
            SearchDTO[] response = new SearchDTO[totalHits];
            for (int index = 0; index < totalHits; index++) {
                Document document = indexSearcher.doc(topDocs.scoreDocs[index].doc);
                response[index].setTitle(document.get("title"));
            }
            return response;
        } catch (Exception e) {
            return new SearchDTO;
        }
    }
}
