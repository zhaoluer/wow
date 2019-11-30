package example.calc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 *define service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.11.0)",
    comments = "Source: calculation.proto")
public final class CalculationGrpc {

  private CalculationGrpc() {}

  public static final String SERVICE_NAME = "calc.Calculation";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAddMethod()} instead. 
  public static final io.grpc.MethodDescriptor<example.calc.Param,
      example.calc.Result> METHOD_ADD = getAddMethodHelper();

  private static volatile io.grpc.MethodDescriptor<example.calc.Param,
      example.calc.Result> getAddMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<example.calc.Param,
      example.calc.Result> getAddMethod() {
    return getAddMethodHelper();
  }

  private static io.grpc.MethodDescriptor<example.calc.Param,
      example.calc.Result> getAddMethodHelper() {
    io.grpc.MethodDescriptor<example.calc.Param, example.calc.Result> getAddMethod;
    if ((getAddMethod = CalculationGrpc.getAddMethod) == null) {
      synchronized (CalculationGrpc.class) {
        if ((getAddMethod = CalculationGrpc.getAddMethod) == null) {
          CalculationGrpc.getAddMethod = getAddMethod = 
              io.grpc.MethodDescriptor.<example.calc.Param, example.calc.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "calc.Calculation", "add"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  example.calc.Param.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  example.calc.Result.getDefaultInstance()))
                  .setSchemaDescriptor(new CalculationMethodDescriptorSupplier("add"))
                  .build();
          }
        }
     }
     return getAddMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getMutiMethod()} instead. 
  public static final io.grpc.MethodDescriptor<example.calc.Param,
      example.calc.Result> METHOD_MUTI = getMutiMethodHelper();

  private static volatile io.grpc.MethodDescriptor<example.calc.Param,
      example.calc.Result> getMutiMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<example.calc.Param,
      example.calc.Result> getMutiMethod() {
    return getMutiMethodHelper();
  }

  private static io.grpc.MethodDescriptor<example.calc.Param,
      example.calc.Result> getMutiMethodHelper() {
    io.grpc.MethodDescriptor<example.calc.Param, example.calc.Result> getMutiMethod;
    if ((getMutiMethod = CalculationGrpc.getMutiMethod) == null) {
      synchronized (CalculationGrpc.class) {
        if ((getMutiMethod = CalculationGrpc.getMutiMethod) == null) {
          CalculationGrpc.getMutiMethod = getMutiMethod = 
              io.grpc.MethodDescriptor.<example.calc.Param, example.calc.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "calc.Calculation", "muti"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  example.calc.Param.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  example.calc.Result.getDefaultInstance()))
                  .setSchemaDescriptor(new CalculationMethodDescriptorSupplier("muti"))
                  .build();
          }
        }
     }
     return getMutiMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CalculationStub newStub(io.grpc.Channel channel) {
    return new CalculationStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CalculationBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CalculationBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CalculationFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CalculationFutureStub(channel);
  }

  /**
   * <pre>
   *define service
   * </pre>
   */
  public static abstract class CalculationImplBase implements io.grpc.BindableService {

    /**
     */
    public void add(example.calc.Param request,
        io.grpc.stub.StreamObserver<example.calc.Result> responseObserver) {
      asyncUnimplementedUnaryCall(getAddMethodHelper(), responseObserver);
    }

    /**
     */
    public void muti(example.calc.Param request,
        io.grpc.stub.StreamObserver<example.calc.Result> responseObserver) {
      asyncUnimplementedUnaryCall(getMutiMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                example.calc.Param,
                example.calc.Result>(
                  this, METHODID_ADD)))
          .addMethod(
            getMutiMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                example.calc.Param,
                example.calc.Result>(
                  this, METHODID_MUTI)))
          .build();
    }
  }

  /**
   * <pre>
   *define service
   * </pre>
   */
  public static final class CalculationStub extends io.grpc.stub.AbstractStub<CalculationStub> {
    private CalculationStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalculationStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculationStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalculationStub(channel, callOptions);
    }

    /**
     */
    public void add(example.calc.Param request,
        io.grpc.stub.StreamObserver<example.calc.Result> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void muti(example.calc.Param request,
        io.grpc.stub.StreamObserver<example.calc.Result> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMutiMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *define service
   * </pre>
   */
  public static final class CalculationBlockingStub extends io.grpc.stub.AbstractStub<CalculationBlockingStub> {
    private CalculationBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalculationBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculationBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalculationBlockingStub(channel, callOptions);
    }

    /**
     */
    public example.calc.Result add(example.calc.Param request) {
      return blockingUnaryCall(
          getChannel(), getAddMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public example.calc.Result muti(example.calc.Param request) {
      return blockingUnaryCall(
          getChannel(), getMutiMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *define service
   * </pre>
   */
  public static final class CalculationFutureStub extends io.grpc.stub.AbstractStub<CalculationFutureStub> {
    private CalculationFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalculationFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculationFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalculationFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<example.calc.Result> add(
        example.calc.Param request) {
      return futureUnaryCall(
          getChannel().newCall(getAddMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<example.calc.Result> muti(
        example.calc.Param request) {
      return futureUnaryCall(
          getChannel().newCall(getMutiMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD = 0;
  private static final int METHODID_MUTI = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CalculationImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CalculationImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD:
          serviceImpl.add((example.calc.Param) request,
              (io.grpc.stub.StreamObserver<example.calc.Result>) responseObserver);
          break;
        case METHODID_MUTI:
          serviceImpl.muti((example.calc.Param) request,
              (io.grpc.stub.StreamObserver<example.calc.Result>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CalculationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CalculationBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return example.calc.Calc.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Calculation");
    }
  }

  private static final class CalculationFileDescriptorSupplier
      extends CalculationBaseDescriptorSupplier {
    CalculationFileDescriptorSupplier() {}
  }

  private static final class CalculationMethodDescriptorSupplier
      extends CalculationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CalculationMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CalculationGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CalculationFileDescriptorSupplier())
              .addMethod(getAddMethodHelper())
              .addMethod(getMutiMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
