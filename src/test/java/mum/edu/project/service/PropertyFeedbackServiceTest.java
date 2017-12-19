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

import mum.edu.project.model.PropertyFeedback;
import mum.edu.project.repository.PropertyFeedbackRepository;
import mum.edu.project.service.impl.PropertyFeedbackServiceImpl;

public class PropertyFeedbackServiceTest {
    
    
    @Mock
    PropertyFeedbackRepository propertyFeedbackRepositoryMock;
    
    @InjectMocks
    PropertyFeedbackServiceImpl propertyFeedbackService;

    List<PropertyFeedback> fbList = new ArrayList<PropertyFeedback>();
    
    @Before
    public void setup() {
 
        // Process mock annotations
        MockitoAnnotations.initMocks(this);
        PropertyFeedback pf1 = new PropertyFeedback();
        pf1.setComment("test1");
        pf1.setRegisterDate(new Date());
        pf1.setStatus(1);
        
        PropertyFeedback pf2 = new PropertyFeedback();
        pf2.setComment("test2");
        pf2.setRegisterDate(new Date());
        pf2.setStatus(1);
        fbList.add(pf1);
        fbList.add(pf2);
    }

    @Test
    public void getAll() throws Exception {
        when(propertyFeedbackRepositoryMock.findAll()).thenReturn(fbList);
        List<PropertyFeedback> pfeedbacks = propertyFeedbackService.getAll();
        for(PropertyFeedback fb :pfeedbacks ) {
            System.out.println(fb.getComment());
            System.out.println(fb.getRegisterDate());
        }
    }
}
