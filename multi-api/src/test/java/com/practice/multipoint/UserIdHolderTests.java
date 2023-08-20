package com.practice.multipoint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.junit.jupiter.api.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class UserIdHolderTests {

    @Test
    public void UserIdHolder_shouldNotHoldUserId_whenAsyncCall() throws Exception {
        // given
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
        long userId = 1L;

        // when
        UserIdHolder.setUserId(userId);

        // then
        assertEquals(UserIdHolder.getUserId(), userId);
        executor.submit(() -> assertNull(UserIdHolder.getUserId()))
                .get();
    }

    @Test
    public void UserIdHolder_shouldHoldUserId_whenAsyncCallWithDecorator() throws Exception {
        // given
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>()) {
            @Override
            public void execute(Runnable command) {
                super.execute(RunnableDecorator.USER_ID_HOLDER_RUNNABLE_DECORATOR.decorate(command));
            }
        };
        long userId = 1L;

        // when
        UserIdHolder.setUserId(userId);

        // then
        assertEquals(UserIdHolder.getUserId(), userId);
        executor.submit(() -> assertEquals(UserIdHolder.getUserId(), userId))
                .get();
    }

    @Test
    public void UserIdHolder_shouldHoldUserId_whenAsyncCallWithDecorator2() throws Exception {
        // given
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setTaskDecorator((runnable) -> {
            long userId = UserIdHolder.getUserId();
            return () -> {
                try {
                    UserIdHolder.setUserId(userId);
                    runnable.run();
                } finally {
                    UserIdHolder.clear();
                }
            };
        });
        executor.initialize();
        long userId = 1L;

        // when
        UserIdHolder.setUserId(userId);

        // then
        assertEquals(UserIdHolder.getUserId(), userId);
        executor.submit(() -> assertEquals(UserIdHolder.getUserId(), userId))
                .get();
    }
}
