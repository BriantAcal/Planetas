package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import com.example.demo.models.PlanetaDTO;

@Controller
public class DemoController {

    @GetMapping("/API/Planetas/{nombre}")
    public String viewPlaneta(@PathVariable("nombre") String nombre, Model model) {
        String titulo = "Página de API con Spring Boot";
        model.addAttribute("name", nombre);
        model.addAttribute("titulo", titulo);
        PlanetaDTO planetaDTO = getPlaneta(nombre);
        model.addAttribute("planetaDTO", planetaDTO);
        return "Planeta";
    }

    public PlanetaDTO getPlaneta(String nombre) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PlanetaDTO> resp =
                restTemplate.getForEntity(
                        String.format("https://example.com/api/planetas/%s", nombre), PlanetaDTO.class);
        return resp.getBody();
    }

    @GetMapping("/Index/{id}")
    public String index(@PathVariable String id, Model model) {
        String titulo = "Página de inicio con Spring Boot";
        model.addAttribute("titulo", titulo);

        PlanetaDTO planetaDTO = getPlaneta(id);
        model.addAttribute("planetaDTO", planetaDTO);

        return "index";
    }
}
