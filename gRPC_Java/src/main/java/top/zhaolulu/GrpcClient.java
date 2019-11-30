package top.zhaolulu;

import example.calc.CalculationGrpc;
import example.calc.Param;
import example.calc.Result;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Random;

/**
 * Create by zhaolulu on 2019/11/30 23:31
 */
public class GrpcClient {

    private final ManagedChannel managedChannel;
    private final CalculationGrpc.CalculationBlockingStub blockingStub;


    public GrpcClient(String host,int port){
        managedChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext(true).build();
        blockingStub=CalculationGrpc.newBlockingStub(managedChannel);
    }


    private void calc(int param1,int param2){
        Param request = Param.newBuilder().setParam1(param1).setParam2(param2).build();
        Result addResult = blockingStub.add(request);
        Result mutiResult = blockingStub.muti(request);
        System.out.println(param1+" + "+param2+" = "+addResult.getResult());
        System.out.println(param1+" * "+param2+" = "+mutiResult.getResult());
    }

    public static void main(String[] args) {
        GrpcClient grpcClient = new GrpcClient("127.0.0.1", 1234);
        Random random = new Random();
        for (int i = 0; i < 10 ; i++) {
            int p1 = random.nextInt(100);
            int p2 = random.nextInt(100);
            grpcClient.calc(p1,p2);
        }
    }
}
