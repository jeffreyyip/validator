package com.jy.validator.numVerPhoneValidation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/NVValidator")
public class NumVerController {

    @Autowired
    private NumVerService numVerService;

    @GetMapping("/{phone}")
    public NumVerResult validate(@PathVariable  String phone) {

        return numVerService.validate(phone);
    }
}
