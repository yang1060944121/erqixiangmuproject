package com.aaa.base;

import java.util.Map;

public abstract class CommonController<T> extends BaseController {
    public abstract BaseService<T> getBaseService();

    public ResultData add(Map map) {
        return new ResultData();
    }
}
