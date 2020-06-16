
public class Three {

	public static int getMaxValue(int[] arr){
		int max = arr[0];
		
		for(int i=0; i< arr.length ; i++){
			
			if(max < arr[i]){
				max = arr[i];
			}
			
		}		
		return max;		
	}
	
	public static int[]  getSortDESC(int[] arr){
				
		int temp=0;
		for(int i = 0 ; i < arr.length ; i++) {
			
			for(int j = 0 ; j < arr.length -i -1 ; j++) {
				
				if(arr[j]<arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		return arr;		
	}

}