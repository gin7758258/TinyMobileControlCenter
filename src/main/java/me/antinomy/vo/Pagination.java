package me.antinomy.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ginvan on 15/10/9.
 */
@SuppressWarnings("unused")
public class Pagination<T> implements Serializable {
    private Integer pageSize = 10;
    private Integer pageNo = 1;
    private Long totalCount = 0L;
    private String orderBy = "id";
    private String direction = "desc";
    private List<T> data = new ArrayList<T>();

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPosStart() {
        return (pageNo - 1) * pageSize;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Long getPages() {
        return (totalCount - 1) / pageSize + 1;
    }
}
