
public class convert {
	int x;
	int y;
	int rows=ChessGame.num2;
	int convertedx;
	int convertedy;
	
		public convert(int l,int v) {
			this.x=l;
			this.y=v;
			
		}
		
		public int getx(){
			convertedx=x;
			int temp = 600/rows;
			int adder = 600/rows;
			for(int z=1;z<=rows;z++) {
				if(convertedx<temp) {
					convertedx=z;
					break;
										
				}
				else {
					temp=temp+adder;
				}
			}
			return convertedx;
			
			
		}
		public int gety(){
			convertedy=y;
			int temp= 600/rows;
			int adder =600/rows;
			int temprow = rows;
			for(int z=1;z<=rows;z++) {
				if(y<temp) {
					convertedy=temprow;
					break;
					
				}
				else {
					
					temprow=temprow-1;

					temp=temp+adder;
				}
			}
			return convertedy;
			
			
		}
		

}
