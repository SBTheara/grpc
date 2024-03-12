package com.theara.grpc.grpcclient;



import com.theara.grpc.StudentRequest;
import com.theara.grpc.StudentResponse;
import com.theara.grpc.StudentServiceGrpc;
import com.theara.grpc.grpcshare.GrpcShareApplication;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class GrpcClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(GrpcShareApplication.class, args);
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091)
            .usePlaintext()
            .build();
    StudentServiceGrpc.StudentServiceBlockingStub stub = StudentServiceGrpc.newBlockingStub(channel);

    StudentResponse response = stub.getStudent(
            StudentRequest.newBuilder()
                    .build()
    );
    log.info(response.toString());
    channel.shutdown();
  }
}
