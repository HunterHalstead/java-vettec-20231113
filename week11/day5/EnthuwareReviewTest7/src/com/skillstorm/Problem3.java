package com.skillstorm;

public class Problem3 {
	
	void probe(int... x) { System.out.println("In ..."); }  //1
//    
//    void probe(Integer x) { System.out.println("In Integer"); } //2
//    
//    void probe(long x) { System.out.println("In long"); } //3 
	void probe(Integer x) { System.out.println("In Integer"); } //4
	
    public static void main(String[] args){
//        Long a = 4L; new Problem3().probe(a); //5
        int b = 4; new Problem3().probe(b); //6
    }
    
    // Rules:
    /*
     * Method chosen based on params: 
     * 1. Look for exact match - fails
     * 2. Try widening the data type
     * 3. Try autoboxing - Integer > int
     * 4. varargs
     */

}
