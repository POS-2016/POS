package com.test.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by XinLian on 2016/4/16.
 */
public class SelectValue {

    public static List<Map> getParkingSpaceStausMap() {
        List<Map> list = new ArrayList<Map>();

        Map map1 = new HashMap();
        map1.put("status","可用");

        Map map2 = new HashMap();
        map2.put("status","已预订");

        Map map3 = new HashMap();
        map3.put("status","正在使用");

        Map map4 = new HashMap();
        map4.put("status","禁用");

        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);

        return list;
    }

    public static List<Map> getservantStausMap() {
        List<Map> list = new ArrayList<Map>();

        Map map1 = new HashMap<>();
        map1.put("key",1);

        Map map2 = new HashMap<>();
        map2.put("key",0);

        list.add(map1);
        list.add(map2);

        return list;
    }
}
