package com.apimvcexample.HW17_ApiMvcPractice.pages;

import com.apimvcexample.HW17_ApiMvcPractice.interfaces.iConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("converter")
public class PageConvertController
{
    private final iConverter converter;
    //Внедрение зависимости через конструктор
    public PageConvertController(iConverter converter)
    {
        this.converter = converter;
    }

    @GetMapping
    public String getConvertFromPage(Model model,
                                     ModelMap modelMap)
    {
        List<String> numberSystems = converter.numberSystems();
        model.addAttribute("numberSystems", numberSystems);


        Object from = model.getAttribute("from");
        if (from == null) {
            model.addAttribute("from", numberSystems.getFirst());
        }
        Object to = model.getAttribute("to");
        if (to == null) {
            model.addAttribute("to", numberSystems.getFirst());
        }
        Object value = model.getAttribute("value");
        if (value == null) {
            model.addAttribute("value", 1);
        }

        Object result = model.getAttribute("result");
        if (result == null) {
            model.addAttribute("result", converter.convert("1", numberSystems.getFirst(), numberSystems.getFirst()));
        }

        return "converter";
    }

    @PostMapping
    public String postConvertPage(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam String value,
            RedirectAttributes redirectAtr) {

        String result = this.converter.convert(value, from, to);

        redirectAtr.addFlashAttribute("result", result);
        redirectAtr.addFlashAttribute("from", from);
        redirectAtr.addFlashAttribute("to", to);
        redirectAtr.addFlashAttribute("value", value);

        return "redirect:/converter";
    }


}
