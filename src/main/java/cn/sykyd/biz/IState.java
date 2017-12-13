package cn.sykyd.biz;

import com.alibaba.fastjson.JSONObject;

public interface IState {
    public void exec(JSONObject o);
}
