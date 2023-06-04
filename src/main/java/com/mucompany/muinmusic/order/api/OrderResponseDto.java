package com.mucompany.muinmusic.order.api;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class OrderResponseDto {

    private Long memberId;

    private List<Long> orderItemIdList;

    private String orderStatus;

    private String address;

    private LocalDateTime orderDate;

    @Builder
    public OrderResponseDto(Long memberId, List<Long> orderItemIdList, String orderStatus, String address, LocalDateTime orderDate) {
        this.memberId = memberId;
        this.orderItemIdList = orderItemIdList;
        this.orderStatus = orderStatus;
        this.address = address;
        this.orderDate = orderDate;
    }
}
