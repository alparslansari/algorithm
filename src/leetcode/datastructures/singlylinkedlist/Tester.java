package leetcode.datastructures.singlylinkedlist;

public class Tester {
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        System.out.println(list.getLast());
        list.addLast("Alparslan");
        list.addLast("Esra");
        list.addFirst("Melissa");
        list.addFirst("Annem");
        System.out.println(list.get(1));
        System.out.println(list.get(5));


        SinglyLinkedList<Integer> listInt = new SinglyLinkedList<>(1);
        listInt.addFirst(2);
        listInt.addFirst(1);
        listInt.addFirst(3);
        listInt.addFirst(4);
        listInt.removeFirst();
        listInt.removeFirst();
        listInt.removeFirst();
        listInt.removeFirst();
        listInt.removeFirst();
        listInt.removeFirst();
        listInt.removeFirst();

    }
}
