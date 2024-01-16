public class Hideout<T> {
    private T element;

    public Hideout() {
    }

    public void putIntoHideout(T toHide) {
        element = toHide;
    }

    public T takeFromHideout() {

        if (isInHideout()) {
            T r = element;
            element = null;
            return r;
        } else {
            return null;
        }
    }

    public boolean isInHideout() {
        return !(element == null);
    }

}
