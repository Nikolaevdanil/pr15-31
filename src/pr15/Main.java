package pr15;


public class Main {
    public static void main(String[] args) {
        IntegerCollection obj = new IntegerCollection();

        for(int i = 1; i <= 10; i++)
            obj.push(i);
        obj.print();
        obj.delete(5);
        obj.print();
        obj.search(4);
        obj.searchForIndex(8);
        obj.searchForIndex(9);
        obj.maxElem();
        obj.minElem();
        obj.average();
    }
}