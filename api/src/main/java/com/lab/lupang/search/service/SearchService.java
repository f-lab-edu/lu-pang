package com.lab.lupang.search.service;

import com.lab.lupang.search.domain.SearchDTO;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.search.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    @Autowired
    private DirectoryManager directoryManager;

    public List<SearchDTO> getAll() {
        try {
            IndexSearcher indexSearcher = new IndexSearcher(DirectoryReader.open(directoryManager.getDirectory()));

            BooleanQuery.Builder booleanQueryBuilder = new BooleanQuery.Builder();
            booleanQueryBuilder.add(new MatchAllDocsQuery(), BooleanClause.Occur.MUST);

            int size = 30;
            TopDocs topDocs = indexSearcher.search(booleanQueryBuilder.build(), size);
            int totalHits = (int) topDocs.totalHits.value;
            List<SearchDTO> list = new ArrayList<>(totalHits);
            for (int index = 0; index < totalHits; index++) {
                Document document = indexSearcher.doc(topDocs.scoreDocs[index].doc);
                SearchDTO dto = new SearchDTO();
                dto.setTitle(document.get("title"));
                list.add(dto);
            }
            return list;
        } catch (Exception e) {
            return new ArrayList<>(0);
        }
    }
}
