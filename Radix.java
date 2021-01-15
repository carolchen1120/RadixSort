import java.lang.Math;

public class Radix{
  // return the number of digits in n.
  // length(0) -> 1
  // length(15) -> 2
  // length(-10) -> 2
  // length(5112) -> 4
  public static int length(int n) {
    int newNum = 0;
    int answer = 0;
    if (n < 0) {
      newNum = -1 * n;
    } else {
      newNum = n;
    }
    double base = Math.log10(newNum);
    base = Math.floor(base);
    answer = (int) base;
    return answer + 1;
  }

  // get nth digit of an int, where 0 is the ones column, 1 is the tens column etc.
  // nth(123,1) -> 2
  // nth(-123,1) -> 2
  // nth(123,2) -> 1
  // nth(-123,2) -> 1
  public static int nth(int n, int col) {
    String number = "";
    int newNum = 0;
    String answer = "";
    int base = 0;
    if (n < 0) {
      newNum = -1 * n;
    } else {
      newNum = n;
    }
    base = length(newNum);
    number = String.valueOf(newNum);
    answer = number.substring(base-col, base-col+1);
    return Integer.parseInt(answer);
  }


  // Merge all of the linked lists in the bucket array into your original linked list. The original may have elements, and those should be kept.
  // This is O(buckets.length) which should be 10 when we use this later.
  // The bucket[0] list will be merged first, then the bucket[1] etc.
  public static void merge(SortableLinkedList original, SortableLinkedList[]buckets) {
    for (int i = 0; i < buckets.length; i++) {
      original.extend(buckets[i]);
    }
  }


  // Write a method that sorts non-negative integer values: [This part is the most important part, and I expect every student can complete it!]
  public static void radixSortSimple(SortableLinkedList data) {
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    int max = 0;
    String dataList = "";
    for (int i = 0; i < 10; i++) {
      buckets[i] = new SortableLinkedList();
    }

    for (int x = 0; x < data.size(); x++) {
      if (data.get(x) > max) {
        max = data.get(x);
      }
    }


    for (int j = 0; j < data.size(); j++) {
      for (int k = 0; k < length(max); k++) {
        buckets[nth(data.get(k), j)].add(data.get(k));
      }


    }

  }


  public static void radixSort(SortableLinkedList data) {

  }

  // public static void main(String[] args) {
  //   System.out.println(nth(123, 2));
  //   System.out.println(nth(-123, 2));
  //   System.out.println(nth(12345, 1));
  //   System.out.println(nth(-12347, 1));
  // }
}
