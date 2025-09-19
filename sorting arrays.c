#include<stdio.h>
int main()
{
	int arr[100], n, i, j, t;
	printf("enter the number of elements ");
	scanf("%d", &n);
	printf("enter the elements ");
	for(i=0; i<n;i++)
	{
		scanf("%d", &arr[i]);
	}	
	for(i = 0; i < n - 1; i++)
	{
		for(j = 0; j < n - i - 1; j++
		{
			if(arr[j] > arr[j + 1])
			{
				t = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = t;
			}
		}
	} 
	printf("array in assending order");
	for(i = 0; i < n; i++)
	{
		printf("%d ", arr[i]);
	}
	return 0;
}
