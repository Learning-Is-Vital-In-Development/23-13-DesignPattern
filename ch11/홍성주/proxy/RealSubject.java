package livid_design_pattern.proxy;

import livid_design_pattern.proxy.Subject;

public class RealSubject implements Subject {
    @Override
    public void action() {
        System.out.println("realSubject Action");
    }
}




