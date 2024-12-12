public class DS7_Sorts {
    public static void selectionSort(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++)
        {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[j] < arr[minIndex])
                {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    public static void insertionSort(int[] arr)
    {
        for (int i = 1; i < arr.length; i++)
        {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key)
            {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    public static void mergeSort(int[] data, int from, int to)
    {
        int[] tempData = new int[data.length];
        if(to == from)
        {
            return;
        }
        int middle = (from + to) / 2;
        mergeSort(data, from, middle);
        mergeSort(data, middle + 1, to);
        int i = from;
        int j = middle + 1;
        int k = from;
        while (i <= middle && j <= to)
        {
            if (data[i] < data[j])
                tempData[k++] = data[i++];
            else
                tempData[k++] = data[j++];
        }
        while (i <= middle)
            tempData[k++] = data[i++];
        while (j <= to)
            tempData[k++] = data[j++];
        for (k = from; k <= to; k++)
            data[k] = tempData[k];
    }
    public static void quickSort(int[] data, int from, int to)
    {
        if (from >= to)
            return;
        int p = data[(from + to) / 2];
        int i = from;
        int j = to;
        while (i <= j)
        {
            while (data[i] < p) i++;
            while (data[j] > p) j--;
            if (i <= j)
            {
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
                i++;
                j--;
            }
        }
        if (from < j)
            quickSort(data, from, j);
        if (i < to)
            quickSort(data, i, to);
    }
    public static void heapSort(int[] data)
    {
        DS7_MinHeap<Integer> heap = new DS7_MinHeap<>();
        for(int i = 0; i < data.length; i++)
        {
            heap.insert(data[i]);
        }
        for(int i = 0; i < data.length; i++)
        {
            data[i] = heap.remove();
        }
    }
}
