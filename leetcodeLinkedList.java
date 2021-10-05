import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class leetcodeLinkedList {


    public static void main(String[] args) {
        int[] args1 = {1,2,3,4,5};
        ListNode head = buildListNode(args1);
        ListNode tar = middleNode(head);


    }

    static boolean hasCylce(ListNode head) {
        Set<ListNode> sets = new HashSet<>();
        ListNode curr = head;
        while (curr != null) {
            sets.add(curr);
            ListNode next = curr.next;
            if (sets.contains(next)) {
                return true;
            }
            curr = next;
        }
        return  false;
    }

    // 快慢双指针
    static boolean hasCylce2(ListNode head) {
        ListNode g = head;
        ListNode t = head;
        while (t != null) {
            ListNode tmp = t.next;
            if (tmp != null) {
                tmp = tmp.next;
            } else {
                return false;
            }
            t = tmp;
            tmp = g.next;
            g = tmp;
            if (t == g) {
                return true;
            }
        }
        return false;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    static ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head;
        ListNode back = head;
        while (pre != null) {
            if (pre.val == back.val) {
                pre = pre.next;
                if (pre == null) {
                    back.next = null;
                }
            } else {
                back.next = pre;
                back = pre;
                pre = pre.next;
            }
        }
        return head;
    }

    static boolean isPalindrome(ListNode head) {
        ListNode pre = head.next;
        ListNode back = head;
        while (pre != null) {
            pre = pre.next;
            if (pre != null) {
                pre = pre.next;
            } else {
                break;
            }
            back = back.next;
        }
        ListNode right = reserveList(back);
        ListNode left = head;
        while (left != null) {
            if (left.val == right.val) {
                left = left.next;
                right = right.next;
            } else {
                return false;
            }
        }
        return true;
    }

    static ListNode reserveList(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    static ListNode removeElements(ListNode head, int val) {
        while (head.val == val) {
            head = head.next;
        }
        ListNode pre = head;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val == val) {
                curr = curr.next;
                pre.next = curr;
            } else {
                pre = curr;
                curr = curr.next;

            }
        }
        return head;
    }

    static ListNode middleNode(ListNode head) {
        ListNode pre = head;
        ListNode back = head;
        while (pre != null) {
            pre = pre.next;
            if (pre != null) {
                pre = pre.next;
            } else {
                break;
            }
            back = back.next;
        }
        return back;
    }

    static ListNode buildListNode(int[] args) {
        ListNode head = new ListNode(args[0]);
        ListNode curr = null;
        ListNode pre = head;
        for (int i = 1; i < args.length; i++) {
            curr = new ListNode(args[i]);
            pre.next = curr;
            pre = curr;
        }
        return head;
    }

    static ListNode reverseBetween(ListNode head, int left, int right) {
        return  null;

    }
}
