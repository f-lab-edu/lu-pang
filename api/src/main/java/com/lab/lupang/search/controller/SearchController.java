package com.lab.lupang.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search")
class SearchController {

    @Autowired
    private Indexer indexer;
    @Autowired
    private Searcher searcher;

    @GetMapping("{title}")
    public ResponseEntity getList(@PathVariable String title) {
        indexer = new Indexer();
        indexer.add("test");
        return new ResponseEntity(indexer.add(title), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity getList() {
        searcher = new Searcher();
        return new ResponseEntity(searcher.getAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity getList() {
        searcher = new Searcher();
        return new ResponseEntity(searcher.getAll(), HttpStatus.OK);
    }
}