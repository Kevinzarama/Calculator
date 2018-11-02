# Calculator
public class MergeSort { public static void main(String args[]){ int vec[]={45,17,23,67,21}; System.out.println("Vector original"); imprimirVector(vec); System.out.println("\nVector ordenado"); ordenacionMergeSort(vec); imprimirVector(vec); } public static void ordenacionMergeSort(int vec[]){ if(vec.length<=1) return; int mitad= vec.length/2; int izq[]=Arrays.copyOfRange(vec, 0, mitad); int der[]=Arrays.copyOfRange(vec, mitad, vec.length); ordenacionMergeSort(izq); ordenacionMergeSort(der); combinarVector(vec, izq, der); } public static void combinarVector(int v[], int izq[],int der[]){ int i=0; int j=0; for(int k=0;k<v.length;k++){ if(i>=izq.length){ v[k]=der[j]; j++; continue; } if(j>=der.length){ v[k]=izq[i]; i++; continue; } if(izq[i]<der[j]){ v[k]=izq[i]; i++; }else{ v[k]=der[j]; j++; } } } public static void imprimirVector(int vec[]){ for(int i=0;i<vec.length;i++){ System.out.print(vec[i]+" "); } } }






public static void mergeSort(int array[]){
    int [] tmp = new int[array.length];
    mergeSort(array, tmp, 0, array.length-1);
}
private static void mergeSort(int[] a, int[] tmp,int left, int right){
    if(left < right){
        int centre = (left + right)/2;
        mergeSort(a, tmp, left, centre);
        mergeSort(a, tmp, centre+1, right);
        merge(a, tmp, left, centre+1, right);
    }
}
private static void merge(int [] a, int [] tmp, int left, int right, int rend){
    int lend = right-1;
    int tpos = left; int lbeg = left;
  
    while(left <= lend && right <= rend){
         if(a[left] < a[right]){
               tmp[tpos++] = a[left++];
         }else{
               tmp[tpos++] = a[right++];
         }
    }
    while(left <= lend){
         tmp[tpos++] = a[left++];
    }
    while(right <= rend){
         tmp[tpos++] = a[right++];
    }
    for(tpos = lbeg; tpos <= rend; tpos++){
         a[tpos] = tmp[tpos];
    }
}
