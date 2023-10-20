package com.example.rabbitmqproducer;


import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainResource {

    @Autowired
    private Producer producer;

    @GetMapping("/hello")
    public ResponseEntity<String> hello(HttpServletResponse response, @RequestHeader("X-Request-Id") String paramA,
                                        @RequestParam("param") String param2,
                                        @CookieValue(value = "cookie", required = false) String cookie){

        HttpCookie cookie3 = ResponseCookie.from("cookie", "1233")
                .build();
        String xpto = "Hello World header: "+paramA+" param2: "+param2+" cookie: "+cookie;
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie3.toString())
                .body(producer.sendMessage(xpto));
    }
    @GetMapping("/health")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok().body(producer.sendMessage("Hello health"));
    }

}
