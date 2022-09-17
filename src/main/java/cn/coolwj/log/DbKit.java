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

import cn.coolwj.thread.ThreadKit;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public static void main(String[] args) throws Exception {
        List<Future<String>> futures = new ArrayList<>();
        Callable<String> task = () -> {

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
                    stmt.executeQuery("select count(*) from p_file_manage_oss where id>10000 and id < 1000000000000");
                    ThreadKit.sleep(2);
                    stmt.executeQuery("select count(*) from p_file_manage_oss where id>30000 and id < 3000000000000");
                    ThreadKit.sleep(4);
                    stmt.executeQuery("select count(*) from p_file_manage_oss where id>20000 and id < 2000000000000");
                    ThreadKit.sleep(6);
                    stmt.executeQuery("select count(*) from p_file_manage_oss where id>40000 and id < 6000000000000");
                    ThreadKit.sleep(7);

                    ResultSet set = stmt.executeQuery("select nextval('SEQ_PAAS_GLOBAL') as id");
                    Long id = null;
                    while (set.next()) {
                        id = set.getLong("id");
                        System.out.println("ID: " + id);
                    }

                    String sql = """
                            INSERT INTO p_data ( id, code, meta_id, ent_code, name, l_1, l_2 )  VALUES  (%s, '%s','%s', 'HECOM_CRM', '201812151821-17', cast(power(random(),random()) as text),  cast(cbrt(random()) as text))
                            """;
                    String insertSql = String.format(sql, id, id, id);
                    int rs = stmt.executeUpdate(insertSql);
                    System.out.println(rs);

                    ThreadKit.sleep(23);
                    conn.commit();
                }
            }

            return System.currentTimeMillis() + "";
        };

        int loop = 500;
        while (loop > 0) {
            futures.add(EXECUTOR_SERVICE.submit(task));
            loop--;
        }
        for (Future<String> future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }


}
