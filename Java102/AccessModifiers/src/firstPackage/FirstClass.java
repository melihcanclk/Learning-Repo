package firstPackage;

public class FirstClass {

    private String str;

    public FirstClass(String str){
        this.str = str;
    }

    void showStrPrv(){
        System.out.println(this.str);
    }

    public void showStrPubl(){
        System.out.println(this.str);
    }
}
