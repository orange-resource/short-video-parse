package com.ongsat.video.web.common.response;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 结果建造者
 */
public class ResultBuilder implements Serializable {

    private Map<String,Object> map = new HashMap();

    public ResultBuilder set(String name, Object value) {
        if (null != name) {
            map.put(name, value);
        }
        return this;
    }

    public ResultBuilder setTotal(Object total) {
        map.put("total", total);
        return this;
    }

    public ResultBuilder setPage(Object page) {
        map.put("page", page);
        return this;
    }

    public ResultBuilder setPageTotal(Object pageTotal) {
        map.put("pageTotal", pageTotal);
        return this;
    }

    public ResultBuilder setList(Object list) {
        map.put("list", list);
        return this;
    }

    public ResultBuilder setListTotal(Object listTotal) {
        map.put("listTotal", listTotal);
        return this;
    }

    public ResultBuilder setContent(Object content) {
        map.put("content", content);
        return this;
    }

    public ResultBuilder setDetail(Object details) {
        map.put("detail", details);
        return this;
    }

    public ResultBuilder setText(Object text) {
        map.put("text", text);
        return this;
    }

    public ResultBuilder setUrl(Object url) {
        map.put("url", url);
        return this;
    }

    public ResultBuilder setStatus(Object status) {
        map.put("status", status);
        return this;
    }

    public ResultBuilder setCount(Object count) {
        map.put("count", count);
        return this;
    }

    public ResultBuilder setTree(Object tree) {
        map.put("tree", tree);
        return this;
    }

    public ResultBuilder setRelation(Object relation) {
        map.put("relation", relation);
        return this;
    }

    public ResultBuilder setQuantity(Object quantity) {
        map.put("quantity", quantity);
        return this;
    }

    public ResultBuilder setToken(Object token) {
        map.put("token", token);
        return this;
    }

    public Map<String,Object> build() {
        return map;
    }

}
