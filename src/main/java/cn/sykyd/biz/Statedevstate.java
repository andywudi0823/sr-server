package cn.sykyd.biz;

import com.alibaba.fastjson.JSONObject;

/*
 *
 * { "method": "devstate", "params": ["IP地址", "状态", "火情发现时间-Windows Timestamp-0时区"], "id": 1009}
 *
 * */
public class Statedevstate implements IState {
    @Override
    public void exec(JSONObject o) {
        JSONObject s = o.getJSONObject("data");
        System.out.println(s.getInteger("id"));
        System.out.println(s.getInteger("row"));
        System.out.println(s.getInteger("column"));
        System.out.println(s.getInteger("status"));
    }
}
