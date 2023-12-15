/**
 * ----
 * problem: 35
 * status: completed
 * notes:
 * ----
 *
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 *
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
async function searchInsert(nums, target) {
    let l = 0;
    let h = nums.length - 1;
    let n = Math.floor((l + h) / 2);

    if(h === 0){
        if (nums[n] >= target){
            return n;
        }

        if(nums[n] < target){
            return n +1;
        }
    }

    while (nums[n] !== target) {

        if (nums[n] > target) {

            if(n === l){
                break;
            }

            h = n;
            n = Math.floor((l + h) / 2);
        }

        if (nums[n] < target) {
            // if the array consists of only two elements, the second to last and the last
            if(n === h -1){
                if(nums[h] >= target){
                    n = h;
                }

                if(nums[h] < target){
                    n = h + 1;
                }
                break;
            }

            l = n;
            n = Math.floor((l + h) / 2);
        }
    }

    return n;
}

let input1 = [1];
let result1 = searchInsert(input1, -2);

console.log("result1:", result1);


