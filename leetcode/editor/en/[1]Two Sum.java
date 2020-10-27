//Given an array of integers nums and an integer target, return indices of the t
//wo numbers such that they add up to target.
//
// You may assume that each input would have exactly one solution, and you may n
//ot use the same element twice.
//
// You can return the answer in any order.
//
//
// Example 1:
//
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Output: Because nums[0] + nums[1] == 9, we return [0, 1].
//
//
// Example 2:
//
//
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
//
//
// Example 3:
//
//
//Input: nums = [3,3], target = 6
//Output: [0,1]
//
//
//
// Constraints:
//
//
// 2 <= nums.length <= 105
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// Only one valid answer exists.
//
// Related Topics Array Hash Table
// 👍 17497 👎 627
/*使用时间复杂度为(n*n)/2的也可以过，比较好的解法是使用map
*List，Map，Set
*
*
*/
//leetcode submit region begin(Prohibit modification and deletion)
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*int[] result = new int[2];
        //map中有contains方法，可以直接判断存不存在，先将数组转换成为map，可以将值作为key，然后将数组下标作为value
        //应该将数组下标作为key，将值作为value
        HashMap<Integer,Integer> tempmap = new HashMap<Integer,Integer>();
        for(int i=0;i<=nums.length-1;i++){
            tempmap.put(i,nums[i]);
        }
        Set<Integer> keySet = tempmap.keySet();
        Iterator<Integer> iterator = keySet.iterator();
        while(iterator.hasNext()){
            Object key = iterator.next();
            //iterator.remove();
            if(tempmap.containsValue(target-tempmap.get(key))){
                if (!key.equals(tempmap.containsValue(target-tempmap.get(key)))){
                    result[0] = (int) key;
                    result[1] = target-tempmap.get(key);
                    return result;
                }
            }
        }
        return result;
        //此解法为什么不行？——>因为此解法无法判断重复的情况
        */
        //改成先寻找再将元素放入,可以将num[i]放入key，数组下标是value；
//        执行耗时:1 ms,击败了99.92% 的Java用户
//        内存消耗:39.5 MB,击败了8.03% 的Java用户
        int[] indexs = new int[2];
        HashMap<Integer,Integer> temp_map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++){
            if ( temp_map.containsKey(target-nums[i])){
                indexs[0] = temp_map.get(target-nums[i]);
                indexs[1] = i;
                return indexs;
            }
            if (temp_map.containsKey(nums[i])!=true){
                temp_map.put(nums[i],i);
            }
        }
        return indexs;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
