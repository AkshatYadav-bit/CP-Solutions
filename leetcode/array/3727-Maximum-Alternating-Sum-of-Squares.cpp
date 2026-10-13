class Solution {
public:
    long long maxAlternatingSum(vector<int>& nums) {
        for(int i = 0 ; i < nums.size() ; i++){
            if(nums[i]<0) nums[i] *=-1;
        }
        sort(nums.begin(),nums.end());
        // for(auto x: nums){
        //     cout << x <<" ";
        // }
        // cout <<'\n';

        long long ans=0;
        int l=0,r=nums.size()-1;
        while(l<r){
            // cout << ans << " ";
            ans += ((1LL*nums[r]*nums[r])-(1LL*nums[l]*nums[l])); 
            l++;
            r--;
        }
        if(nums.size()%2 !=0){
            ans+=1LL*nums[l]*nums[l];
            //   cout << ans << " ";
        }
     return ans;
    }
};