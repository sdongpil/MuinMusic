package com.mucompany.muinmusic.order.api;

import com.mucompany.muinmusic.order.app.OrderRequest;
import com.mucompany.muinmusic.order.app.OrderResponse;
import com.mucompany.muinmusic.order.app.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping(value = "/orders")
    public ResponseEntity<OrderResponseDto> create(@RequestBody OrderRequestDto orderRequestDto) {

        OrderRequest orderRequest = createOrderRequest(orderRequestDto);

        OrderResponse orderResponse = orderService.placeOrder(orderRequest);

        OrderResponseDto orderResponseDto = new OrderResponseDto(orderResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(orderResponseDto);
    }

    private static OrderRequest createOrderRequest(OrderRequestDto orderRequestDto) {
        return OrderRequest.builder()
                .memberId(orderRequestDto.getMemberId())
                .orderItemIdList(orderRequestDto.getOrderItemIdList())
                .address(orderRequestDto.getAddress())
                .orderDate(orderRequestDto.getOrderDate())
                .build();
    }
}
