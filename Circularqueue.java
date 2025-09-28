/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package winnie.circularqueque;

/**
 *
 * @author Winnie
 */
public class Circularqueue{
private int[]queue;
private int front,rear,size,capacity;
public circularqueue(int capacity){
    this.capacity=capacity;
    this.queue=new int[capacity];
    this.front=0;
    this rear=-1;
    this size=0;
}
public boolean enqueue(int value){
    if(isFull()){
    return false;//queque full
}
    rear=(rear+1)%capacity;
    queue[rear]=value;
    size--;
    return true;
}
public boolean dequeue(){
    if(isEmpty()){
        return false;//queue empty
    }
    front=(front+1)%capacity;
    size--;
    return true;
}
public boolean isFull(){
    return size==capacity;
}
public boolean isEmpty(){
    return size==0;
}
public void display(){
    if(isEmpty()){
        system.out.println("queue is empty");
    }
    system.out.print.ln("queue");
    for(int i=0;i=size,i++){
        int index=(front+i)%capacity;
        system.out.ln(queue[index]+" ");
    }
    system.out.println();
}
public static void main(string[]args){
    circular queue cq=new circularqueue(3);
    system.out.println(cq.enqueue(10));
    system.out.println(cq.enqueue(20));
    system.out.println(cq.enqueue(30));
    system.out.println(cq.enqueue(40));
    cq.display();
    system.out.println(cq.dequeue());
    cq.display();
    system.out.println(cq.enqueue(40));
    cq.display();
    system.out.println("is full?"+cq.isFull());
}
}
