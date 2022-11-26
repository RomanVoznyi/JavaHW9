public class Main {
    public static void main(String[] args) {
        testMyArrayList();
        testMyLinkedList();
        testMyQueue();
        testMyStack();
        testMyHashMap();

        System.gc();
    }

    public static void testMyArrayList() {
        System.out.println("------------MyArrayList------------");
        MyArrayList<String> myList = new MyArrayList<String>();
        myList.add("I");
        myList.add("study");
        myList.add("Java");
        System.out.println("My list looks like this: " + myList);
        System.out.println("The size of the list is " + myList.size());
        System.out.println("My list has class " + myList.getClass().getName());
        System.out.println("Element with index 1 is '" + myList.get(1) + "'.");
        System.out.println("Elements in the list have class " + myList.get(0).getClass().getName());
        try {
            System.out.println("Element with index 5 is " + myList.get(5));      //Should throw an Error
        } catch (Exception e) {
            System.out.println("Cannot get an element with illegal index: less than 0 or more than array's capacity");
        }
        myList.remove(1);
        System.out.println("After removing 1 element my list looks like this: " + myList);
        myList.clear();
        System.out.println("After clearing my list looks like this: " + myList);
        System.out.println("The size of the list is " + myList.size());
        System.out.println("");                                           //divider
        MyArrayList<Number> myNumbList = new MyArrayList<Number>();
        myNumbList.add(1);
        myNumbList.add(0.5f);
        myNumbList.add(12.33333333d);
        myNumbList.add(2.0);
        System.out.println("My list of numbers looks like this: " + myNumbList);
        System.out.println("The size of the list is " + myNumbList.size());
        System.out.println("");
    }

    public static void testMyLinkedList() {
        System.out.println("------------MyLinkedList------------");
        MyLinkedList<Character> myList = new MyLinkedList<Character>();
        myList.add('A');
        myList.add('B');
        myList.add('C');
        System.out.println("My list looks like this: " + myList);
        System.out.println("The size of the list is " + myList.size());
        System.out.println("Element with index 1 is " + myList.get(1));
        myList.remove(1);
        System.out.println("After removing 1 element my list looks like this: " + myList);
        myList.clear();
        try {
            System.out.println("Element with index 0 is " + myList.get(0));      //Should throw an Error
        } catch (Exception e) {
            System.out.println("Cannot get an element with illegal index: less than 0, more than array's capacity or from empty array");
        }
        System.out.println("After clearing my list looks like this: " + myList);
        System.out.println("");                                           //divider
        MyLinkedList<Boolean> answersToTest15QuizList = new MyLinkedList<>();
        answersToTest15QuizList.add(true);
        answersToTest15QuizList.add(false);
        answersToTest15QuizList.add(true);
        answersToTest15QuizList.add(true);
        answersToTest15QuizList.add(false);
        System.out.println("Total answer's list of quiz 15 looks like this: " + answersToTest15QuizList);
        System.out.println("Total amount of questions of quiz 15 is " + answersToTest15QuizList.size());
        System.out.println("An answer to question 5 is: " + answersToTest15QuizList.get(4));
        System.out.println("");
    }

    public static void testMyQueue() {
        System.out.println("------------MyQueue------------");
        MyQueue<String> myList = new MyQueue<String>();
        myList.add("Jhon Smith 1");
        myList.add("Jhon Smith 2");
        myList.add("Jhon Smith 3");
        myList.add("Jhon Smith 4");
        myList.add("Jhon Smith 5");
        System.out.println("My queue looks like this: " + myList);
        System.out.println("The size of the queue is " + myList.size());
        System.out.println("Student " + myList.poll() + " is the first to answer");
        System.out.println("Now it's the turn of the student named: " + myList.peek() + ". Please get ready.");
        System.out.println("After " + myList.poll() + " and " + myList.poll() + " the queue looks like this: " + myList);
        myList.clear();
        System.out.println("When all students have answered the queue looks like this: " + myList);
        System.out.println("");
    }

    public static void testMyStack() {
        System.out.println("------------MyStack------------");
        MyStack<Integer> myBooksStack = new MyStack<Integer>();
        myBooksStack.push(1);
        myBooksStack.push(2);
        myBooksStack.push(3);
        myBooksStack.push(4);
        myBooksStack.push(5);
        myBooksStack.push(6);
        System.out.println("My stack of books looks like this: " + myBooksStack);
        System.out.println("The size of the stack is " + myBooksStack.size());
        System.out.println("Book number " + myBooksStack.peek() + " is on top of the stack");
        myBooksStack.pop();
        System.out.println("When I picked up the first book, book number " + myBooksStack.peek() + " now came on top.");
        myBooksStack.push(7);
        myBooksStack.remove(2);
        System.out.println("When I added the new book and removed the third book the stack looks like this: " + myBooksStack);
        myBooksStack.clear();
        System.out.println("When all the books were taken apart the stack looks like this: " + myBooksStack);
        try {
            System.out.println("Book on top is " + myBooksStack.pop());      //Should throw an Error
        } catch (Exception e) {
            System.out.println("We cannot get an book from empty stack");
        }
        System.out.println("");
    }

    public static void testMyHashMap() {
        System.out.println("------------MyHashMap------------");
        MyHashMap<String, Integer> group = new MyHashMap<>();
        group.put("Student 1", 18);
        group.put("Student 2", 19);
        group.put("Student 3", 16);
        group.put("Student 4", 17);
        group.put("Student 5", 20);
        System.out.println("Our group has students of the following age: " + group);
        int size = group.size();
        System.out.println("In our group " + size + (size == 1 ? " student" : " students"));
        System.out.println("Student with age " + group.remove("Student 3") + " has left our group");
        System.out.println("Student 'Student 1' has age: " + group.get("Student 1"));
        System.out.println("Student 'Student 4' has age: " + group.get("Student 4"));
        try {
            int tempValue = group.get("Student 7");                                             //Should throw an Error
            System.out.println("Student 'Student 7' has age: " + group.get("Student 7"));       //This line will return 'null'
        } catch (NullPointerException e) {
            System.out.println(";) we don't know age of Student 7, he is not in our group");
        }
        group.clear();
        System.out.println("All students graduated, received certificates and now our group is empty: " + group);
        System.out.println("");
    }
}