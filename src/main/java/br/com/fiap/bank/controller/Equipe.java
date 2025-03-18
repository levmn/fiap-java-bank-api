package br.com.fiap.bank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Equipe {

    @GetMapping
    public String getEquipe() {
        return "[Levi Magni - RM98276 - 2TDSPX]";
    }
}
