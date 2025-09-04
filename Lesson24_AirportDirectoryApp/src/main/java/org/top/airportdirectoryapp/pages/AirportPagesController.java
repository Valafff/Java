package org.top.airportdirectoryapp.pages;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.top.airportdirectoryapp.api.message.CommonApiMessages;
import org.top.airportdirectoryapp.model.*;

import java.util.List;

// AirportPagesController - контроллер для работы с аэропортами через страницы
@Controller
@RequestMapping("airport")
public class AirportPagesController {

    private final AirportScenario airports;

    public AirportPagesController(AirportScenario airports) {
        this.airports = airports;
    }

    // обработчики операций со справочником аэропортов

    @GetMapping
    public String getAll(Model model) {
        List<Airport> allAirports = airports.listAll();
        model.addAttribute("airports", allAirports);
        return "airport/list";
    }

    @GetMapping("new")
    public String getNewAirport(Model model) {
        model.addAttribute("airport", new Airport("", "", 0));
        return "airport/add-form";
    }

    @PostMapping("new")
    public String postNewAirport(Airport airport, RedirectAttributes ra) {
        airports.add(airport);
        ra.addFlashAttribute("message", "Аэропорт успешно добавлен");
        return "redirect:/airport";
    }

    @GetMapping("edit/{code}")
    public String getEditAirport(@PathVariable String code, Model model) {
        Airport airport = airports.getByCode(code);
        model.addAttribute("airport", airport);
        return "airport/edit-form";
    }

    @PostMapping("edit/{code}")
    public String postEditAirport(@PathVariable String code, Airport airport, RedirectAttributes ra) {
        airport.setCode(code);
        airports.edit(airport);
        ra.addFlashAttribute("message", "Аэропорт успешно отредактирован");
        return "redirect:/airport";
    }

    @GetMapping("delete/{code}")
    public String deleteAirport(@PathVariable String code, RedirectAttributes ra) {
        airports.remove(code);
        ra.addFlashAttribute("message", "Аэропорт успешно удален");
        return "redirect:/airport";
    }

    // обработчики исключений

    @ExceptionHandler(AirportNotFoundException.class)
    public String handleAirportNotFound(AirportNotFoundException e, RedirectAttributes ra) {
        String errorMessage = "Аэропорт с данным кодом не найден";
        ra.addFlashAttribute("errorMessage", errorMessage);
        return "redirect:/airport";
    }

    @ExceptionHandler(DuplicatedCodeException.class)
    public String handleDuplicatedCode(DuplicatedCodeException e, RedirectAttributes ra) {
       String errorMessage = "Код дублируется";
       ra.addFlashAttribute("errorMessage", errorMessage);
       return "redirect:/airport";
    }

    @ExceptionHandler(InvalidCodeException.class)
    public String handleInvalidCode(InvalidCodeException e, RedirectAttributes ra) {
        String errorMessage = "Код не валидный";
        ra.addFlashAttribute("errorMessage", errorMessage);
        return "redirect:/airport";
    }
}
