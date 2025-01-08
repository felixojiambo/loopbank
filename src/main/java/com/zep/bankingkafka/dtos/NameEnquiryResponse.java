package com.zep.bankingkafka.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NameEnquiryResponse {
    private String name;
}
