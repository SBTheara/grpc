package com.theara.grpc.grpcshare.service.grpc;

import com.theara.grpc.StudentRequest;
import com.theara.grpc.StudentResponse;
import com.theara.grpc.StudentServiceGrpc;
import io.grpc.stub.StreamObserver;

public class StudentService extends StudentServiceGrpc.StudentServiceImplBase {
    @Override
    public void getStudent(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {
        StudentResponse response = StudentResponse.newBuilder()
                .setFirstName("Helloworld")
                .setLastName("Theara")
                .setPhoneNumber("012236815")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
