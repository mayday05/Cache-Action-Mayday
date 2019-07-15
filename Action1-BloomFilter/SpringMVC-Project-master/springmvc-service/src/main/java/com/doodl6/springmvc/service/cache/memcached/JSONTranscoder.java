package com.doodl6.springmvc.service.cache.memcached;

import com.alibaba.fastjson.JSON;
import net.rubyeye.xmemcached.transcoders.CachedData;
import net.rubyeye.xmemcached.transcoders.PrimitiveTypeTranscoder;

import java.io.UnsupportedEncodingException;

/**
 * Created by daixiaoming on 2018/5/12.
 */
public class JSONTranscoder extends PrimitiveTypeTranscoder<Object> {

    private static final int JSON_FLAG = 0;

    public Object decode(CachedData d) {
        if (d.getFlag() == 0) {
            String rv = null;
            try {
                if (d.getData() != null) {
                    rv = new String(d.getData(), this.charset);
                }
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
            return rv;
        } else {
            throw new RuntimeException("Decode JSON error");
        }
    }

    public CachedData encode(Object o) {
        byte[] b;

        try {
            b = JSON.toJSONString(o).getBytes(this.charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return new CachedData(JSON_FLAG, b);
    }
}
