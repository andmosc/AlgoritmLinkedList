package arrLinkedList;

public class Main {
    public static void main(String[] args) {
        ArrLinkedList<Integer> list = new ArrLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(33);

        list.set(0,11);
        System.out.println(list.get(0));

    }

}
