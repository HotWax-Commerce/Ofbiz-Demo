package com.company.ofbizdemo.services;
import java.util.Map;
import org.apache.ofbiz.base.util.Debug;
import org.apache.ofbiz.entity.Delegator;
import org.apache.ofbiz.entity.GenericEntityException;
import org.apache.ofbiz.entity.GenericValue;
import org.apache.ofbiz.service.DispatchContext;
import org.apache.ofbiz.service.ServiceUtil;

public class PartyServices{
  public static final String Module= PartyServices.class.getName();

  public static Map<String, Object> createParty(DispatchContext dtx, Map<String, Object> context){
      Map<String, Object> result= ServiceUtil.returnSuccess();
      Delegator delegator = dtx.getDelegator();
    try{
      GenericValue party = delegator.makeValue("Party");
      party.setNextSeqId();
      party= delegator.create(party);

      result.put("partyId" , party.getString("partyId"));
      Debug.log("====My first Java Service implementation in Apache OFBiz. " + "OfbizDemo record created successfully with ofbizDemoId:" + party.getString("partyId"));
    }
    catch(Exception e){
      return ServiceUtil.returnError("Error in creating record in Party entity ........" + e);
    }

    return result;
  }
}