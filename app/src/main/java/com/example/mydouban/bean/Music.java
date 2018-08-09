package com.example.mydouban.bean;

import java.util.List;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/5/28 14:48
 */
public final class Music  {



    private int count;
    private int start;
    private int total;
    private List<MusicsBean> musics;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<MusicsBean> getMusics() {
        return musics;
    }

    public void setMusics(List<MusicsBean> musics) {
        this.musics = musics;
    }

    public static class MusicsBean {
        /**
         * rating : {"max":10,"average":"9.2","numRaters":74784,"min":0}
         * author : [{"name":"周杰伦"}]
         * alt_title : Fantasy
         * image : https://img3.doubanio.com/view/subject/s/public/s3750422.jpg
         * tags : [{"count":18297,"name":"周杰伦"},{"count":7096,"name":"范特西"},{"count":5212,"name":"台湾"},{"count":4453,"name":"Jay"},{"count":3762,"name":"R&B"},{"count":3062,"name":"流行"},{"count":2810,"name":"华语"},{"count":2032,"name":"pop"}]
         * mobile_link : https://m.douban.com/music/subject/1403307/
         * attrs : {"publisher":["BMG"],"singer":["周杰伦"],"version":["专辑"],"pubdate":["2001-09-14"],"title":["范特西"],"media":["CD"],"tracks":["1. 爱在西元前\n2. 爸我回来了\n3. 简单爱\n4. 忍者\n5. 开不了口\n6. 上海一九四三\n7. 对不起\n8. 威廉古堡\n9. 双截棍\n10. 安静"],"discs":["1"]}
         * title : 范特西
         * alt : https://music.douban.com/subject/1403307/
         * id : 1403307
         */

        private RatingBean rating;
        private String alt_title;
        private String image;
        private String mobile_link;
        private AttrsBean attrs;
        private String title;
        private String alt;
        private String id;
        private List<AuthorBean> author;
        private List<TagsBean> tags;

        public RatingBean getRating() {
            return rating;
        }

        public void setRating(RatingBean rating) {
            this.rating = rating;
        }

        public String getAlt_title() {
            return alt_title;
        }

        public void setAlt_title(String alt_title) {
            this.alt_title = alt_title;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getMobile_link() {
            return mobile_link;
        }

        public void setMobile_link(String mobile_link) {
            this.mobile_link = mobile_link;
        }

        public AttrsBean getAttrs() {
            return attrs;
        }

        public void setAttrs(AttrsBean attrs) {
            this.attrs = attrs;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
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

        public List<AuthorBean> getAuthor() {
            return author;
        }

        public void setAuthor(List<AuthorBean> author) {
            this.author = author;
        }

        public List<TagsBean> getTags() {
            return tags;
        }

        public void setTags(List<TagsBean> tags) {
            this.tags = tags;
        }

        public static class RatingBean {
            /**
             * max : 10
             * average : 9.2
             * numRaters : 74784
             * min : 0
             */

            private int max;
            private String average;
            private int numRaters;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public String getAverage() {
                return average;
            }

            public void setAverage(String average) {
                this.average = average;
            }

            public int getNumRaters() {
                return numRaters;
            }

            public void setNumRaters(int numRaters) {
                this.numRaters = numRaters;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }
        }

        public static class AttrsBean {
            private List<String> publisher;
            private List<String> singer;
            private List<String> version;
            private List<String> pubdate;
            private List<String> title;
            private List<String> media;
            private List<String> tracks;
            private List<String> discs;

            public List<String> getPublisher() {
                return publisher;
            }

            public void setPublisher(List<String> publisher) {
                this.publisher = publisher;
            }

            public List<String> getSinger() {
                return singer;
            }

            public void setSinger(List<String> singer) {
                this.singer = singer;
            }

            public List<String> getVersion() {
                return version;
            }

            public void setVersion(List<String> version) {
                this.version = version;
            }

            public List<String> getPubdate() {
                return pubdate;
            }

            public void setPubdate(List<String> pubdate) {
                this.pubdate = pubdate;
            }

            public List<String> getTitle() {
                return title;
            }

            public void setTitle(List<String> title) {
                this.title = title;
            }

            public List<String> getMedia() {
                return media;
            }

            public void setMedia(List<String> media) {
                this.media = media;
            }

            public List<String> getTracks() {
                return tracks;
            }

            public void setTracks(List<String> tracks) {
                this.tracks = tracks;
            }

            public List<String> getDiscs() {
                return discs;
            }

            public void setDiscs(List<String> discs) {
                this.discs = discs;
            }
        }

        public static class AuthorBean {
            /**
             * name : 周杰伦
             */

            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class TagsBean {
            /**
             * count : 18297
             * name : 周杰伦
             */

            private int count;
            private String name;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
