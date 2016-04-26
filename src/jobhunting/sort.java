package jobhunting;

/**
 * Created by wyq on 4/25/16.
 */
public class sort {
    void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    void quickSort(int[] a, int start, int end) {
        if (start < end) {
            int pivot = partition(a, start, end);
            quickSort(a, start, pivot);
            quickSort(a, pivot + 1, end);
        }
    }

    int partition(int[] a, int start, int end) {
        int location = start;
        int pivot = a[location];
        int index = start;
        for (int i = start; i < end; ++i) {
            if (a[i] < pivot) {
                swap(a, i, ++ index);
            }
        }

        a[location] = a[index];
        a[index] = pivot;
        return index;
    }

    void bubbleSort(int[] a, int start, int end) {
        for (int i = start; i < end; ++i) {
           for (int j = start; j < end - 1 - start; ++j) {
               if (a[j] > a[j + 1]) {
                   swap(a, j, j + 1);
               }
           }
        }
    }

    void selectSort(int[] a, int start, int end) {
        for (int i = start; i < end; ++i) {
            int min = a[i];
            int minIndex = i;
            for (int j = i + 1; j < end; ++j) {
                if (a[j] < min) {
                    min = a[j];
                    minIndex = j;
                }
            }
            a[minIndex] = a[i];
            a[i] = min;
        }
    }

    void insertSort(int[] a, int start, int end) {
        for (int i = start + 1; i < end; ++i) {
            int j = i;
            while (j > start && a[j] < a[j - 1]) {
                swap(a, j, j - 1);
                j --;
            }
        }
    }

    void mergeSort(int[] a, int start, int end) {
        if (start < end - 1) {
            int mid = (start + end) / 2;
            mergeSort(a, start, mid);
            mergeSort(a, mid, end);
            merge(a, start, mid, end);
        }
    }

    void merge(int[] a, int start, int mid, int end) {
        int i = start, j = mid, k = start;
        int[] num = new int[end];
        while (i < mid && j < end) {
            if (a[i] < a[j]) {
                num[k ++] = a[i ++];
            } else {
                num[k ++] = a[j ++];
            }
        }

        while (i < mid)
            num[k ++] = a[i ++];

        while (j < end)
            num[k ++] = a[j ++];
        i = start;
        while (i < k) {
            a[i] = num[i];
            i ++;
        }
    }

    void max_heapify(int[] a, int i, int n) {
        int temp = a[i];
        int j = 2 * i;
        while (j <= n) {
            if (j < n && a[j] < a[j + 1])
                j ++;
            if (temp > a[j])
                break;
            a[j / 2] = a[j];
            j *= 2;
        }
        a[j / 2] = temp;
    }

    void heapSort(int[] a, int n) {
        for (int i = n; i > 1; --i) {
            //move largest to the tail
            swap(a, i, 1);
            max_heapify(a, 1, i - 1);
        }
    }

    void buildHeap(int[] a, int n) {
        for (int i = n / 2; i > 0; --i)
            max_heapify(a, i, n);
    }
    public static void main(String[] args) {
        int[] a = new int[]{9,8,7,6,5,4,3,2,1,0};
//        new sort().quickSort(a, 0, 10);
//        new sort().bubbleSort(a, 0, 10);
//        new sort().selectSort(a, 0, 10);
//        new sort().insertSort(a, 0, 10);
//        new sort().mergeSort(a, 0, 10);
        sort s = new sort();
        s.buildHeap(a, 9);
        s.heapSort(a, 9);
        for (int n : a)
            System.out.println(n);
    }
}
