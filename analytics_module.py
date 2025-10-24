import heapq
class AnalyticsModule:
    def __init__(self,student_registry,course_scheduler):
        self.students= student_registry
        self.courses=course_scheduler
        self._grade_graph={}
    def record_grade(self,student_id,course_code,grade):
        """record a student grade"""
        if student_id not in self._grade_graph:
            self._grade_graph[student_id]={}
            self._grade_graph[student_id][course_code]=grade
            print(f"recorded grade:student{student_id}got{grade}in{course_code}")
    def get_top_performers(self,course_code,top_n=3):
        """find top students"""
        heap=[]
        for student_id,courses in self._grade_graph.items():
            if course_code in courses:
                grade=courses[course_code]
                student_name=self.students.find_student(student_id)['name']
                heapq.heappush(heap,(grade,student_id,student_name))
                if len(heap)>top_n:
                    heapq.heappop(heap)
        top_performers=sorted(heap,reverse=true)
        print(f"\n---Top{top_n} performers in{course_code}---")
        for i,(grade,sid,name)in enumerate(top_performers,1):
         print(f"{i}.{name}(ID:{sid}):{grade}")
        return top_performers
