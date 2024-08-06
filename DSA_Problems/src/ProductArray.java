//https://www.geeksforgeeks.org/a-product-array-puzzle/
public class ProductArray
{
public static void main(String[] args)
{
    ProductArray pa = new ProductArray();
    int arr[] = { 1, 2, 3, 4, 5 };
    int n = arr.length;
    System.out.println("The product array is : ");
    pa.productArray(arr, n);
}

    private void productArray(int[] arr, int n) {

    int res[]=new int[n];
    int product=1;
    for(int i=0;i<n;i++){
        product=product*arr[i];
     }

    for(int i=0;i<n;i++){
        res[i]=product;
    }

    for(int i=0;i<n;i++){
        res[i]=res[i]/arr[i];
    }

        for(int i=0;i<n;i++){
            System.out.print(res[i]+" ");
        }
    }


}
