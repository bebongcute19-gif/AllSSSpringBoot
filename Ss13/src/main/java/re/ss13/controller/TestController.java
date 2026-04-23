package re.ss13.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import re.ss13.security.UserDetailServiceCustom;
import re.ss13.security.UserPrincipal;

@RestController
@RequestMapping("/api")
public class TestController {

    private final UserDetailServiceCustom userDetailServiceCustom;

    public TestController(UserDetailServiceCustom userDetailServiceCustom) {
        this.userDetailServiceCustom = userDetailServiceCustom;
    }

    @GetMapping("/debug-user")
    public String debugUser() {

        UserPrincipal user = (UserPrincipal)
                userDetailServiceCustom.loadUserByUsername("admin");

        //trả thẳng ra response luôn (KHÔNG phụ thuộc console)
        return "USERNAME: " + user.getUsername()
                + " | ROLE: " + user.getAuthorities()
                + " | ENABLED: " + user.isEnabled();
    }
}