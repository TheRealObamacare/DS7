import java.util.ArrayList;

public class DS7_MinHeap<E extends Comparable<E>> implements DS7_HeapInterface<E>
{
        private ArrayList<E> heap;
        public DS7_MinHeap()
        {
            heap= new ArrayList<>();
        }
        public DS7_MinHeap(ArrayList<E> heap)
        {
            this.heap = heap;
        }
        @Override
        public boolean insert(E item)
        {
            heap.add(item);
            heapifyUp();
            return true;
        }
        private void heapifyUp()
        {
            int index = heap.size()-1;
            while(index>0)
            {
                int p= (index-1)/2;
                E cur= heap.get(index);
                E parent= heap.get(p);
                if(cur.compareTo(parent)<0)
                {
                    heap.set(index, parent);
                    heap.set(p, cur);
                    index=p;
                }
                else
                    break;
            }
        }
        @Override
        public E remove()
        {
            if(heap.isEmpty())
                return null;
            E removedItem= heap.get(0);
            heap.set(0, heap.get(heap.size()-1));
            heap.remove(heap.size()-1);
            heapifyDown();
            return removedItem;
        }
        private void heapifyDown()
        {
            int index=0;
            int left=2*index+1;
            while(left<heap.size())
            {
                int min=left;
                int right=left+1;
                if(right<heap.size())
                {
                    if(heap.get(right).compareTo(heap.get(left))<0)
                        min++;
                }
                if(heap.get(index).compareTo(heap.get(min))>0)
                {
                    E temp= heap.get(index);
                    heap.set(index, heap.get(min));
                    heap.set(min, temp);
                    index=min;
                    left=2*index+1;
                }
                else
                    break;
        }
        }
        @Override
        public boolean isEmpty()
        {
            return heap.isEmpty();
        }
        @Override
            public int size()
        {
            return heap.size();
        }

    @Override
    public E get(int x) {
        return heap.get(x);
    }

    @Override
            public void clear()
        {
            heap.clear();
        }
        @Override
            public String toString()
        {
            return heap.toString();
        }
}
