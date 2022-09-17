package cn.coolwj.db;
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

import cn.coolwj.log.MaxPrime;
import cn.coolwj.thread.ThreadKit;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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

    private static final int MAX_THREAD = 3500;

    public static void main(String[] args) throws Exception {
        //String prime = MaxPrime.readPrime();
        String prime = System.nanoTime() + System.currentTimeMillis() + "";


        List<Future<Long>> futures = new ArrayList<>();
        Callable<Long> task = () -> {

            HikariConfig config = new HikariConfig();
            config.setJdbcUrl("jdbc:postgresql://pgm-2zef61o064dsynlrvo.pg.rds.aliyuncs.com:5432/hqcloud");
            config.setUsername("hqcloud");
            config.setPassword("Heli198213");
            config.setMinimumIdle(1);
            config.setMaximumPoolSize(1);
            config.setIdleTimeout(60000);
            config.setConnectionTimeout(600000);

            try (HikariDataSource ds = new HikariDataSource(config)) {

                try (Connection conn = ds.getConnection()) {
                    System.out.println(conn);
                    conn.setAutoCommit(false);
                    Statement stmt = conn.createStatement();

                    if (false) {
                        String[] types = {"TABLE"};
                        ResultSet resultSet = conn.getMetaData().getTables(null, null, null, types);
                        while (resultSet.next()) {
                            System.out.println("oss id: ");
                        }
                    }

                    if (false) {
                        String sql = "update p_org set s_" + System.currentTimeMillis() + " = null where ent_code = 'Web_Auto_test'";
                        stmt.executeUpdate(sql);
                    }

                    if (false) {
                        String sel = "select * from p_file_manage_oss where id < random() and oss_url like '%2%' and oss_size is null";
                        System.out.println(sel);
                        ResultSet resultSet = stmt.executeQuery(sel);
                        while (resultSet.next()) {
                            long id = resultSet.getLong("id");
                            System.out.println("oss id: " + id);
                        }
                    }

                    if (false) {
                        for (int i = 0; i < 100000; i++) {
                            Statement stmt1 = conn.createStatement();
                            String sql = "update p_file_manage_oss set oss_size = random()  ,oss_status =1 where id =200474533575";
                            stmt1.executeLargeUpdate(sql);
                        }
                    }

                    if (true) {

                        for (int j = 0; j < 40000; j++) {
                            Statement stmt1 = conn.createStatement();
                            ResultSet set = stmt1.executeQuery("select nextval('SEQ_PAAS_GLOBAL') as id");
                            Long id = null;
                            while (set.next()) {
                                id = set.getLong("id");
                                System.out.println("insert id : " + id);
                            }

                            StringBuilder sql = new StringBuilder();
                            sql.append("INSERT INTO p_data");
                            sql.append("(id, code, meta_id, ent_code, name, ");

                            int dataCount = 1;
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
                            sql.append(" md5(?), ".repeat(dataCount));
                            sql.append(" 0 ,");
                            //content
                            sql.append(" md5(?)");
                            sql.append(" ) ");

                            String insert = sql.toString();
                            System.out.println(insert);
                            PreparedStatement preparedStatement = conn.prepareStatement(insert);

                            for (int i = 1; i <= dataCount; i++) {
                                preparedStatement.setString(i, prime);
                            }
                            preparedStatement.setString(dataCount + 1, prime);
                            int rs = preparedStatement.executeUpdate();
                            //System.out.println(rs);
                        }
                    }

                    ThreadKit.sleep(100);
                    if (new Random().nextBoolean()) {
                        conn.rollback();
                    } else {
                        conn.commit();
                    }
                }

            }


            return System.currentTimeMillis();
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
