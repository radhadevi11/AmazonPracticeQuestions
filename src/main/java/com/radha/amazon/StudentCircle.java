package com.radha.amazon;

public class StudentCircle {
    public int[] studentOrder(int n, int[] a, int position){
        /*
        ALGORITHM:(input n => size , a[n] => values, position => initial possition)
        Step 0: initialize orderPosition = 0, initialize order array of size n
	    Step 1: for each value in the values start from the i=position-1 do
			1.1: if i is equal to n then do
				1.1.2: for each value from j = 0 to postion-2
						1.1.2.1: order[orderPosition]  = a[j]
						1.1.2.2: Increament orderPosition by 1
			1.2: Otherwise order[orderPosition]  = a[i]
			1.3: Increament orderPosition by 1
		Step 2: return order
         */
        int orderPosition = 0;
        int[] order = new int[n];
        for(int i = position-1; i <= n; i++){
            if(i == n){
                for(int j = 0; j < position-2; j++){
                    order[orderPosition] = a[j];
                    orderPosition++;
                }
            }
            else{
                order[orderPosition] = a[i];
                orderPosition++;
            }
        }
        return order;
    }
}
