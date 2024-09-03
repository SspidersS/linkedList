public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();

        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Date");

        System.out.println("Size of list: " + list.size());

        System.out.println("Element at index 2: " + list.get(2));

        String removedElement = list.remove(1);
        System.out.println("Removed element: " + removedElement);

        System.out.println("Size of list after removal: " + list.size());

        for (int i = 0; i < list.size(); i++) {
            System.out.println("Element at index " + i + ": " + list.get(i));
        }

        list.clear();
        System.out.println("Size of list after clearing: " + list.size());
    }
}
