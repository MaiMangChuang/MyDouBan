package com.example.mydouban.bean;

import java.util.List;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/5/20 3:59
 */
public class MovieValue extends BaseBean {

    /**
     * rating : {"max":10,"average":5.4,"stars":"30","min":0}
     * reviews_count : 449
     * wish_count : 12154
     * douban_site :
     * year : 2018
     * images : {"small":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2508618114.webp","large":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2508618114.webp","medium":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2508618114.webp"}
     * alt : https://movie.douban.com/subject/26004132/
     * id : 26004132
     * mobile_url : https://movie.douban.com/subject/26004132/mobile
     * title : 移动迷宫3：死亡解药
     * do_count : null
     * share_url : http://m.douban.com/movie/subject/26004132
     * seasons_count : null
     * schedule_url :
     * episodes_count : null
     * countries : ["美国"]
     * genres : ["动作","科幻","冒险"]
     * collect_count : 42491
     * casts : [{"alt":"https://movie.douban.com/celebrity/1314963/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p53688.webp","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p53688.webp","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p53688.webp"},"name":"迪伦·奥布莱恩","id":"1314963"},{"alt":"https://movie.douban.com/celebrity/1031178/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p13769.webp","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p13769.webp","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p13769.webp"},"name":"卡雅·斯考达里奥","id":"1031178"},{"alt":"https://movie.douban.com/celebrity/1333684/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1395179688.42.webp","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1395179688.42.webp","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1395179688.42.webp"},"name":"李起弘","id":"1333684"},{"alt":"https://movie.douban.com/celebrity/1016669/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1426088482.74.webp","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1426088482.74.webp","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1426088482.74.webp"},"name":"托马斯·布罗迪-桑斯特","id":"1016669"}]
     * current_season : null
     * original_title : Maze Runner: The Death Cure
     * summary : 托马斯（迪伦·奥布莱恩饰）率领的林间斗士在经历了迷宫逃脱和末日丧尸的生死考验后，终于迎来最后的正邪较量。由托马斯、纽特（托马斯·桑斯特饰）等人领军的营救团队，耗时三年筹划营救被抓走的米诺，却意外地发现米诺不在劫获的那截火车上。经调查得知，米诺深陷在WCKD组织的控制之中，托马斯和纽特毅然决定起身前往被称为“最后之都”的人类最后净土，更不惜利用背叛林间斗士投身WCKD的特蕾莎（卡雅·斯考达里奥饰）闯入WCKD，营救米诺和其他人。
     * subtype : movie
     * directors : [{"alt":"https://movie.douban.com/celebrity/1332723/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1417887954.94.webp","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1417887954.94.webp","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1417887954.94.webp"},"name":"韦斯·鲍尔","id":"1332723"}]
     * comments_count : 15294
     * ratings_count : 39641
     * aka : ["移动迷宫3","死亡解药","The Death Cure"]
     */

    private RatingBean rating;
    private int reviews_count;
    private int wish_count;
    private String douban_site;
    private String year;
    private ImagesBean images;
    private String alt;
    private String id;
    private String mobile_url;
    private String title;
    private Object do_count;
    private String share_url;
    private Object seasons_count;
    private String schedule_url;
    private Object episodes_count;
    private int collect_count;
    private Object current_season;
    private String original_title;
    private String summary;
    private String subtype;
    private int comments_count;
    private int ratings_count;
    private List<String> countries;
    private List<String> genres;
    private List<CastsBean> casts;
    private List<DirectorsBean> directors;
    private List<String> aka;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public int getReviews_count() {
        return reviews_count;
    }

    public void setReviews_count(int reviews_count) {
        this.reviews_count = reviews_count;
    }

    public int getWish_count() {
        return wish_count;
    }

    public void setWish_count(int wish_count) {
        this.wish_count = wish_count;
    }

    public String getDouban_site() {
        return douban_site;
    }

    public void setDouban_site(String douban_site) {
        this.douban_site = douban_site;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile_url() {
        return mobile_url;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getDo_count() {
        return do_count;
    }

    public void setDo_count(Object do_count) {
        this.do_count = do_count;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public Object getSeasons_count() {
        return seasons_count;
    }

    public void setSeasons_count(Object seasons_count) {
        this.seasons_count = seasons_count;
    }

    public String getSchedule_url() {
        return schedule_url;
    }

    public void setSchedule_url(String schedule_url) {
        this.schedule_url = schedule_url;
    }

    public Object getEpisodes_count() {
        return episodes_count;
    }

    public void setEpisodes_count(Object episodes_count) {
        this.episodes_count = episodes_count;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public Object getCurrent_season() {
        return current_season;
    }

    public void setCurrent_season(Object current_season) {
        this.current_season = current_season;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getRatings_count() {
        return ratings_count;
    }

    public void setRatings_count(int ratings_count) {
        this.ratings_count = ratings_count;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<CastsBean> getCasts() {
        return casts;
    }

    public void setCasts(List<CastsBean> casts) {
        this.casts = casts;
    }

    public List<DirectorsBean> getDirectors() {
        return directors;
    }

    public void setDirectors(List<DirectorsBean> directors) {
        this.directors = directors;
    }

    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }

    public static class RatingBean {
        /**
         * max : 10
         * average : 5.4
         * stars : 30
         * min : 0
         */

        private int max;
        private double average;
        private String stars;
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public double getAverage() {
            return average;
        }

        public void setAverage(double average) {
            this.average = average;
        }

        public String getStars() {
            return stars;
        }

        public void setStars(String stars) {
            this.stars = stars;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }

    public static class ImagesBean {
        /**
         * small : http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2508618114.webp
         * large : http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2508618114.webp
         * medium : http://img7.doubanio.com/view/photo/s_ratio_poster/public/p2508618114.webp
         */

        private String small;
        private String large;
        private String medium;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }
    }

    public static class CastsBean extends BaseBean {
        /**
         * alt : https://movie.douban.com/celebrity/1314963/
         * avatars : {"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p53688.webp","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p53688.webp","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p53688.webp"}
         * name : 迪伦·奥布莱恩
         * id : 1314963
         */

        private String alt;
        private AvatarsBean avatars;
        private String name;
        private String id;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public AvatarsBean getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBean avatars) {
            this.avatars = avatars;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBean  extends BaseBean{
            /**
             * small : http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p53688.webp
             * large : http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p53688.webp
             * medium : http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p53688.webp
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }

    public static class DirectorsBean extends BaseBean {
        /**
         * alt : https://movie.douban.com/celebrity/1332723/
         * avatars : {"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1417887954.94.webp","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1417887954.94.webp","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1417887954.94.webp"}
         * name : 韦斯·鲍尔
         * id : 1332723
         */

        private String alt;
        private AvatarsBeanX avatars;
        private String name;
        private String id;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public AvatarsBeanX getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBeanX avatars) {
            this.avatars = avatars;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBeanX extends BaseBean{
            /**
             * small : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1417887954.94.webp
             * large : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1417887954.94.webp
             * medium : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1417887954.94.webp
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }
}
