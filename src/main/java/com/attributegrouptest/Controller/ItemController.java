package com.attributegrouptest.Controller;

import com.attributegrouptest.Domain.Category;
import com.attributegrouptest.Domain.Item;
import com.attributegrouptest.Domain.User;
import com.attributegrouptest.Enums.CategoryType;
import com.attributegrouptest.Enums.ItemCondition;
import com.attributegrouptest.Service.blueprint.CategoryService;
import com.attributegrouptest.Service.blueprint.ItemService;
import com.attributegrouptest.Service.blueprint.UserService;
import com.attributegrouptest.Service.impl.MailService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.Arrays;
import java.util.Map;


/**
 * Created by Noobs on 05/09/2016.
 */
@Controller
@RequestMapping(value = "/items")
public class ItemController {

    private ItemService itemService;
    private CategoryService categoryService;
    private MailService mailService;
    private UserService userService;

    @Autowired
    public ItemController(ItemService itemService, CategoryService categoryService, MailService mailService, UserService userService) {
        this.itemService = itemService;
        this.categoryService = categoryService;
        this.mailService = mailService;
        this.userService = userService;
    }



    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public String putItemForRent(Model model)
    {
        model.addAttribute("itemCondition", ItemCondition.values());
        model.addAttribute("itemCategories", CategoryType.values());
        return "items/new";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processItem(HttpServletRequest request,Principal principal)
    {
        Map<String,String[]> parameters = request.getParameterMap();
        Category itemCategory = categoryService.getByType(parameters.get("category")[0]);
        User user = userService.findByUsername(principal.getName());
        Item item = new Item();
        item.setDescription(parameters.get("description")[0]);
        item.setCondition(parameters.get("condition")[0]);
        item.setPrice(Double.parseDouble(parameters.get("price")[0]));
        item.setCategory(itemCategory);
        item.setRenter(user);
        itemService.saveItem(item);
        return "redirect:/category";
    }

    @RequestMapping(value = "/{item_id}",method = RequestMethod.POST)
    public String rentItem(@PathVariable("item_id") Long itemId, Principal principal)
    {
        Item item = itemService.findById(itemId);
        User toUser = item.getRenter();
        User contactUser = userService.findByUsername(principal.getName());
        try
        {
            mailService.sendMail(toUser,contactUser);
        }
        catch(Exception e)
        {
            System.out.println("Error is " + e.getMessage());
        }

        return "redirect:/category";

    }


}
