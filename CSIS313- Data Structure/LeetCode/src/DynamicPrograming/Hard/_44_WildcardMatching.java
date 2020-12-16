package DynamicPrograming.Hard;

public class _44_WildcardMatching {
    //Time: O(m*n)
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[][] memo = new boolean[n][m]; //记忆搜索结果
        boolean[][] visited = new boolean[n][m]; //标记是否访问
        return matchHelper(s, 0, p, 0, memo, visited);
    }

    private boolean matchHelper(String s, int sIndex,
                                String p, int pIndex,
                                boolean[][] memo,
                                boolean[][] visited){
        //if p is empty fron pIndex, then s must be empty fron sIndex to match with p
        if(pIndex==p.length()){
            return sIndex==s.length();
        }

        if(sIndex==s.length()){
            //if s is empty fron sIndex, then p must be all *
            return allStar(p, pIndex);
        }

        if(visited[sIndex][pIndex]){
            return memo[sIndex][pIndex];
        }

        char sFirstChar = s.charAt(sIndex);
        char pFirstChar = p.charAt(pIndex);
        boolean match;

        if(pFirstChar=='*'){
            match =  matchHelper(s, sIndex+1, p, pIndex,memo, visited) ||
                    matchHelper(s, sIndex, p, pIndex+1,memo, visited);
        }else{
            match = charMatch(sFirstChar, pFirstChar) &&
                    matchHelper(s, sIndex+1, p, pIndex+1, memo, visited);
        }
        memo[sIndex][pIndex] = match;
        visited[sIndex][pIndex] = true;
        return match;
    }

    private boolean charMatch(char sFirstChar, char pFirstChar){
        return (sFirstChar==pFirstChar) || (pFirstChar=='?');
    }

    private boolean allStar(String p, int pIndex){
        for(int i=pIndex; i<p.length(); i++){
            if(p.charAt(i)!='*'){
                return false;
            }
        }
        return true;
    }
}
