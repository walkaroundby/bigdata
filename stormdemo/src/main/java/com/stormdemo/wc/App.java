package com.stormdemo.wc;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.StormSubmitter;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.tuple.Fields;

import java.io.File;

/**
 * App
 */
public class App {
    public static void main(String[] args) throws Exception {
        File file = new File("/home/record.log");
        if(file.exists()){
            file.delete();
        }
        Config conf = new Config();
        //worker是进程，线程里运行的是任务，主机会均衡分布资源。本例设置了worker数为2。
        conf.setNumWorkers(2);
        conf.setDebug(true);
        TopologyBuilder builder = new TopologyBuilder();
        //wcspout设置线程暗示数3个，任务数（spouse的个数）3个，在2个worker里运行，启3个线程，每个线程执行1个spouse。
        builder.setSpout("wcspout", new WordCountSpout(),3).setNumTasks(3);
        //splitBolt线程暗示数3，任务数（splitBolt个数）4个，2个worker执行，启3个线程，有1台主机有2个线程分别跑1个splitBolt，1台1个线程跑2个任务
        builder.setBolt("split-bolt", new SplitBolt(),3).shuffleGrouping("wcspout").setNumTasks(4);
        //counterBolt线程暗示数和任务数均为5，1台2个线程，1台3个线程，
        builder.setBolt("counter-bolt", new CountBolt(),5).fieldsGrouping("split-bolt", new Fields("word")).setNumTasks(5);

        /**
         * 本地模式storm
         */
//        LocalCluster cluster = new LocalCluster();
//        cluster.submitTopology("wc", conf, builder.createTopology());
//        Thread.sleep(10000);
//        cluster.shutdown();
        StormSubmitter.submitTopology("wordcount", conf, builder.createTopology());

    }
}
