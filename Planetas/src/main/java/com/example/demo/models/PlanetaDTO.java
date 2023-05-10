package com.example.demo.models;

import java.util.Map;

public class PlanetaDTO {
    private Map<String, PlanetaDTO> planetas;

    public Map<String, PlanetaDTO> getPlanetas() {
        return planetas;
    }

    public void setPlanetas(Map<String, PlanetaDTO> planetas) {
        this.planetas = planetas;
    }
}
