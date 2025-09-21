#include<iostream>
#include<vector>
#include<unordered_map>
#include<set>
#include<string>
using namespace std;
class foodrating
{
private:
	unordered_map<string,string>foodtocuisine;
	unordered_map<string,int>foodtorating;	
	unordered_map<string,set<pair<int,string>>>cuisine to foods;
	public:
		foodratings(vector<string>&foods,vector<string>&cuisines,vector<int>&ratings)
		{
			for(int i=0;i<foods.size();i++)
			{
				string food=foods[i];
		string cuisine=cuisines[i];
		int rating=ratingss[i];	
		foodtocuisine[food]=cuisine;
		foodtorating[food]=rating;
		cuisinetofoods[cuisine].insert({-rating,food});
			}		
		}
		void changerating(string food,int newrating)
		{
			string cuisine=foodtocuisine[food];
			int oldrating=foodtorating[food];
			cuisinetofoods[cuisine].erase({-oldrating,food});
			cuisinetofoods[cuisine].insert({-newrating,food});
			foodtorating[food]=newrating;
		}
		string highestrated(string cuisine)
		{
			return cuisinetofoods[cuisine].begin()->second;
		}
};
int main()
{
	vector<string>foods={"ugali","chapati","samosa","sushi"};
	vector<string>cuisines={"kenyan","kenyan","kenyan","japanese"};
	ventor<int>ratings=(7,8,15,6);
	foodratings obj(foods,cuisines,ratings);
	cout<<obj.highestrated("kenyan")<<endl;
	obj.changerating("sushi",6);
	cout<<obj.highestrated("japanese")<<endl;
	return 0;
}