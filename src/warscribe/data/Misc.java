package warscribe.data;

import java.util.Arrays;

public class Misc{    

    /**
     * Returns an array appended with the integer 'data'
     * @param in
     * @param data
     */
    static public int[] add(int[] in, int data){
            if(in != null && in.length > 0){
                int[] newArray = new int[in.length + 1];
                for(int i = 0; i < newArray.length - 1; i++){
                    newArray[i] = in[i];
                }
            newArray[newArray.length - 1] = data;
            return newArray;
        }else{
            int[] newArray = {data};
            return newArray;
        }
    }
    
    static public String[] add(String[] in, String data){
        if(in != null && in.length > 0){
            String[] newArray = new String[in.length + 1];
            for(int i = 0; i < newArray.length - 1; i++){
                newArray[i] = new String(in[i]);
            }
            newArray[newArray.length - 1] = new String(data);
            return newArray;
        }else{
            String[] newArray = {data};
            return newArray;
        }
    }
    
    /**
     * Combines two arrays, omitting all repeated values.
     * @param list1
     * @param list2
     */
    static public int[] union(int[] list1, int[] list2){
        int[] list3 = list1.clone();
        for(int i = 0; i < list2.length; i++){
            boolean found = false;
            for(int c = 0; c < list1.length; c++){
                if (list2[i] == list1[c]){
                    found = true;
                }
            }
            if(!found){
                list3 = add(list3,list2[i]);
            }
        }
        return list3;
    }
    
    /**
     * Linearly searches and returns the index of value 'key' within array 'list'
     * If not found, returns -1
     * @param list
     * @param key
     */
    static public int search(int[] list, int key){
        for(int i = 0; i < list.length; i++){
            if(list[i] == key)
                return i;
            }
        return -1;
    }
    
    /**
     * Removes all instances of value 'key' within array 'list'
     * @param list
     * @param key
     */
    static public int[] removeAll(int[] list, int key){
        while(search(list, key) >= 0){
            list = remove(list, key);   
        }
        return list;
    }
    
    /**
     * Removes the first instance of value 'key' within array 'list'
     * @param list
     * @param key
     */
    static public int[] remove(int[] list, int key){
        int removeIndex = search(list, key);
        if(removeIndex >= 0){
            int[] list1 = new int[removeIndex];
            for(int i = 0; i < removeIndex; i++){
                list1[i] = list[i];
            }
            for(int i = removeIndex + 1; i < list.length; i++){
                list1 = add(list1, list[i]);
            }
            return list1;
        }
        return list;
    }
    
    /**
     * Returns the minimum value within 'list'
     * @param list
     */
    static public int getMin(int[] list){
        Arrays.sort(list);
        return list[0];
    }
    
    /**
     * Returns the index of the minimum value within 'list'
     * @param list
     */
    static public int indexOfMin(int[] list){
        int[] copy = list.clone();
        Arrays.sort(copy);
        for(int i = 0; i < list.length; i++){
            if(copy[0] == list[i])
                return i;
        }
        return -1;
    }
    
    /**
     * Returns the maximum value within 'list'
     * @param list
     */
    static public int getMax(int[] list){
        int[] copy = list.clone();
        Arrays.sort(copy);
        return copy[copy.length - 1];
    }
    
    /**
     * Returns the index of the maximum value within 'list'
     * @param list
     */
    static public int indexOfMax(int[] list){
        int[] copy = list.clone();
        Arrays.sort(copy);
        for(int i = 0; i < list.length; i++){
            if(copy[copy.length - 1] == list[i])
                return i;
        }
        return -1;
    }
    
    /**
     * Returns the minimum value within 'list'
     * @param list
     */    
    static public double getMin(double[] list){
        double[] copy = list.clone();
        Arrays.sort(copy);
        return copy[0];
    }
    
    /**
     * Returns the index of the minimum value within 'list'
     * @param list
     */    
    static public int indexOfMin(double[] list){
        double[] copy = list.clone();
        Arrays.sort(copy);
        for(int i = 0; i < list.length; i++){
            if(copy[0] == list[i])
                return i;
        }
        return -1;
    }
    
    
    /**
     * Returns the maximum value within 'list'
     * @param list
     */    
    static public double getMax(double[] list){
        double[] copy = list.clone();
        Arrays.sort(copy);
        return copy[copy.length - 1];
    }   
    
    /**
     * Returns the index of the maximum value within 'list'
     * @param list
     */    
    static public int indexOfMax(double[] list){
        double[] copy = list.clone();
        Arrays.sort(copy);
        for(int i = 0; i < list.length; i++){
            if(copy[copy.length - 1] == list[i])
                return i;
        }
        return -1;
    }
}