package com.slice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.slice.model.Configuration;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evegeny on 24/09/2016.
 */
@Controller
@RequestMapping("/api/configurations")
public class ConfigurationsController {
    @GetMapping("/create")
    public String newConfiguration(){
        return "createconfiguration";
    }

    @GetMapping(value = "/submit")
    @SneakyThrows
    public String addConfiguration(ModelMap model, HttpServletRequest request) {
        String configurationJson = request.getParameter("data");
        ObjectMapper mapper = new ObjectMapper();
        Configuration configuration = mapper.readValue(configurationJson, Configuration.class);

        System.out.println("******************************************");
        System.out.println("configuration = " + configuration);
        System.out.println("******************************************");


        return "userconfigurations";
    }

}
