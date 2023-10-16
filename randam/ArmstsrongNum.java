import java.util.Scanner;

public class ArmstsrongNum {

	int power(int x, long y)
	{
		if (y == 0)
			return 1;
		if (y % 2 == 0)
			return power(x, y / 2) * power(x, y / 2);
		return x * power(x, y / 2) * power(x, y / 2);
	}
	int order(int x)
	{
		int n = 0;
		while (x != 0) {
			n++;
			x = x / 10;
		}
		return n;
	}
	int isArmstrong(int x)
	{
		int n = order(x);
		int temp = x, sum = 0;
		while (temp != 0) {
			int r = temp % 10;
			sum = sum + power(r, n);
			temp = temp / 10;
		}
		if(sum == x){
            return x;
        }
        return 0;
	}
	public static void main(String[] args)
	{
        ArmstsrongNum ob = new  ArmstsrongNum();
        
		System.out.println("\n");
        for(int i = 10000 ; i<=99999; i++){
            int re = ob.isArmstrong(i);    
            if(re!=0){
                System.out.println(re);    
            }
        }

        Scanner s = new Scanner(System.in);
        System.out.println("Enter number to check");
        int n = s.nextInt();
        int z = ob.isArmstrong(n);
        if(z==n){
            System.out.println("It's Armstsrong number ");
        }
        s.close();
	}
}
