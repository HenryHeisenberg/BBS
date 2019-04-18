import redis.clients.jedis.Jedis;

/**
 * RedisTest
 */
public class RedisTest {

    public static void main(String[] args) {
        Jedis redis = new Jedis("localhost");
        System.out.println(redis.ping());
        //System.out.println(redis.asking());
      // redis.set("name", "hxy");
      // redis.expire("name", 180);
      redis.close();
    }
}