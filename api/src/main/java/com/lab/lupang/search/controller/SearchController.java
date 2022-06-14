package com.lab.lupang.search.controller;

import com.lab.lupang.search.domain.SearchDTO;
import com.lab.lupang.search.service.IndexService;
import com.lab.lupang.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private IndexService indexService;

    @Autowired
    private SearchService searchService;

    @PostMapping("")
    public String create(SearchDTO searchDto) {
        return indexService.add(searchDto);
    }

    @GetMapping("")
    public List<SearchDTO> getList() {
        return searchService.getAll();
    }
}
