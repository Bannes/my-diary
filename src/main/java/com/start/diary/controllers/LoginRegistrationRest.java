package com.start.diary.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.start.diary.entities.Teacher;
import com.start.diary.entities.TeacherNew;
import com.start.diary.entities.dto.CaptchaResponseDto;
import com.start.diary.entities.dto.ServiceResponse;
import com.start.diary.repos.TeacherRepo;
import com.start.diary.service.LoginRegistrationService;
import com.start.diary.service.RegistrationService;
import com.start.diary.service.TeacherService;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

@RestController
public class LoginRegistrationRest {
    // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private static String CAPTCHA_URL="https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s";
    @Autowired
    TeacherService teacherService;
    @Autowired
    private RestTemplate restTemplate;

    //its value from properties see
    @Value("${upload.path}")
    private String uploadPath;
    @Value("${recaptcha.secret}")
    private String secret;
    @Autowired
    TeacherRepo teacherRepo;
    @Autowired
    LoginRegistrationService loginRegistrationService;
    @Autowired
    RegistrationService registrationService;

    @GetMapping("/lo")
    public ResponseEntity<Object> lo(@RequestParam String username){
        System.out.println("tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt");
        Map<String,String> map = new HashMap<>();
        ServiceResponse<Map<String,String>> response = new ServiceResponse<>("success",map);

            loginRegistrationService.loginValidation(username,map);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/test")
    @Consumes("application/json;charset=UTF-8")
    public String test(
           // @RequestBody MultiValueMap<String, String> formData
              TeacherNew teacher
            /*    @FormParam("psw") String psw*/
              //@RequestParam("g-recaptcha-response") String captchaResponse,
               //@Valid Teacher teacher,
             // @RequestBody String psw
            //11 video 5.06
            //there is one subtlety
            //BindingResult bindingResult
    )

    {
       /* POJO pj = new POJO();
        ObjectMapper mapper = new ObjectMapper();
        pj = mapper.readValue(json, POJO.class);*/
        System.out.println("breddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
        //System.out.println("Name: "+ teacher.getName());
        System.out.println("Name: "+ teacher.name);
      //  System.out.println(formData.get("psw"));
        //System.out.println(formData.get("name"));
        //System.out.println(teacher.getName());
        return "String";
    }


    @PostMapping(value = "/registration2",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String /*ResponseEntity<Object>*/ registrationPost(
            //@RequestParam("file") MultipartFile file,
           // @RequestParam("passwordConfirm") String passwordConfirm,
            //  @RequestParam("g-recaptcha-response") String captchaResponse,
            /*@Valid*/ //Teacher teacher
            //11 video 5.06
            //there is one subtlety
           // BindingResult bindingResult
    )
            throws IOException {
        /*System.out.println("Reigrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
        Map<String,String> map = new HashMap<>();
        map.put("test","test1");
        ServiceResponse<Map<String,String>> response = new ServiceResponse<>("success",map);*/

       // registrationService.handlingCaptchaAndFile(captchaResponse,file,map,teacher);
        //reCaptcha
/*        String url = String.format(CAPTCHA_URL, secret, captchaResponse);
        CaptchaResponseDto response = restTemplate.postForObject(url, Collections.emptyList(), CaptchaResponseDto.class);
        if (!response.isSuccess()) {
            model.addAttribute("captchaError", "Fill captcha");
        }
        //reCaptcha

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            teacher.setFilename(resultFilename);
        }*/



       //boolean v=registrationService.addTeacherRegistration(teacher,map,passwordConfirm,bindingResult) && !map.containsKey("captchaError");



        return /*new ResponseEntity<>(response, HttpStatus.OK)*/ "Str";
    }
}
