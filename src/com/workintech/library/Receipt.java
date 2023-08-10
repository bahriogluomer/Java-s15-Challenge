package com.workintech.library;

import com.workintech.person.Member;
import com.workintech.publication.Publication;

import java.util.Date;

public class Receipt {

    private Member member;
    private Publication publication;
    private Date dateOfIssue;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public Receipt(Member member, Publication publication, Date dateOfIssue) {
        this.member = member;
        this.publication = publication;
        this.dateOfIssue = dateOfIssue;
    }

    @Override
    public String toString() {
        return member + " " + publication + " " + dateOfIssue;
    }
}
