package top.zhaolulu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import top.zhaolulu.mapreduce.wordcount.WordCountMain;
import top.zhaolulu.spark.core.WordCount;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Slf4j
public class Application implements CommandLineRunner {
    @Autowired
    private WordCountMain wordCountMain;
    @Autowired
    private WordCount sparkWordCount;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        wordCountMain.boot(args);
        //sparkWordCount.sparkWordCount();
    }

}
