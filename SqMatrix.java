public class SqMatrix {
    private int [][] arr;

    public SqMatrix(int max){
        arr = new int[max][max];
    }
    
    public String toString(){
        String S = "";
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++ ){
                S+=arr[i][j] + " ";
            }
            S= S+"\n";
        }
        return S;
    }
    public void AddElemt(int e, int r, int c){
        arr[r][c] = e;
    }
    public SqMatrix ScalarProd(int k){
        int[][] Lol = new int[arr.length][arr.length];
        for(int i = 0; i < arr.length;i++){

            for(int j = 0 ; j < arr.length; j++){
                Lol[i][j] = k * arr[i][j];
            }

        }
        SqMatrix result = new SqMatrix(arr.length);
        for(int i = 0; i < Lol.length; i++){
            for(int j = 0; j < Lol[0].length; j++){
                result.AddElemt(Lol[i][j], i, j);
            }
        }
        return result;

    }

    public SqMatrix Add(SqMatrix c){
        if(this.arr.length != c.arr.length){
            return null;
        }
        int[][] M = new int[arr.length][arr.length];

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                M[i][j] = this.arr[i][j] + c.arr[i][j];
            }
        }
        SqMatrix result = new SqMatrix(arr.length);
        for(int i = 0; i < M.length; i++){
            for(int j = 0; j < M[0].length; j++){
                result.AddElemt(M[i][j], i, j);
            }
        }
        return result;
        

    }
    
    public SqMatrix Refresh(){

        int[][] A = new int [arr.length][arr[0].length];
        for(int i = 0; i < arr.length ; i++){

            for(int j = 0; j < arr[0].length; j++){
                
                int s = 0;
                int c = 0;

                if(i-1 >= 0 ){ 
                    s+=arr[i-1][j];
                    c++;
                }
                if(i+1 < arr.length){
                    s+=arr[i+1][j];
                    c++;
                }
                if(j-1 >= 0){
                    s+=arr[i][j-1];
                    c++;
                }
                if(j+1 < arr[0].length){
                    s+=arr[i][j+1];
                    c++;
                }
                if(i-1 >=0 && j-1 >=0){
                    s+=arr[i-1][j-1];
                    c++;
                }
                if(i-1 >=0 && j+1 < arr[0].length){
                    s+=arr[i-1][j+1];
                    c++;
                }
                if(i + 1 < arr.length && j-1 >= 0){ 
                    s+=arr[i+1][j-1];
                    c++;
                }
                if(i + 1 > arr.length && j+1 < arr[0].length){
                    s+=arr[i+1][j-1];
                    c++;
                }
                A[i][j] = s/c;
            
            }
        }

        SqMatrix result = new SqMatrix(A.length);
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                result.AddElemt(A[i][j], i, j);
            }
        }
        return result;



    }

    private Integer Determinat2x2(int [][] A){

        if(A.length !=2 && A[0].length !=2){
            return null;
        }

        int D = (A[0][0] * A[1][1]) - (A[0][1] * A[1][0]);


        return D;

    }
    
    public Integer Determinant()
    {
        if(arr.length == 2){
            return Determinat2x2(arr);
        }

        if(arr.length != arr[0].length){
            return null;
        }
        if(arr.length == 1){
            return arr[0][0];
        }

         int D = 0;
         boolean flag = false;
        for(int i = 0; i < arr.length; i ++ , flag = !flag )
        {
            int[][] Matrix = new int [arr.length-1][arr.length-1];

            for(int j = 1 ; j < arr.length ; j++){

                    for(int l = 0 ; l < arr.length; l++  ){

                        if(l < i){
                            Matrix[j-1][l] = arr[j][l];
                        }
                        else if(l > i){
                            Matrix[j-1][l-1] = arr[j][l];
                        }


                    }

            }

            int coefactor = Determinat2x2(Matrix);

            if(flag == false)
                D-=arr[0][i] * coefactor;
            else
                D+=arr[0][i] * coefactor; 

        }
        return D;

    }





}