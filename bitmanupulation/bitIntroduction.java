package bitmanupulation;

public class bitIntroduction {
    public static int getIthBit(int n, int i) {
        int bitMask = 1 << i;
        if ((n & bitMask) == 0) {
            return 0;
        } else {
            return 1;
        }

    }

    public static int setIthBit(int n, int i) {
        int bitMask = 1 << i;
        return n | bitMask;
    }

    public static int clearIthBit(int n, int i) {
        int bitMask = ~(1 << i);
        return n & bitMask;
    }

    public static int updateIthBit(int n, int i, int newbit) {
        // if(newbit == 0){
        // return clearIthBit(n, i);
        // } else{
        // return setIthBit(n, i);
        // }

        // 2nd Approach
        n = clearIthBit(n, i);
        int bitMask = newbit << i;
        return n | bitMask;
    }

    public static int clearLastBit(int n, int i) {
        int bitMask = ~(0) << i;
        return n & bitMask;
    }

    public static int clearRangeBit(int n, int i, int j) {
        int a = ((~0) << (j + 1));
        int b = (1 << i) - 1;
        int bitMask = a | b;
        return n & bitMask;
    }

    public static void main(String[] args) {
        // AND & ----- 1 & 1 => 1
        // OR | ------ 0 | 0 => 0
        // XOR ^ ----- 0 ^ 0 => 0 , 1 ^ 1 => 0
        // NOT ~ , One's Complement ~1 => 0 , ~0 => 1
        // Left Shift << ----- a<<b => a * 2 ki power b
        // Right Shift >> ---- a >>b => a / 2 ki power b
        // System.out.println(5 & 6);
        // System.out.println(5 | 6);
        // System.out.println(5 ^ 6);
        // System.out.println(~5);
        // System.out.println(6 << 2);

        // Operation

        // Get ith Bit
        // &(1<<i)
        // System.out.println(": " + getIthBit(10, 3));

        // Set ith Bit
        // |(1<<i)
        // System.out.println(": " + setIthBit(10, 2));

        // Clear ith Bit
        // ~(1<<i)
        // System.out.println(": " + clearIthBit(10, 1));

        // Update ith bit
        // int bitMask = (newBit<<i)
        // System.out.println(": " + updateIthBit(10, 2, 1));

        // Clear Last bit
        // (~0 << i) or (-1 <<i)
        // System.out.println(": " + clearLastBit(10, 2));

        // Clear Range bit

        // System.out.println(": " + clearRangeBit(10, 2, 4));


    }
}
