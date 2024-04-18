package com.workintech.library;

import com.workintech.person.Member;
import com.workintech.publication.Category;
import com.workintech.publication.Publication;
import com.workintech.publication.Status;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Library {
    private List<Publication> publications;
    private Set<Member> members;

   public Library() {
       publications = new ArrayList<>();
       members = new HashSet<>();
   }

    public void addMember(Member member) {
        if(members.contains(member)) {
            System.out.println("Member already exists");
            return;
        }
        members.add(member);
        System.out.println("Member added");
    }

    public void deleteMember(Member member) {
        if(!members.contains(member)) {
            System.out.println("Member does not exist");
            return;
        }
        members.remove(member);
        System.out.println("Member deleted");
    }

    public void addPublication(Publication publication) {
        if(publications.contains(publication)) {
            System.out.println("Publication already exists");
            return;
        }
        publications.add(publication);
        System.out.println("Publication added");
    }

    public void deletePublication (long publication_ID) {
        if(publications.stream().noneMatch(p -> p.getPublication_ID() == publication_ID)) {
            System.out.println("Publication does not exist");
            return;
        }
        publications.removeIf(p -> p.getPublication_ID() == publication_ID);
        System.out.println("Publication has been deleted");
    }


    public List<Publication> getPublications() {
        return publications;
    }

    public Set<Member> getMembers() {
        return members;
    }


    public void displayPublications() {
        for(Publication publication : publications) {
            System.out.println(publication);
        }
    }

    public Member getMemberById(long memberID) {
       if(members.stream().noneMatch(m -> m.getMember_ID() == memberID)) {
           System.out.println("Member does not exist");
       }
        return members.stream().filter(m -> m.getMember_ID() == memberID).findFirst().get();
    }

    public void displayMembers() {
        for(Member member : members) {
            System.out.println(member);
        }
    }

    public Receipt issueReceipt(Member member, Publication publication) {
        Receipt receipt = new Receipt(member, publication, new Date());
        return receipt;
    }

    public void calculateFine(long memberID) {
        if(members.stream().noneMatch(m -> m.getMember_ID() == memberID)) {
            System.out.println("Member does not exist");
            return;
        }
        Member member = members.stream().filter(m -> m.getMember_ID() == memberID).findFirst().get();
        LocalDate today = LocalDate.now();
        LocalDate returnDate = member.getReturnDate();
        long daysOverdue = ChronoUnit.DAYS.between(returnDate, today);
        if(daysOverdue > 30) {
            int fine = (int) ((daysOverdue-30) * 1.5);
            System.out.println("Your fine is: " + fine);
        } else {
            System.out.println("No fine");
        }
    }

    public void lendPublication(long memberID, long publication_ID) {
       Member member = members.stream().filter(m -> m.getMember_ID() == memberID).findFirst().get();
       Publication publication = publications.stream().filter(p -> p.getPublication_ID() == publication_ID).findFirst().get();
        if(member.getNumberOfBooksIssued() >= member.getMaxBookLimit()) {
            System.out.println("You cannot borrow more than " + member.getMaxBookLimit() + " books");
            return;
        }
        if(publication.getStatus() != Status.AVAILABLE) {
            System.out.println("Publication is not available");
            return;
        }
        member.setNumberOfBooksIssued(member.getNumberOfBooksIssued() + 1);
        member.setReturnDate();
        publication.updateStatus(Status.BORROWED);
        publication.setBorrower(member);
        System.out.println("Borrowed publication: " + publication.getTitle());
        System.out.println("Receipt: " + issueReceipt(member, publication));
    }

    public void returnPublication(long memberID, long publication_ID) {
        Publication publication = publications.stream().filter(p -> p.getPublication_ID() == publication_ID).findFirst().get();
        if(members.stream().noneMatch(m -> m.getMember_ID() == memberID)) {
            System.out.println("Member does not exist");
            return;
        }

        Member member = members.stream().filter(m -> m.getMember_ID() == memberID).findFirst().get();
        if(publication.getStatus() != Status.BORROWED) {
            System.out.println("Publication is not borrowed");
            return;
        }
        System.out.println("Returned publication: " + publication.getTitle());
        calculateFine(memberID);
        member.setNumberOfBooksIssued(member.getNumberOfBooksIssued() - 1);
        publication.updateStatus(Status.AVAILABLE);
        publication.setBorrower(null);
    }

    public Publication getPublicationByTitle(String title) {
        for(Publication publication : publications) {
            if(publication.getTitle().equals(title)) {
                System.out.println(publication);
                return publication;
            }
        }
        System.out.println("No publication found");
        return null;
    }

    public void getPublicationByAuthor(String fullName) {
        for(Publication publication : publications) {
            if(publication.getAuthor().getFullName().equalsIgnoreCase(fullName)) {
                System.out.println(publication);
                return;
            }
        }
        System.out.println("No publication found");
    }

    public Publication getPublicationByPublication_ID(long publication_ID) {
        for(Publication publication : publications) {
            if(publication.getPublication_ID() == publication_ID) {
                System.out.println(publication);
                return publication;
            }
        }
        System.out.println("No publication found");
        return null;
    }

    public void displayPublicationsByAuthor(String fullName) {
        for(Publication publication : publications) {
            if(publication.getAuthor().getFullName().equalsIgnoreCase(fullName)) {
                System.out.println(publication);
            }
        }
        System.out.println("No publication found");
    }

    public void displayPublicationsByCategory(Category category) {
        for(Publication publication : publications) {
            if(publication.getCategory() == category) {
                System.out.println(publication);
            }
        }
    }

    public void displayMainMenu(){
        System.out.println("******************************");
        System.out.println("Welcome to the library");
        System.out.println("         Library Menu");
        System.out.println("0. Exit.");
        System.out.println("1: Add a book.");
        System.out.println("2: Get a book information.");
        System.out.println("3: Update a book information.");
        System.out.println("4: Delete a book.");
        System.out.println("5: Print all books by category.");
        System.out.println("6. Print all books by author.");
        System.out.println("7. Borrow a book.");
        System.out.println("8. Return a book.");
        System.out.println("9. List all Publications.");
        System.out.println("******************************" + "\r\n");
    }

}
