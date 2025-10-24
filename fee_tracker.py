class FeeTracker:
    class transactionNode:
        def __init__(self,student_id,amount,date):
            self._student_id=student_id
            self._amount=amount
            self._date=date
            self.left=None
            self.right=None
        def __init__(self):
            self._root=None
        def record_payment(self,student_id,amount,date):
            """record a payment"""
            self._root=self._insert(self._root,student_id,amount,date)
            print(f"recorded payment:student{student_id}paid{amount}on{date}")
        def insert(self,node,student_id,amount,date):
            """inserting to the search tree"""
            if node is None:
                return self.TransactionNode(student_id,amount,date)
            if date<node.date:
                node.left=self._insert(node.left,student_id,amount,date)
            else:
               node.right=self._insert(node.right,student_id,amount,date) 
            return node
        def generate_report(self,student_id):
            """generate fee report"""
            report=[]
            self._inorder_traversal(self._root,student_id,report)
            if report:
                print(f"\n---fee report for student{student_id}---")
                for line in report:
                    print(line)
                else:
                    print(f"no payment found for student{student_id}")
        def _inorder_traversal(self,node,student_id,report):
            """inorder traversal gives transactions in date order"""
            if node:
                self._inorder_traversal(node.left,student_id,report)
                if node.student_id==student_id:
                    report.append(f"{node.date}:{node.amount}")
                    self._inorder_traversal(node.right,student_id,report)
