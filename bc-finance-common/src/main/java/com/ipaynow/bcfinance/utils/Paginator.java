package com.ipaynow.bcfinance.utils;

import lombok.Data;

/**
 * @author hai 17/4/7
 */
@Data
public class Paginator {
    private Integer currentPage;
    private Integer pageSize;
    private Integer pageNum;
    private Long totalCount;

}
