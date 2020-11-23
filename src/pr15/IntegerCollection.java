package pr15;


public class IntegerCollection {

    static class list {
        public int data;
        list next = null;
        list head = null;
        list prev = null;

        list() {}
        list(int data, list head, list prev) {
            this.data = data;
            this.head = head;
            this.prev = prev;
        }
    }

    list current;

    public IntegerCollection() {
        current = new list();
    }

    public void push(int data) {
        if (current.head == null) {
            current.data = data;
            current.head = current;
        } else {
            current = current.head;
            while(current.next != null)
                current = current.next;
            current.next = new list(data, current.head, current);
        }
        System.out.printf("Element %d successfully add to collection\n", data);
    }

    public void delete(int data) {
        current = current.head;
        while (true){
            if(current.data == data){
                current = current.prev;
                current.next = current.next.next;
                current = current.next;
                current.prev = current.prev.prev;
                System.out.printf("Element %d successfully delete from collection\n", data);
                break;
            }
            if(current.next == null) {
                System.out.printf("Element %d is not contained in the collection\n", data);
                break;
            }
            current = current.next;
        }
    }

    public  void search(int data) {
        int i = -1;
        current = current.head;
        while (true){
            i++;
            if(current.data == data){
                System.out.printf("Index of element %d is %d\n", data, i);
                break;
            }
            if(current.next == null) {
                System.out.printf("Element %d is not contained in the collection\n", data);
                break;
            }
            current = current.next;
        }
    }

    public void searchForIndex(int index) {
        current = current.head;
        for(int i = 0; i < index; i++){
            if(current.next == null) {
                System.out.printf("Under index %d is not element\n", index);
                return;
            }
            current = current.next;
        }
        System.out.printf("Under index %d is the element %d\n", index, current.data);
    }

    public int maxElem() {
        current = current.head;
        if(current == null) {
            System.out.println("Collection is empty\n");
            return 0;
        }
        else {
            int max = 0;
            while (true){
                max = Math.max(current.data, max);
                if(current.next == null)
                    break;
                current= current.next;
            }
            System.out.printf("Maximum element in collection is %d\n", max);
            return max;
        }
    }

    public int minElem() {
        current = current.head;
        if(current == null) {
            System.out.println("Collection is empty\n");
            return 0;
        }
        else {
            int min = maxElem();
            current = current.head;
            while (true){
                min = Math.min(current.data, min);
                if(current.next == null)
                    break;
                current= current.next;
            }
            System.out.printf("Minimum element in collection is %d\n", min);
            return min;
        }
    }

    public float average() {
        current = current.head;
        if(current == null) {
            System.out.println("Collection is empty\n");
            return 0;
        }
        else {
            float average = 0;
            int sum = 0;
            int size = 0;
            while (true){
                size++;
                sum += current.data;
                if(current.next == null)
                    break;
                current = current.next;
            }
            average = (float)sum / (float)size;
            System.out.printf("Average of all elements of collections %.2f\n", average);
            return average;
        }
    }

    public void print() {
        int i = 1;
        current = current.head;
        System.out.print("[");
        while (true){
            if (current.next == null) {
                System.out.print(current.data);
                break;
            }
            else
                System.out.print(current.data + ", ");
            current = current.next;
            i++;
        }
        System.out.print("]\n");
    }
}
