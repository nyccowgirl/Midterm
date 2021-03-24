package Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice {

    public static void main(String[] args) {
        // Question 1:

        LinkedBag nameBag = new LinkedBag();
        System.out.println(nameBag.isEmpty());                      // true
        nameBag.add("adam");
        nameBag.add("brian");
        nameBag.add("carl");
        nameBag.add("adam");
        nameBag.add("fred");
        nameBag.add("carl");
        nameBag.add("harry");
        nameBag.add("hank");
        System.out.println(nameBag.remove("adam"));         // true
        System.out.println(nameBag.getCurrentSize());               // 7
        System.out.println(nameBag.remove("adam"));         // true
        System.out.println(nameBag.remove("adam"));         // false
        System.out.println(nameBag.remove("ivan"));         // false
        System.out.println(nameBag.getCurrentSize());               // 6
        System.out.println(nameBag.getFrequencyOf("carl")); // 2
        System.out.println(nameBag.contains("ivan"));               // false
        System.out.println(nameBag.getFrequencyOf("ivan")); // 0
        nameBag.clear();
        System.out.println(nameBag.getCurrentSize());               // 0

        // Question 2:

        LList nameList = new LList();
        System.out.println(nameList.isEmpty());                     // true
        nameList.add("adam");
        nameList.add("brian");
        nameList.add("carl");
        nameList.add("edgar");
        nameList.add(3, "hank");
        nameList.add("lenny");
        nameList.add(1, "mark");
        System.out.println(nameList.getLength());                   // 7
        System.out.println(nameList.getEntry(3));       // brian
        System.out.println(nameList.remove(2));         // adam
        System.out.println(nameList.getEntry(2));       // brian
        System.out.println(nameList.remove(1));         // mark
        System.out.println(nameList.remove(2));         // hank
        System.out.println(nameList.getLength());                   // 4
        System.out.println(nameList.replace(2, "peter"));   // carl
        System.out.println(nameList.getEntry(2));       // peter
        System.out.println(nameList.getEntry(1));       // brian
        System.out.println(nameList.getLength());                   // 4

        // Question 3:

        List<String> nameList1 = new ArrayList<>();
        System.out.println(nameList1.isEmpty());                    // true
        nameList1.add("adam");
        nameList1.add("brian");
        nameList1.add("carl");
        nameList1.add("edgar");
        nameList1.add(3, "hank");
        nameList1.add("lenny");
        nameList1.add(1, "mark");
        System.out.println(nameList1.size());                       // 7
        System.out.println(nameList1.get(3));                       // carl
        System.out.println(nameList1.remove(2));              // brian
        System.out.println(nameList1.get(2));                       // carl
        System.out.println(nameList1.remove(1));              // mark
        System.out.println(nameList1.remove(2));              // hank
        System.out.println(nameList1.size());                       // 4
        System.out.println(nameList1.set(2, "peter"));              // edgar
        System.out.println(nameList1.get(2));                       // peter
        System.out.println(nameList1.get(1));                       // carl

        // Question 4:

        // 1. As a client, you can access the public methods. With an interface, you would only need to understand
        // what is being implemented without knowing the code behind the methods.

        ListInterface list1 = new AList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        ListInterface list2 = new AList();
        list2.add(4);
        list2.add(6);
        list2.add(8);
        list2.add(10);

//        Practice.ListInterface list3 = Practice.Midterm_ExamplePracticeAnswers.mergeListInterface(list1, list2);

//        System.out.println(Arrays.toString(list3.toArray()));       // [1, 4, 2, 6, 3, 8, 10]

        System.out.println(Arrays.toString(Midterm_ExamplePracticeAnswers.mergeListInterface(list1, list2).toArray()));

        BagInterface bag1 = new LinkedBag();
        bag1.add(1);
        bag1.add(2);
        bag1.add(3);
        BagInterface bag2 = new LinkedBag();
        bag2.add(4);
        bag2.add(6);
        bag2.add(8);
        bag2.add(10);

        System.out.println(Arrays.toString(Midterm_ExamplePracticeAnswers.mergeBagInterfaces(bag1, bag2).toArray()));
        // [4, 6, 8, 10, 1, 2, 3]

        ListInterface list4 = new LList();
        list4.add("apple");
        list4.add("bee");
        list4.add("cherry");
        list4.add("bee");

        System.out.println(Midterm_ExamplePracticeAnswers.containsDuplicates(list4));       // true

        System.out.println(Midterm_ExamplePracticeAnswers.getSize(bag2));                   // 4

        // Question 5:

        System.out.println(((LList<?>) list4).getFrequencyOf("bee"));               // 2
        System.out.println(((LinkedBag<?>) bag2).getSize());                                // 4

        // Question 6:

        /*
         list: 4 -> 6 -> 10 -> 12

        Practice.Node nodeA = list.firstNode.next.next;
        Practice.Node nodeB = list.firstNode.next;
        Practice.Node nodeC = list.firstNode.next.next.next;
        Practice.Node nodeD = nodeC.next;

        System.out.println(nodeA.data);                     // 10
        System.out.println(nodeB.data);                     // 6
        System.out.println(nodeC.data);                     // 12
        System.out.println(nodeD.data);                     // exception thrown
        System.out.println(mystery(list.firstNode, 9));     // false
        System.out.println(mystery(list.firstNode, 10));    // 6; true

        public boolean mystery(Practice.Node firstNode, int target) {
            Practice.Node currentNode = firstNode;
            if(currentNode.next==null) {
                return false;
            } else {
                Practice.Node tmpNode = currentNode;
                currentNode = currentNode.next;
                while(currentNode!=null) {
                    if(currentNode.data==target) {
                        System.out.println(tmpNode.data);
                        return true;
                    } else {
                        tmpNode = currentNode;
                        currentNode = currentNode.next;
                    }
                }
                return false;
            }
        }

        => mystery method looks for target value and prints value before that and returns true; otherwise, false
        => crash on empty list and skips looking at firstNode
         */

        // Question 7:

        /*
        Practice.Node firstNode = new Practice.Node(3);
        firstNode.next = new Practice.Node(4);
        firstNode.next.next = new Practice.Node(6);
        firstNode.next.next.next new Practice.Node(8);
        Practice.Node currentNode = firstNode;

        print currentNode.data                              // 3
        print the chain headed by firstNode                 // 3 -> 4 -> 6 -> 8

        currentNode = currentNode.next
        print currentNode.data                              // 4
        print the chain headed by firstNode                 // 3 -> 4 -> 6 -> 8

        currentNode.data = 7
        print currentNode.data                              // 7
        print the chain headed by firstNode                 // 3 -> 7 -> 6 -> 8

        currentNode.next = currentNode.next.next;
        print currentNode.data                              // 7
        print the chain headed by firstNode                 // 3 -> 7 -> 8

        firstNode = firstNode.next;
        print currentNode.data                              // 7
        print the chain headed by firstNode                 // 7 -> 8
         */

        // Question 8:
        /*
        Practice.ArrayBag: add/remove from end
        Practice.LinkedBag: add/remove from beginning
        Practice.AList: add/remove from end
        Practice.LList: add/remove from end

        Practice.ArrayBag: O(n)
        Practice.LinkedBag: O(1)

        Practice.AList: O(n) to add or remove from front; O(1) to add or remove from end
        Practice.LList: O(1) to add or remove from front; O(n) to add or remove from end

        Bags are more efficient with linked since you don't care about order; but with lists, it depends on where you
        are adding/removing from.

        Nodes are easier to expand an array/capacity since you don't have to create a new array in order to expand the
        size.
         */

        // Question 9:

        Node str = new Node("oye",
                new Node("oil",
                        new Node("cool",
                                new Node("on",
                                        new Node("thou",
                                                new Node("homefront"))))));

        System.out.println(Midterm_ExamplePracticeAnswers.allContainChar(str, 'o'));    // true

        Node num1 = new Node(4,
                new Node(2,
                        new Node(2,
                                new Node(3))));

        Node num2 = new Node(3,
                new Node(2,
                        new Node(4,
                                new Node(2))));

        System.out.println(Midterm_ExamplePracticeAnswers.hasNeighborRepeats(num1));                // true
        System.out.println(Midterm_ExamplePracticeAnswers.hasNeighborRepeats(num2));                // false

        int[] array = {4, 6, 8, 10};

        System.out.println(Arrays.toString(Midterm_ExamplePracticeAnswers.merge(num1, array)));
        // [4, 4, 2, 6, 2, 8, 3, 10]

        // Question 10:

        /*
        == is used to compare primitives or check aliases/null, whereas equals is to check for logical equivalents (for
        doubles or floats, use Math.abs(d1 - d2) < 0.0001)

        objects inherits equals from Object class

        <> are used to compare primitives, whereas compareTo is used for objects if Comparable interface is implemented

        negative, 0 or positive
         */

        // Question 11:

        /*
        runtime is the time efficiency, whereas big o is order of growth

        constants or linears are good big o while nested loops are bad big o

        Algo 1:
            statement1;

            if(condition1) {
               statement2;
            } else {
               for(int i=0; i<n; i++) {
                  statement3;
                }
               statement4;
            }

            => O(n)

        Algo 2:
            i=0;
            while(i<n) {
               for(int j=i; j<n; j++) {
                  statement1;
                }
               statement2;
               i++;
            }

            => O(n^2)

        Algo 3:
           for(int i=0; i<n; i++) {
               for(int j=0; j<n; j++) {
                  if(condition1) {
                     for(int k=0; k<10; k++) {
                          statement1;
                       }
                  } else {
                     statement2;
                  }
               }
            }

            => O(n^2)

        Algo 4:
            for(int i=0; i<=n; i++) {
               for(int j=0; j<=n; j++) {
                  if(j%2==0) {
                     statement1
                  }
               }
            }

            => O(n^2)

        Algo 5:
            for(int i=0; i<n; i++)
                add i to the beginning of an array-based list

            => O(n^2)

        Algo 6:
            for(int i=0; i<n; i++)
                add i to the end of an array-based list

            => O(n)

        Algo 7:
            for(int i=0; i<n; i++)
                add i to the beginning of a linked list with only a head pointer

            => O(n)

        Algo 8:
            for(int i=0; i<n; i++)
                add i to the end of a linked list with only a head pointer

            => O(n^2)
         */

    }

}
