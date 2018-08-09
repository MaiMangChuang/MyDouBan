package com.example.mydouban.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.List;

/**
 * 类描述：
 * 创建人：maimanchuang
 * 创建时间：2018/5/18 23:18
 */
public final class MovieTop250   implements Parcelable {


    private int count;
    private int start;
    private int total;
    private String title;
    private List<SubjectsBean> subjects;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SubjectsBean> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectsBean> subjects) {
        this.subjects = subjects;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.count);
        dest.writeInt(this.start);
        dest.writeInt(this.total);
        dest.writeString(this.title);
        dest.writeTypedList(this.subjects);
    }

    public MovieTop250() {
    }

    protected MovieTop250(Parcel in) {
        this.count = in.readInt();
        this.start = in.readInt();
        this.total = in.readInt();
        this.title = in.readString();
        this.subjects = in.createTypedArrayList(SubjectsBean.CREATOR);
    }

    public static final Parcelable.Creator<MovieTop250> CREATOR = new Parcelable.Creator<MovieTop250>() {
        @Override
        public MovieTop250 createFromParcel(Parcel source) {
            return new MovieTop250(source);
        }

        @Override
        public MovieTop250[] newArray(int size) {
            return new MovieTop250[size];
        }
    };
}
