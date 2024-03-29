import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class leetcodeLinkedList {

    public static void main(String[] args) {
        int[] args1 = {2, 1, 6, 3, 7, 5, 4};
        ListNode head = buildListNode(args1);
        // reverseBetween(head,5,5);
        //emoveNthFromEnd(head, 2);
        sortList(head);

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
        return false;
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

    /**
     * 区间反转链表 1 - 2 - 3 - 4 - 5 => 1 - 4 - 3 - 2 - 5
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    static ListNode reverseBetween(ListNode head, int left, int right) {
        // find left -1 node
        // find right + 1 node
        // reverse left node
        // joint nodes
        int count = 0;
        ListNode slow = null;
        ListNode fast = null;
        ListNode leftNode = head;
        ListNode rightNode = head;

        while (count != left - 1) {
            count++;
            slow = leftNode;
            leftNode = leftNode.next;
        }
        rightNode = leftNode;
        while (count != right - 1) {
            count++;
            rightNode = rightNode.next;
        }
        if (rightNode != null) {
            fast = rightNode.next;
        } else {
            fast = null;
        }
        rightNode.next = null;
        ListNode newLeft = reserveList(leftNode);
        if (slow != null) {
            slow.next = newLeft;
        } else {
            head = newLeft;
        }
        if (leftNode != null) {
            leftNode.next = fast;
        }

        return head;
    }

    /**
     * reorder 0 1 2 3 4 => 0 4 1 3 2
     *
     * @param head
     */
    static void reorderList(ListNode head) {
        // set2 = set1.stream().map(Object::toString).collect(Collectors.toSet());
        // find mid node and mid pre node
        // reverse mid - end,
        // merge head - midpre and mid - end
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
        ListNode mid = back.next;
        back.next = null;
        ListNode rightS = reserveList(mid);

        ListNode curr = head;
        while (rightS != null) {
            ListNode tmp = curr.next;
            ListNode tmp2 = rightS.next;
            curr.next = rightS;
            rightS = tmp2;
            curr = tmp;

        }

    }

    /**
     * 1 2 3 4 5 5 6 => 1 2 3 4 6
     *
     * @param head
     * @return
     */
    static ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode preNode = new ListNode(101, head);
        boolean flag = false;
        ListNode left = preNode;
        ListNode mid = head;
        ListNode right = head.next;
        while (right != null) {
            if (mid.val == right.val) {
                right = right.next;
                if (right == null) {
                    left.next = null;
                }
                flag = true;
            } else {
                if (flag) {
                    left.next = right;
                    mid = right;
                    right = right.next;
                    flag = false;
                } else {
                    right = right.next;
                    mid = mid.next;
                    left = left.next;
                }
            }
        }
        return preNode.next;
    }

    static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dum = new ListNode(101, head);

        int count = 1;
        ListNode left = dum;
        ListNode right = head;
        while (right.next != null) {
            right = right.next;
            if (count >= n) {
                left = left.next;
            }
            count++;

        }
        left.next = left.next.next;
        return dum.next;
    }

    /**
     * sort the linkedList by asc
     *
     * 1. 遍历操作实现 部分有序    2. 合并有序链表
     */

    static ListNode sortList(ListNode head) {

        if (head == null) {
            return head;
        }
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        ListNode dummyHead = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummyHead, curr = dummyHead.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merged = merge(head1, head2);
                prev.next = merged;
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummyHead.next;
    }

    static ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }
    }
}
