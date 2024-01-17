import java.util.LinkedList;
import java.util.Scanner;

record Destination(String name, int distanceFromSydney) {}

public class Main {
  public static void main(String[] args) {
    LinkedList<Destination> towns = new LinkedList<>();

    addTown(towns, new Destination("Sydney", 0));
    addTown(towns, new Destination("Adelaide", 1374));
    addTown(towns, new Destination("Alice Springs", 2771));
    addTown(towns, new Destination("Brisbane", 917));
    addTown(towns, new Destination("Darwin", 3972));
    addTown(towns, new Destination("Melbourne", 877));
    addTown(towns, new Destination("Perth", 3923));

    getUserInput(towns);
  }

  public static void getUserInput(LinkedList<Destination> list) {
    Scanner sc = new Scanner(System.in);
    boolean running = true;
    int count = 0;

    sortList(list);

    while (running) {
      System.out.print("Choose action (type m or Menu to display options): ");
      String choice = sc.nextLine().toLowerCase();

      if (choice.contains("f") || choice.contains("forward")) {
        if (count < (list.size() - 1)) {
          var iterator = list.listIterator(count);
          iterator.next();
          count++;
          System.out.printf("%s (%dkm)\n",list.get(count).name(), list.get(count).distanceFromSydney());
        } else {
          System.out.println("You have reached the end of itinerary");
        }
      } else if (choice.contains("b") || choice.contains("backward")) {
        if (count > 0) {
          var iterator = list.listIterator(count);
          iterator.previous();
          count--;
          System.out.printf("%s (%dkm)\n",list.get(count).name(), list.get(count).distanceFromSydney());
        } else {
          System.out.println("You are already at the starting point Sydney");
        }
      } else if (choice.contains("l") || choice.contains("list places")) {
        listTowns(list);
      } else if (choice.contains("m") || choice.contains("menu")) {
        printMenu();
      } else {
        running = false;
      }
    }
  }

  public static void listTowns(LinkedList<Destination> list) {
    System.out.println("Travel Itinerary");

    for (int i = 0; i < list.size(); i++ ) {
      if (i == list.size() - 1) {
        System.out.printf("%s (%dkm)",list.get(i).name(), list.get(i).distanceFromSydney());
      } else {
        System.out.printf("%s (%dkm) -> ", list.get(i).name(), list.get(i).distanceFromSydney());
      }
    }

    System.out.println();
  }

  public static void sortList(LinkedList<Destination> list) {
    list.sort((t1, t2) -> t1.distanceFromSydney() - t2.distanceFromSydney());
  }

  public static void printMenu() {
    System.out.println("""
          Available actions (select word or letter):
          (F)orward
          (B)ackword
          (L)ist Places
          (M)enu
          (Q)uit
          """
    );
  }

  public static void addTown(LinkedList<Destination> list, Destination town) {
    if (!list.contains(town)) {
      list.add(town);
    }
  }
}
