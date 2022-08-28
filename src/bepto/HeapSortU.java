/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bepto;

/**
 *
 * @author Jose
 */
public class HeapSortU {
    public void sort(Rutas arr[])
    {
        int N = arr.length;
 
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);
 
        for (int i = N - 1; i > 0; i--) {
            Rutas rtemp = arr[0];
            arr[0] = arr[i];
            arr[i] = rtemp;
 
            heapify(arr, i, 0);
        }
    }
 
    // ORDENANDO SEGUN EL ATRIBUTO EVT
    
    public void heapify(Rutas arr[], int N, int i){
        
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
       
        if (l < N && arr[l].getMSR()[1] > arr[largest].getMSR()[1])  // EVT
            largest = l;
 
        if (r < N && arr[r].getMSR()[1] > arr[largest].getMSR()[1])  // EVT
            largest = r;
 
        if (largest != i) {
            Rutas rswap = arr[i]; 
            arr[i] = arr[largest];
            arr[largest] = rswap;

            heapify(arr, N, largest);
        }
    }
public static void printArray2(Rutas arr[]){
        
        int N = arr.length;
 
        for (int i = 0; i < N; ++i)
            System.out.println("id --> "+arr[i].getId()
                    +"\nUnidades operativas  --> "+arr[i].getMSR()[1]+"%"+"\n----------------------------------------------");  
        
    }    
}
