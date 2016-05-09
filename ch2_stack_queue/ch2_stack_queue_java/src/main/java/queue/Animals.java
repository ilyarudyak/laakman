package queue;

/**
 * Created by ilyarudyak on 5/9/16.
 */
public class Animals {

    public static final String CAT = "cat";
    public static final String DOG = "dog";


    QueueWithTime<String> cats, dogs;

    public Animals() {
        cats = new QueueWithTime<>();
        dogs = new QueueWithTime<>();
    }

    public void enqueue(String name, String type) {

        if (type.equals(CAT)) {
            cats.enqueue(name);
        } else {
            dogs.enqueue(name);
        }
    }

    public String dequeue() {

        if (cats.isEmpty() && dogs.isEmpty()) { return null; }
        else if (cats.isEmpty()) { return dogs.dequeue(); }
        else if (dogs.isEmpty()) { return cats.dequeue(); }

        long timeCat = cats.peekTime();
        long timeDog = dogs.peekTime();

        if (timeCat < timeDog) {
            return cats.dequeue();
        } else {
            return dogs.dequeue();
        }
    }

    public static void main(String[] args) {

        Animals animals = new Animals();
        animals.enqueue("d1", DOG);
        animals.enqueue("d2", DOG);
        animals.enqueue("c1", CAT);
        animals.enqueue("c2", CAT);
        animals.enqueue("d3", DOG);
        animals.enqueue("c3", CAT);

        System.out.print("cats: ");
        animals.cats.show();
        System.out.print("dogs: ");
        animals.dogs.show();

        int n = animals.cats.size() + animals.dogs.size();
        for (int i = 0; i < n; i++) {
            System.out.print(animals.dequeue() + " ");
        }
        System.out.println();
    }
}
