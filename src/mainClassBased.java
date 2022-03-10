package src;
import java.util.ArrayList;
import java.util.Arrays;

public class mainClassBased {
    public static void main(String[] args) {

        Mediator m = new Mediator();

        Agent a1 = new Agent("a1", "secret 1");
        Agent a2 = new Agent("a2", "secret 2");
        Mole m1 = new Mole("m1", "deep secret 1");
        Mole m2 = new Mole("m2", "deep secret 2");
        Mole m3 = new Mole("m3", "deep secret 3");
        Cleaner c1 = new Cleaner(" Leon ", " I do not like moles ");

        m.setTeam(new ArrayList<Informer>(Arrays.asList(a1, a2, m1, m2, m3, c1)));
        System.out.println("team is " + m );

        System.out.println("a1 has changed");
        a1.statusChange();

        System.out.println("m2 has changed");
        m2.statusChange();

        System.out.println("cleaner has changed");
        c1.statusChange();
        System.out.println("team is" + m);



    }

}


