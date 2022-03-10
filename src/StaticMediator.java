package src;

import java.util.ArrayList;
import java.util.Arrays;

public class StaticMediator {

    private Spy s1, s2, s3, s4;
    private Agent a1, c1;
    private Mole m1;
    //step 2
    private Agent a2, a3;
    private Mole m2, m3;
    private CompositeAgent duo;

    public void createSpyTeam () {

        s1 = new Spy("spy1 ", "secret 1 ", 10, this);
        s2 = new Spy("spy2 ", "secret 2 ", 5, this);
        s3 = new Spy("spy3 ", "secret 3 ", 2, this);
        s4 = new Spy("spy4 ", "secret 4 ", 20, this);
        a1 = new Agent("a1 ", "ultra secret 1 ",this);
        m1 = new Mole("m1 ", "deep secret 1 ", this);
        c1 = new Agent("cleaner ", " no secret ",this);

        //step2
        a2 = new Agent("a2 ", " ultra secret 2 ",this);
        m2 = new Mole("m2 ", " deep secret 2 ", this);
        a3 = new Agent("a3 ", " ultra secret 3 ",this);
        m3 = new Mole("m3 ", " deep secret 3 ", this);
        duo = new CompositeAgent (new ArrayList<>(Arrays.asList(a2, m2)));


    }

    public void informerChange(Informer i) {
        /**
         * When	s1	changes	status	then	s1	and	s2	swap	their	secret
         * When	s2	changes	status	then	s3’s	secret	is	appended	to	the	end	of	s2’s	secret
         * When	s3	changes	status	then	s3’s	clearance	is	to	the	clearance	of	s1	+	the	clearance	of	s2
         *      And	the	clearance	of	s4	is	set	to	0
         * When	s4	changes	status	then
         * 		If	s4’s	clearance	is	>	0	then	s1’s	clearance	is	set	to	s4’s	clearance
         * 		And	s2’s	clearance	is	set	to	s3’s	clearance
         *  	Else	do	nothing
         * When	a1	changes	status	then			a1’s	secret	is	set	to	s3’s	secret
         * 		And	the	secret	of	m1	is	set	to	“forgotten”
         * When	m1	changes	status	m1	and	s4	swap	secrets
         * When	c1	changes	status	a1	and	m1	are	set	to	null
         */

        String temp;
        System.out.println(i.getName() + " status update:");
        if (i == s1) {
            temp = i.getSecret();
            i.setSecret(s2.getSecret());
            s2.setSecret(temp);
        }
        if (i == s2) {
            temp = i.getSecret();
            temp += s3.getSecret();
            i.setSecret(temp);
        }
        if (i == s3) {
            int x = s1.getClearance() + s2.getClearance();
            s3.setClearance(x);
            s4.setClearance(0);
        }
        if (i == s4) {
            if (s4.getClearance() > 0) {
                s1.setClearance(s4.getClearance());
                s2.setClearance(s3.getClearance());
            }
        }
        if (i == a1) {
            i.setSecret(s3.getSecret());
            m1.setSecret("forgotten");
        }
        if (i == m1) {
            temp = i.getSecret();
            i.setSecret(s4.getSecret());
            s4.setSecret(temp);
        }
        if (i == c1) {
            a1 = null;
            m1 = null;
        }
        /**
         * When	a2	changes	status	then set	its	secret	to	a1’s	secret	followed	by	m1’s	secret
         * When	m2	changes	status	then set	secret	of	s1	to	m2’s	secret
         * When	a3	changes	status	then
         * - set	duo’s	secret	(ie	the	secret	of	its	each	of	its	components)	to	the	secret	of	a1	followed
         * by	the	secret	of	m2
         * - set	the	secret	of	a3	to	the	secret	of	s1
         * - set	the	secret	of	m3	to	“forgotten”
         * When	m3	changes	status	then swap	the	secret	of	duo	with	the	secret	of	m1
         */
        if (i == a2) {
            i.setSecret(a1.getSecret() + m1.getSecret());
            //this is a change... i'm not sure why
            s1.setClearance(77);
        }
        if (i == m2) {
            temp = i.getSecret();
            i.setSecret(s1.getSecret());
            s1.setSecret(temp);
        }
        if (i == a3) {
            duo.setSecret(a1.getSecret() + m2.getSecret());
            i.setSecret(s1.getSecret());
            m3.setSecret("forgotten");
        }
        if (i == m3) {
            temp = m1.getSecret();
            m1.setSecret(duo.getSecret());
            duo.setSecret(temp);
        }
        printStatus();
    }

    public StaticMediator() {
        createSpyTeam();
    }

    public void runScenario1 () {
        System.out.println("Initial set up");
        printStatus();
        s4.statusChange();
        s1.statusChange();
        s2.statusChange();
        s3.statusChange();
        s4.statusChange();
        a1.statusChange();
        m1.statusChange();
        c1.statusChange();
    }

    public void runScenario2 () {
        System.out.println("Initial set up");
        printStatus();
        duo.statusChange();
        a3.statusChange();
        m3.statusChange();
    }

    private void printStatus() {
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(a1);
        System.out.println(m1);
        System.out.println(c1);
        //Step 2
        System.out.println(duo);
    }

   //missing code

}