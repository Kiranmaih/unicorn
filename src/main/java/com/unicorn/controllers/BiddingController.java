package com.unicorn.controllers;

import com.unicorn.domain.ServiceResponse;
import com.unicorn.domain.Unicorn;
import com.unicorn.jpa.UnicornRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class BiddingController {

    @Autowired
    UnicornRepo unicornRepo;

    @PostMapping(path = "/unicorns")
    public @ResponseBody ServiceResponse<Unicorn> createUnicorn( @RequestBody Unicorn unicorn) {
        try {
            unicornRepo.insert(unicorn);
        }catch(Exception e){
            return new ServiceResponse<>(e.getMessage());
        }
        return new ServiceResponse<>("SUCCESS", unicorn);
    }

    @GetMapping(path = "/unicorns/{unicornId}")
    public @ResponseBody ServiceResponse<Unicorn> getUnicorn(@PathVariable(name = "unicornId") int unicornId) {
        return new ServiceResponse<>("SUCCESS", unicornRepo.findById(unicornId));
    }

    @GetMapping(path = "/unicorns")
    public @ResponseBody ServiceResponse<List<Unicorn>> getUnicorns() {
        return new ServiceResponse<>("SUCCESS", unicornRepo.findAll());
    }
}
