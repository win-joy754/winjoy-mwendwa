#include<stdio.h>
#define max 10
int stack[max];
int top=-1;
void push (int x)
{
	if(top==max-1)
	{
		printf("stack overflow \n");
	}
	else
	{
		stack[++top]=x;
		printf("%d pushed \n",x);
	}
}
int pop()
{
if(top==-1)
	{
		printf("stack underflow \n");
		return -1;
	}
	else
	{
		int y=stack[top--];
		printf("%d popped \n",y);
		return y;
	}	
}
void increment(int k,int val)
{
	int limit=(k<top+1)?k:(top+1);//if k is big,use the stack size if not increment k
	int i;
	for(i=0;i<limit;i++)
	{
		stack[i]+=val;
		printf("incremented bottom %d elements by %d\n",limit,val);
	}
}
	void display()
	{
		if(top == -1)
		{
			printf("stack is empty");
		}
		else
		{
			printf("stack elements from bottom to top");
			int i;
			for(i = top; i >= 0; i++)
			{
				printf("%d", stack[i]);
			}
			printf("\n");
		}
	}
	int main()
	{
		int choice, val, k;
		while(1)
		{
			printf("\n...stack menu..\n");
			printf("1.push\n");
			printf("2.pop\n");
			printf("3.increment\n");
			printf("4.display\n");
			printf("0.exit\n");
			printf("enter your choice:");
			scanf("%d",&choice);
			switch(choice)
			{
			case 1:
				printf("enter the value to push:");
				scanf("%d",& val);
				push(val);
				break;
			case 2:
				pop();
				break;
			case 3:
				printf("enter the number of elements k:");
				scanf("%d",&k);
				printf("enter the increment value:");scanf("%d",&val);increment(k, val); break;
			case 4: display(); break;
				case 0: printf("exiting"); return 0;
					default:printf("invalid choice") ;

						}
		}
	}







