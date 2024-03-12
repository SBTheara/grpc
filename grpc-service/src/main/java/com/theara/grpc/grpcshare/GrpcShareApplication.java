package com.theara.grpc.grpcshare;

import com.theara.grpc.grpcshare.service.grpc.StudentService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class GrpcShareApplication {

  public static void main(String[] args) throws IOException, InterruptedException {
    SpringApplication.run(GrpcShareApplication.class, args);
    Server server = ServerBuilder.forPort(9091).addService(new StudentService()).build();
    server.start();
    server.awaitTermination();
  }
}
