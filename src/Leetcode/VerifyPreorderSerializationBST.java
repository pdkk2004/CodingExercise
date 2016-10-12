package Leetcode;

public class VerifyPreorderSerializationBST {

    // Graph in/out degree solution.
    //https://leetcode.com/discuss/83824/7-lines-easy-java-solution
    public boolean isValidSerialization(String preorder) {
        String[] bst = preorder.split(",");
        int diff = 1;
        for (String s : bst) {
            if (diff == 0) {
                return false;
            }
            if (s.equals("#")) {
                diff--;
            } else {
                diff++;
            }
        }
        return diff == 0;
    }
}
