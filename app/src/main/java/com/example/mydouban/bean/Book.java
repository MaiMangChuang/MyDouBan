package com.example.mydouban.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/5/26 20:24
 */
public class Book  extends BaseBean{



    private int count;
    private int start;
    private int total;
    private List<BooksBean> books;

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

    public List<BooksBean> getBooks() {
        return books;
    }

    public void setBooks(List<BooksBean> books) {
        this.books = books;
    }

    public static class BooksBean implements Parcelable {
        /**
         * rating : {"max":10,"numRaters":2260,"average":"7.8","min":0}
         * subtitle :
         * author : ["[美] 马尔科姆·格拉德威尔"]
         * pubdate : 2006-1
         * tags : [{"count":1306,"name":"营销","title":"营销"},{"count":897,"name":"引爆点","title":"引爆点"},{"count":674,"name":"传播","title":"传播"},{"count":547,"name":"商业","title":"商业"},{"count":539,"name":"心理学","title":"心理学"},{"count":354,"name":"互联网","title":"互联网"},{"count":286,"name":"经济","title":"经济"},{"count":258,"name":"管理","title":"管理"}]
         * origin_title :
         * image : https://img3.doubanio.com/view/subject/m/public/s1532953.jpg
         * binding : 平装16开
         * translator : ["钱清","覃爱冬"]
         * catalog :
         * pages : 218
         * images : {"small":"https://img3.doubanio.com/view/subject/s/public/s1532953.jpg","large":"https://img3.doubanio.com/view/subject/l/public/s1532953.jpg","medium":"https://img3.doubanio.com/view/subject/m/public/s1532953.jpg"}
         * alt : https://book.douban.com/subject/1473323/
         * id : 1473323
         * publisher : 中信出版社
         * isbn10 : 7508605462
         * isbn13 : 9787508605463
         * title : 引爆点
         * url : https://api.douban.com/v2/book/1473323
         * alt_title :
         * author_intro : 马尔科姆·格拉德威尔，曾是《华盛顿邮报》商务科学专栏作家，目前是《纽约客》杂志专职作家。2005年被《时代》周刊评为全球最有影响力的100位人物之一。2005年，他更是创造书市神话，两部作品同时位居《纽约时报》畅销书排行榜精装本和平装本第一名。
         * summary : 这本书是《纽约客》杂志专职作家马尔科姆·格拉德威尔的一部才华横溢之作。他以社会上突如其来的流行风潮研究为切入点，从一个全新的角度探索了控制科学和营销模式。他认为，思想、行为、信息以及产品常常会像传染病爆发一样，迅速传播蔓延。正如一个病人就能引起一场全城流感；如果个别工作人员对顾客大打出手，或几位涂鸦爱好者管不住自己，也能在地铁里掀起一场犯罪浪潮；一位满意而归的顾客还能让新开张的餐馆座无虚席。这些现象均属“社会流行潮”，它爆发的那一刻，即达到临界水平的那一刻，就是一个引爆点。
         格拉德威尔走访了宗教团体、成功的高科技公司以及全球最优秀的推销员，他在书中分析了几种有利于开创流行风潮的性格特征，剖析了种种极具感染力的事件，如各种风尚、吸烟现象、儿童电视、商业邮寄广告等，并阐明其背后的导火索。通过大量深具说明力的研究，揭示出发起流行潮并保持其势头的原则和方法。对于企业领袖、艺术家、思想者、设计师而言，这本书可以帮助你找到一种拓展影响、传播观念的全新思路。
         《引爆点》可谓是一部智力历险记忆，妙趣横生，极富有感染力，让人充分感受到思想的魅力和愉悦。尤其重要的是，这本书如同一幅思维导航图，让人看到思维的一种新的拓展方式，并且相信，一个富有想像力的人只要能找准引爆点，就能打开一个充满惊喜的世界。
         * price : 29.80元
         * series : {"id":"4394","title":"东方书林俱乐部文库"}
         */

        private RatingBean rating;
        private String subtitle;
        private String pubdate;
        private String origin_title;
        private String image;
        private String binding;
        private String catalog;
        private String pages;
        private ImagesBean images;
        private String alt;
        private String id;
        private String publisher;
        private String isbn10;
        private String isbn13;
        private String title;
        private String url;
        private String alt_title;
        private String author_intro;
        private String summary;
        private String price;
        private SeriesBean series;
        private List<String> author;
        private List<TagsBean> tags;
        private List<String> translator;

        public RatingBean getRating() {
            return rating;
        }

        public void setRating(RatingBean rating) {
            this.rating = rating;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getPubdate() {
            return pubdate;
        }

        public void setPubdate(String pubdate) {
            this.pubdate = pubdate;
        }

        public String getOrigin_title() {
            return origin_title;
        }

        public void setOrigin_title(String origin_title) {
            this.origin_title = origin_title;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getBinding() {
            return binding;
        }

        public void setBinding(String binding) {
            this.binding = binding;
        }

        public String getCatalog() {
            return catalog;
        }

        public void setCatalog(String catalog) {
            this.catalog = catalog;
        }

        public String getPages() {
            return pages;
        }

        public void setPages(String pages) {
            this.pages = pages;
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

        public String getPublisher() {
            return publisher;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        public String getIsbn10() {
            return isbn10;
        }

        public void setIsbn10(String isbn10) {
            this.isbn10 = isbn10;
        }

        public String getIsbn13() {
            return isbn13;
        }

        public void setIsbn13(String isbn13) {
            this.isbn13 = isbn13;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getAlt_title() {
            return alt_title;
        }

        public void setAlt_title(String alt_title) {
            this.alt_title = alt_title;
        }

        public String getAuthor_intro() {
            return author_intro;
        }

        public void setAuthor_intro(String author_intro) {
            this.author_intro = author_intro;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public SeriesBean getSeries() {
            return series;
        }

        public void setSeries(SeriesBean series) {
            this.series = series;
        }

        public List<String> getAuthor() {
            return author;
        }

        public void setAuthor(List<String> author) {
            this.author = author;
        }

        public List<TagsBean> getTags() {
            return tags;
        }

        public void setTags(List<TagsBean> tags) {
            this.tags = tags;
        }

        public List<String> getTranslator() {
            return translator;
        }

        public void setTranslator(List<String> translator) {
            this.translator = translator;
        }

        public static class RatingBean implements Parcelable {
            /**
             * max : 10
             * numRaters : 2260
             * average : 7.8
             * min : 0
             */

            private int max;
            private int numRaters;
            private String average;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public int getNumRaters() {
                return numRaters;
            }

            public void setNumRaters(int numRaters) {
                this.numRaters = numRaters;
            }

            public String getAverage() {
                return average;
            }

            public void setAverage(String average) {
                this.average = average;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.max);
                dest.writeInt(this.numRaters);
                dest.writeString(this.average);
                dest.writeInt(this.min);
            }

            public RatingBean() {
            }

            protected RatingBean(Parcel in) {
                this.max = in.readInt();
                this.numRaters = in.readInt();
                this.average = in.readString();
                this.min = in.readInt();
            }

            public static final Creator<RatingBean> CREATOR = new Creator<RatingBean>() {
                @Override
                public RatingBean createFromParcel(Parcel source) {
                    return new RatingBean(source);
                }

                @Override
                public RatingBean[] newArray(int size) {
                    return new RatingBean[size];
                }
            };
        }

        public static class ImagesBean implements Parcelable {
            /**
             * small : https://img3.doubanio.com/view/subject/s/public/s1532953.jpg
             * large : https://img3.doubanio.com/view/subject/l/public/s1532953.jpg
             * medium : https://img3.doubanio.com/view/subject/m/public/s1532953.jpg
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

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.small);
                dest.writeString(this.large);
                dest.writeString(this.medium);
            }

            public ImagesBean() {
            }

            protected ImagesBean(Parcel in) {
                this.small = in.readString();
                this.large = in.readString();
                this.medium = in.readString();
            }

            public static final Creator<ImagesBean> CREATOR = new Creator<ImagesBean>() {
                @Override
                public ImagesBean createFromParcel(Parcel source) {
                    return new ImagesBean(source);
                }

                @Override
                public ImagesBean[] newArray(int size) {
                    return new ImagesBean[size];
                }
            };
        }

        public static class SeriesBean implements Parcelable {
            /**
             * id : 4394
             * title : 东方书林俱乐部文库
             */

            private String id;
            private String title;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.id);
                dest.writeString(this.title);
            }

            public SeriesBean() {
            }

            protected SeriesBean(Parcel in) {
                this.id = in.readString();
                this.title = in.readString();
            }

            public static final Creator<SeriesBean> CREATOR = new Creator<SeriesBean>() {
                @Override
                public SeriesBean createFromParcel(Parcel source) {
                    return new SeriesBean(source);
                }

                @Override
                public SeriesBean[] newArray(int size) {
                    return new SeriesBean[size];
                }
            };
        }

        public static class TagsBean implements Parcelable {
            /**
             * count : 1306
             * name : 营销
             * title : 营销
             */

            private int count;
            private String name;
            private String title;

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

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.count);
                dest.writeString(this.name);
                dest.writeString(this.title);
            }

            public TagsBean() {
            }

            protected TagsBean(Parcel in) {
                this.count = in.readInt();
                this.name = in.readString();
                this.title = in.readString();
            }

            public static final Creator<TagsBean> CREATOR = new Creator<TagsBean>() {
                @Override
                public TagsBean createFromParcel(Parcel source) {
                    return new TagsBean(source);
                }

                @Override
                public TagsBean[] newArray(int size) {
                    return new TagsBean[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable(this.rating, flags);
            dest.writeString(this.subtitle);
            dest.writeString(this.pubdate);
            dest.writeString(this.origin_title);
            dest.writeString(this.image);
            dest.writeString(this.binding);
            dest.writeString(this.catalog);
            dest.writeString(this.pages);
            dest.writeParcelable(this.images, flags);
            dest.writeString(this.alt);
            dest.writeString(this.id);
            dest.writeString(this.publisher);
            dest.writeString(this.isbn10);
            dest.writeString(this.isbn13);
            dest.writeString(this.title);
            dest.writeString(this.url);
            dest.writeString(this.alt_title);
            dest.writeString(this.author_intro);
            dest.writeString(this.summary);
            dest.writeString(this.price);
            dest.writeParcelable(this.series, flags);
            dest.writeStringList(this.author);
            dest.writeList(this.tags);
            dest.writeStringList(this.translator);
        }

        public BooksBean() {
        }

        protected BooksBean(Parcel in) {
            this.rating = in.readParcelable(RatingBean.class.getClassLoader());
            this.subtitle = in.readString();
            this.pubdate = in.readString();
            this.origin_title = in.readString();
            this.image = in.readString();
            this.binding = in.readString();
            this.catalog = in.readString();
            this.pages = in.readString();
            this.images = in.readParcelable(ImagesBean.class.getClassLoader());
            this.alt = in.readString();
            this.id = in.readString();
            this.publisher = in.readString();
            this.isbn10 = in.readString();
            this.isbn13 = in.readString();
            this.title = in.readString();
            this.url = in.readString();
            this.alt_title = in.readString();
            this.author_intro = in.readString();
            this.summary = in.readString();
            this.price = in.readString();
            this.series = in.readParcelable(SeriesBean.class.getClassLoader());
            this.author = in.createStringArrayList();
            this.tags = new ArrayList<TagsBean>();
            in.readList(this.tags, TagsBean.class.getClassLoader());
            this.translator = in.createStringArrayList();
        }

        public static final Parcelable.Creator<BooksBean> CREATOR = new Parcelable.Creator<BooksBean>() {
            @Override
            public BooksBean createFromParcel(Parcel source) {
                return new BooksBean(source);
            }

            @Override
            public BooksBean[] newArray(int size) {
                return new BooksBean[size];
            }
        };
    }
}
