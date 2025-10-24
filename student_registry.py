class StudentRegistry:
    def __init__(self):
     self._students={}
    def add_student(self,student_id,name):
        """add a student to the registry"""
        self._student[student_id]={'id':student_id,'name':name}
        print(f"added student:{name}(ID:{student_id,})")
        def find_student(self,student_id,name): 
            """find the student by ID-this is 0(1) fast lookup""" 
            return self.students.get(student_id,"student not found")
        def remove_student(self,student_id,name): 
            """remove student from registry""" 
            if student_id in self._students:
                del self._students[student_id]
                print(f"removed student{student_id}")
            else:
                print("student not found")