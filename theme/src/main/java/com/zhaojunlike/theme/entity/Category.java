package com.zhaojunlike.theme.entity;

/**
 * Created by zhaojunlike@ on 2016/6/21.
 * Email: 1716771371@qq.com
 * Phone：15760079693
 * Oschina：http://git.oschina.net/zhaojunlike/
 */
public class Category {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getList_row() {
        return list_row;
    }

    public void setList_row(int list_row) {
        this.list_row = list_row;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private int id;
    private String name;
    private String title;
    private int pid;
    private int sort;
    private int list_row;

}
