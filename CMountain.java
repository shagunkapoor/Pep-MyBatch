package DSA_Udemy.Arrays;

//Returns the length of highest mountain /\
//Mountain = adjascent integers that are strictly increasing until they reach a peak, at which they become strictly decreasing
//Atleast 3 no. are required to form a mountain
public class CMountain {
    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 2, 3, 4, 5, 4, 3, 2, 0, 1, 2, 3, -2, 4};

        //O(n)
        int mountainLength = getMountainLength(arr);
        System.out.println(mountainLength);

        //O(n)
        int len = getMountainLengthViaPeaks(arr);
        System.out.println(len);
    }

    private static int getMountainLength(int[] arr) {
        if (arr.length < 3) {
            return 0;
        }

        boolean isGoingUpwards = arr[0] < arr[1];

        int currLen = 1;
        int overallLen = currLen;

        for (int i = 1; i < arr.length - 1; i++) {
            currLen++;
            if (isGoingUpwards) {
                if (arr[i + 1] < arr[i]) {
                    isGoingUpwards = false;
                }
            } else {
                if (arr[i + 1] > arr[i]) {//   \/  valley area
                    if (overallLen < currLen) {
                        overallLen = currLen;
                    }

                    isGoingUpwards = true;
                    currLen = 1;
                }
            }
        }

        return overallLen;
    }

    private static int getMountainLengthViaPeaks(int[] arr) {

        int maxLen = 0;
        //Identify Peaks
        for (int i = 1; i < arr.length - 1; ) {
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) { //Peak point /\
                int count = 1;
                int peak;
                //Count backwards
                for (peak = i; peak > 0 && arr[peak - 1] < arr[peak]; peak--, count++) ;
                //count = i - peak + 1;

                //Count forward
                for (; i < arr.length - 1 && arr[i + 1] < arr[i]; i++, count++) ;

                if (maxLen < count) {
                    maxLen = count;
                }
            } else {
                i++;
            }
        }

        return maxLen;
    }
}
