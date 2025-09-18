#include<stdio.h>
int main()
{
	int n;
	int remainder;
	int reversed=0;
	printf("enter the value of n:");
	scanf("%d",&n);  
	while(n!=0)
	{
		remainder= n%10;
		reversed=(reversed*10)+remainder;
		n=n/10;
	}
	printf("reversed=%d"	,reversed);
	return 0;	
}