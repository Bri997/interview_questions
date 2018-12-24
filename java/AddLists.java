public class AddLists {

  private static class ListNode {
    private int data;
    private ListNode next;

    public ListNode(int data){
      this.data = data;
      this.next = null;
    }

    public ListNode next(){
      return this.next;
    }

    public void setNext( ListNode next ){
      this.next = next;
    }

    public int getData(){
      return this.data;
    }

    public void setData(int data){
      this.data = data;
    }
  }

  private static ListNode createList( int[] data ){
    ListNode head = new ListNode(data[0]);
    ListNode ptr = head;
    for(int i = 1; i < data.length; i++){
      ptr.setNext( new ListNode(data[i]) );
      ptr = ptr.next;
    }
    return head;
  }

  private static void printList( ListNode ptr ){
    while(ptr != null){
      System.out.print(ptr.getData() + " ");
      ptr = ptr.next();
    }
  }

  private static ListNode add(ListNode l1, ListNode l2){
    ListNode starter = new ListNode(0);
    ListNode current = starter;
    ListNode p = l1;
    ListNode q = l2;
    int carry = 0;

    while(p != null || q != null){
      int a = p != null ? p.getData() : 0;
      int b = q != null ? q.getData() : 0;
      int sum = a + b + carry;
      carry = sum / 10;
      current.next = new ListNode(sum % 10);
      current = current.next();
      if(p != null) p = p.next();
      if(q != null) q = q.next();
    }
    if(carry > 0){
      current.next = new ListNode(carry);
    }
    return starter.next();
  }

  // Solution to Leetcode https://leetcode.com/problems/add-two-numbers/
  public static void main(String[] args){
    int[] a = {9, 9, 9};
    int[] b = {1, 1, 1};
    ListNode l1 = createList(a);
    ListNode l2 = createList(b);
    ListNode sum = add(l1, l2);
    printList(sum); // this example should return 0 1 1 1 when reversed is 1 1 1 0
  }

}
