package stage.ifm;

import stage.ifm.obs.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ObservableImpl observable = new ObservableImpl();

        Observer ob1 = new ObserverImpl1();
        Observer ob2 = new ObserverImpl2();



        observable.subscribe(ob1);
        observable.subscribe(ob2);
        observable.subscribe(new Observer() {
            @Override
            public void update(int newState) {
                System.out.println("Res = " + newState * Math.cos(newState));
            }
        });
        observable.setState(60);
        observable.setState(100);
        observable.unsubscribe(ob2);
        observable.setState(180);

    }
}