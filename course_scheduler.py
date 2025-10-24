from collections import deque
class CourseSchedular:
    def __init__(self):
        self._course_queues={}
        self.enrolled_students={}
        def add_course(self,course_code,name,capacity=3):
            """create a new course waiting list"""
            self._course_queues[course_code]=deque()
            self._enrolled_students[course_code]=[]
            self._course_capacity=capacity
            print(f"added course:{name}({course_code})")
        def enroll_students(self,course_code,student):
            """enroll student"""
            if len(self._enrolled_students[course_code])<self._course_capacity:
                self._enrolled_students[course_code].append(student)
                print(f"enrolled{student['name']}in{course_code}")
            else:
                self._course_queues[course_code].append(student)
                print(f"course full.")
        def get_enrolled_students(self,course_code):
            """get list of enrolled students"""
            return[f"{s['id']}:{s['name']}"for s in self._enrolled_students.get(course_code.[])]