package Heap;

import java.util.Arrays;

/**
 * @ClassName MyPriorityQueuen
 * @Description TODO
 * @Auther danni
 * @Date 2019/9/22 14:18]
 * @Version 1.0
 **/

public class MyPriorityQueuen {
    private static  int[] array;
    private static int size;

    public MyPriorityQueuen() {
     array = new int[2];
    }
    public MyPriorityQueuen(int length) {array = new int[length];}
    private  int[] ensureCapicity(){
        int newlen=size*2;
        int[] temp=new int[newlen];
        System.arraycopy(array,0,temp,0,array.length);
        array=temp;
        return array;
    }
    private void checkRange(int index){
        if(index<0){
            throw new RuntimeException("队列为空");
        }
    }
    //小堆
    public void putSmall(int[] array, int element){
        if(size>=array.length){
            array=ensureCapicity();
        }
        array[size++]=element;
        shiftUpSmall(array,size-1);
    }
    //大堆
    public void putMax(int[] array, int element){
        if(size>=array.length){
            array=ensureCapicity();
        }
        array[size++]=element;
       shiftupMax(array,size-1);
    }

    public int peek(){
        checkRange(0);
        return array[0];
    }
    //小堆
    public int pollSmall(){
        checkRange(0);
        int element=array[0];
        array[0]=array[size-1];
        size--;
        TestHeap.shiftDownSmall(array,0,size);
        return element;
    }
    //大堆
    public int pollMax(){
        checkRange(0);
        int element=array[0];
        array[0]=array[size-1];
        size--;
        TestHeap.shiftDownBig(array,0,size);
        return element;
    }
    public static void shiftUpSmall(int[] array, int index) {
        int parent = (index - 1) / 2;
        while (parent >= 0) {
            if (array[parent] > array[index]) {
                swamp(array, index, parent);
                index=parent;
                parent = (parent - 1) / 2;
            } else {
                break;
            }
        }
    }
    public static void shiftupMax(int[] array,int index){
        int parent = (index - 1) / 2;
        while (parent>=0) {
            if (array[parent] < array[index]) {
                swamp(array, index, parent);
                index=parent;
                parent = (parent - 1) / 2;
            } else {
                break;
            }
        }
    }
    private static void swamp(int[] array, int index, int parent) {
        int temp=array[index];
        array[index]=array[parent];
        array[parent]=temp;
    }

    public static void main(String[] args) {
        MyPriorityQueuen queuen=new MyPriorityQueuen();
        queuen.putMax(array,1);
        queuen.putMax(array,3);
        queuen.putMax(array,2);
        queuen.putMax(array,5);
        queuen.putMax(array,4);
        for (int i = 0; i <size; i++) {
            System.out.print(array[i]+",");
        }

    }
}
