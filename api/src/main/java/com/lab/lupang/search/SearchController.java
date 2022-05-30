package com.lab.lupang.search;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search")
class SearchController {
    private Indexer indexer;
    private Searcher searcher;

    @GetMapping("/add/{title}")
    public ResponseEntity add(@PathVariable String title) {
        indexer = new Indexer();
        indexer.add("test");
        return new ResponseEntity(indexer.add(title), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity get() {
        searcher = new Searcher();
        return new ResponseEntity(searcher.getAll(), HttpStatus.OK);
    }
}