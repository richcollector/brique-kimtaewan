package com.logun.brique.codingtest.question5;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Response {
    public static void main(String[] args) {
        List<Map.Entry<Object, Integer>> entryList = sort(countVal(getResponses()));

        Integer totalCount = 0;
        for (Map.Entry<Object, Integer> entry : entryList) {
            totalCount += entry.getValue();
            System.out.println( "Count: " + entry.getValue() + " " + entry.getKey());
        }

        System.out.println("totalCount: " + totalCount);
        System.exit(0);
    }

    public static List<Object> getResponses(){
        Executor executor = Executors.newFixedThreadPool(5);
        CountDownLatch latch = new CountDownLatch(100);

        List<Object> responses = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            executor.execute(() -> {
                try {
                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create("http://codingtest.brique.kr:8080/random"))
                            .build();

                    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                    synchronized (responses) {
                        responses.add(response.body());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                    System.out.println(latch);
                }
            });
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return responses;
    }

    public static Map<Object, Integer> countVal(List<Object> responses){

        Map<Object, Integer> countMap = new HashMap<>();

        for (Object response : responses) {
            if (countMap.containsKey(response)) {
                countMap.put(response, countMap.get(response) + 1);
            } else {
                countMap.put(response, 1);
            }
        }

        return countMap;
    }

    public static List<Map.Entry<Object, Integer>> sort(Map<Object, Integer> countMap){

        List<Map.Entry<Object, Integer>> entryList = new ArrayList<>(countMap.entrySet());
        entryList.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));

        return entryList;
    }
}
