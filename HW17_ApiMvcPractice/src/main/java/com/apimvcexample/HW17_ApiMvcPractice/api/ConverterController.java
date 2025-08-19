package com.apimvcexample.HW17_ApiMvcPractice.api;

import com.apimvcexample.HW17_ApiMvcPractice.interfaces.iConverter;
import com.apimvcexample.HW17_ApiMvcPractice.api.ApiMessages.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


//Как Spring связывает сервис и контроллер?
//Обнаружение компонентов:
//
//Spring сканирует пакеты (через @SpringBootApplication или @ComponentScan).
//
//Находит ConverterService (т.к. он помечен как @Service) и создаёт его бин.
//
//Внедрение зависимости:
//
//Когда Spring создаёт ConverterController, он видит, что ему нужен iConverter.
//
//Находит единственную реализацию iConverter — ваш ConverterService.
//
//Автоматически передаёт сервис в конструктор контроллера.


@RestController
@RequestMapping("api")
@Tag(name = "Convertor Controller", description = "Контроллер для работы с системами счисления")
public class ConverterController
{
    private final iConverter converter;
    //Внедрение зависимости через конструктор
    public ConverterController(iConverter converter)
    {
        this.converter = converter;
    }

    public List<String> numberSystems () {return converter.numberSystems();};

    @PostMapping("convert")
    @Operation(summary = "Операция конвертации одной системы счисления в другую")
    public ResponseEntity<?> convert(@RequestBody ApiMessages.DataToConvertMessage data)
    {

        if(data.from() == null || data.from().isEmpty())
        {
            ErrorMessage error = new ErrorMessage("EmptyString", "'from' is null or empty");
            return ResponseEntity.badRequest().body(error);
        }
        if(data.to() == null || data.to().isEmpty())
        {
            ErrorMessage error = new ErrorMessage("EmptyString", "'to' is null or empty");
            return ResponseEntity.badRequest().body(error);
        }
        if (data.value() == null)
        {
            ErrorMessage error = new ErrorMessage("EmptyString", "'value' is null");
            return ResponseEntity.badRequest().body(error);
        }
        if (!numberSystems().contains(data.from()) )
        {
            ErrorMessage error = new ErrorMessage("Unsupported number system", "'from' is invalid");
            return ResponseEntity.badRequest().body(error);
        }
        if (!numberSystems().contains(data.to()) )
        {
            ErrorMessage error = new ErrorMessage("Unsupported number system", "'to' is invalid");
            return ResponseEntity.badRequest().body(error);
        }
        String result = converter.convert(data.value(), data.from(), data.to());
        return  ResponseEntity.ok(result);
    }
}
