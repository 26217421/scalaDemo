package com.wbw.study.spider;

import com.alibaba.fastjson.JSON;
import com.wbw.study.spider.mapper.MovieMapper;
import com.wbw.study.spider.model.Movie;
import com.wbw.study.spider.util.GetJson;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author wbw
 * @version 1.0
 * @description: 爬取豆瓣电影启动类
 * @date 2021-7-17 18:32
 */
public class Main {
    public static  void  main(String [] args) {
        //定义配置文件路径
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            //读取配置文件
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //注册mybatis 工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //得到连接对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //从mybatis中得到dao对象
        MovieMapper movieMapper = sqlSession.getMapper(MovieMapper.class);

        int start;
        int total = 0;
        int end = 10000;
        int pageNum = 20;
        long a = System.currentTimeMillis();
        for (start  = 0; start < end; start += pageNum)  {
            try {

                String address = "https://Movie.douban.com/j/new_search_subjects?sort=U&range=0,10&tags=&start=" + start;

                JSONObject dayLine = new GetJson().getHttpJson(address, 1);
                System.out.println("start:" + start);
                JSONArray json = dayLine.getJSONArray("data");
                List<Movie> list = JSON.parseArray(json.toString(), Movie.class);


                for (Movie movie : list) {
                    movieMapper.insert(movie);
                    sqlSession.commit();
                }

                total += list.size();
                System.out.println("正在爬取中---共抓取:" + total + "条数据");


            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        long b = System.currentTimeMillis();
        System.out.println("已经爬取到底了");
        System.out.println("cost time: " + (b-a));
        sqlSession.close();
    }


}
