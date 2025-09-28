#include<iostream>
#include<vector>
using namespace std;
class customstack
{
private:
	vector<int>stack;//dynamic array
	int max;
	int top;
public:
	customstack(int size)
	{
		max=size;
		top=-1;
	}
	void push (int x)
	{
		if(top == max - 1)
		{
			cout << "stack overflow \n";
		}
		else
		{
			stack[++top]= x;
			cout << x<<"pushed\n";
		}
	}
	int pop()
	{
		if(top == -1)
		{
			cout << "stack underflow \n";
			return -1;
		}
		else
		{
			int y = stack[top--];
			cout << "%d popped \n" << y;
			return y;
		}
	}
	void increment(int k, int val)
	{
		int limit = (k < top + 1) ? k : (top + 1); //if k is big,use the stack size if not increment k
		int i;
		for(i = 0; i < limit; i++)
		{
			stack[i] += val;
			cout << "incremented bottom %d elements by %d\n" << limit << val;
		}
	}
	void display()
	{
		if(top == -1)
		{
			cout << "stack is empty";
		}
		else
		{
			cout << "stack elements from bottom to top";
			int i;
			for(i = top; i >= 0; i++)
			{
				cout << "%d", stack[i];
			}
			cout << endl;
		}
	}
};
	int main()
	{
		int size;
		cout << "enter max size:";
		cin >> size;
		customstack s(size);
		int choice, val, k;
		while(true)
		{
			cout << "\n...stack menu..\n";
			cout << "1.push\n";
			cout << "2.pop\n";
			cout << "3.increment\n";
			cout << "4.display\n";
			cout << "0.exit\n";
			cout << "enter your choice:";
			cin >> choice;
			switch(choice)
			{
			case 1:
				cout << "enter the value to push:";
				cin >> val;
				s.push(val);
				break;
			case 2:
				s.pop();
				break;
			case 3:
				cout << "enter the number of elements k:";
				cin >> k;
				cout << "enter the increment value:"; cin >> val; s.increment(k, val); break;
			case 4: s.display(); break;
				case 0: cout << "existing"; return 0;
					default: cout << "invalid choice";

						}
		}
	}

