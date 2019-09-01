package com.jy.validator.numVerPhoneValidation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Service
public class NumVerService {

    private static final Logger log = LoggerFactory.getLogger(NumVerService.class);

    @Value("${nv_scheme}")
    private String scheme;

    @Value("${nv_host}")
    private String host;

    @Value("${nv_path}")
    private String path;

    @Value("${nv_country_code}")
    private String country_code;

    @Value("${nv_format}")
    private String format;

    @Value("${nv_access_key}")
    private String access_key;

    @Autowired
    RestTemplate restTemplate;


    public NumVerResult validate(String phone){

        Map<String, Object> params = new HashMap<>();
        params.put("accessKey", access_key);
        params.put("number", phone);
        params.put("countryCode", country_code);
        params.put("format", format);

        URI uri = UriComponentsBuilder.newInstance()
                .scheme(scheme)
                .host(host)
                .path(path)
                .query("access_key={accessKey}")
                .query("number={number}")
                .query("country_code={countryCode}")
                .query("format={format}").build(params);

        log.info( uri.toString());

        NumVerResult result = restTemplate.getForObject( uri,
                NumVerResult.class


        );

        log.info(result.toString());

        return result;

    }
}
