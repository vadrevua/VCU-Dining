package com.vadrevua.vcudining;

public class SortMenuItems {

private static String []menuItems;
public static void main(String[] args) {
  // Get a String array
  menuItems= new String[]{"Fries","Cheeseburger","Burrito","Chocolate Cake","Chicken Fingers"};
  
  // sort the array
  sort();
  
  System.out.println("");
  
  //prints the sorted array
  printArray();
  
 }
 
 // This method sort an array internally and internally calls quickSort 
 public static void sort(){
  int left = 0;
  int right = menuItems.length-1;
   
  quickSort(left, right);
 }
 
 // This method is used to sort the array using quicksort algorithm.
 // It takes left and the right end of the array as two cursors
 private static void quickSort(int left,int right){
  
  // If both cursor scanned the complete array quicksort exits
  if(left >= right)
   return;
  
  // Pivot using median of 3 approach
  String pivot = getMedian(left, right);
  int partition = partition(left, right, pivot);
  
  // Recursively, calls the quicksort with the different left and right parameters of the sub-array
  quickSort(0, partition-1);
  quickSort(partition+1, right);
 }
 
 // This method is used to partition the given array and returns the integer which points to the sorted pivot index
 private static int partition(int left,int right,String pivot){
  int leftCursor = left-1;
  int rightCursor = right;
  while(leftCursor < rightCursor){
  while(((Comparable<String>)menuItems[++leftCursor]).compareTo(pivot) < 0);
        while(rightCursor > 0 && ((Comparable<String>)menuItems[--rightCursor]).compareTo(pivot) > 0);
   if(leftCursor >= rightCursor){
    break;
   }else{
    swap(leftCursor, rightCursor);
   }
  }
  swap(leftCursor, right);
  return leftCursor;
 }
 
 public static String getMedian(int left,int right){
  int center = (left+right)/2;
  
  if(((Comparable<String>)menuItems[left]).compareTo(menuItems[center]) > 0)
   swap(left,center);
  
  if(((Comparable<String>)menuItems[left]).compareTo(menuItems[right]) > 0)
   swap(left, right);
  
  if(((Comparable<String>)menuItems[center]).compareTo(menuItems[right]) > 0)
   swap(center, right);
  
  swap(center, right);
  return menuItems[right];
 }
 
 // This method is used to swap the values between the two given index
 public static void swap(int left,int right){
  String temp = menuItems[left];
  menuItems[left] = menuItems[right];
  menuItems[right] = temp;
 }
 
 public static void printArray(){
  for(String i : menuItems){
   System.out.print(i+" ");
  }
 }
 
}