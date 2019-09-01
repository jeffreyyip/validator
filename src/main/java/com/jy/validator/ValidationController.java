package com.jy.validator;


import com.jy.validator.numVerPhoneValidation.NumVerResult;
import com.jy.validator.numVerPhoneValidation.NumVerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/phoneValidation")
public class ValidationController {

    private static final Logger log = LoggerFactory.getLogger(ValidationController.class);


    @Autowired
    private NumVerService numVerService;

    @GetMapping("/{phone}")
    public NumVerResult validate(@PathVariable String phone) {

        log.info("validate : " + phone);

        return numVerService.validate(phone);
    }

}
