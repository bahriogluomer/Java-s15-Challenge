package com.workintech.publication;

import com.workintech.person.Author;
import com.workintech.person.Member;

import java.time.LocalDate;
import java.util.Date;

public class Publication {

    private static long count = 10000;
    private long publication_ID;
    private Author author;
    private String title;
    private double price;

    private Category category;
    private Status status;
    private int edition;
    private LocalDate dateOfPurchase;

    private Member borrower;



        public Publication( Author author, String title, double price,Category category, int edition, LocalDate dateOfPurchase) {
        this.publication_ID = count++;
        this.author = author;
        this.title = title;
        this.price = price;
        this.category = category;
        this.status = Status.AVAILABLE;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
    }

    public void setBorrower(Member borrower) {
        this.borrower = borrower;
    }

    public Member getBorrower() {
        return borrower;
    }

    public long getPublication_ID() {
        return publication_ID;
    }

    public Author getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public Status getStatus() {
        return status;
    }

    public int getEdition() {
        return edition;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setPublication_ID(long publication_ID) {
        this.publication_ID = publication_ID;
    }



    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public void setEdition(int edition) {
        this.edition = edition;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void updateStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Publication [author=" + getAuthor() + ", dateOfPurchase=" + dateOfPurchase.toString() + ", edition=" + edition
                + ", price=" + price + ", publication_ID=" + publication_ID + ", status=" + status
                + ", title=" + title + "]";
    }

}
