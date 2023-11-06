package com.logun.brique.codingtest.question1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
@Service
@RequiredArgsConstructor
public class Calculator {
    public static double min(String[] row) {
        double minValue = 100;
        for (String cell : row) {
            double value = Double.parseDouble(cell);
            if (value < minValue) {
                minValue = value;
            }
        }
        return minValue;
    }

    public static double max(String[] row) {
        double maxValue = 0;
        for (String cell : row) {
            double value = Double.parseDouble(cell);
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    public static double sum(String[] row) {
        double sum = 0;

        for (String cell : row) {
            sum += Double.parseDouble(cell);
        }

        return sum;
    }

    public static double average(String[] row) {
        double sum = sum(row);
        return sum / row.length;
    }

    public static double standardDeviation(String[] row) {
        double mean = average(row);
        double calculateValue = 0;

        for (String cell : row) {
            double value = Double.parseDouble(cell);
            calculateValue += Math.pow(value - mean, 2);
        }

        double result = calculateValue / row.length;
        return Math.sqrt(result);
    }

    public static double median(String[] row) {
        double[] values = new double[row.length];
        int i = 0;

        for (String cell : row) {
            values[i] = Double.parseDouble(cell);
            i++;
        }

        Arrays.sort(values);

        if (values.length % 2 == 1) {
            return values[values.length / 2];
        } else {
            int mid = values.length / 2;
            return (values[mid - 1] + values[mid]) / 2;
        }
    }
}