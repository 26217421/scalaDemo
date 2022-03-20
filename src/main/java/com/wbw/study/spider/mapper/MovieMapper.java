package com.wbw.study.spider.mapper;

import com.wbw.study.spider.model.Movie;

import java.util.List;

/**
 * @author wbw
 * @version 1.0
 * @description: TODO
 * @date 2021-7-17 18:33
 */
public interface MovieMapper {
    void insert(Movie movie);

    List<Movie> findAll();
}
