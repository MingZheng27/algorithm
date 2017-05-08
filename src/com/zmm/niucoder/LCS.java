import java.util.*;
/*
最长公共子序列
*/
public class LCS{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		String result = lCS(str1,str2);
		//int result = lCS(str1,str2);
		System.out.println(result);
	}
	
	public static String lCS(String str1,String str2){
		int x = str1.length();
		int y = str2.length();
		int[][] dp = new int[x + 1][y + 1];
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ;i <= x;i++){
			for (int j = 0 ;j <= y;j++){
				if (i == 0 || j == 0){ 
					dp[i][j] = 0;
					continue;
				}
				if (str1.charAt(i - 1) == str2.charAt(j - 1)){
					//sb.append(str1.charAt(i - 1));
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}else dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
			}
		}
		//build lcs
		while (x > 0 && y > 0){
			if (str1.charAt(x - 1) == str2.charAt(y - 1)){
				sb.insert(0,str1.charAt(x - 1));
				x--;
				y--;
				continue;
			}else{
				if (dp[x - 1][y] > dp[x][y - 1]){
					x--;
				}else if (dp[x - 1][y] < dp[x][y - 1]){
					y--;
				}else{
					//当两边相等的时候只要始终选择同一种方向即可
					//由于长度问题可能出现多种lcs
					//x--;
					y--;
				}
			}
		}
		return sb.toString();
	}
	
}
/*
acdebf
cejklisdjfkjl
cdef
*/