import com.workintech.library.Library;
import com.workintech.person.Author;
import com.workintech.person.Member;
import com.workintech.person.Membership;
import com.workintech.publication.Category;
import com.workintech.publication.Publication;



import java.time.LocalDate;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addMember(new Member("John Doe", 12345, Membership.STUDENT, LocalDate.now(), 0, "123 Main St", "555-555-5555"));
        library.addMember(new Member("Jane Doe", 23456, Membership.FACULTY, LocalDate.now(), 0, "123 Main St", "555-555-5555"));
        library.addMember(new Member("Bob Smith", 34567, Membership.EMPLOYEE, LocalDate.now(), 0, "123 Main St", "555-555-5555"));

        Author author1 = new Author("George Orwell");
        Author author2 = new Author("J.K. Rowling");
        Author author3 = new Author("Gilbert Brands");
        Author author4 = new Author("Mark Twain");
        Author author5 = new Author("Charles Darwin");
        Author author6 = new Author("George R. R. Martin");
        Author author7 = new Author("Andrzej Sapkowski");
        Author author8 = new Author("Yunus cengel");

        Publication publication1 = new Publication( author1, "1984", 10.99, Category.FICTION, 2,LocalDate.of(2020, 10, 25));
        Publication publication2 = new Publication( author2, "Harry Potter and the Philosopher's Stone", 9.99, Category.FICTION,  3, LocalDate.of(2018, 11, 16));
        Publication publication3 = new Publication( author3, "Introduction to Computer Science", 12.99, Category.TEXTBOOK,  4, LocalDate.of(2023, 9, 1));
        Publication publication4 = new Publication( author4, "Adventures of Huckleberry Finn", 8.99, Category.FICTION,  1, LocalDate.of(2001, 1, 1));
        Publication publication5 = new Publication( author5, "The Origin of Species", 14.99, Category.SCIENCE,  2, LocalDate.of(2010, 1, 1));
        Publication publication6 = new Publication( author6, "Game of Thrones", 14.99, Category.FICTION,  2, LocalDate.of(2010, 1, 1));
        Publication publication7 = new Publication(author7, "Lady of the Lake", 14.99, Category.FICTION,  2, LocalDate.of(2010, 1, 1));
        Publication publication8 = new Publication(author7, "Blood of Elves", 14.99, Category.FICTION,  2, LocalDate.of(2010, 1, 1));
        Publication publication9 = new Publication(author8, "Thermodynamics", 25.99, Category.TEXTBOOK,  2, LocalDate.of(2016, 4, 5));

        library.addPublication(publication1);
        library.addPublication(publication2);
        library.addPublication(publication3);
        library.addPublication(publication4);
        library.addPublication(publication5);
        library.addPublication(publication6);
        library.addPublication(publication7);
        library.addPublication(publication8);
        library.addPublication(publication9);

        author1.addPublication(publication1);
        author2.addPublication(publication2);
        author3.addPublication(publication3);
        author4.addPublication(publication4);
        author5.addPublication(publication5);
        author6.addPublication(publication6);
        author7.addPublication(publication7);
        author7.addPublication(publication8);
        author8.addPublication(publication9);



        Scanner scanner = new Scanner(System.in);
        long memberId = -1;

        boolean running = true;

        do{
            library.displayMainMenu();

            Scanner sc = new Scanner(System.in);

            if (memberId == -1 || library.getMemberById(memberId) == null) {
                System.out.println("Please Enter your Member id: ");
                memberId = scanner.nextLong();
                if (library.getMemberById(memberId) == null) {
                    System.out.println("Member does not exist");
                    continue;
                }
            }
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Bye!");
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Enter author name: ");
                    String authorName = scanner.nextLine();
                    scanner.nextLine();
                    Author newAuthor = new Author(authorName);
                    System.out.println("Enter publication name: ");
                    String publicationName = scanner.nextLine();
                    System.out.println("Enter publication price: ");
                    double publicationPrice = scanner.nextDouble();
                    System.out.println("Enter publication category: ");
                    String publicationCategory = switch (scanner.next().toUpperCase()) {
                        case "TEXTBOOK" -> "TEXTBOOK";
                        case "JOURNAL" -> "JOURNAL";
                        case "MAGAZINE" -> "MAGAZINE";
                        case "NOVEL" -> "NOVEL";
                        case "SCIENCE" -> "SCIENCE";
                        case "SCIENCEFICTION" -> "SCIENCEFICTION";
                        case "FICTION" -> "FICTION";
                        default -> "UNKNOWN";
                    };
                    System.out.println("Enter publication edition: ");
                    int publicationEdition = scanner.nextInt();
                    System.out.println("Enter publication date(yyyy-mm-dd): ");

                    LocalDate publicationDate = LocalDate.parse(scanner.next());
                    Publication newPublication = new Publication(newAuthor, publicationName, publicationPrice, Category.valueOf(publicationCategory), publicationEdition, publicationDate);
                    newPublication.setAuthor(newAuthor);
                    newAuthor.addPublication(newPublication);
                    library.addPublication( newPublication );
                    System.out.println("Publication added successfully!");
                    break;
                case 2:
                    System.out.println("Please enter your choice: ");
                    System.out.println("1. Search by publication name");
                    System.out.println("2. Search by publication id");
                    int searchChoice = scanner.nextInt();
                    switch (searchChoice) {

                        case 1:
                            System.out.println("Enter publication name: ");
                            String publicationName1 = scanner.next();
                            library.getPublicationByTitle(publicationName1);
                            break;
                        case 2:
                            System.out.println("Enter publication id: ");
                            long publicationId = scanner.nextLong();
                            library.getPublicationByPublication_ID(publicationId);
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Enter publication id: ");
                    long publicationId = scanner.nextLong();
                    Publication publication = library.getPublicationByPublication_ID(publicationId);
                    System.out.println("1. Edit publication author.");
                    System.out.println("2. Edit publication title.");
                    System.out.println("3. Edit publication price.");
                    System.out.println("4. Edit publication category.");
                    System.out.println("5. Edit publication edition.");
                    System.out.println("6. Edit publication date.");
                    int choice1 = scanner.nextInt();
                    switch (choice1) {
                        case 1:
                            System.out.println("Enter new author name: ");
                            String newAuthorName = scanner.next();
                            publication.setAuthor(new Author(newAuthorName));
                            break;
                        case 2:
                            System.out.println("Enter new publication name: ");
                            String newPublicationName = scanner.next();
                            publication.setTitle(newPublicationName);
                            break;
                        case 3:
                            System.out.println("Enter new publication price: ");
                            double newPublicationPrice = scanner.nextDouble();
                            publication.setPrice(newPublicationPrice);
                            break;
                        case 4:
                            System.out.println("Enter new publication category: ");
                            String newPublicationCategory = scanner.next();
                            publication.setCategory(Category.valueOf(newPublicationCategory));
                            break;
                        case 5:
                            System.out.println("Enter new publication edition: ");
                            int newPublicationEdition = scanner.nextInt();
                            publication.setEdition(newPublicationEdition);
                            break;
                    }
                    break;

                case 4:
                    System.out.println("Enter publication id: ");
                    long publicationID = scanner.nextLong();
                    library.deletePublication(publicationID);
                case 5:
                    System.out.println("Enter category: ");
                    String category = scanner.next().toUpperCase();
                    System.out.println("Publications in " + category + " category: ");
                    library.displayPublicationsByCategory(Category.valueOf(category));
                    break;
                case 6:
                    System.out.println("Enter author name: ");
                    scanner.nextLine();
                    String authorName2 = scanner.nextLine();

                    library.displayPublicationsByAuthor(authorName2);
                    break;

                case 7:
                    System.out.println("Enter publication id: ");
                    long publicationId2 = scanner.nextLong();
                    library.lendPublication(memberId,publicationId2);
                    break;
                case 8:
                    System.out.println("Enter publication id: ");
                    long publicationId1 = scanner.nextLong();
                    library.returnPublication(memberId,publicationId1);
                    break;
                case 9:
                    library.displayPublications();
                    break;

            }
            System.out.println("Do you want to continue? (yes/no)");
            String continueChoice = scanner.next();
            if (!continueChoice.equalsIgnoreCase("yes")) {
                running = false;
                System.out.println("Bye!");
            }

        }
        while(running);

    }
}