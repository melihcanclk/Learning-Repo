package businessDelegate;

public class BusinessLookUp {
    public BusinessService getBusinessService(String serviceType) {
        return switch (serviceType) {
            case "EJB" -> new EJBService();
            case "JMS" -> new JMSService();
            default -> null;
        };
    }

}
