import java.util.LinkedList;
import java.util.Scanner;

record Destination(String name, int distanceFromSydney) {}

public class Main {
  public static void main(String[] args) {
    LinkedList<Destination> towns = new LinkedList<>();
    towns.add(new Destination("Sydney", 0));
    towns.add(new Destination("Adelaide", 1374));
    towns.add(new Destination("Alice Springs", 2771));
    towns.add(new Destination("Brisbane", 917));
    towns.add(new Destination("Darwin", 3972));
    towns.add(new Destination("Melbourne", 877));
    towns.add(new Destination("Perth", 3923));

    getUserInput(towns);
  }

  public static void getUserInput(LinkedList<Destination> list) {
    Scanner sc = new Scanner(System.in);
    boolean running = true;

    while (running) {
      System.out.println("""
          Available actions (select word or letter):
          (F)orward
          (B)ackword
          (L)ist Places
          (M)enu
          (Q)uit
          """
      );
      String choice = sc.nextLine().toLowerCase();

      if (choice.contains("f") || choice.contains("forward")) {
        System.out.println("Moving forward");
      } else if (choice.contains("b") || choice.contains("backward")) {
        System.out.println("Moving backward");
      } else if (choice.contains("l") || choice.contains("list places")) {
        listTowns(list);
      } else if (choice.contains("m") || choice.contains("menu")) {
        System.out.println("Listing menu");
      } else {
        running = false;
      }
    }
  }

  public static void listTowns(LinkedList<Destination> list) {
    System.out.println("Travel Itinerary");

    for (int i = 0; i < list.size(); i++) {
      for (int j = 1; j < list.size(); j++) {
        if (i < j) {
          if (list.get(i).distanceFromSydney() < list.get(j).distanceFromSydney()) {
            var temp = list.get(i);
            var one = list.get(i);
            var two = list.get(j);
            one = two;
            two = temp;
          }
        }
      }
      System.out.printf("Sydney to %s -> %dkm\n", list.get(i).name(), list.get(i).distanceFromSydney());
    }

    System.out.println();
  }

}
