package com.workintech.person;

import java.time.LocalDate;
import java.util.Date;

public class Member extends Person {
    private long member_ID;
    private Membership membershipType;
    private LocalDate dateOfJoining;
    private int numberOfBooksIssued;
    private int maxBookLimit = 5;
    private String Address;
    private String phoneNumber;

    private double fineAmount;

    private LocalDate returnDate;


    public Member(String fullName, long member_ID, Membership membershipType, LocalDate dateOfJoining, int numberOfBooksIssued, String address, String phoneNumber) {
        super(fullName);
        this.member_ID = member_ID;
        this.membershipType = membershipType;
        this.dateOfJoining = dateOfJoining;
        this.numberOfBooksIssued = numberOfBooksIssued;
        this.Address = address;
        this.phoneNumber = phoneNumber;
    }

    public void whoYouAre() {
        System.out.println("I am a member");
    }



    public long getMember_ID() {
        return member_ID;
    }

    public void setMember_ID(long member_ID) {
        this.member_ID = member_ID;
    }

    public Membership getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(Membership membershipType) {
        this.membershipType = membershipType;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public int getNumberOfBooksIssued() {
        return numberOfBooksIssued;
    }

    public void setNumberOfBooksIssued(int numberOfBooksIssued) {
        this.numberOfBooksIssued = numberOfBooksIssued;
    }

    public int getMaxBookLimit() {
        return maxBookLimit;
    }

    public void setMaxBookLimit(int maxBookLimit) {
        this.maxBookLimit = maxBookLimit;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void increaseNumberOfBooksIssued() {
        numberOfBooksIssued++;
    }

    public void decreaseNumberOfBooksIssued() {
        numberOfBooksIssued--;
    }

    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public void payFine() {
        fineAmount = 0;
        System.out.println("Thank you for paying the fine");
    }

    public void setReturnDate() {
        LocalDate today = LocalDate.now();
        LocalDate returnDate = today.plusDays(30);
        this.returnDate = returnDate; // Store the LocalDate directly
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }
    @Override
    public String toString() {
        return super.toString() + " " + member_ID + " " + membershipType + " " + dateOfJoining + " " + numberOfBooksIssued + " " + maxBookLimit + " " + Address + " " + phoneNumber;
    }
}
