package com.example.mydouban.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/5/23 0:52
 */
public  class SubjectsBean extends BaseBean implements Parcelable {
    /**
     * rating : {"max":10,"average":9.6,"stars":"50","min":0}
     * genres : ["犯罪","剧情"]
     * title : 肖申克的救赎
     * casts : [{"alt":"https://movie.douban.com/celebrity/1054521/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.webp","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.webp","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.webp"},"name":"蒂姆·罗宾斯","id":"1054521"},{"alt":"https://movie.douban.com/celebrity/1054534/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34642.webp","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34642.webp","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34642.webp"},"name":"摩根·弗里曼","id":"1054534"},{"alt":"https://movie.douban.com/celebrity/1041179/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5837.webp","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5837.webp","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5837.webp"},"name":"鲍勃·冈顿","id":"1041179"}]
     * collect_count : 1284170
     * original_title : The Shawshank Redemption
     * subtype : movie
     * directors : [{"alt":"https://movie.douban.com/celebrity/1047973/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.webp","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.webp","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.webp"},"name":"弗兰克·德拉邦特","id":"1047973"}]
     * year : 1994
     * images : {"small":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p480747492.webp","large":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p480747492.webp","medium":"http://img7.doubanio.com/view/photo/s_ratio_poster/public/p480747492.webp"}
     * alt : https://movie.douban.com/subject/1292052/
     * id : 1292052
     */

    private SubjectsBean.RatingBean rating;
    private String title;
    private int collect_count;
    private String original_title;
    private String subtype;
    private String year;
    private SubjectsBean.ImagesBean images;
    private String alt;
    private String id;
    private List<String> genres;
    private List<SubjectsBean.CastsBean> casts;
    private List<SubjectsBean.DirectorsBean> directors;

    public SubjectsBean.RatingBean getRating() {
        return rating;
    }

    public void setRating(SubjectsBean.RatingBean rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public SubjectsBean.ImagesBean getImages() {
        return images;
    }

    public void setImages(SubjectsBean.ImagesBean images) {
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

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<SubjectsBean.CastsBean> getCasts() {
        return casts;
    }

    public void setCasts(List<SubjectsBean.CastsBean> casts) {
        this.casts = casts;
    }

    public List<SubjectsBean.DirectorsBean> getDirectors() {
        return directors;
    }

    public void setDirectors(List<SubjectsBean.DirectorsBean> directors) {
        this.directors = directors;
    }

    public static class RatingBean implements Parcelable {
        /**
         * max : 10
         * average : 9.6
         * stars : 50
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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.max);
            dest.writeDouble(this.average);
            dest.writeString(this.stars);
            dest.writeInt(this.min);
        }

        public RatingBean() {
        }

        protected RatingBean(Parcel in) {
            this.max = in.readInt();
            this.average = in.readDouble();
            this.stars = in.readString();
            this.min = in.readInt();
        }

        public static final Parcelable.Creator<SubjectsBean.RatingBean> CREATOR = new Parcelable.Creator<SubjectsBean.RatingBean>() {
            @Override
            public SubjectsBean.RatingBean createFromParcel(Parcel source) {
                return new SubjectsBean.RatingBean(source);
            }

            @Override
            public SubjectsBean.RatingBean[] newArray(int size) {
                return new SubjectsBean.RatingBean[size];
            }
        };
    }

    public static class ImagesBean implements Parcelable {
        /**
         * small : http://img7.doubanio.com/view/photo/s_ratio_poster/public/p480747492.webp
         * large : http://img7.doubanio.com/view/photo/s_ratio_poster/public/p480747492.webp
         * medium : http://img7.doubanio.com/view/photo/s_ratio_poster/public/p480747492.webp
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

        public static final Parcelable.Creator<SubjectsBean.ImagesBean> CREATOR = new Parcelable.Creator<SubjectsBean.ImagesBean>() {
            @Override
            public SubjectsBean.ImagesBean createFromParcel(Parcel source) {
                return new SubjectsBean.ImagesBean(source);
            }

            @Override
            public SubjectsBean.ImagesBean[] newArray(int size) {
                return new SubjectsBean.ImagesBean[size];
            }
        };
    }

    public static class CastsBean implements Parcelable {
        /**
         * alt : https://movie.douban.com/celebrity/1054521/
         * avatars : {"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.webp","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.webp","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.webp"}
         * name : 蒂姆·罗宾斯
         * id : 1054521
         */

        private String alt;
        private SubjectsBean.CastsBean.AvatarsBean avatars;
        private String name;
        private String id;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public SubjectsBean.CastsBean.AvatarsBean getAvatars() {
            return avatars;
        }

        public void setAvatars(SubjectsBean.CastsBean.AvatarsBean avatars) {
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

        public static class AvatarsBean implements Parcelable {
            /**
             * small : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.webp
             * large : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.webp
             * medium : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p17525.webp
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

            public AvatarsBean() {
            }

            protected AvatarsBean(Parcel in) {
                this.small = in.readString();
                this.large = in.readString();
                this.medium = in.readString();
            }

            public static final Creator<SubjectsBean.CastsBean.AvatarsBean> CREATOR = new Creator<SubjectsBean.CastsBean.AvatarsBean>() {
                @Override
                public SubjectsBean.CastsBean.AvatarsBean createFromParcel(Parcel source) {
                    return new SubjectsBean.CastsBean.AvatarsBean(source);
                }

                @Override
                public SubjectsBean.CastsBean.AvatarsBean[] newArray(int size) {
                    return new SubjectsBean.CastsBean.AvatarsBean[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.alt);
            dest.writeParcelable(this.avatars, flags);
            dest.writeString(this.name);
            dest.writeString(this.id);
        }

        public CastsBean() {
        }

        protected CastsBean(Parcel in) {
            this.alt = in.readString();
            this.avatars = in.readParcelable(SubjectsBean.CastsBean.AvatarsBean.class.getClassLoader());
            this.name = in.readString();
            this.id = in.readString();
        }

        public static final Parcelable.Creator<SubjectsBean.CastsBean> CREATOR = new Parcelable.Creator<SubjectsBean.CastsBean>() {
            @Override
            public SubjectsBean.CastsBean createFromParcel(Parcel source) {
                return new SubjectsBean.CastsBean(source);
            }

            @Override
            public SubjectsBean.CastsBean[] newArray(int size) {
                return new SubjectsBean.CastsBean[size];
            }
        };
    }

    public static class DirectorsBean implements Parcelable {
        /**
         * alt : https://movie.douban.com/celebrity/1047973/
         * avatars : {"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.webp","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.webp","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.webp"}
         * name : 弗兰克·德拉邦特
         * id : 1047973
         */

        private String alt;
        private SubjectsBean.DirectorsBean.AvatarsBeanX avatars;
        private String name;
        private String id;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public SubjectsBean.DirectorsBean.AvatarsBeanX getAvatars() {
            return avatars;
        }

        public void setAvatars(SubjectsBean.DirectorsBean.AvatarsBeanX avatars) {
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

        public static class AvatarsBeanX implements Parcelable {
            /**
             * small : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.webp
             * large : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.webp
             * medium : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p230.webp
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

            public AvatarsBeanX() {
            }

            protected AvatarsBeanX(Parcel in) {
                this.small = in.readString();
                this.large = in.readString();
                this.medium = in.readString();
            }

            public static final Parcelable.Creator<SubjectsBean.DirectorsBean.AvatarsBeanX> CREATOR = new Parcelable.Creator<SubjectsBean.DirectorsBean.AvatarsBeanX>() {
                @Override
                public SubjectsBean.DirectorsBean.AvatarsBeanX createFromParcel(Parcel source) {
                    return new SubjectsBean.DirectorsBean.AvatarsBeanX(source);
                }

                @Override
                public SubjectsBean.DirectorsBean.AvatarsBeanX[] newArray(int size) {
                    return new SubjectsBean.DirectorsBean.AvatarsBeanX[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.alt);
            dest.writeParcelable(this.avatars, flags);
            dest.writeString(this.name);
            dest.writeString(this.id);
        }

        public DirectorsBean() {
        }

        protected DirectorsBean(Parcel in) {
            this.alt = in.readString();
            this.avatars = in.readParcelable(SubjectsBean.DirectorsBean.AvatarsBeanX.class.getClassLoader());
            this.name = in.readString();
            this.id = in.readString();
        }

        public static final Parcelable.Creator<SubjectsBean.DirectorsBean> CREATOR = new Parcelable.Creator<SubjectsBean.DirectorsBean>() {
            @Override
            public SubjectsBean.DirectorsBean createFromParcel(Parcel source) {
                return new SubjectsBean.DirectorsBean(source);
            }

            @Override
            public SubjectsBean.DirectorsBean[] newArray(int size) {
                return new SubjectsBean.DirectorsBean[size];
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
        dest.writeString(this.title);
        dest.writeInt(this.collect_count);
        dest.writeString(this.original_title);
        dest.writeString(this.subtype);
        dest.writeString(this.year);
        dest.writeParcelable(this.images, flags);
        dest.writeString(this.alt);
        dest.writeString(this.id);
        dest.writeStringList(this.genres);
        dest.writeTypedList(this.casts);
        dest.writeTypedList(this.directors);
    }

    public SubjectsBean() {
    }

    protected SubjectsBean(Parcel in) {
        this.rating = in.readParcelable(SubjectsBean.RatingBean.class.getClassLoader());
        this.title = in.readString();
        this.collect_count = in.readInt();
        this.original_title = in.readString();
        this.subtype = in.readString();
        this.year = in.readString();
        this.images = in.readParcelable(SubjectsBean.ImagesBean.class.getClassLoader());
        this.alt = in.readString();
        this.id = in.readString();
        this.genres = in.createStringArrayList();
        this.casts = in.createTypedArrayList(SubjectsBean.CastsBean.CREATOR);
        this.directors = in.createTypedArrayList(SubjectsBean.DirectorsBean.CREATOR);
    }

    public static final Parcelable.Creator<SubjectsBean> CREATOR = new Parcelable.Creator<SubjectsBean>() {
        @Override
        public SubjectsBean createFromParcel(Parcel source) {
            return new SubjectsBean(source);
        }

        @Override
        public SubjectsBean[] newArray(int size) {
            return new SubjectsBean[size];
        }
    };
}