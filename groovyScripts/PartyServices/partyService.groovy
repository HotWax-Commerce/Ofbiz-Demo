import org.apache.ofbiz.entity.GenericEntityException;

def createParty() {
  result = [:];
  try {
    party = delegator.makeValue("DemoParty");
    party.setNextSeqId()
    party.setNonPKFields(context);
    party = delegator.create(party)
    result.partyId = party.partyId
    logInfo("==========This is my first Groovy Service implementation in Apache OFBiz. OfbizDemo record "
        + "created successfully with ofbizDemoId: " + party.getString("partyId"));
  }
  catch (GenericEntityException e) {
    logError(e.getMessage());
    return error("Error in creating record in OfbizDemo entity ........");
  }
  return result;
}