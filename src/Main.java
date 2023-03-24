import java.util.List;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        boolean result = list.isEmpty();
        list.add("fdf");
        list.add("1dfdf");
        list.add("2dfdfsd");
        list.add("3fdfsdf");
        list.remove("fdf");
        boolean res2 = list.contains("fdf");
        boolean res3 = list.containsAll(List.of(new String[]{"123", "123", "123"}));
        boolean res4 = list.containsAll(List.of(new String[]{"1dfdf", "2dfdfsd"}));
        //list.indexOf(2);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        list.add(2, "1234");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}