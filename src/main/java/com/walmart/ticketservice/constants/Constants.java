package com.walmart.ticketservice.constants;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

public final class Constants {

    private Constants() {
    }

    public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static final int HOLD_SEAT_LIMIT = 33;

    public static final int ZERO = 0;

    public static final int NINE = 9;

    public static final int NINE_PLUS_ONE = 10;

    public static final int LEVEL_1 = 1;

    public static final int LEVEL_2 = 2;

    public static final int LEVEL_3 = 3;

    public static final Map<String, Boolean> AUTHORIZED_USERS = new ImmutableMap.Builder<String, Boolean>()
            .put("abc1@gmail.com", Boolean.TRUE).put("abc2@gmail.com", Boolean.TRUE).put("abc3@gmail.com", Boolean.TRUE)
            .put("abc4@gmail.com", Boolean.TRUE).put("abc5@gmail.com", Boolean.TRUE).put("abc6@gmail.com", Boolean.TRUE)
            .put("abc7@gmail.com", Boolean.TRUE).put("abc8@gmail.com", Boolean.TRUE).put("abc9@gmail.com", Boolean.TRUE)
            .put("abc10@gmail.com", Boolean.TRUE).put("abc11@gmail.com", Boolean.TRUE)
            .put("abc12@gmail.com", Boolean.TRUE).put("abc13@gmail.com", Boolean.TRUE)
            .put("abc14@gmail.com", Boolean.TRUE).put("abc15@gmail.com", Boolean.TRUE).build();

    public static final String ROW_MAPPING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

}
