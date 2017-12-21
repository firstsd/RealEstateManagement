/*
 * Created on Nov 16, 2017
 */
package mum.edu.project.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import mum.edu.project.domain.PropertyOrder;
import mum.edu.project.repository.PropertyOrderRepository;
import mum.edu.project.service.impl.PropertyOrderServiceImpl;

public class OrderSeivceTest {
    
    @Mock
    PropertyOrderRepository propertyOrderRepositoryMock;
    
    @InjectMocks
    PropertyOrderServiceImpl propertyOrderService;

    List<PropertyOrder> list = new ArrayList<PropertyOrder>();
    
    @Before
    public void setup() {
 
        // Process mock annotations
        MockitoAnnotations.initMocks(this);
        PropertyOrder pf1 = new PropertyOrder();
        pf1.setId(1l);
        pf1.setComment("order1");
        pf1.setRegisterDate(new Date());
        pf1.setStatus(1);
        pf1.setBuyPrice(12000l);
        pf1.setDeposit(10000l);
        pf1.setRentMonth(100);
        
        PropertyOrder pf2 = new PropertyOrder();
        pf2.setId(2l);
        pf2.setComment("order2");
        pf2.setRegisterDate(new Date());
        pf2.setStatus(1);
        pf2.setBuyPrice(22000l);
        pf2.setDeposit(20000l);
        pf2.setRentMonth(200);
       
        list.add(pf1);
        list.add(pf2);
    }

    @Test
    public void getAll() throws Exception {
        when(propertyOrderRepositoryMock.findAll()).thenReturn(list);
        List<PropertyOrder> orders = propertyOrderService.getAll();
        for(PropertyOrder od :orders ) {
            System.out.println(od.getComment());
            System.out.println(od.getRegisterDate());
            System.out.println(od.getBuyPrice());
            System.out.println(od.getDeposit());
            System.out.println(od.getRentMonth());
        }
    }
}
