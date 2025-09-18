#include<stdio.h>
int main()
{
	int n,original;
	int remainder;
	int reversed=0;
	printf("enter the value of n:");
	scanf("%d",&n); 
	original=n; 
	while(n!=0)
	{
		remainder= n%10;
		reversed=(reversed*10)+remainder;
		n=n/10;
	}
	if(original==reversed)
	{
		printf("%d is a palindrome./n",original);
	}
	else
	{
		printf("%d is not a palindrome./n",original);
	}
return 0;
		
}