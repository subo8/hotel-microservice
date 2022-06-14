package com.miu.edu.cs590.project.notification.Controller;

import com.miu.edu.cs590.project.notification.common.InformationTest;
import com.miu.edu.cs590.project.notification.service.InformationTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class InformationTestController {


    @Autowired
    InformationTestService informationTestService;

    @GetMapping("/notifications")
    public List<InformationTest> getNotifications() {
        return informationTestService.getAllNotifications();
    }

    @GetMapping("/notifications/{email}")
    public List<InformationTest> getNotifications(@PathVariable String email) {
        return informationTestService.getByEmail(email);
    }

    // Testing Purposes Only
    @PostMapping("/notifications")
    public void addInformation(@Valid  @RequestBody InformationTest informationTest) {
        informationTestService.saveInformationTest(informationTest);
    }

    @DeleteMapping ("/notifications/{email}")
    public void deleteNotification(@PathVariable String email) {
        informationTestService.deleteByEmail(email);
    }

}
