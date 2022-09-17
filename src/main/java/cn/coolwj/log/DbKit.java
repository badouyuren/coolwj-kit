package cn.coolwj.log;
/**
 * 　　　　　　　　┏┓　　　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the god animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 */

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Nigel Lee
 * @date 2022/9/17
 */
public class DbKit {

    public final static ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

    private static final int MAX_THREAD = 1000;

    public static void main(String[] args) throws Exception {
        List<Future<Long>> futures = new ArrayList<>();
        Callable<Long> task = () -> {
            long start = System.currentTimeMillis();

            HikariConfig config = new HikariConfig();
            config.setJdbcUrl("jdbc:postgresql://pgm-2zef61o064dsynlrvo.pg.rds.aliyuncs.com:5432/hqcloud");
            config.setUsername("hqcloud");
            config.setPassword("Heli198213");
            config.addDataSourceProperty("connectionTimeout", "100000");
            config.addDataSourceProperty("idleTimeout", "60000");
            config.addDataSourceProperty("maximumPoolSize", "500");

            try (HikariDataSource ds = new HikariDataSource(config)) {
                try (Connection conn = ds.getConnection()) {
                    conn.setAutoCommit(false);
                    Statement stmt = conn.createStatement();

                    ResultSet resultSet = stmt.executeQuery("select * from p_file_manage_oss where id < random() and oss_url like '%2%' and oss_size is null");
                    while (resultSet.next()) {
                        long id = resultSet.getLong("id");
                        System.out.println("oss id: " + id);
                    }

                    ResultSet set = stmt.executeQuery("select nextval('SEQ_PAAS_GLOBAL') as id");
                    Long id = null;
                    while (set.next()) {
                        id = set.getLong("id");
                        System.out.println("insert id : " + id);
                    }

                    StringBuilder sql = new StringBuilder();
                    sql.append("INSERT INTO p_data");
                    sql.append("(id, code, meta_id, ent_code, name, ");

                    int dataCount = 88;
                    for (int i = 1; i <= dataCount; i++) {
                        sql.append("s_").append(i).append(", ");
                    }
                    for (int i = 1; i <= dataCount; i++) {
                        sql.append("n_").append(i).append(", ");
                    }
                    for (int i = 1; i <= dataCount; i++) {
                        sql.append("l_").append(i).append(", ");
                    }
                    sql.append(" status ,");
                    sql.append(" content");
                    sql.append(" ) VALUES ( ");
                    sql.append(id).append(", ");
                    sql.append(" '").append(id).append("', ");
                    sql.append(" '").append(id).append("', ");
                    sql.append(" 'nigel_test', ");
                    //name
                    sql.append(" cast(power(random(), random()) as text), ");
                    sql.append(" cast(cbrt(random()) as text), ".repeat(dataCount));
                    sql.append(" exp(random()), ".repeat(dataCount));
                    sql.append(" ?, ".repeat(dataCount));
                    sql.append(" 0 ,");
                    //content
                    sql.append(" md5(?)");
                    sql.append(" ) ");

                    String insert = sql.toString();
                    System.out.println(insert);
                    PreparedStatement preparedStatement = conn.prepareStatement(insert);

                    String prime = MaxPrime.readPrime();
                    for (int i = 1; i <= dataCount; i++) {
                        preparedStatement.setString(i, prime);
                    }
                    preparedStatement.setString(dataCount + 1, prime);
                    int rs = preparedStatement.executeUpdate();
                    System.out.println(rs);


                    conn.commit();
                }
            }

            return System.currentTimeMillis() - start;
        };

        for (int i = 0; i < MAX_THREAD; i++) {
            futures.add(EXECUTOR_SERVICE.submit(task));
        }
        for (Future<Long> future : futures) {
            try {
                System.out.println("cost : " + future.get() + "ms");
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

}
