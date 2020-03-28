package top.zhaolulu.mapreduce.wordcount;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Create by zhaolulu on 2020/3/29 0:00
 * wordcount 程序启动类
 */
@Service
@Slf4j
public class WordCountMain {
    @Value("${input}")
    private String inputPath;
    @Value("${mapreduce.output}")
    private String outputPath;


    @Autowired
    private Configuration configuration;
    @Autowired
    private FileSystem fileSystem;

    public void boot(String...args){
        Job job = null;
        try {
            //获取job
            job = Job.getInstance(configuration);
            job.setJobName("wordCount");
            job.setJarByClass(WordCountMain.class);

            job.setMapperClass(WordCountMapper.class);
            job.setReducerClass(WordCountReducer.class);
            job.setMapOutputKeyClass(Text.class);
            job.setMapOutputValueClass(IntWritable.class);

            FileInputFormat.addInputPath(job, new Path(inputPath));
            Path outPath = new Path(outputPath);
            if(fileSystem.exists(outPath)){
                fileSystem.delete(outPath, true);
            }
            FileOutputFormat.setOutputPath(job, outPath);
            Boolean result = job.waitForCompletion(true);
            if(result){
               log.info("Job is complete!");
            }else{
               log.info("Job is fail!");
            }
        } catch (IOException e) {
            log.info(e.toString(),e);
        } catch (InterruptedException e) {
            log.info(e.toString(),e);
        } catch (ClassNotFoundException e) {
            log.info(e.toString(),e);
        }

    }
}
