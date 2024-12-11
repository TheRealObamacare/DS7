
public interface DS7_HeapInterface<E extends Comparable>
{
    public boolean insert(E item);
    public E remove();
    public boolean isEmpty();
    public int size();
    public E get(int x);
    public void clear();
}
