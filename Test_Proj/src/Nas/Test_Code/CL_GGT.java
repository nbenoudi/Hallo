package Nas.Test_Code;
/**
 * 
 * @author Benoudi Nasser 2017
 *
 */
public class CL_GGT {
	private int GGT=0;
	private String type ="";// wich Algorithme 
	private boolean print_one=false;
	//
	private int a=0,b=0;
	//
	public  void initialise(int a, int b, String type){
		this.a=a;
		this.b=b;
		this.type=type;
		this.GGT=0;
	}
	//  Benoudi_ALgo GGT ist  die anzahl der elemente die gleichzeitig in Diagonal M a*b liegen.
	public int getGGT_Benoudi_Algo(int a, int b){
		initialise(a,b,"GGT_Nasser_Benoudi_Algorithm");
		for(int i=1;i<=a;i++){
		for(int j=1;j<=b;j++){
						if(j*a==b*i) GGT++;
		}	
			}
		
		return GGT;
	}
	// Default Algorith 
	private  int getGGT_Defaut_Algo (int a, int b) {
		initialise(a,b,"GGT_Defaut_Algorithm");
		   while (b != 0) {
			  if (a > b) {
		       a = a - b;
		     } else {
		       b = b - a;
		     }
		   }
		   this.GGT=a;
		   return a;
		 }
	// Rekursive Algo 
	// Definition 	ggT(m,m) = 1; ggT(m,n) = ggT(m-n,n) falls m > n;ggT(m,n) = ggT(n,m) 
	public  int getGGT_Rekursive_Algo(int a, int b)	{
		if(print_one==false){
		initialise(a,b,"GGT_Rekursive_Algorithm");
		print_one=true;
		}
		
	   if (a==b) return(a);
	   else
	   {
	      if (a>b) return(getGGT_Rekursive_Algo(a-b,b));
	      else return(getGGT_Rekursive_Algo(b-a,a));
	   }
	 	}
	//GGT Euklid_Algo
	public  int getGGT_Euklid_Algo(int a, int b)	{
		initialise(a,b,"GGT_Euklid_Algorithm");
		int r = a;
		while ( r != 0 ){
			r = a % b;
			a = b;
			b = r;
				}
		this.GGT=a;
		return a;
	}
    

	  // Ausgabe des Ergebnisses:
	   public void Anzeigen(int ggt){
	   System.out.println("Der "+ type +" von "  + this.a + 
		       " und " + this.b + " ist: " + ggt);
	   }
	// Testen
	   public static void main(String[] arg){
		   CL_GGT cl_ggt = new CL_GGT();
		   cl_ggt.Anzeigen(cl_ggt.getGGT_Benoudi_Algo(25, 5));
		   cl_ggt.Anzeigen(cl_ggt.getGGT_Defaut_Algo(25, 5));
		   cl_ggt.Anzeigen(cl_ggt.getGGT_Euklid_Algo(25, 5));
		   cl_ggt.Anzeigen(cl_ggt.getGGT_Rekursive_Algo(25, 5));
		   
		   
	   }
}
