package com.example.calculator1.Controller;

import com.example.calculator1.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping(value = "/calculator")
    public String Hello() {
        return "Добро пожаловать  в  калькулятор ";
    }

    @GetMapping("/calculator/puls")
    public String plus(@RequestParam(value = "num1", required = false) Integer a, @RequestParam(value = "num2", required = false) Integer b) {
        return buildView(a, b, "+");
    }

    @GetMapping("/calculator/minus")
    public String minus(@RequestParam(value = "num1", required = false) Integer a, @RequestParam(value = "num2", required = false) Integer b) {
        return buildView(a, b, "-");
    }

    @GetMapping("/calculator/multiply")
    public String multiply(@RequestParam(value = "num1", required = false) Integer a, @RequestParam(value = "num2", required = false) Integer b) {
        return buildView(a, b, "*");
    }

    @GetMapping("/calculator/divide")
    public String divide(@RequestParam(value = "num1", required = false) Integer a, @RequestParam(value = "num2", required = false) Integer b) {
        return buildView(a, b, "/");
    }
    private String buildView(Integer a, Integer b, String operation) {
        if (a == null || b == null) {
            return "Не передан один из параметров!";
        }
        if ("/".equals(operation) && b == 0) {
            if ("/".equals(operation) && b == 0) {
                return "На 0 делить нельзя !";
            }
            Number result;
            switch (operation) {
                case "+":
                    result = calculatorService.plus(a, b);
                    break;
                case "-":
                    result = calculatorService.minus(a, b);
                    break;
                case "*":
                    result = calculatorService.multiply(a, b);
                    break;
                case "/":
                    result = calculatorService.divide(a, b);
                    break;
                default:
                    result= calculatorService.plus(a,b);
            }
            return a + " " + operation + " " + b + " = " + result;

        }


        return operation;
    }
}

