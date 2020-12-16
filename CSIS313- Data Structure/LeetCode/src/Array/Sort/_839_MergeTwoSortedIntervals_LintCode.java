package Array.Sort;

import java.util.ArrayList;
import java.util.List;

public class _839_MergeTwoSortedIntervals_LintCode {

    // Time: O(m + n)

    class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }


        public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
            List<Interval> results = new ArrayList<>();
            Interval last = null, curr = null;
            if (list1 == null && list2 == null) {
                return results;
            }

            int i = 0, j = 0;

            while (i < list1.size() && j < list2.size()) {
                if (list1.get(i).start < list2.get(j).start) {
                    curr = list1.get(i);
                    i++;
                } else {
                    curr = list2.get(j);
                    j++;
                }
                last = merge(results, last, curr);
            }
            while (i < list1.size()) {
                last = merge(results, last, list1.get(i));
                i++;
            }
            while (j < list2.size()) {
                last = merge(results, last, list2.get(j));
                j++;
            }
            if (last != null) {
                results.add(last);
            }
            return results;
        }

        private Interval merge(List<Interval> results, Interval last, Interval curr) {
            if (last == null) {
                return curr;
            }
            if (last.end < curr.start) {
                results.add(last);
                return curr;
            }
            last.end = Math.max(last.end, curr.end);
            return last;
        }
    }
}
