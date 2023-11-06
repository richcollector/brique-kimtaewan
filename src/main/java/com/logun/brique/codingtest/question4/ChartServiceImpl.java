package com.logun.brique.codingtest.question4;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/chart/api")
public class ChartServiceImpl {

    @RequestMapping("/list")
    public ModelAndView chartList(){
        ModelAndView mav = new ModelAndView("/question/question4");
        return mav;
    }

    @RequestMapping("/random")
    public Map<String, Object> randomList() {
        Map<String, Object> map = new HashMap<>();

        int[] randomTemperature = randomNumbers(5, 35, 12);

        int[] randomClimate = randomNumbers(20, 90, 12);

        map.put("randomTemperature",randomTemperature);
        map.put("randomClimate",randomClimate);

        return map;
    }

    public static int[] randomNumbers(int min, int max, int count) {
        Random random = new Random();
        int[] randomNumbers = new int[count];
        for (int i = 0; i < count; i++) {
            randomNumbers[i] = random.nextInt(max - min + 1) + min;
        }
        return randomNumbers;
    }
}
