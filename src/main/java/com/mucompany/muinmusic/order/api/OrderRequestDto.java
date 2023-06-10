package com.mucompany.muinmusic.order.api;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@JsonRootName(value = "order")
public class OrderRequestDto {

    private Long memberId;

    private List<Long> orderItemIdList;

    private String address;

    private LocalDateTime orderDate;

    @Builder
    public OrderRequestDto(Long memberId, List<Long> orderItemIdList, String address, LocalDateTime orderDate) {
        this.memberId = memberId;
        this.orderItemIdList = orderItemIdList;
        this.address = address;
        this.orderDate = orderDate;
    }
}
