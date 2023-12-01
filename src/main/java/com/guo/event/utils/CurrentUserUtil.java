package com.guo.event.utils;

import java.util.Map;

public class CurrentUserUtil {

    public static Integer getCurrentUser() {
        Map<String,Object> map = ThreadLocalUtil.get();
        return  (Integer) map.get("id");
    }
}
