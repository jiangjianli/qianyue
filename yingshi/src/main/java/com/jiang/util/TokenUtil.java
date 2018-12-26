package com.jiang.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class TokenUtil {


    public static String getToken()
    {


        //生成token
        UUID uuid = UUID.randomUUID();

        return uuid.toString();

    }


}
