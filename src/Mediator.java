package src;
import java.awt.*;
import java.util.ArrayList;

public class Mediator {

    CompositeAgent myAgents = new CompositeAgent(new ArrayList<Informer> ());
    CompositeAgent myMoles = new CompositeAgent(new ArrayList<Informer> ());
    Cleaner myCleaner;

    public void setTeam(ArrayList<Informer> list) {
        for (Informer i : list) {
            if (i instanceof Agent) {
                myAgents.add(i);
                i.setMediator(this);
            }
            if (i instanceof Mole) {
                myAgents.add(i);
                i.setMediator(this);
            }
        }
    }

    public void informerChange(Informer i) {
        if (i instanceof Agent) {
            i.setSecret(myMoles.getSecret());
        }
    }

    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append(" agents: ");
        result.append(myAgents.toString());
        result.append(" moles: ");
        result.append(myMoles.toString());
        result.append(" cleaner: " + myCleaner);
        return result.toString();
    }

    
}
