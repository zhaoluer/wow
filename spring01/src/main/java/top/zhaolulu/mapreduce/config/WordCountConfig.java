package top.zhaolulu.mapreduce.config;


import org.apache.hadoop.fs.FileSystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * Create by zhaolulu on 2020/3/29 0:02
 */
@Configuration
public class WordCountConfig {

    /**
     * hadoop 的Configuration对象
     * @return
     */
    @Bean
    public org.apache.hadoop.conf.Configuration configuration(){
        return new org.apache.hadoop.conf.Configuration();
    }

    /**
     *
     * @param configuration hadoop 的configuration 对象
     * @return  hadoop 根据configuration 返回的文件系统
     * @throws IOException
     */
    @Bean
    public FileSystem fileSystem(org.apache.hadoop.conf.Configuration configuration) throws IOException {
        return FileSystem.get(configuration);
    }
}
