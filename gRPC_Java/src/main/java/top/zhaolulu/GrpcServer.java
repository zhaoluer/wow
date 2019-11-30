package top.zhaolulu;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * Create by zhaolulu on 2019/11/28 23:59
 */
public class GrpcServer {
    private int port = 1234;
    private Server server;

    private void start() throws IOException {
        server = ServerBuilder.forPort(port)
                .addService((BindableService) new Calcuation())
                .build()
                .start();

        System.out.println("server start ......");

        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                System.err.println("grpc server exit");
                GrpcServer.this.stop();
            }
        });
    }


    private void stop(){
        if (this.server!=null){
            server.shutdown();
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server!=null){
            server.awaitTermination();
        }
    }


    public static void main(String[] args) throws IOException, InterruptedException {
        GrpcServer grpcServer = new GrpcServer();
        grpcServer.start();
        grpcServer.blockUntilShutdown();
    }
}
