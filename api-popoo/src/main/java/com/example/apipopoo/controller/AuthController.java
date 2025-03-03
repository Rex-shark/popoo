package com.example.apipopoo.controller;

import com.example.servicepopoo.request.AuthRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> login(@Valid @RequestBody AuthRequest authRequest
            , HttpServletRequest httpServletRequest
            , HttpServletResponse response)  {
        System.out.println("authRequest.getAccount() = " + authRequest.getAccount());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
