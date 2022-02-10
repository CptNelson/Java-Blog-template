package com.rekrytest.blogapp;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class ServerPortCustomizer {

    public static int getPort() {
        ArrayList<Integer> availablePorts = new ArrayList<>();

        for (int port = 8080; port < 9000; port++) {
            try {
                ServerSocket socket = new ServerSocket(port);
                socket.close();
                availablePorts.add(port);
            } catch (IOException e) {

            }
        }
        int freePort = availablePorts.get(0);
        System.out.println("Using port: " + freePort);
    return freePort;

    }

}