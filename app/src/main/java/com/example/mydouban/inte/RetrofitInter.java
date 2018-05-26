package com.example.mydouban.inte;


import com.example.mydouban.bean.Book;
import com.example.mydouban.bean.MovieFuture;
import com.example.mydouban.bean.MovieHot;
import com.example.mydouban.bean.MovieSearch;
import com.example.mydouban.bean.MovieTop250;
import com.example.mydouban.bean.MovieValue;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 类描述：
 * 创建人：Administrator
 * 创建时间：2017/7/19 17:51
 */
public interface RetrofitInter {
    /**
     * 查询Top榜上的电影
     * @param start 开始的位置
     * @param count 加载的数量
     * @return
     */
    @GET("/v2/movie/top250")
    Observable<MovieTop250> getTopMovies(@Query("start") int start,@Query("count") int count);

    /**
     * 查询电影内容
     * @param id 电影的id
     * @return
     */
    @GET("/v2/movie/subject/{id}")
    Observable<MovieValue> getMovieValue(@Path("id") String id);

    /**
     * 查询正在热播的电影
     * @return
     */
    @GET("/v2/movie/in_theaters")
    Observable<MovieHot> getHotMovies();

    /**
     * 查询即将上映的电影
     * @return
     */
    @GET("/v2/movie/coming_soon")
    Observable<MovieFuture> getFutureMovies();

    /**
     * 根据内容查询电影
     * @param text 内容
     * @param start 开始的位置
     * @param count 加载的数量
     * @return
     */
    @GET("/v2/movie/search?q={text}")
    Observable<MovieSearch> getSearchMovies(@Path("text") String text,@Query("start") int start,@Query("count") int count);

    @GET("/v2/book/search")
    Observable<Book> getTagBooks(@Query("tag") String tag, @Query("start") int start, @Query("count") int count);

}
