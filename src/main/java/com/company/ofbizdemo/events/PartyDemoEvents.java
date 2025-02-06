package com.company.ofbizdemo.events;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import org.apache.ofbiz.entity.Delegator;
import org.apache.ofbiz.entity.GenericValue;
import org.apache.ofbiz.service.GenericServiceException;
import org.apache.ofbiz.service.LocalDispatcher;

public class PartyDemoEvents{

  public static String createPartyDemoEvent(HttpServletRequest request, HttpServletResponse response ){

    Delegator del = (Delegator)request.getAttribute("delegator");
    LocalDispatcher dis = (LocalDispatcher)request.getAttribute("dispatcher");

    GenericValue userLogin = (GenericValue) request.getSession().getAttribute("userLogin");

    String partyId =request.getParameter("partyId");
    String partyName = request.getParameter("partyName");

    if(partyName.isEmpty()){
      String errMsg= "partyName cannot be null";
      request.setAttribute("_ERROR_MESSAGE_", errMsg);
      return "error";
    }

    Map<String, Object> party = new HashMap<>();
    party.put("partyId",partyId);
    party.put("partyName", partyName);


    try{
      dis.runSync("createPartyByJavaEngine", party);
    }
    catch (GenericServiceException e) {
      String errMsg = "Unable to create new records in OfbizDemo entity: " + e.toString();
      request.setAttribute("_ERROR_MESSAGE_", errMsg);
      return "error";
    }
    request.setAttribute("_EVENT_MESSAGE_", "OFBiz Demo created succesfully.");
    return "success";
  }
}