package top.zhaolulu;

import example.calc.CalculationGrpc;
import example.calc.Param;
import example.calc.Result;
import io.grpc.stub.StreamObserver;

/**
 * Create by zhaolulu on 2019/11/29 0:03
 */
public class Calcuation extends CalculationGrpc.CalculationImplBase {
    @Override
    public void add(Param request, StreamObserver<Result> responseObserver) {
        int result=request.getParam1()+request.getParam2();
        response(responseObserver,result);
    }


    @Override
    public void muti(Param request, StreamObserver<Result> responseObserver) {
        int result=request.getParam1()*request.getParam2();
        response(responseObserver,result);
    }


    private void response(StreamObserver<Result> responseObserver,int resV){
        Result result = Result.newBuilder()
                .setResult(resV)
                .build();
        responseObserver.onNext(result);
        responseObserver.onCompleted();
    }
}
