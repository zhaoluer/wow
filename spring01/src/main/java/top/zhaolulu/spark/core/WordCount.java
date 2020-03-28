package top.zhaolulu.spark.core;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import scala.Tuple2;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Create by zhaolulu on 2020/3/29 0:33
 */
@Service
public class WordCount implements Serializable {
    @Value("${input}")
    private String inputPath;
    @Value("${output}")
    private String outPputPath;


    public void sparkWordCount(){
        SparkSession ss = SparkSession
                .builder()
                .master("local")
                .appName(WordCount.class.getName())
                .getOrCreate();

        JavaSparkContext jsc = new JavaSparkContext(ss.sparkContext());

        //JavaRDD<String> lineRDD = jsc.textFile("D:\\bigdata\\input\\text.txt");
        jsc.textFile(inputPath)
                .flatMap(new FlatMapFunction<String, String>() {
                    public Iterator<String> call(String line) throws Exception {
                        return Arrays.asList(line.split(",")).iterator();
                    }
                }).mapToPair(new PairFunction<String, String, Integer>() {
                    public Tuple2<String, Integer> call(String word) throws Exception {
                        return new Tuple2<String, Integer>(word, 1);
                    }
                }).reduceByKey(new Function2<Integer, Integer, Integer>() {
                    public Integer call(Integer v1, Integer v2) throws Exception {
                        return v1+v2;
                    }
                }).saveAsTextFile(outPputPath);
    }
}
