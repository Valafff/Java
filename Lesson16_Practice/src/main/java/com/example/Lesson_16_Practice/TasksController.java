package com.example.Lesson_16_Practice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("tasks")
public class TasksController {

    @PostMapping("postphifagor")
    public ResponseEntity<?> postphifagor(@RequestBody Map<String, String> request)
    {
        try {
            double one = Double.parseDouble(request.get("a"));
            double two = Double.parseDouble(request.get("b"));
            return ResponseEntity.ok(one * one + two * two);
        }
        catch (NumberFormatException ex)
        {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("getconvertor")
    public ResponseEntity<?> convertor(@RequestParam Integer val, String inputType, String outputType) {
        long inputVal = 0;
        if (inputType.equalsIgnoreCase("byte")) {
            inputVal = val;
        }
        else if (inputType.equalsIgnoreCase("kbyte")) {
            inputVal = val * 1024;
        }
        else if (inputType.equalsIgnoreCase("mbyte")) {
            inputVal = val * 1024 * 1024;
        }
        else if (inputType.equalsIgnoreCase("gbyte")) {
            inputVal = val * 1024 * 1024 * 1024;
        }
        else if (inputType.equalsIgnoreCase("tbyte")) {
            inputVal = val * 1024 * 1024 * 1024 * 1024;
        }
        else {
            throw new IllegalArgumentException("Ошибка ввода данных inputType: " + inputType);
        }


        if (outputType.equalsIgnoreCase("byte")) {
            return ResponseEntity.ok(inputVal);
        }
        else if (outputType.equalsIgnoreCase("kbyte")) {
            return ResponseEntity.ok( inputVal / 1024);
        }
        else if (outputType.equalsIgnoreCase("mbyte")) {
            return ResponseEntity.ok( inputVal / (1024 * 1024));
        }
        else if (outputType.equalsIgnoreCase("gbyte")) {
            return ResponseEntity.ok(inputVal / (1024 * 1024 * 1024));
        }
        else if (outputType.equalsIgnoreCase("tbyte")) {
            return ResponseEntity.ok ( inputVal / (1024 * 1024 * 1024 * 1024));
        }
        else {
            throw new IllegalArgumentException("Ошибка ввода данных outputType: " + outputType);
        }
    }

    @PostMapping("factorial")
    public ResponseEntity<?> postParams(@RequestParam Integer n) {
        try {
            if (n < 0 || n > 20) {
                throw new IllegalArgumentException("Число должно быть от 0 до 20");
            }
            if (n == 0 || n == 1) {
                ResponseEntity.ok ( 1);
            }
            long result = 1;
            for (int i = 2; i <= n; i++) {
                result *= i;
            }

            return ResponseEntity.ok ("Факториал " + n + "! = " + result);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Ошибка ввода данных n: " + n);
        }
    }

    @GetMapping("path-url/{r}")
    public ResponseEntity<?> pathVariable(@PathVariable Integer r)
    {
        try {
            double pi = 3.14;
            double L = 2 * pi * r;
            double s = pi * Math.pow(r, 2);
            return ResponseEntity.ok ( "Длина L = " + L + ", Площадь S = " + s);

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Ошибка ввода данных id: " + r);
        }

    }


    @GetMapping("rle")
    public ResponseEntity<?> compressString(@RequestHeader("inputString") String input) {
        if (!input.matches("[a-z]+")) {
            return ResponseEntity.badRequest().body("Ошибка: строка должна содержать только английские маленькие буквы");
        }
        StringBuilder compressed = new StringBuilder();
        char currentChar = input.charAt(0);
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == currentChar) {
                count++;
            } else {
                appendCompressed(compressed, count, currentChar);
                currentChar = input.charAt(i);
                count = 1;
            }
        }

        appendCompressed(compressed, count, currentChar);

        return  ResponseEntity.ok( "Сжатая строка: " + compressed.toString());
    }
    private void appendCompressed(StringBuilder builder, int count, char character) {
        if (count > 1) {
            builder.append(count);
        }
        builder.append(character);
    }

}
