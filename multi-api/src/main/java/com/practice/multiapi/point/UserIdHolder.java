package com.practice.multipoint;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserIdHolder {

    private final static ThreadLocal<Long> USER_ID_HOLDER = new ThreadLocal<>();

    public static Long getUserId() {
        return USER_ID_HOLDER.get();
    }

    public static void setUserId(Long userId) {
        USER_ID_HOLDER.set(userId);
    }

    public static void clear() {
        USER_ID_HOLDER.remove();
    }

}
