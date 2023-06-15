package com.company.oop.cosmetics;

import com.company.oop.cosmetics.core.EngineImpl;
import com.company.oop.cosmetics.models.CategoryImpl;
import com.company.oop.cosmetics.models.GenderType;
import com.company.oop.cosmetics.models.ProductImpl;

public class Startup {

    public static void main(String[] args) {
        EngineImpl engine = new EngineImpl();
        engine.start();
    }

}
