public class MyProgram extends ConsoleProgram
{
    
 
    
    
    public void run()
    {
       
       int len = readInt("Enter the length of the SqMatrix");
       
       
        SqMatrix M1 = new SqMatrix(len);
        
        for(int i = 0; i < len;i++)
        {
            
            for(int j = 0; j < len; j++)
            {
                
                M1.AddElemt(readInt("Grid[" + i + "][" + j + "] = " + " "), i, j);
                
            }
            
        }
        
        int len2 = readInt("Enter the length of the second SqMatrix");
        
         SqMatrix M2 = new SqMatrix(len2);
        
        for(int i = 0; i < len2;i++)
        {
            
            for(int j = 0; j < len2; j++)
            {
                
                M2.AddElemt(readInt("Grid[" + i + "][" + j + "] = " + " "), i, j);
                
            }
            
        }
        
        

        System.out.println("M1: \n" + M1);
        System.out.println("ScalarProd M1: \n" + M1.ScalarProd(2));
        System.out.println("M2: \n" + M2);
        System.out.println("M1 + M2: \n" + M1.Add(M2));
        System.out.println("M1 Refresh: \n" + M1.Refresh());
        System.out.println("M1 Determinant: \n" + M1.Determinant());
        
        
        
        
        
    }
}