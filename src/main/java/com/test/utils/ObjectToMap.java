package com.test.utils;

import com.test.model.Reserve;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by XinLian on 2016/4/9.
 */
public class ObjectToMap {

    public static List<Map> reserveToMap(List<Reserve> list) {

        List<Map> result = new ArrayList<>();

        for(Reserve reserve : list) {
            Map map = new HashMap();
            map.put("time",reserve.getOrderTime());
            map.put("park",reserve.getSpaceId());
            map.put("id",reserve.getId());
            map.put("fee",reserve.getFee());

            result.add(map);
        }

        return result;
    }
}
