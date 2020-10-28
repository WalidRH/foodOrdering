package com.FoodOrdering.app.FoodOrderingApp.service.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.FoodOrdering.app.FoodOrderingApp.Handler.Exceptions.ActionErrorException;
import com.FoodOrdering.app.FoodOrderingApp.Handler.Exceptions.ElementExistException;
import com.FoodOrdering.app.FoodOrderingApp.Handler.Exceptions.ElementNotFoundException;
import com.FoodOrdering.app.FoodOrderingApp.Handler.Exceptions.MediaNotSupportedException;
import com.FoodOrdering.app.FoodOrderingApp.service.enums.ImageFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import static org.springframework.http.ResponseEntity.ok;
import com.FoodOrdering.app.FoodOrderingApp.connector.impl.MenuConnectorImpl;
import com.FoodOrdering.app.FoodOrderingApp.model.Menu;
import com.FoodOrdering.app.FoodOrderingApp.service.interfaces.MenuService;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuConnectorImpl menuConnector;

	@Override
	public ResponseEntity addMenu(Menu menu) {
		Map<String, Object> model = new HashMap<>();
		if (menuConnector.getMenu(menu.getName()) == null ) {
			Menu menu_ = menuConnector.saveMenu(menu);
			model = setModel(menu_);
		} else
			throw new ElementExistException("Meal already exist");
		return ok(model);
	}

	@Override
	public ResponseEntity updateMenu(Menu menu) {
		Map<String, Object> model = new HashMap<>();
		if (menuConnector.getMenu(menu.getName()) != null) {
			menu.setIdmenu(menuConnector.getMenu(menu.getName()).getIdmenu());
			Menu menu_ = menuConnector.editMenu(menu);
			model = setModel(menu_);
		} else
			throw new ElementNotFoundException("Meal deosn't exist");
		return ok(model);
	}

	@Override
	public ResponseEntity getMenu(int id) {
		Map<String, Object> model = new HashMap<>();
		Menu menu = menuConnector.getMenu(id);
		if (menu != null) {
			model = setModel(menu);
		} else {
			throw new ElementNotFoundException("Meal deosn't exist");
		}
		return ok(model);

	}

	@Override
	public ResponseEntity getMenu(String name) {
		Map<String, Object> model = new HashMap<>();
		Menu menu = menuConnector.getMenu(name);
		if (menu != null) {
			model = setModel(menu);
		}else {
			throw new ElementNotFoundException("Meal deosn't exist");
		}
		return ok(model);
	}

	@Override
	public ResponseEntity getMenuListByCategorie(String categorie) {
		Iterable<Menu> menuDB = menuConnector.getMenuList(categorie);
		List<HashMap<String, Object>> menuList = new ArrayList<HashMap<String, Object>>();
		for ( Menu menuElement : menuDB ) {
			System.out.println("menuElt ==> "+menuElement.getIdmenu());
			Map<String, Object> menuMap = setModel(menuElement);
			menuList.add((HashMap<String, Object>) menuMap);
		}
		return new ResponseEntity(menuList, HttpStatus.OK);
	}

	@Override
	public ResponseEntity getAll() {
		Iterable<Menu> menuDB = menuConnector.getAll();
		List<HashMap<String, Object>> menuList = new ArrayList<HashMap<String, Object>>();

		for (Menu menuElement : menuDB) {
			System.out.println("menuElt ==> "+menuElement.getIdmenu());
			Map<String, Object> menuMap = setModel(menuElement);
			menuList.add((HashMap<String, Object>) menuMap);
		}
		return new ResponseEntity(menuList, HttpStatus.OK);
	}

	private Map<String, Object> setModel(Menu menu){
		Map<String, Object> menuMap = new HashMap<>();
		menuMap.put("ref", menu.getIdmenu());
		menuMap.put("name", menu.getName());
		menuMap.put("price", menu.getPrice());
		menuMap.put("image", menu.getImage());
		menuMap.put( "categorie", menu.getCategorie());
		return menuMap;
	}

	@Override
	public ResponseEntity saveImage(String category, MultipartFile imageFile){
		try {
			setImageFile(imageFile.getBytes(), imageFile.getContentType(), imageFile.getOriginalFilename(), category);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	private boolean setImageFile(byte[] data , String imageFormat, String imageName, String category){
		ByteArrayInputStream bis = new ByteArrayInputStream(data);
		BufferedImage bImage2 = null;
		try {
			String imgFormat = setImageTypeFormat(imageFormat);
			if ( imgFormat != null){
				bImage2 = ImageIO.read(bis);
				ImageIO.write(bImage2, imgFormat, new File("../../FrontEnd/FoodOrderingUI/src/assets/images/categories/"+category+"/"+imageName) );
				return true;
			}else{
				throw new MediaNotSupportedException("Unsupported Media Type");
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new ActionErrorException("Can't save image");
		}
	}

	private String setImageTypeFormat(String imageFormat) {
		switch (imageFormat){
			case "image/gif":
				return ImageFormat.GIF.toString();
			case "image/png":
				return ImageFormat.PNG.toString();
			case "image/jpg":
				return ImageFormat.JPG.toString();
			case "image/jpeg":
				return ImageFormat.JPEG.toString();
			case "image/pjpeg":
				return ImageFormat.PJPEG.toString();
			default:
				return null;
		}
	}

}
