package com.doodl6.springmvc.client.request;

public class GetDubboInfoRequest extends BaseRequest {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
