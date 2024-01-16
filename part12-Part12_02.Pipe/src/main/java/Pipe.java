import java.util.ArrayList;

public class Pipe<T>  {
    private ArrayList<T> pipe;

    public Pipe() {
        this.pipe = new ArrayList();
    }

    public void putIntoPipe(T value) {
        pipe.add(value);
    }

    public T takeFromPipe() {
        if (pipe.isEmpty()) {
            return null;
        } else {
            T p = pipe.get(0);
            pipe.remove(0);
            return p;
        }
    }

    public boolean isInPipe() {
        return !pipe.isEmpty();
    }

}
