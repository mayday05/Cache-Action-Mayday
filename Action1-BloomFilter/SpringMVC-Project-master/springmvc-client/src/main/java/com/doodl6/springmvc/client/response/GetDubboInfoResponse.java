package com.doodl6.springmvc.client.response;

import com.doodl6.springmvc.client.domain.DubboDomain;

public class GetDubboInfoResponse extends BaseResponse {

    private DubboDomain dubboDomain;

    public DubboDomain getDubboDomain() {
        return dubboDomain;
    }

    public void setDubboDomain(DubboDomain dubboDomain) {
        this.dubboDomain = dubboDomain;
    }
}
