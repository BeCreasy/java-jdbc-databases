package com.pluralsight.order.service;

import com.pluralsight.order.service.dao.InsertOrderDao;
import com.pluralsight.order.dto.ParamsDto;
import com.pluralsight.order.util.Database;

/**
 * Service class to insert an order
 */
public class InsertOrderService implements OrderService {
    InsertOrderDao insertOrderDao = new InsertOrderDao(Database.getInstance());

    /**
     * Method to execute the service operation
     * @param  paramsDTO Object with the parameters to execute the service
     */
    @Override
    public String execute(ParamsDto paramsDTO) {
        String result;
        long orderId = insertOrderDao.insertOrder(paramsDTO.getOrder());

        if(orderId > 0) {
            result = "A new order with the ID " + orderId + " was inserted";
        } else {
            result = "No order was inserted";
        }

        return result;
    }
}
