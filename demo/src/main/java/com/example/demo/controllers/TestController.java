package com.example.demo.controllers;

import com.example.demo.domain.model.CompositeKeys.GameMemberPK;
import com.example.demo.domain.model.GameMember;
import com.example.demo.domain.model.UserAdditional;
import com.example.demo.domain.service.GameMemberService;
import com.example.demo.domain.service.GameService;
import com.example.demo.domain.service.UserAdditionalService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
public class TestController {

    private UserAdditionalService service;
    private GameService serviceG;

    public TestController(UserAdditionalService service, GameMemberService serviceGM, GameService serviceG) {
        this.service = service;
        this.serviceG = serviceG;
    }



    @GetMapping("/admin")
    public ResponseEntity<?> Test()
    {
        return ResponseEntity.ok("Admin authorities works!");
    }

    @GetMapping("/ratings")
    public ResponseEntity<?> GetRatings(@RequestParam(value = "page") Integer page)
    {
        return ResponseEntity.ok(service.getRatingTable(PageRequest.of(page,20)));
    }
    @GetMapping("/archive")
    public ResponseEntity<?> GetGames(@RequestParam(value = "page") Integer page)
    {
        return ResponseEntity.ok(serviceG.getAllGamesArhived(PageRequest.of(page,20)));
    }







}
