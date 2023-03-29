package pro.sky.calculator.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CalculatorController {

    @GetMapping(value = "/calculator")
    public String Hello() {
        return "Добро пожаловать  в  калькулятор ";
    }

    @GetMapping("/calculator/puls")
    public String plus(@RequestParam(value = "num1", required = false) Integer a, @RequestParam(value = "num2", required = false) Integer b) {
        if (a == null && b == null) {


            return "Не передан один из параметров! ";
        }
        return a + " + " + b + " = " + (a+ b);
    }

    @GetMapping("/calculator/minus")
    public String minus(@RequestParam(value = "num1", required = false) Integer a, @RequestParam(value = "num2", required = false) Integer b) {
        if (a == null && b == null) {


            return "Не передан один из параметров! ";
        }
        return a + " - " + b + " = " + (a - b);
    }

    @GetMapping("/calculator/multiply")
    public String multiply(@RequestParam(value = "num1", required = false) Integer a, @RequestParam(value = "num2", required = false) Integer b) {
        if (a == null && b == null) {


            return "Не передан один из параметров! ";
        }
        return a + " * " + b + " = " + (a * b);
    }

    @GetMapping("/calculator/divide")
    public String divide(@RequestParam(value = "num1", required = false) Integer a, @RequestParam(value = "num2", required = false) Integer b) {
        if (a == null && b == null) {


            return "Не передан один из параметров! ";
        }
        if (b == 0) {
            return "На 0 делить нельзя ";
        }

        return a + " / " + b + " = " + (a /(double) b);
    }

    @SpringBootApplication
    public static class    CalculatorApplication {

        public static void main(String[] args) {
            SpringApplication.run(CalculatorApplication.class, args);

        }

    }
}
