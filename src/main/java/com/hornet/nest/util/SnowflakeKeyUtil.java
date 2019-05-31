package com.hornet.nest.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;

/**
 * witter-Snowflake算法产生唯一主键.
 *
 * @see "sharding-jdbc io.shardingsphere.core.keygen.DefaultKeyGenerator"
 */
@Component
public class SnowflakeKeyUtil {

    private static final long EPOCH;
    private static final long SEQUENCE_BITS = 12L;
    private static final long WORKER_ID_BITS = 10L;
    private static final long SEQUENCE_MASK = (1 << SEQUENCE_BITS) - 1;
    private static final long WORKER_ID_LEFT_SHIFT_BITS = SEQUENCE_BITS;
    private static final long TIMESTAMP_LEFT_SHIFT_BITS = WORKER_ID_LEFT_SHIFT_BITS + WORKER_ID_BITS;
    private static Logger log = LoggerFactory.getLogger(SnowflakeKeyUtil.class);
    private static long workerId;

    static {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, Calendar.NOVEMBER, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        EPOCH = calendar.getTimeInMillis();
        initWorkerId();
    }

    private long sequence;

    private long lastTime;

    /**
     * Set work process id.
     *
     * @param workerId work process id
     */
    private static void setWorkerId(final long workerId) {
        SnowflakeKeyUtil.workerId = workerId;
    }

    /**
     * 根据ip初始化workerId.
     */
    private static void initWorkerId() {
        InetAddress address;
        try {
            address = InetAddress.getLocalHost();
        } catch (final UnknownHostException e) {
            log.error("Cannot get LocalHost InetAddress, please check your network!");
            return;
        }
        byte[] ipAddressByteArray = address.getAddress();
        long workerId = 0L;
        // IPV4
        if (ipAddressByteArray.length == 4) {
            for (byte byteNum : ipAddressByteArray) {
                workerId += byteNum & 0xFF;
            }
            // IPV6
        } else if (ipAddressByteArray.length == 16) {
            for (byte byteNum : ipAddressByteArray) {
                workerId += byteNum & 0B111111;
            }
        } else {
            log.error("Bad LocalHost InetAddress, please check your network!");
            return;
        }
        SnowflakeKeyUtil.setWorkerId(workerId);
    }

    private long getCurrentMillis() {
        return System.currentTimeMillis();
    }

    /**
     * Generate key.
     *
     * @return key type is @{@link Long}.
     */
    public synchronized Number generateKey() {
        long currentMillis = getCurrentMillis();
        if (lastTime == currentMillis) {
            if (0L == (sequence = (sequence + 1) & SEQUENCE_MASK)) {
                currentMillis = waitUntilNextTime(currentMillis);
            }
        } else {
            sequence = 0;
        }
        lastTime = currentMillis;
        return ((currentMillis - EPOCH) << TIMESTAMP_LEFT_SHIFT_BITS) | (workerId << WORKER_ID_LEFT_SHIFT_BITS) | sequence;
    }

    private long waitUntilNextTime(final long lastTime) {
        long time = getCurrentMillis();
        while (time <= lastTime) {
            time = getCurrentMillis();
        }
        return time;
    }
}
