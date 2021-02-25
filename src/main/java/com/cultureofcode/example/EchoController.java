package com.cultureofcode.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import lombok.Data;

/**
 * Basic Spring REST Controller.
 */
@RestController
public class EchoController {

  /**
   * Say Hello, REST/JSON style.
   *
   * @return a JSON greeting.
   */
  @GetMapping("/hello")
  public Greeting echo() {

    return new Greeting();
  }

  /**
   * Give as you receive. Echoes the content of the POST plus a \n.
   *
   * @param input
   * @return the String provided as input
   */
  @PostMapping(path = "/echo", consumes = MediaType.TEXT_PLAIN_VALUE)
  @ResponseStatus(code = HttpStatus.ACCEPTED)
  @ResponseBody
  public String echo(@RequestBody String input) {

    return input + "\n";
  }

  @Data
  public class Greeting {

    String greeting = "Hello World!";
  }
}
