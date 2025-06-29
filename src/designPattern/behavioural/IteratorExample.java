package designPattern.behavioural;

import java.util.List;

// iterator interface
interface Iterator<T> {
    boolean hasNext();
    T next();

}
// concrete iterators
class ForwardIterator implements Iterator<String> {
    List<String> list;
    int index;
    public ForwardIterator(List<String> list) {
        this.list = list;
        this.index = 0;
    }
    @Override
    public boolean hasNext() {
        return index < list.size();
    }
    @Override
    public String next() {
        return list.get(index++);
    }
}
class BackwardIterator implements Iterator<String> {
    List<String> list;
    int index;
    public BackwardIterator(List<String> list) {
        this.list = list;
        this.index = list.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return index >= 0;
    }
    @Override
    public String next() {
        return list.get(index--);
    }
}
// iterable interface, every collection must give a method to return iterator object
interface IterableCollection<T>{
    Iterator<T> getIterator(String type);
}
// actual iterable collection
class Data implements IterableCollection<String>{
    List<String> list;

    public Data(List<String> list) {
        this.list = list;
    }

    @Override
    public Iterator<String> getIterator(String type) {
        if(type.equals("forward")){
            return new ForwardIterator(this.list);
        }
        else{
            return new BackwardIterator(this.list);
        }
    }
}
public class IteratorExample {

    public static void main(String[] args) {
        List<String> list = List.of("a", "b", "c");
        Data data = new Data(list);

        Iterator<String> forward = data.getIterator("forward");
        while(forward.hasNext()){
            System.out.println(forward.next());
        }
        Iterator<String> backward = data.getIterator("backward");
        while(backward.hasNext()){
            System.out.println(backward.next());
        }

    }
}
