package fr.benoit.supinternet.model;

import com.google.gson.annotations.SerializedName;

/**
 * Pojo used to store the full name of the repository
 *
 * Created by benoit on 08/02/2016.
 */
public class Repository {

    @SerializedName("full_name")
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "fullName='" + fullName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Repository that = (Repository) o;

        return !(fullName != null ? !fullName.equals(that.fullName) : that.fullName != null);

    }

    @Override
    public int hashCode() {
        return fullName != null ? fullName.hashCode() : 0;
    }
}
