package src;

public abstract class Informer {

    private String name;
    private String secret;
    private StaticMediator mediator;

    public Informer(String n, String sec, StaticMediator sm) {
        name = n;
        secret = sec;
        mediator = sm;
    }

    public String toString() {
        return name + "  " + secret;
    }

    public void statusChange() {
        mediator.informerChange(this);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getName() {
        return name;
    }

    public String getSecret() {
        return secret;
    }
}

class Spy extends Informer {
    private int clearance;

    public Spy (String n, String sec, int clear, StaticMediator sm) {
        super(n,sec,sm);
        clearance = clear;
    }

    public String toString() {
        String s = super.toString();
        return s + "  and my clearance " + clearance;
    }

    public void setClearance(int clearance) {
        this.clearance = clearance;
    }

    public int getClearance() {
        return clearance;
    }
}

class Agent extends Informer {
    public Agent(String n, String sec, StaticMediator sm) {
        super(n, sec, sm);
    }
}

class Mole extends Informer {
    public Mole(String n, String sec, StaticMediator sm) {
        super(n, sec, sm);
    }
}