package com.practice.multipoint;

public interface RunnableDecorator {

    Runnable decorate(Runnable runnable);

    RunnableDecorator USER_ID_HOLDER_RUNNABLE_DECORATOR = (runnable) -> {
        // 기존 thread에서 userId를 가져온다.
        long userId = UserIdHolder.getUserId();

        return () -> {
            try {
                // 새로운 thread에서 가져온 userId를 세팅한다.
                UserIdHolder.setUserId(userId);
                runnable.run();
            } finally {
                // 새로운 thread 작업이 완료되면 ThreadLocal 값을 초기화한다.
                UserIdHolder.clear();
            }
        };
    };

}
