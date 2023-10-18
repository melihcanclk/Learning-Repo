package businessDelegate;

public class Client {
    BusinessDelegate businessService;

    Client(BusinessDelegate businessService) {
        this.businessService = businessService;
    }

    public void doTask() {
        businessService.doTask();
    }
}
