/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package winnie.customstack;
import java.util.Scanner;
/**
 *
 * @author Winnie
 */
 class Customstack{
private int[]stack;
private int top;
private int max;
    public  customstack(int size) {
       max=size;
       stack=new int[max];
       top=-1;
    }
    public void push(int x){
        if(top==max-1){
            system.out.println("stack overflow");
        }else{
            stack[++top]=x;
            system.out.println("pushed")
        }
    }
    public void pop(){
        if(top==-1){
            system.out.println("stack underflow");
        }else{
            system.out.println(stack[top--]+"popped");
        }
    }
    public void increment(intk,int val){
        int limit=math.min(k,top+1);
        for(int i=0;i<limit;i++){
            stack[i]+=val;
        }
        system.out.println("incremented bottom"+limit+"elementd by "+val);
    }
    public class stackproject{
        public static void main(string[]args){
            java.util.Scanner sc=new java.util.scanner(system.in);
            system.out.println("enter stack size");
            int size=sc.nextInt();
            customstack s=new customstack(size);
            do{
                system.out.println("\n1.push");
                system.out.println("2.pop");
                system.out.println("3.increment");
                system.out.println("4.display");
                system.out.println("5.exit");
                system.out.println("enter choice");
                choice=sc.nextInt();
                switch(choice){
                    case 1:
                        system.out.println("enter value to push;");
                        int val=sc.nextInt();
                        s.push(val);
                        break;
                    case 2:
                        s.pop();
                        break;
                    case 3:
                        system.out.println("enter k and incremented value;");
                        int k=sc.nextInt();
                        int inc=sc.nextInt();
                        s.increment(k,inc);
                        break;
                    case 4:
                        s.display();
                        break;
                    case 5:
                        system.out.println("exiting");
                        break;
                    default:
                        system.out.println("invalid choice");
                }
            }while(choice!=5)
                    sc.close();
        }
    }
}
