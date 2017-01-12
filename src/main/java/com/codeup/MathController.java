package com.codeup;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
class MathController {

    @GetMapping("add/{number}/and/{secondNumber}")

    @ResponseBody

    public String add(@PathVariable int number, @PathVariable int secondNumber){

        return number + " plus " + secondNumber + " equals " + (number + secondNumber) + ".";

    }

    @GetMapping("subtract/{number}/from/{secondNumber}")

    @ResponseBody

    public String subtract(@PathVariable int number, @PathVariable int secondNumber){

        return secondNumber + " minus " + number + " equals " + (secondNumber - number) + ".";

    }

    @GetMapping("multiply/{number}/and/{secondNumber}")

    @ResponseBody

    public String mulitply(@PathVariable int number, @PathVariable int secondNumber){

        return number + " times " + secondNumber + " equals " + (number * secondNumber) + ".";

    }

    @GetMapping("divide/{number}/and/{secondNumber}")

    @ResponseBody

    public String divide(@PathVariable int number, @PathVariable int secondNumber){

        return number + " plus " + secondNumber + " equals " + (number + secondNumber) + ".";

    }

}