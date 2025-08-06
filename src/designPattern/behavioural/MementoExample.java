package designPattern.behavioural;

import java.util.Stack;

class Info {
    int age;
    String name;
    public Info(int age, String name) {
        this.age = age;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Info{" + "age=" + age + ", name='" + name + '\'' + '}';
    }
}
class Originator {
    Info info;
    public void setInfo(Info info) {
        this.info = info;
    }
    public Memento createMemento() {
        return new Memento(info);
    }
    public void restoreMemento(Memento memento) {
        info = memento.info;
    }
    @Override
    public String toString() {
        return "Originator{" + "info=" + info + '}';
    }
}
class Memento {
    Info info;
    public Memento(Info info) {
        this.info = info;
    }
}

class Caretaker {
    Stack<Memento> history ;
    public Caretaker() {
        this.history = new Stack<>();
    }
    public void save(Memento memento) {
        history.push(memento);
    }
    public Memento undo(){
        history.pop();
        return history.peek();
    }
}
public class MementoExample {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        originator.setInfo(new Info(23, "Nitin"));
        caretaker.save(originator.createMemento());

        originator.setInfo(new Info(15, "Ritik"));
        caretaker.save(originator.createMemento());

        System.out.println(originator);

        Memento memento = caretaker.undo();
        originator.restoreMemento(memento);
        System.out.println(originator);

    }
}
