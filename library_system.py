class LibrarySystem:
    class Book:
        def __init__(self,isbn,title):
            self.isbn=isbn
            self.title=title
            self.is_available=True
            self.borrow_history=[]
        def __init__(self):
            self._books={}
        def add_book(self,isbn,title):
            """add book to the library"""
            self._books[isbn]=self.book(isbn,title)
            print(f"added book:'{title}'(ISBN:{isbn})")
        def borrow_book(self,isbn,student_id):
         """borrow a book-last in,first out"""
         book=self._books.get(isbn)
         if book and book.is_available:
            book.is_available=False
            book.borrow_history.append(student_id)
            print((f"student{student_id} borrowed'{book.title}'"))
         elif book:
          print(f"book'{book.title}'is already borrowed")
         else:
          print("book not found")
def return_book(self,isbn,student_id):
    """return a book"""
    book=self._books.get(isbn)
    if book and not book.is_available:
        if book.borrow_history and book.borrow_history[-1]==student_id:
            book.borrow_history.pop()
            book.is_available=True
            print(f"student{student_id}returned '{book.title}'")
        else:
            print("return error")
    elif book:
     print("book available")
    else:
     print("book unavailable")


