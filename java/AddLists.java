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

  private static ListNode add(ListNode l1, ListNode l2){
    boolean carry = false;
    ListNode head1 = l1;
    ListNode head2 = l2;
    while(l1 != null && l2 != null){
      int s = carry ? l1.getData() + l2.getData() + 1 : l1.getData() + l2.getData();
      if( s >= 10 ){
        s = s % 10;
        carry = true;
      }
      else{
        carry = false;
      }
      l1.setData(s);
      l2.setData(s);
      l1 = l1.next();
      l2 = l2.next();
    }
    if( l1 != null ){
      while(l1 != null){
        int s = carry ? l1.getData() + 1 : l1.getData();
        if( s >= 10 ){
          s = s % 10;
          carry = true;
        }
        else{
          carry = false;
        }
        l1.setData(s);
        if(l1.next == null && carry){
          l1.next = new ListNode(1);
          carry = false;
        }
        l1 = l1.next();
      }
      return head1;
    }
    else{
      while(l2 != null){
        int s = carry ? l2.getData() + 1 : l2.getData();
        if( s >= 10 ){
          s = s % 10;
          carry = true;
        }
        else{
          carry = false;
        }
        l2.setData(s);
        if(l1.next == null && carry){
          l1.next = new ListNode(1);
          carry = false;
        }
        l2 = l2.next();
      }
      return head2;
    }
  }
  public static void main(String[] args){
    int[] a = {9, 9, 9};
    int[] b = {1};
    ListNode l1 = createList(a);
    ListNode l2 = createList(b);
    ListNode sum = add(l1, l2);
    while(sum != null){
      System.out.println(sum.getData());
      sum=sum.next();
    }
  }

}
