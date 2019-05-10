/*
Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].

To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].

Example 1:

Input: [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]
Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
Example 2:

Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 */

/*
将矩阵中每行进行前后翻转，然后将1和0互换。
 */
class Solution {
public:
    vector<vector<int>> flipAndInvertImage(vector<vector<int>>& A) {
        for(int i = 0; i<A.size(); i++){
            for(int j = 0; j<A[0].size()/2; j++){
                swap(A[i][j], A[i][A[0].size()-j-1]);
            }
            for(int j = 0; j<A[0].size(); j++){
                A[i][j] ^= 1;
            }
        }
        return A;
    }

    vector<vector<int>> flipAndInvertImage(vector<vector<int>>& A){
        for(auto & row : A)
            reverse(row.begin(), row.end());
        for(auto & row : A){
            for(int & i : row)
                i ^= 1;
        return A;
        }
    }
};
