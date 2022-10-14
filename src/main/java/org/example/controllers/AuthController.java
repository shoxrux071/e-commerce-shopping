package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 15/10/22 02:43 (Saturday)
 * e-commerce-shopping/IntelliJ IDEA
 */
@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
private final UserService userService;


}
