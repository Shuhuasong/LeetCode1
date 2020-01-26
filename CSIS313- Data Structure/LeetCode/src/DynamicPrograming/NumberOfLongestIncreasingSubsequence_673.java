package DynamicPrograming;

public class NumberOfLongestIncreasingSubsequence_673 {
}


/*
C++
class Solution {
public:

    //run time: 44ms (46%)
    //Time Complexity: O(n), Space Complexity: O(n)
    int findNumberOfLIS(vector<int>& nums) {

        int n = nums.size();
        auto len = vector<int>(n, 1);
        auto times = vector<int>(n, 1);

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<i; j++)
            {
                if(nums[j]>=nums[i]) continue;

                if(len[j]+1>len[i])
                {
                    len[i] = len[j]+1;
                    times[i] = times[j];
                }
                else if(len[j]+1==len[i])
                {
                    times[i] += times[j];
                }
            }
        }
        int maxLen = 0;
        int result = 0;
        for(int i=0; i<n; i++)
        {
            if(len[i] > maxLen)
            {
                maxLen = len[i];
                result = times[i];
            }
            else if(len[i]==maxLen)
            {
                result += times[i];
            }
        }
        return result;
    }
};

 */