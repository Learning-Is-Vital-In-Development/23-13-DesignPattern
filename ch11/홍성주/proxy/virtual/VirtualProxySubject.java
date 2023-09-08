package livid_design_pattern.proxy.virtual;

import livid_design_pattern.proxy.RealSubject;
import livid_design_pattern.proxy.Subject;

public class VirtualProxySubject implements Subject {
    private RealSubject realSubject;

    public VirtualProxySubject() {
    }

    @Override
    public void action() {
        if(realSubject == null) {
            realSubject = new RealSubject();
        }
        realSubject.action();
        System.out.println("virtual proxy action");
    }
}

class Client {
    public static void main(String[] args) {
        Subject subject = new VirtualProxySubject();

        subject.action();
    }
}
