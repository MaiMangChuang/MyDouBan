package com.example.mydouban.inte;


import com.example.mydouban.bean.Book;
import com.example.mydouban.bean.MovieFuture;
import com.example.mydouban.bean.MovieHot;
import com.example.mydouban.bean.MovieSearch;
import com.example.mydouban.bean.MovieTop250;
import com.example.mydouban.bean.MovieValue;
import com.example.mydouban.bean.Music;

import retrofit2.http.GET;
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
     * @return Top榜上的电影
     */
    @GET("/v2/movie/top250")
    Observable<MovieTop250> getTopMovies(@Query("start") int start, @Query("count") int count);

    /**
     * 查询电影内容
     * @param id 电影的id
     * @return 电影内容
     */
    @GET("/v2/movie/subject/{id}")
    Observable<MovieValue> getMovieValue(@Path("id") String id);

    /**
     * 查询正在热播的电影
     * @return 热播的电影
     */
    @GET("/v2/movie/in_theaters")
    Observable<MovieHot> getHotMovies();

    /**
     * 查询即将上映的电影
     * @return 即将上映的电影
     */
    @GET("/v2/movie/coming_soon")
    Observable<MovieFuture> getFutureMovies();

    /**
     * 根据内容查询电影
     * @param text 内容
     * @param start 开始的位置
     * @param count 加载的数量
     * @return 电影内容
     */
    @GET("/v2/movie/search")
    Observable<MovieSearch> getSearchMovies(@Query("q") String text,@Query("start") int start,@Query("count") int count);

    /**
     * 根据内容查询书籍
     * @param text 内容
     * @param start 开始的位置
     * @param count 加载的数量
     * @return 书籍内容
     */
    @GET("/v2/book/search")
    Observable<Book> getSearchBooks(@Query("q") String text, @Query("start") int start, @Query("count") int count);

    /**
     * 根据类型查询书籍
     * @param tag 类型
     * @param start 开始的位置
     * @param count 加载的数量
     * @return 书籍内容
     */
    @GET("/v2/book/search")
    Observable<Book> getTagBooks(@Query("tag") String tag, @Query("start") int start, @Query("count") int count);

    /**
     * 根据作者查询书籍
     * @param author 作者名
     * @return 书籍内容
     */
    @GET("/v2/book/search")
    Observable<Book> getAuthorBooks(@Query("tag") String author);

    /**
     * 根据类型查询音乐
     * @param tag 类型
     * @param start 开始的位置
     * @param count 加载的数量
     * @return 音乐内容
     */
    @GET("/v2/music/search")
    Observable<Music> getTagMusic(@Query("tag") String tag, @Query("start") int start, @Query("count") int count);
    /**
     * 根据内容查询音乐
     * @param text 内容
     * @param start 开始的位置
     * @param count 加载的数量
     * @return 音乐内容
     */
    @GET("/v2/music/search")
    Observable<Music> getSearchMusic(@Query("q") String text, @Query("start") int start, @Query("count") int count);

}
