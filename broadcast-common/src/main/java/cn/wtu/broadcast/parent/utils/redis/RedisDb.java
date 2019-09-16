package cn.wtu.broadcast.parent.utils.redis;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisDb {
    private static JedisPool jedisPool;
    private static String password;
    private static String redisIp;
    private static int redisPort;
    private static int maxActive;
    private static int maxIdle;
    private static long maxWait;
    private static int timeout;
    private static Logger logger = LoggerFactory.getLogger(RedisDb.class);
    
    /**
     * 初始化连接池
     */
    public static void initPool() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(maxActive);
        config.setMaxIdle(maxIdle);
        config.setMaxWaitMillis(maxWait);
        config.setTestOnBorrow(false);
        jedisPool = new JedisPool(config, redisIp, redisPort, timeout, password);
    }

    /**
     * 关闭连接池
     */
    public static void closePool() {
        if(jedisPool!=null)
            jedisPool.close();
    }

    /**
     * 从连接池获取redis连接
     */
    public static Jedis getJedis() {
        Jedis jedis = null;
        try {
        	if(jedisPool != null){
        		jedis = jedisPool.getResource();	
        	}
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return jedis;
    }

    /**
     * 回收redis连接
     */
    public static void recycleJedis(Jedis jedis) {
        if (jedis != null) {
            try {
                jedis.close();
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
    }

    /**
     * 保存字符串数据
     * 例如：中文的时候记得要转换一下
     * RedisDb.setString(uuid + "_name", new String(fileName.getBytes("utf-8"), "iso-8859-1"));
     * @param key
     * @param value
     */
    public static void setString(String key, String value) {
        setString(key, value, 0);
    }

    /**
     * 保存字符串数据  例如：
     * RedisDb.setString(Const.REDIS_PRE_FIND_PASSWORD + mobile, captcha + "", 600);
     * @param key
     * @param value
     * @param seconds
     */
    public static void setString(String key, String value, int seconds) {
        Jedis jedis = getJedis();
        if (jedis != null) {
            jedis.set(key, value);
            if (seconds > 0) {
                jedis.expire(key, seconds);
            }
            recycleJedis(jedis);
        }
    }

    /**
     * 获取字符串类型的数据
     * @param key
     * @return
     */
    public static String getString(String key) {
        Jedis jedis = getJedis();
        String result = null;
        if (jedis != null) {
            result = jedis.get(key);
            recycleJedis(jedis);
        }
        return result;
    }

    /**
     * 删除字符串数据
     * @param key
     */
    public static void delString(String key) {
        Jedis jedis = getJedis();
        if (jedis != null) {
            jedis.del(key);
            recycleJedis(jedis);
        }                
    }

    /**
     * 保存byte类型数据
     * 例如：RedisDb.setObject((appKey + appSecret).getBytes(), Tool.ObjectToByte(liftTokenVO), seconds);
     * @param key
     * @param value
     */
    public static void setObject(byte[] key, byte[] value) {
        setObject(key, value, 0);
    }

    /**
     * 保存byte类型数据
     *
     * @param seconds 过期时间,单位秒
     */
    public static void setObject(byte[] key, byte[] value, int seconds) {
        Jedis jedis = getJedis();
        if (jedis != null) {
            jedis.set(key, value);
            if (seconds > 0) {
                jedis.expire(key, seconds);
            }
            recycleJedis(jedis);
        }
    }
    
    /**
     * 删除byte类型数据
     */
    public static void delObject(byte[] key) {
        Jedis jedis = getJedis();
        if (jedis != null) {
            jedis.del(key);
            recycleJedis(jedis);
        }
    }

    /**
     * 获取byte类型数据
     * 例如：LiftTokenVO liftTokenVO = Tool.ByteToObject(RedisDb.getObject((appKey + appSecret).getBytes()), LiftTokenVO.class);
     */
    public static byte[] getObject(byte[] key) {
        Jedis jedis = getJedis();
        byte[] bytes = null;
        if (jedis != null) {
            bytes = jedis.get(key);
            recycleJedis(jedis);
        }
        return bytes;
    }

    /**
     * 加入list
     */
    public static void listAdd(String key, String value) {
        Jedis jedis = getJedis();
        if (jedis != null) {
            jedis.rpush(key, value);
            recycleJedis(jedis);
        }
    }

    /**
     * 取出list
     */
    public static List<String> listGetAll(String key) {
        Jedis jedis = getJedis();
        List<String> strings = null;
        if (jedis != null) {
            strings = jedis.lrange(key, 0, -1);
            recycleJedis(jedis);
        }
        return strings;
    }

    /**
     * 获取自增数据,每天自动重置
     */
    public static Long getNext(String key) {
        return getNext(key, RefreshType.DAY);
    }

    /**
     * 获取自增数据
     *
     * @param key  key
     * @param type 重置类型
     * @return
     */
    public static Long getNext(String key, RefreshType type) {
        Jedis jedis = getJedis();
        Long result = null;
        if (jedis != null) {
            result = jedis.incr(key);
            switch (type) {
                case DAY:
                    Long secondsLeftToday = 86400 - DateUtils.getFragmentInSeconds(Calendar.getInstance(), Calendar.DATE);
                    jedis.expire(key, secondsLeftToday.intValue());
                    break;
                case YEAR:
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(calendar.get(Calendar.YEAR) + 1, Calendar.JANUARY, 1, 0, 0, 0);
                    Long unixTime = calendar.getTimeInMillis() / 1000;
                    jedis.expireAt(key, unixTime);
                    break;
            }
            recycleJedis(jedis);
        }
        return result;
    }

    /**
     * 截取后n位,不满前面补0
     *
     * @param length n
     */
    public static String getNext(String key, int length, RefreshType type) {
        String str = getNext(key, type).toString();
        StringBuilder sb = new StringBuilder();
        if (length >= str.length()) {
            for (int i = str.length(); i < length; i++) {
                sb.append(0);
            }
        } else {
            sb.append(str.substring(str.length() - length));
        }
        sb.append(str);
        return sb.toString();
    }

    /**
     * 截取后n位,不满前面补0,每天重置
     *
     * @param length n
     */
    public static String getNext(String key, int length) {
        return getNext(key, length, RefreshType.DAY);
    }

    public void setPassword(String password) {
        //字符串为空时,不设置密码
        if (!"".equals(password)) {
            RedisDb.password = password;
        }
    }

    public void setRedisIp(String redisIp) {
        RedisDb.redisIp = redisIp;
    }

    public void setRedisPort(int redisPort) {
        RedisDb.redisPort = redisPort;
    }

    public void setMaxIdle(int maxIdle) {
        RedisDb.maxIdle = maxIdle;
    }

    public void setMaxWait(long maxWait) {
        RedisDb.maxWait = maxWait;
    }

    public void setMaxActive(int maxActive) {
        RedisDb.maxActive = maxActive;
    }

    public void setTimeout(int timeout) {
        RedisDb.timeout = timeout;
    }

    public enum RefreshType {DAY, YEAR}
}
