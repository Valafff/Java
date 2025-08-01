package org.top.springpenprobe;

import org.springframework.web.bind.annotation.*;

@RestController
public class HttpParamsController {

    @GetMapping("get-params")
    public String getParams(@RequestParam Integer a, @RequestParam String b) {
        return "[get-params]: received a = " + a + "; b = " + b + ";";
    }

    @PostMapping("post-params")
    public String postParams(@RequestParam Integer a, @RequestParam String b) {
        return "[post-params]: received a = " + a + "; b = " + b + ";";
    }

    @GetMapping("path-variable/{id}")
    public String pathVariable(@PathVariable Integer id) {
        return "[path-variable]: id = " + id + ";";
    }

    @GetMapping("header")
    public String header(@RequestHeader("X-My-Header") String myHeader) {
        return "[header]: myHeader = " + myHeader + ";";
    }

    @PostMapping("body")
    public String body(@RequestBody String content) throws InterruptedException {
        return "[body]: content = " + content + ";";
    }
}
