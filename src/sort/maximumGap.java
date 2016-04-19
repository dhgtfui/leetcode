package sort;
//Given an unsorted array, find the maximum difference 
//between the successive elements in its sorted form.
//input
public class maximumGap {
	public static void main(String[] args){
		int[] list={3, 30, 34, 5, 9};
		printList(list);
		System.out.println(maximumGap(list));
	}
	public static void printList(int[] list){
		for(int i=0;i<list.length;i++){
			System.out.printf("%-4s",list[i]);
		}
	}
	public static int maximumGap(int[] num) {
		if (num == null || num.length < 2) {
            return 0;
        }

        // find out max and min values of input
        int minVal = num[0];
        int maxVal = num[0];
        for (int n: num) {
            minVal = Math.min(minVal, n);
            maxVal = Math.max(maxVal, n);
        }
        // bSize is size of bucket (should be larger by 1)
        int bSize = (maxVal - minVal + 1) / num.length + 1;

        // calcualte number of buckets needed
        int bCount = (maxVal - minVal) / bSize + 1;
        Bucket[] buckets = new Bucket[bCount];

        // match every value into a bucket
        // bucket maintains the max/min within the bucket
        for (int n: num) {
            int bIndex = (n - minVal) / bSize;
            if (buckets[bIndex] == null) {
                buckets[bIndex] = new Bucket(n, n);
            } else {
                buckets[bIndex].updateVal(n);
            }
        }

        // for every bucket, check in sequence and get max gap
        int gap = 0;
        int pre = 0;
        int cur = 1;
        while (cur < bCount) {
            // skip all empty buckets
            while (cur < bCount && buckets[cur] == null) {
                cur++;
            }
            if (cur == bCount) break;
            // update gap, pre and cur
            gap = Math.max(gap, buckets[cur].min - buckets[pre].max);
            pre = cur;
            cur++;
        }

        return gap;
    }
}
class Bucket {
    int min;
    int max;

    public Bucket(int a, int b) {
        min = a;
        max = b;
    }

    public void updateVal(int val) {
        min = Math.min(min, val);
        max = Math.max(max, val);
    }
}
