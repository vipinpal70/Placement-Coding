 
class hyphenStringn
{	 
	static void moveInFront(char str[])
	{		 
		int i = str.length-1;
		for (int j = i; j >= 0; j--)
			if (str[j] != '-')
			{
				char c = str[i];
				str[i] = str[j];
				str[j] = c;
				i--;
			}
	}
	public static void main(String[] args)
	{
		char str[] = "He-y there, i-t's Geeks-for-Geeks".toCharArray();
		moveInFront(str);
		System.out.println(String.valueOf(str));
	}
}


/*
 * weighted subString sum problem
 * String s = "vellore"
 * String q = "abcdefghijklmnopqrstuvwxyz";
 * int k = 10;
 * String str = "";
 * HashSet<String> h = new HashSet<String>;
 * for(int i=0; i<k;i++){
 * int sum =0;
 * for(int j=i;j<s.length;j++){
 *  int position = S.charAt(j) - 'a';
 *     sum += Q.charAt(position)-'0';
 *  }
 * }
 * if(sum <=k){
 *      h.add(S1);
 * }
 * else{
 *  break;
 * }
 * sys(h);
 * sys(h.size);
 */
 
 
