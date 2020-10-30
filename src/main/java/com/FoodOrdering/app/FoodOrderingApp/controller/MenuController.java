package com.FoodOrdering.app.FoodOrderingApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.FoodOrdering.app.FoodOrderingApp.model.Menu;
import com.FoodOrdering.app.FoodOrderingApp.service.impl.MenuServiceImpl;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    MenuServiceImpl menuSerive;

    @RequestMapping(value = "/find",
            params = {"id"},
            method = RequestMethod.GET)
    public ResponseEntity findMenuById(@RequestParam("id") int id) {
        return menuSerive.getMenu(id);
    }


    @RequestMapping(value = "/find",
            params = {"name"},
            method = RequestMethod.GET)
    public ResponseEntity findMenuByName(@RequestParam("name") String name) {
        return menuSerive.getMenu(name);
    }


    @RequestMapping(value = "/find",
            params = {"categorie"},
            method = RequestMethod.GET)
    public ResponseEntity findMenuByCategorie(@RequestParam("categorie") String categorie) {
        return menuSerive.getMenuListByCategorie(categorie);
    }


    @RequestMapping(value = "/findAll",
            method = RequestMethod.GET)
    public ResponseEntity findAll() {
        return menuSerive.getAll();
    }

    @RequestMapping(
            value="/getImage",
            params = {"imageId"},
            method = RequestMethod.GET,
            produces = {MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_PNG_VALUE}
    )
    public @ResponseBody byte[] getImage(@RequestParam("imageId") int id){
        return menuSerive.getimage(id);
    }

    @PostMapping(
            value = "/upload",
            params = {"category"}
    )
    public ResponseEntity uploadImage(@RequestParam("category")String category, @RequestParam("imageFile") MultipartFile imageFile) {
        return menuSerive.saveImage(category, imageFile);
    }

    @PostMapping(value = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addMenu(@RequestBody Menu menu) {
        return menuSerive.addMenu(menu);
    }


    @PutMapping(value = "/edit",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity editMenu(@RequestBody Menu menu) {
        return menuSerive.updateMenu(menu);
    }


}
