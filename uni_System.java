import java.util.*;

public class SchoolSystem {

    // ---------------------------
    // Student Registry
    // ---------------------------
    static class StudentRegistry {
        private final Map<Integer, Student> students = new HashMap<>();

        public void addStudent(int studentId, String name) {
            students.put(studentId, new Student(studentId, name));
            System.out.println("Added student: " + name + " (ID: " + studentId + ")");
        }

        public Student findStudent(int studentId) {
            return students.getOrDefault(studentId, null);
        }

        static class Student {
            public final int id;
            public final String name;

            public Student(int id, String name) {
                this.id = id;
                this.name = name;
            }

            public String toString() {
                return name + " (ID: " + id + ")";
            }
        }
    }

    // ---------------------------
    // Course Scheduler
    // ---------------------------
    static class CourseScheduler {
        private final Map<String, Queue<StudentRegistry.Student>> courseQueues = new HashMap<>();
        private final Map<String, List<StudentRegistry.Student>> enrolledStudents = new HashMap<>();
        private final Map<String, Integer> courseCapacities = new HashMap<>();

        public void addCourse(String courseCode, String name) {
            courseQueues.put(courseCode, new LinkedList<>());
            enrolledStudents.put(courseCode, new ArrayList<>());
            courseCapacities.put(courseCode, 2); // default capacity
            System.out.println("Added course: " + name + " (" + courseCode + ")");
        }

        public void enrollStudent(StudentRegistry.Student student, String courseCode) {
            List<StudentRegistry.Student> enrolled = enrolledStudents.get(courseCode);
            int capacity = courseCapacities.getOrDefault(courseCode, 2);

            if (enrolled.size() < capacity) {
                enrolled.add(student);
                System.out.println("Enrolled " + student.name + " in " + courseCode);
            } else {
                courseQueues.get(courseCode).add(student);
                System.out.println("Course full. " + student.name + " added to waitlist.");
            }
        }

        public List<String> getEnrolledStudents(String courseCode) {
            List<StudentRegistry.Student> enrolled = enrolledStudents.getOrDefault(courseCode, new ArrayList<>());
            List<String> result = new ArrayList<>();
            for (StudentRegistry.Student student : enrolled) {
                result.add(student.id + ":" + student.name);
            }
            return result;
        }
    }

    // ---------------------------
    // Fee Tracker
    // ---------------------------
    static class FeeTracker {
        private TransactionNode root;

        public void recordPayment(int studentId, int amount, String date) {
            root = insert(root, studentId, amount, date);
            System.out.println("Recorded payment: Student " + studentId + " paid " + amount + " on " + date);
        }

        private TransactionNode insert(TransactionNode node, int studentId, int amount, String date) {
            if (node == null) {
                return new TransactionNode(studentId, amount, date);
            }
            if (date.compareTo(node.date) < 0) {
                node.left = insert(node.left, studentId, amount, date);
            } else {
                node.right = insert(node.right, studentId, amount, date);
            }
            return node;
        }

        public void generateReport(int studentId) {
            List<String> report = new ArrayList<>();
            inorderTraversal(root, studentId, report);
            if (!report.isEmpty()) {
                System.out.println("\n--- Fee report for student " + studentId + " ---");
                for (String line : report) {
                    System.out.println(line);
                }
            } else {
                System.out.println("No payment found for student " + studentId);
            }
        }

        private void inorderTraversal(TransactionNode node, int studentId, List<String> report) {
            if (node != null) {
                inorderTraversal(node.left, studentId, report);
                if (node.studentId == studentId) {
                    report.add(node.date + ": " + node.amount);
                }
                inorderTraversal(node.right, studentId, report);
            }
        }

        static class TransactionNode {
            int studentId;
            int amount;
            String date;
            TransactionNode left, right;

            TransactionNode(int studentId, int amount, String date) {
                this.studentId = studentId;
                this.amount = amount;
                this.date = date;
            }
        }
    }

    // ---------------------------
    // Library System
    // ---------------------------
    static class LibrarySystem {
        private final Map<String, Book> books = new HashMap<>();

        public void addBook(String isbn, String title) {
            books.put(isbn, new Book(isbn, title));
            System.out.println("Added book: '" + title + "' (ISBN: " + isbn + ")");
        }

        public void borrowBook(String isbn, int studentId) {
            Book book = books.get(isbn);
            if (book != null && book.isAvailable) {
                book.isAvailable = false;
                book.borrowHistory.push(studentId);
                System.out.println("Student " + studentId + " borrowed '" + book.title + "'");
            } else if (book != null) {
                System.out.println("Book '" + book.title + "' is already borrowed");
            } else {
                System.out.println("Book not found");
            }
        }

        public void checkAvailability(String isbn) {
            Book book = books.get(isbn);
            if (book != null) {
                System.out.println("Availability of '" + book.title + "': " + (book.isAvailable ? "Available" : "Borrowed"));
            } else {
                System.out.println("Book not found");
            }
        }

        static class Book {
            String isbn;
            String title;
            boolean isAvailable;
            Deque<Integer> borrowHistory;

            Book(String isbn, String title) {
                this.isbn = isbn;
                this.title = title;
                this.isAvailable = true;
                this.borrowHistory = new ArrayDeque<>();
            }
        }
    }

    // ---------------------------
    // Analytics Module
    // ---------------------------
    static class AnalyticsModule {
        private final StudentRegistry studentRegistry;
        private final Map<Integer, Map<String, Integer>> gradeGraph = new HashMap<>();

        public AnalyticsModule(StudentRegistry studentRegistry) {
            this.studentRegistry = studentRegistry;
        }

        public void recordGrade(int studentId, String courseCode, int grade) {
            gradeGraph.computeIfAbsent(studentId, k -> new HashMap<>()).put(courseCode, grade);
            System.out.println("Recorded grade: Student " + studentId + " got " + grade + " in " + courseCode);
        }

        public void getTopPerformers(String courseCode, int topN) {
            PriorityQueue<Performer> heap = new PriorityQueue<>(Comparator.comparingInt(p -> p.grade));

            for (Map.Entry<Integer, Map<String, Integer>> entry : gradeGraph.entrySet()) {
                int studentId = entry.getKey();
                Map<String, Integer> courses = entry.getValue();

                if (courses.containsKey(courseCode)) {
                    int grade = courses.get(courseCode);
                    StudentRegistry.Student student = studentRegistry.findStudent(studentId);
                    String name = (student != null) ? student.name : "Unknown";

                    heap.offer(new Performer(studentId, name, grade));
                    if (heap.size() > topN) {
                        heap.poll();
                    }
                }
            }

            List<Performer> topPerformers = new ArrayList<>(heap);
            topPerformers.sort((a, b) -> Integer.compare(b.grade, a.grade));

            System.out.println("\n--- Top " + topN + " performers in " + courseCode + " ---");
            for (int i = 0; i < topPerformers.size(); i++) {
                Performer p = topPerformers.get(i);
                System.out.println((i + 1) + ". " + p.name + " (ID: " + p.studentId + "): " + p.grade);
            }
        }

        static class Performer {
            int studentId;
            String name;
            int grade;
            Performer(int studentId, String name, int grade) {
                this.studentId = studentId;
                this.name = name;
                this.grade = grade;
            }
        }
    }
    // ---------------------------
    // Main Method with Sample Data
    // ---------------------------
    public static void main(String[] args) {
        StudentRegistry registry = new StudentRegistry();
        CourseScheduler scheduler = new CourseScheduler();
        FeeTracker fees = new FeeTracker();
        LibrarySystem library = new LibrarySystem();
        AnalyticsModule analytics = new AnalyticsModule(registry);
        registry.addStudent(1001, "Alice");
        registry.addStudent(1002, "Nafula");
        scheduler.addCourse("cs101", "Calculus");
        scheduler.addCourse("cs102", "OOP1");
        StudentRegistry.Student alice = registry.findStudent(1001);
        StudentRegistry.Student nafula = registry.findStudent(1002);
        scheduler.enrollStudent(alice, "cs101");
        scheduler.enrollStudent(alice, "cs102");
        scheduler.enrollStudent(nafula, "cs101");
        scheduler.enrollStudent(nafula, "cs102");
        fees.recordPayment(1001, 1000, "2024-09-20");
        fees.recordPayment(1002, 2000, "2024-08-20");
        library.addBook("786-1123", "OOP1");
        library.addBook("786-1125", "Calculus");
        library.borrowBook("786-1123", 1001);
        library.borrowBook("786-1125", 1002);
        analytics.recordGrade(1001, "cs101", 50);
        analytics.recordGrade(1002, "cs101", 80);
        System.out.println("\n" + "=".repeat(50));
        System.out.println("System Demo");
        System.out.println("=".repeat(50));
        System.out.println("\n1. Student Lookup");
        System.out.println("Looking for student 1001: " + registry.findStudent(1001));
        System.out.println("\n2. Course Enrollment");
        System.out.println("Students in cs101: " + scheduler.getEnrolledStudents("cs101"));
        System.out.println("\n3. Fee Tracking");
        fees.generateReport(1001);
        System.out.println("\n4. Library System");
        library.checkAvailability("786-1123");
        System.out.println("\n5. Performance Analytics");
        analytics.getTopPerformers("cs101", 2);
    }
}       