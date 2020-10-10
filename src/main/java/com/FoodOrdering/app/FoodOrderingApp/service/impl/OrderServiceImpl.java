package com.FoodOrdering.app.FoodOrderingApp.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.Timestamp;

import javax.swing.text.StyledEditorKit.ItalicAction;

import com.FoodOrdering.app.FoodOrderingApp.Handler.Exceptions.ActionErrorException;
import com.FoodOrdering.app.FoodOrderingApp.Handler.Exceptions.ElementNotFoundException;
import com.FoodOrdering.app.FoodOrderingApp.connector.Interface.MenuConnector;
import com.FoodOrdering.app.FoodOrderingApp.model.Menu;
import org.apache.logging.log4j.util.SystemPropertiesPropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.FoodOrdering.app.FoodOrderingApp.connector.Interface.ClientConnector;
import com.FoodOrdering.app.FoodOrderingApp.connector.Interface.OrderConnector;
import com.FoodOrdering.app.FoodOrderingApp.model.Client;
import com.FoodOrdering.app.FoodOrderingApp.model.Order;
import com.FoodOrdering.app.FoodOrderingApp.service.interfaces.OrderService;

import static org.springframework.http.ResponseEntity.ok;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderConnector orderCon;

    @Autowired
    MenuConnector menuCon;

    @Autowired
    ClientConnector clientCon;

    @Override
    public ResponseEntity makeOrder(Order order, String email, int id) {
        Client client = clientCon.getClient(email);
        Map<String, Object> model;
        if (client != null) {
            order.setClient(client);
            Menu menu = menuCon.getMenu(id);
            if (menu != null) {
                setOrderData(order, menu);
                order = orderCon.insertOrder(order);
                model = this.setModelOrder(order);
            } else {
                throw new ElementNotFoundException("Menu does not exist");
            }
        } else {
            throw new ElementNotFoundException("User does not exist");
        }
        return ok(model);
    }

    @Override
    public ResponseEntity updateOrder(Order order) {
        Map<String, Object> model;
        System.out.println("Is ORDER NULL"+ order == null);
        System.out.println("Order ID" + order.getIdOrder());
        if (order != null && orderCon.getByIdOrder(order.getIdOrder()) != null) {
            order = orderCon.editOrder(order);
            model = this.setModelOrder(order);
        } else {
            throw new ActionErrorException("Can't Update Order");
        }

        return ok(model);
    }

    @Override
    public ResponseEntity getOrder(int idOrder) {
        Order order = orderCon.getByIdOrder(idOrder);
        return ok(this.setModelOrder(order));
    }

    @Override
    public ResponseEntity trackCommande(String trackingStatus) {
        Iterable<Order> orderList = orderCon.getByTrackingStatus(trackingStatus);
        List<HashMap<String, Object>> orderLitMap = this.getOrderListMap(orderList);
        return new ResponseEntity(orderLitMap, HttpStatus.OK);
    }

    @Override
    public ResponseEntity getOrderbyOrderdate(String dateOrder) {
        List<HashMap<String, Object>> orderLitMap;
        Timestamp dateOrdered = Timestamp.valueOf(dateOrder);
        Iterable<Order> ordersList = orderCon.getByDateOrder(dateOrdered);
        List<Order> ordersWithSameDateTime = new ArrayList<>();
        for (Order orderItem : ordersList) {
            Timestamp dbDateOrder = orderItem.getDateOrder();
            if (dbDateOrder.equals(dateOrdered)) {
                ordersWithSameDateTime.add(orderItem);
            }
        }
        if (!ordersWithSameDateTime.isEmpty()) {
            ordersList = ordersWithSameDateTime;
        }
        orderLitMap = this.getOrderListMap(ordersList);
        return new ResponseEntity(orderLitMap, HttpStatus.OK);

    }

    @Override
    public ResponseEntity getOrder(String clientEmail) {
        Client client = clientCon.getClient(clientEmail);
        Iterable<Order> orderList = orderCon.getByClient(client);
        List<HashMap<String, Object>> orderLitMap = this.getOrderListMap(orderList);
        return new ResponseEntity(orderLitMap, HttpStatus.OK);
    }

    @Override
    public ResponseEntity getPrebookingOrder(String reserveDate) {
        Timestamp dateReserving = Timestamp.valueOf(reserveDate);
        Iterable<Order> orderList = orderCon.getByServeDate(dateReserving);
        List<HashMap<String, Object>> orderLitMap = this.getOrderListMap(orderList);
        return new ResponseEntity(orderLitMap, HttpStatus.OK);
    }

    @Override
    public ResponseEntity getOrderedItems(boolean popularity) {
        Iterable<Order> orderList = orderCon.getOrderedMenus();
        if (popularity) {
            return new ResponseEntity(this.getPopularity(orderList), HttpStatus.OK);
        }
        return new ResponseEntity(this.getOrderedMenuListMap(orderList), HttpStatus.OK);
    }

    @Override
    public ResponseEntity deleteOrderItem(int idOrder) {
        Map<String, Object> model = new HashMap<>();
        if ( this.orderCon.deleteOrder(idOrder) ){
            model.put("message","Order DELETED");
        } else {
            throw new ActionErrorException("Can't Delete order");
        }
        return ok(model);
    }

    private void setOrderData(Order order, Menu menu){
        order.setMenu(menu);
        long now = System.currentTimeMillis();
        Timestamp date = new Timestamp(now);
        order.setDateOrder(date);
        if (order.getTrackingState() == null) {
            order.setTrackingState("Submitted");
        }
        order.setTotalPrice( menu.getPrice() * order.getQuantity() );
    }

    private List<HashMap<String, Object>> getOrderListMap(Iterable<Order> orderList) {
        List<HashMap<String, Object>> orderLitMap = new ArrayList<HashMap<String, Object>>();
        for (Order orderItem : orderList) {
            orderLitMap.add(this.setModelOrder(orderItem));
        }
        return orderLitMap;
    }

    private List<HashMap<String, Object>> getOrderedMenuListMap(Iterable<Order> orderList) {
        List<HashMap<String, Object>> orderListMap = new ArrayList<HashMap<String, Object>>();
        for (Order orderItem : orderList) {
            HashMap<String, Object> model;
            model = this.setModelOrder(orderItem);
            model.put("totalOrders", orderItem.getNumberOrders());
            orderListMap.add(model);
        }
        return orderListMap;
    }

    private HashMap<String, Object> setModelOrder(Order order) {
        HashMap<String, Object> model = new HashMap<String, Object>();
        System.out.println("ORDER ID "+ order.getIdOrder());
        model.put("ref", order.getIdOrder());
        model.put("quantity", order.getQuantity());
        model.put("trackingStatus", order.getTrackingState());
        model.put("orderDate", order.getDateOrder());
        model.put("totalPrice", order.getTotalPrice());
        model.put("menu", order.getMenuDataMap());
        model.put("client", order.getClientDataMap());
        if (order.getServeDate() != null && order.getNbPerson() != 0) {
            model.put("serveDate", order.getServeDate());
            model.put("nbPreson", order.getNbPerson());
        }
        return model;
    }

    private List<HashMap<String, Long>> getPopularity(Iterable<Order> orderedList) {
        List<HashMap<String, Long>> popular = new ArrayList<HashMap<String, Long>>();
        for (Order orderElement : orderedList) {
            HashMap<String, Long> model = new HashMap<String, Long>();
            if ( !checkMenuIdInList(popular, (long) orderElement.getMenu().getIdmenu()) ) {
                long totalOrders = countOrderNumbers(orderElement.getMenu().getIdmenu(), orderedList);
                model.put("menu", (long) orderElement.getMenu().getIdmenu());
                model.put("totalOrders", totalOrders);
                popular.add(model);
            }
        }

        Comparator<Map<String, Long>> mapComparator = new Comparator<Map<String, Long>>() {
            @Override
            public int compare(Map<String, Long> o1, Map<String, Long> o2) {
                return o1.get("totalOrders").compareTo(o2.get("totalOrders"));
            }
        };

        Collections.sort(popular, mapComparator);
        return popular;
    }

    private boolean checkMenuIdInList(List<HashMap<String, Long>> searchList, long idMenu) {
        boolean exist = false;
        for (HashMap<String, Long> mapElement : searchList) {
            if (mapElement.get("menu") == idMenu) {
                exist = true;
            }
        }
        return exist;
    }

    private long countOrderNumbers(int idMenu, Iterable<Order> orderedList) {

        long totalMenuOrders = 0;

        for (Order orderItem : orderedList) {
            if (orderItem.getMenu().getIdmenu() == idMenu) {
                totalMenuOrders += orderItem.getNumberOrders();
            }
        }
        return totalMenuOrders;
    }
}
