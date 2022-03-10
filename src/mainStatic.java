package src;

public class mainStatic {
    public static void main (String[] args) {
        StaticMediator m = new StaticMediator();
        //notice we cannot refer to any coordinated instances here...
        //m.runScenario1();
        //step 2
        m.runScenario2();
    }

}
