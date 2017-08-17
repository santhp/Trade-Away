package com.tw.tradeaway.service;

import com.tw.tradeaway.dao.OrderDAO;
import com.tw.tradeaway.dao.ProductDAO;
import com.tw.tradeaway.dao.ProductSellerQuantityMappingDao;
import com.tw.tradeaway.dto.OrderItemDto;
import com.tw.tradeaway.entities.Order;
import com.tw.tradeaway.entities.Product;
import com.tw.tradeaway.entities.ProductSellerQuantityMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderPlacementServiceImpl  implements  OrderPlacementService{

    @Autowired
    OrderDAO orderRepo;

    @Autowired
    ProductDAO productDAO;

    @Autowired
    ProductSellerQuantityMappingDao productSellerQuantityMappingDao;
    /**
     * method to perform process order creation
     * @param orderDto
     * @return orderID
     */
    @Override
    @Transactional
    public OrderItemDto createOrder(OrderItemDto orderDto)  {

        // perform validations
        performValidations(orderDto);

        if(orderDto.getErrorMsg().isEmpty()){
            Product product=productDAO.findOne(orderDto.getProductId());
            Order newOrder=new Order(product,orderDto.getBuyerId(),orderDto.getSellerId(),orderDto.getQty(),orderDto.getDeliveryAddress(),"PENDING");
            ProductSellerQuantityMapping productInfo =  productSellerQuantityMappingDao.getProductSellerQuantityMappingGivenProductAndSeller(orderDto.getProductId(),orderDto.getSellerId());
            int availableQuantity= productInfo.getQuantity();
            productInfo.setQuantity(availableQuantity-orderDto.getQty());

            productSellerQuantityMappingDao.save(productInfo);
            newOrder = orderRepo.save(newOrder);
            orderDto.setOrderId(newOrder.getId());

            // set total order price
            double totalOrderPrice = product.getPrice()*orderDto.getQty();
            orderDto.setPrice(totalOrderPrice);
            orderDto.setProductname(product.getName());
       }

        return orderDto;
    }


    private void performValidations(OrderItemDto orderDto)  {

        // mandatory validations
        if(orderDto == null || orderDto.getBuyerId() == 0
                || orderDto.getSellerId() == 0
                || orderDto.getProductId() == 0
                || orderDto.getQty() == 0
                || orderDto.getDeliveryAddress() == null
                || orderDto.getDeliveryAddress().isEmpty()){

            orderDto.getErrorMsg().add("Address, Quantity are mandatory to create order");
            return;
        }

        int quantityAvailable=productSellerQuantityMappingDao.getQuantityForGivenProductAndSeller(orderDto.getProductId(),orderDto.getSellerId());
        if(quantityAvailable< orderDto.getQty()){
            orderDto.getErrorMsg().add("Order Quantity is not available in stock");
        }


    }
}
