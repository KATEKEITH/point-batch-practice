package com.practice.multiapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.practice.multiapi.payment.service.CardPaymentFactory;

@RestController
public class PlaceController {

    private PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("/list")
    public List<PlaceDto> loadAndsave()
            throws JsonProcessingException, ParseException, UnsupportedEncodingException, URISyntaxException {

        // try {
        return placeService.getPlace();

        // } catch (Exception e) {
        // e.printStackTrace();
        // }

    }

}
