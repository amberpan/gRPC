package com.grpc.sample.server;

import com.grpc.sample.server.api.HelloServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.internal.IoUtils;
import org.apache.velocity.texen.util.FileUtil;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GRPCServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        File cert = new File(GRPCServer.class.getClassLoader().getResource("certs/cert.pem").getFile());
        File key = new File(GRPCServer.class.getClassLoader().getResource("certs/key.pem").getFile());

        System.out.println("Certificate: "+cert.getAbsolutePath());
        System.out.println("Key: "+key.getAbsolutePath());
        Server server = ServerBuilder.forPort(9002)
                .useTransportSecurity(cert,key)
                .addService(new HelloServiceImpl()).build();
        System.out.println("Starting server..."+server);
        server.start();
        System.out.println("Server started...");
        server.awaitTermination();







    }
}
