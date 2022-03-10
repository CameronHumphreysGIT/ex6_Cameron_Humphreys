package src;

import java.util.ArrayList;

public class CompositeAgent extends Informer{
    ArrayList<Informer> informers;
    public CompositeAgent(ArrayList<Informer> list) {
        super("team", list.get(0).getSecret(), list.get(0).getMediator());
        informers = list;
    }
    public String toString() {
        String informString = "";
        for (Informer i : informers) {
            informString += i.toString() + "\n";
        }
        return super.getName() + ":\n" + informString;
    }

    public void statusChange() {
        System.out.println("team status changed");
        for (Informer i : informers) {
            i.statusChange();
        }
    }

    public void setSecret(String s) {
        for (Informer i : informers) {
            i.setSecret(s);
        }
    }

    public String getSecret() {
        String secrets = "";
        for (Informer i : informers) {
            secrets += i.getSecret();
        }
        return secrets;
    }
}
