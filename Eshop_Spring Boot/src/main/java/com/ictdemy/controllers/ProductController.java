package com.ictdemy.controllers;

import com.ictdemy.models.dto.ProductDTO;
import com.ictdemy.models.dto.mappers.ProductMapper;
import com.ictdemy.models.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Controller for managing products in the application.
 * Handles operations such as listing, creating, editing, viewing, and deleting products.
 */
@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    /**
     * Displays the list of all products.
     *
     * @param model the {@link Model} object to pass data to the view.
     * @return the path to the products index page template.
     */
    @GetMapping
    public String renderIndex(Model model) {
        List<ProductDTO> products = productService.getAll();
        model.addAttribute("products", products);

        return "pages/products/index";
    }

    /**
     * Displays the form to create a new product.
     * Restricted to users with the `ROLE_ADMIN` role.
     *
     * @param product a {@link ProductDTO} object for binding form data.
     * @return the path to the product creation form template.
     */
    @Secured("ROLE_ADMIN")
    @GetMapping("/create")
    public String renderCreateForm(@ModelAttribute ProductDTO product) {
        return "pages/products/create";
    }

    /**
     * Handles the creation of a new product.
     * Restricted to users with the `ROLE_ADMIN` role.
     *
     * @param product            the {@link ProductDTO} object with product data.
     * @param redirectAttributes attributes for passing messages during redirects.
     * @return a redirect to the products index page upon success.
     */
    @Secured("ROLE_ADMIN")
    @PostMapping("/create")
    public String createProduct(@ModelAttribute ProductDTO product, RedirectAttributes redirectAttributes) {

        productService.create(product);
        redirectAttributes.addFlashAttribute("success", "Product created.");

        return "redirect:/products";
    }

    /**
     * Displays the details of a specific product.
     *
     * @param id    the ID of the product to display.
     * @param model the {@link Model} object to pass data to the view.
     * @return the path to the product detail page template.
     */
    @GetMapping("{id}")
    public String renderDetail(@PathVariable long id, Model model) {
        ProductDTO product = productService.getById(id);
        model.addAttribute("product", product);

        return "pages/products/detail";
    }

    /**
     * Displays the form to edit an existing product.
     * Restricted to users with the `ROLE_ADMIN` role.
     *
     * @param id      the ID of the product to edit.
     * @param product a {@link ProductDTO} object for binding form data.
     * @return the path to the product editing form template.
     */
    @Secured("ROLE_ADMIN")
    @GetMapping("/edit/{id}")
    public String renderEditForm(@PathVariable Long id, ProductDTO product) {
        ProductDTO fetchedProduct = productService.getById(id);
        productMapper.updateProductDTO(fetchedProduct, product);

        return "pages/products/edit";
    }

    /**
     * Handles the updating of an existing product.
     * Restricted to users with the `ROLE_ADMIN` role.
     *
     * @param id                 the ID of the product to update.
     * @param product            the {@link ProductDTO} object with updated product data.
     * @param redirectAttributes attributes for passing messages during redirects.
     * @return a redirect to the products index page upon success.
     */
    @Secured("ROLE_ADMIN")
    @PostMapping("/edit/{id}")
    public String editProduct(@PathVariable Long id, ProductDTO product, RedirectAttributes redirectAttributes) {
        product.setId(id);
        productService.edit(product);
        redirectAttributes.addFlashAttribute("success", "Product edited.");

        return "redirect:/products";
    }

    /**
     * Deletes a product by its ID.
     * Restricted to users with the `ROLE_ADMIN` role.
     *
     * @param id                 the ID of the product to delete.
     * @param redirectAttributes attributes for passing messages during redirects.
     * @return a redirect to the products index page upon success.
     */
    @Secured("ROLE_ADMIN")
    @GetMapping("delete/{id}")
    public String deleteProduct(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        productService.remove(id);
        redirectAttributes.addFlashAttribute("success", "Product deleted.");

        return "redirect:/products";
    }
}
