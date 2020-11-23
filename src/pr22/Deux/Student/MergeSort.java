package pr22.Deux.Student;

import java.util.Comparator;

public class MergeSort<T> implements SortConsumer<T> {

    @Override
    public void accept(T[] arr, Comparator<T> comparator) {
        mergeSort(arr, comparator, 0,arr.length - 1);
    }

    private void mergeSort(T[] arr, Comparator<T> comparator, int low, int high) {
        if (high <= low) return;

        int mid = (low+high) / 2;
        mergeSort(arr, comparator, low, mid);
        mergeSort(arr, comparator, mid+1, high);

        merge(arr, comparator, low, mid, high);
    }


    @SuppressWarnings("unchecked")
    public void merge(T[] arr, Comparator<T> comparator, int low, int mid, int high) {
        T[] leftArray = (T[]) new Object[mid - low + 1];
        T[] rightArray = (T[]) new Object[high - mid];

        for (int i = 0; i < leftArray.length; i++)
            leftArray[i] = arr[low + i];

        for (int i = 0; i < rightArray.length; i++)
            rightArray[i] = arr[mid + i + 1];

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = low; i < high + 1; i++) {
            if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (comparator.compare(leftArray[leftIndex], rightArray[rightIndex]) < 0) {
                    arr[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    arr[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex < leftArray.length) {
                arr[i] = leftArray[leftIndex];
                leftIndex++;
            } else if (rightIndex < rightArray.length) {
                arr[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }

}