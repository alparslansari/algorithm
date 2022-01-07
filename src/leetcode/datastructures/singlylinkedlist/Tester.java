package leetcode.datastructures.singlylinkedlist;

public class Tester {
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.addLast("Alparslan");
        list.addLast("Esra");
        list.addFirst("Melissa");
        list.addFirst("Annem");

        SinglyLinkedList<Integer> listInt = new SinglyLinkedList<>(1);
        listInt.addFirst(2);
        listInt.addFirst(1);
        listInt.addFirst(3);
        listInt.addFirst(4);

    }
}
