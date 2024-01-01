public class HashingOpenAdd {
    String[] buckets; //BUCKETS --> [null,null,null,null,.......]
    static int totalcollisions=0;

    HashingOpenAdd(int s){
        buckets=new String[s+s/3];
    }

    private int strtoInt(String v){//string ke har ascii value ko add krna
        int sum=0;
        for (int i = 0; i <v.length(); i++) {
            char c=v.charAt(i);
            int val=(int) c;//asccii me converted
            sum+=val;//sum me added
        }
        return sum;
    }

    private int Hash(int val){
        //int bi=Integer.hashCode(sum);
        //return Math.abs(bi) % buckets.length;
        return (val % buckets.length);
    }

    private int Rehash_L(int sum,int i){
       //LINEAR PROBING
       //return (sum%buckets.length+i)%buckets.length;
       return (Hash(sum)+i)%buckets.length; //better way
    }

    
    private int RehashQ(int sum,int i){
       //LINEAR PROBING
       return (Hash(sum)+(i*i))%buckets.length;
    }
       


    public void insert(String v){
        int sum=strtoInt(v);//sum of ascii of all vals in string
        int bi=Hash(sum);
        int collisions=0;
        int i=0;
      while(buckets[bi]!=null ){
       
        bi=Rehash_L(sum, i); //enable this for linear
        //bi=RehashQ(sum, i); //enable this for quadratic
        i++;
      collisions++;
    }
    totalcollisions+=collisions;
    System.out.println(v+" "+collisions);

    if(buckets[bi]==null){//now insert
        buckets[bi]=v;
    }

    }


    public boolean delete(String v){
        int sum=strtoInt(v);//sum of ascii of all vals in string
        int bi=Hash(sum);
        int i=1;
      while(buckets[bi]!=null){
        if(buckets[bi].equals(v)){
            buckets[bi]=null;
            return true;//deleted
        }
         bi=Rehash_L(sum, i);//searching by linear probing
         i++; 
      }

      return false;//not deleted


    }


    public String displayTable(){
        String temp="";

        for (int i = 0; i < buckets.length; i++) {
            if(buckets[i]!=null )
            temp+=buckets[i]+"\n";
        }
        System.out.println("Total Collisions =" + totalcollisions);
        return temp;

    }

    
}
