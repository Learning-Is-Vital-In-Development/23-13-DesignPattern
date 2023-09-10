package livid_design_pattern.proxy.basic;

import livid_design_pattern.proxy.RealSubject;
import livid_design_pattern.proxy.Subject;

class ProxySubject implements Subject {
    Subject subject;

    public ProxySubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void action() {
        subject.action();
        System.out.println("proxy action");
    }
}

class Client {
    public static void main(String[] args) {
        Subject subject = new ProxySubject(new RealSubject());

        subject.action();
    }
}
