/*
 * Created on Nov 17, 2017
 */
package mum.edu.project.factory;

import java.util.Date;

import mum.edu.project.constants.Constants;
import mum.edu.project.model.Property;
import mum.edu.project.model.PropertyStatus;
import mum.edu.project.model.dto.PropertyDto;

public class PropertyFactory {
    
    private static PropertyFactory INSTANCE = null;
 
    // private constructor restricted to this class itself
    private PropertyFactory()
    {
  
    }
    // static method to create instance of Singleton class
    public static PropertyFactory getInstance()
    {
        if (INSTANCE == null)
            INSTANCE = new PropertyFactory();
 
        return INSTANCE;
    }
    
     public Property createUserFromDto(PropertyDto dto) {
         Property p = new Property();
         p.setName(dto.getName());
         p.setAddress(dto.getAddress());
         p.setOwner(dto.getOwner());
         p.setBedroom(dto.getBedroom());
         p.setBathroom(dto.getBathroom());
         p.setStatus(PropertyStatus.PENDING);
         p.setApprovedBy(dto.getApprovedBy());
         p.setRegisterDate((new Date()));
         p.setApprovedDate(dto.getApprovedDate());
         p.setAgentAccount(dto.getAgentAccount());
         p.setUtilitiesCost(dto.getUtilitiesCost());
         p.setPropertyType(dto.getPropertyType());
         p.setMainPicturePath(dto.getMainPicturePath());
         p.setLivingroom(dto.getLivingroom());
         p.setParking(dto.getParking());
         p.setKitchen(dto.getKitchen());
         p.setPurposeKey(dto.getPurposeKey());
         p.setSubject(dto.getSubject());
         p.setDescription(dto.getDescription());
         p.setGoogleMapPath(dto.getGoogleMapPath());
         p.setFloor(dto.getFloor());
         p.setYard(dto.getYard());
         p.setPurposeType(dto.getPurposeType());
         p.setPurposeName(dto.getPurposeName());
         return p;
    }

}
