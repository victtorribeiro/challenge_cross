package github.victtorribeiro.rest.controller;

import github.victtorribeiro.domain.entity.Numbers;
import github.victtorribeiro.service.NumbersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/numbers")
public class NumbersController {

    @Autowired
    NumbersService numbersService;

    @GetMapping("/{page}")
    public List<Double> listNumbers( @PathVariable Integer page){

        return numbersService.searchNumbers(page);
    }
}
