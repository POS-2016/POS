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

    public static List<Map> getDateTime(String date) {
        List<Map> list = new ArrayList<Map>();

        String start1 = date + " 00:00:00";
        String end1 = date + " 03:59:59";

        String start2 = date + " 04:00:00";
        String end2 = date + " 07:59:59";

        String start3 = date + " 08:00:00";
        String end3 = date + " 11:59:59";

        String start4 = date + " 12:00:00";
        String end4 = date + " 15:59:59";

        String start5 = date + " 16:00:00";
        String end5 = date + " 19:59:59";

        String start6 = date + " 20:00:00";
        String end6 = date + " 23:59:59";

        Map map1 = new HashMap();
        map1.put("startTime",start1);
        map1.put("endTime",end1);

        Map map2 = new HashMap();
        map2.put("startTime",start2);
        map2.put("endTime",end2);

        Map map3 = new HashMap();
        map3.put("startTime",start3);
        map3.put("endTime",end3);

        Map map4 = new HashMap();
        map4.put("startTime",start4);
        map4.put("endTime",end4);

        Map map5 = new HashMap();
        map5.put("startTime",start5);
        map5.put("endTime",end5);

        Map map6 = new HashMap();
        map6.put("startTime",start6);
        map6.put("endTime",end6);

        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);
        list.add(map5);
        list.add(map6);

        return list;
    }
}
