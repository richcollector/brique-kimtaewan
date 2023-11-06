package com.logun.brique.codingtest.question1;

import lombok.RequiredArgsConstructor;

import java.io.*;
import java.util.*;

@RequiredArgsConstructor
public class ReadCsv {
    private Calculator calculator;

    public static void main(String[] args) {
        ReadCsv readCsvInstance = new ReadCsv();
        readCsvInstance.readCsvList();
    }
    public void readCsvList(){
        String csvFilePath = "csv/sample.csv";

        List<String[]> data = new ArrayList<>();
        List<Map<String, Double>> realDataList = new ArrayList<>();
        List<Object> errorValue = new ArrayList<>();

        try (InputStream is = getClass().getClassLoader().getResourceAsStream(csvFilePath);
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                data.add(row);
            }

            for (String[] row : data) {
                boolean hasString = false;
                for (String cell : row) {
                    try {
                        Double.parseDouble(cell);
                    } catch (NumberFormatException e) {
                        errorValue.add(cell);
                        hasString = true;
                    }
                }

                if (!hasString) {
                    Map<String, Double> calculatorValue = new LinkedHashMap<>();
                    calculatorValue.put("minValue", calculator.min(row));
                    calculatorValue.put("maxValue", calculator.max(row));
                    calculatorValue.put("sum", calculator.sum(row));
                    calculatorValue.put("average", calculator.average(row));
                    calculatorValue.put("standardDeviation", calculator.standardDeviation(row));
                    calculatorValue.put("median", calculator.median(row));
                    realDataList.add(calculatorValue);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        for(Map<String, Double> realData: realDataList){
            System.out.println(realData);
        }

        System.out.println("-------------------------------------------------------------------------------------" );
        System.out.println("The total number of lines: " + data.size());
        System.out.println("The calculated lines: " + realDataList.size());
        System.out.println("The error values: " + errorValue);
    }
}
