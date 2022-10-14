package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.domains.Product;
import org.example.repository.ProductRepository;
import org.example.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 15/10/22 02:45 (Saturday)
 * e-commerce-shopping/IntelliJ IDEA
 */
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ProductRepository productRepository;

    private final ProductService productService;

    @RequestMapping
    @PreAuthorize("permitAll()")
    public String homePage(
            @RequestParam(name = "search") Optional<String> search,
            @RequestParam(name = "page") Optional<Integer> page,
            @RequestParam(name = "limit") Optional<Integer> limit,
            Model model
    ) {
        String searchQuery = search.orElse("");

        Page<Product> productPage = productService.findAllByPage(page, limit, searchQuery);

        model.addAttribute("page", productPage);
        model.addAttribute("products", productPage.getContent());
        model.addAttribute("pageNumbers", IntStream.range(0, productPage.getTotalPages()).toArray());

        return "home";

    }



}
