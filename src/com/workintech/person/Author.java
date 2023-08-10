package com.workintech.person;

import com.workintech.publication.Publication;

import java.util.HashSet;
import java.util.Set;

public class Author extends Person {

    private Set<Publication> publications;

    public Author(String fullName) {
        super(fullName);
        this.publications = new HashSet<>();
    }

    public void addPublication(Publication publication) {
        publications.add(publication);
    }

    public Set<Publication> getPublications() {
        return publications;
    }

    @Override
    public void whoYouAre() {
        System.out.println("I am an author");
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Author other = (Author) obj;
        if (publications == null) {
            return other.publications == null;
        } else return publications.equals(other.publications);
    }
}
