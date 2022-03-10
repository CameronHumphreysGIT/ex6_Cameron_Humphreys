package src;

public abstract class Informer {

    private String name;
    private String secret;
    private Mediator mediator;

    public Informer(String n, String sec) {
        name = n;
        secret = sec;
    }

    public String toString() {
        return name + "  " + secret;
    }

    public void statusChange() {
        mediator.informerChange(this);
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

    public void setMediator(Mediator m) {
        mediator = m;
    }

}


class Agent extends Informer {
    public Agent(String n, String sec) {
        super(n, sec);
    }
}

class Mole extends Informer {
    public Mole(String n, String sec) {
        super(n, sec);
    }
}